package com.spark.zwanandroid.base.presenter;


import com.spark.zwanandroid.base.BaseView;
import com.spark.zwanandroid.model.DataManager;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BasePresenter<V extends BaseView> implements AbstractPresenter<V> {

    private WeakReference<V> mWeak;
    protected V mView;
    protected DataManager mDataManager;
    private CompositeDisposable compositeDisposable;

    public BasePresenter(DataManager dataManager) {
        this.mDataManager = dataManager;
    }

    @Override
    public void attachView(V view) {
        mWeak = new WeakReference<V>(view);
        this.mView = mWeak.get();
    }

    @Override
    public void detachView() {
        this.mView = null;
        if (mWeak != null) {
            mWeak.clear();
        }
        if (compositeDisposable != null) {
            compositeDisposable.clear();
        }
    }

    @Override
    public void addRxBindingSubscribe(Disposable disposable) {
        addSubscribe(disposable);
    }

    public void addSubscribe(Disposable disposable) {
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(disposable);
    }

    public DataManager getDataManager() {
        return mDataManager;
    }
}
