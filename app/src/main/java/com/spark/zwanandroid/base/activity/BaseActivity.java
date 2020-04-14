package com.spark.zwanandroid.base.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.gyf.barlibrary.ImmersionBar;
import com.spark.zwanandroid.R;
import com.spark.zwanandroid.base.App;
import com.spark.zwanandroid.base.BaseView;
import com.spark.zwanandroid.base.presenter.BasePresenter;
import com.spark.zwanandroid.di.component.ActivityComponent;
import com.spark.zwanandroid.di.component.DaggerActivityComponent;
import com.spark.zwanandroid.utils.ActivityUtils;
import com.spark.zwanandroid.widgets.LoadingDialog;
import com.tbruyelle.rxpermissions2.RxPermissions;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import es.dmoral.toasty.Toasty;


/**
 * desc:    基类
 *
 *
 */
public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements BaseView {
    protected ActivityComponent activityComponent;
    private Unbinder unBinder;
    protected BaseActivity mActivity;
    @Inject
    protected T mPresenter;
    private LoadingDialog mLoadingDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


       // ActivityCollector.addActivity(this);
        if ((getIntent().getFlags() & Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT) != 0) {
            finish();
            return;
        }
        if (getLayoutId() != 0) {
            setContentView(getLayoutId());
        }
        mActivity = this;
        unBinder = ButterKnife.bind(this);
        ActivityUtils.getInstance().addActivity(this);
        if (isImmersionBarEnabled()) {
            //状态栏沉浸式 默认黑色
            initImmersionBar(R.color.black);
        }
        activityComponent = DaggerActivityComponent.builder()
                .applicationComponent(((App) getApplication()).getApplicationComponent())
                .build();
        activityInject();
        if (mPresenter != null) {
            mPresenter.attachView(this);
            mPresenter.addRxBindingSubscribe(new RxPermissions(this)
                    .request(Manifest.permission.WRITE_EXTERNAL_STORAGE,
                            Manifest.permission.READ_EXTERNAL_STORAGE)
                    .subscribe(aBoolean -> {
                        if (!aBoolean) {
                            showToast("请求权限失败");
                        }
                    }));
        }
        initView();
        initEvent();
    }

    /**
     * //状态栏沉浸式
     *
     * @param colorId 颜色
     */
    protected void initImmersionBar(int colorId) {
        ImmersionBar.with(this).statusBarColor(colorId).init();
    }

    /**
     * 是否可以使用沉浸式
     * Is immersion bar enabled boolean.
     *
     * @return the boolean
     */
    protected boolean isImmersionBarEnabled() {
        return true;
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void showToast(String message) {
        Toasty.info(this, message, Toast.LENGTH_SHORT, false).show();
    }

    @Override
    public void showLoadingDialog() {
        try {
            if (mLoadingDialog != null) {
                mLoadingDialog.dismiss();
                mLoadingDialog = null;
            }
            mLoadingDialog = LoadingDialog.newInstance();
            if (!mLoadingDialog.isAdded() && !mLoadingDialog.isVisible() && !mLoadingDialog.isRemoving()) {
                mLoadingDialog.show(getSupportFragmentManager(), getClass().getSimpleName());
            }
        } catch (Exception e) {
            //KLog.e(e.getMessage());
        }
    }

    @Override
    public void hideLoadingDialog() {
        try {
            if (mLoadingDialog != null && mLoadingDialog.isAdded()) {
                mLoadingDialog.dismiss();
            }
        } catch (Exception ignored) {

        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityUtils.getInstance().removeActivity(this);
        //ActivityCollector.removeActivity(this);
        if (isImmersionBarEnabled()) {
            ImmersionBar.with(this).destroy();
        }
        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter = null;
        }
        if (unBinder != null && unBinder != Unbinder.EMPTY) {
            unBinder.unbind();
            unBinder = null;
        }
    }

    /**
     * 获取布局Id
     *
     * @return id
     */
    protected abstract int getLayoutId();

    /**
     * dagger2初始化
     */
    protected abstract void activityInject();

    /**
     * 初始化控件
     */
    protected abstract void initView();

    /**
     * 初始化事件
     */
    protected abstract void initEvent();
}
