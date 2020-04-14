package com.spark.zwanandroid.base.fragment;

import android.content.Context;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.gyf.barlibrary.SimpleImmersionOwner;
import com.spark.zwanandroid.base.App;
import com.spark.zwanandroid.base.BaseView;
import com.spark.zwanandroid.base.activity.BaseActivity;
import com.spark.zwanandroid.base.presenter.BasePresenter;
import com.spark.zwanandroid.di.component.DaggerFragmentComponent;
import com.spark.zwanandroid.di.component.FragmentComponent;


import java.util.Objects;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * desc:Fragment 基类 懒加载
 *
 * @author Bian
 * create at 2018/12/14 17:38

 */
public abstract class BaseFragment<T extends BasePresenter> extends Fragment implements BaseView, SimpleImmersionOwner {
    protected FragmentComponent fragmentComponent;
    private Unbinder unBinder;
    /**
     * 懒加载过
     */
    private boolean isLazyLoaded = false;
    @Inject
    protected T mPresenter;
    protected Context mContext;

    View view =null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        if(view==null){

            view = inflater.inflate(getLayoutId(), container, false);
        }

        unBinder = ButterKnife.bind(this, view);
        mContext = getContext();
        if (immersionBarEnabled()) {
            initImmersionBar();
        }
        fragmentComponent = DaggerFragmentComponent.builder()
                .applicationComponent(((App) (Objects.requireNonNull(getContext())
                        .getApplicationContext())).getApplicationComponent())
                .build();
        fragmentInject();
        initView(view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isLazyLoaded = true;
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        initEvent();
        if (getUserVisibleHint()) {
            lazyEvent();  //这种情况针对 vp 第一个fragment 可见 直接加载数据  其余的 因为不可见的关系 不加载数据 当切换时 对应的fragment 调用 setUserVisble
            isLazyLoaded = false;
        }
    }


    public void lazyEvent() {
        //懒加载数据
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        //viewpager 嵌套懒加载有问题自己写
        if (isLazyLoaded && isVisibleToUser) {
            lazyEvent();
            isLazyLoaded = false;
        }
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
    }

    @Override
    public void showToast(String message) {
        ((BaseActivity) Objects.requireNonNull(getActivity())).showToast(message);
    }

    @Override
    public void showLoadingDialog() {
        ((BaseActivity) Objects.requireNonNull(getActivity())).showLoadingDialog();
    }

    @Override
    public void hideLoadingDialog() {
        ((BaseActivity) Objects.requireNonNull(getActivity())).hideLoadingDialog();
    }

    @Override
    public boolean immersionBarEnabled() {
        return true;
    }

    @Override
    public void initImmersionBar() {

    }

    @Override
    public void onDestroyView() {
        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter = null;
        }
        if (unBinder != null && unBinder != Unbinder.EMPTY) {
            unBinder.unbind();
            unBinder = null;
        }

        if (view != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }

        super.onDestroyView();
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
    protected abstract void fragmentInject();

    /**
     * 初始化控件
     *
     * @param view
     */
    protected abstract void initView(View view);

    /**
     * 初始化时间
     */
    protected abstract void initEvent();

}
