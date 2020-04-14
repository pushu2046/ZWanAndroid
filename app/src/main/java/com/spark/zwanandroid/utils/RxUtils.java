package com.spark.zwanandroid.utils;


import com.spark.zwanandroid.model.beans.OtherException;
import com.spark.zwanandroid.model.http.api.BaseResponse;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * desc: RxJava  返回结果处理类 -----
 *
 * @author Bian
 * create at 2018/12/17 16:52
 */
public class RxUtils {

    /**
     * 统一线程处理
     *
     * @param <T> 指定的泛型类型
     * @return ObservableTransformer
     */
    public static <T> ObservableTransformer<T, T> rxScheduler() {

        return observable -> observable.subscribeOn(Schedulers.io())
                .doOnSubscribe(disposable -> {
                    if (!CommonUtils.isNetworkConnected()) {
                        throw new OtherException("网络不可用，请检查网络。");
                    }
                })
                .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * 统一返回结果处理 对象
     *
     * @param <T> 指定的泛型类型
     * @return ObservableTransformer
     */
    public static <T> ObservableTransformer<BaseResponse<T>, T> handleEvent() {

        return observable -> observable.flatMap((Function<BaseResponse<T>, Observable<T>>) baseResponse -> {
            if (baseResponse.getCode() == Constants.HTTP_SUCCESS
                    && baseResponse.getData() != null
                    && CommonUtils.isNetworkConnected()) {
                return createData(baseResponse.getData());
            } else if (baseResponse.getCode() == Constants.HTTP_NOT_LOGIN) {
                //登录失效
                return Observable.error(new OtherException("登录失效，请重新登录"));
            } else {
                if (StringUtils.isNotEmpty(baseResponse.getMsg())) {
                    return Observable.error(new OtherException(baseResponse.getMsg()));
                }
                return Observable.error(new OtherException());
            }
        });
    }

    /**
     * 得到 Observable
     *
     * @param <T> 指定的泛型类型
     * @return Observable
     */
    public static <T> Observable<T> createData(final T t) {
        return Observable.create(emitter -> {
            try {
                emitter.onNext(t);
                emitter.onComplete();
            } catch (Exception e) {
                emitter.onError(e);
            }
        });
    }

}
