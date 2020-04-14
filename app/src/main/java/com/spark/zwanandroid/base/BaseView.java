package com.spark.zwanandroid.base;


import android.content.Context;

/**
 * @author zuo
 * @Description View 的基类
 * @Time 2018/10/9 0009 20:16
 */
public interface BaseView {

    /**
     * 页面状态
     */
    static final int STATE_NORMAL = 0x00;
    static final int STATE_LOADING = 0x01;
    static final int STATE_ERROR = 0x02;

    /**
     * 吐司
     *
     * @param message 信息
     */
    void showToast(String message);

    /**
     * 上下文
     *
     * @return context
     */
    Context getContext();

    /**
     * 显示加载框
     */
    void showLoadingDialog();

    /**
     * 隐藏
     */
    void hideLoadingDialog();

}
