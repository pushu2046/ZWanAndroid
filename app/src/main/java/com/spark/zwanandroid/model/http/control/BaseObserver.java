package com.spark.zwanandroid.model.http.control;

import android.app.Activity;
import android.content.Intent;


import com.spark.zwanandroid.base.BaseView;
import com.spark.zwanandroid.ui.login.LoginActivity;
import com.spark.zwanandroid.utils.ActivityUtils;
import com.spark.zwanandroid.utils.Constants;

import io.reactivex.observers.ResourceObserver;

public class BaseObserver<T> extends ResourceObserver<T> {
    private BaseView mView;
    private boolean isRefresh = false;

    protected BaseObserver(BaseView mView) {
        this.mView = mView;
    }

    protected BaseObserver(BaseView mView, boolean isRefresh) {
        this.mView = mView;
        this.isRefresh = isRefresh;
    }

    @Override
    protected void onStart() {
        if (mView != null && !isRefresh) {
            mView.showLoadingDialog();
        }
        super.onStart();
    }

    @Override
    public void onNext(T t) {
    }

    @Override
    public void onError(Throwable t) {
        if (mView != null && !isRefresh) {
            mView.hideLoadingDialog();
            mView.showToast(t.getMessage());
        }
        if (mView != null && "登录失败".equals(t.getMessage())) {
           // Constants.getInstance().setUserEntity(null);
            //Constants.getInstance().setNull();
            ActivityUtils.getInstance().finishAllWithOutClass(mView.getContext().getClass());
            mView.getContext().startActivity(new Intent(mView.getContext(), LoginActivity.class));
            ((Activity) mView.getContext()).finish();
        }
    }

    @Override
    public void onComplete() {
        if (mView != null && !isRefresh) {
            mView.hideLoadingDialog();
        }
    }
}
