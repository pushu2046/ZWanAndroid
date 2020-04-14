package com.spark.zwanandroid.base.presenter;



import com.spark.zwanandroid.base.BaseView;

import io.reactivex.disposables.Disposable;

public interface AbstractPresenter<T extends BaseView> {

    /**
     * 注入View
     *
     * @param view view
     */
    void attachView(T view);

    /**
     * 回收View
     */
    void detachView();


    /**
     * Add rxBing subscribe manager
     *
     * @param disposable Disposable
     */
    void addRxBindingSubscribe(Disposable disposable);

}
