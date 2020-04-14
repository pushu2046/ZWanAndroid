package com.spark.zwanandroid.model.sp;

/**
 * desc:
 *
 * @author Bian
 * create at 2018/12/14 15:35
 */
public interface IPreferencesHelper {
    /**
     * 保存用户名
     *
     * @param account 账号
     */
    void setLoginAccount(String account);

    /**
     * 保存密码
     *
     * @param password 密码
     */
    void setLoginPassword(String password);

    /**
     * 保存Token
     *
     * @param token token
     */
    void setUserToken(String token);

    /**
     * 语音播报
     *
     * @param flag 是否开启
     */
    void setSpeechOpenStatus(boolean flag);

    /**
     * 获取用户名
     *
     * @return 账号
     */
    String getLoginAccount();

    /**
     * 获取登录密码
     *
     * @return 密码
     */
    String getLoginPassword();

    /**
     * 获取用户Token
     *
     * @return token
     */
    String getUserToken();


}
