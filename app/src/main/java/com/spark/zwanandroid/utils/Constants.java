package com.spark.zwanandroid.utils;

import android.os.Environment;


import com.spark.zwanandroid.BuildConfig;
import com.spark.zwanandroid.model.beans.StatusEntity;
import com.spark.zwanandroid.model.beans.UserEntity;

import java.io.File;



public final class Constants {

    public static final String CODE_YES = "Y";
    private static Constants instance;
    public static final String LOG_TAG = "LOG_TAG";

    //测试地址
    public static String BASE_URL_TEST_1 = "http://uuapi-test.uulivego.com";
    public static String BASE_URL_TEST_2 ="https://youyou.utools.club";
    public static String BASE_URL_TEST_3 = "http://youyouapi.uulivego.com";

    public static String BASE_URL_DEV = "http://youyouapi.uulivego.com";
    public static String BASE_URL = BuildConfig.DEBUG?BASE_URL_TEST_1:BASE_URL_DEV;

    public static final String TAODIAN_URL = "http://101.201.38.102";
    public static final String TAODIAN = "taodian";
    public static final String TAODIAN_HEADER = "domin";

    public static final int HTTP_SUCCESS = 200;
    public static final int HTTP_NOT_LOGIN = 700;
    public static final String INTENT_KEY = "Intent_Key";
    public static final String SHARE_SCREEN_PICTURE = "new_retail.png";
    public static final String DOWNLOAD_APK_NAME = "new_retail.apk";
    public static final String DOWNLOAD_FILEPATH = Environment.getExternalStorageDirectory().getAbsolutePath()
            + File.separator + "new_retail_download"+ File.separator;


    public static final String CRASH_PATH = Environment.getExternalStorageDirectory().getAbsolutePath()+ File.separator + "ZMVPCrash_log"+ File.separator ;
    public static final int PAGE_SIZE = 15;
    public static final long TIME_TWO_SECONDS = 2000;
    public static final long TIME_CLICK_INTERVAL = 800;
    public static final long TIME_TEXT_CHANGE = 500;

    /* */

    public static String FORCE_UPDATE = "Y";
    public static String APK_URL = "";
    public static String UPDATE_POINTS = "";
    public static String APK_MD5 = "";
    public static String VERSION_NAME="";


    /**
     * 账号类型
     */

    public static final String TYPE_ALL = "ALL";
    public static final String TYPE_AGENT = "AGENT";
    public static final String TYPE_MERCHANT = "MERCHANT";

    public static final String TYPE_PROFIT = "PROFIT";
    public static final String TYPE_INCOME = "AMOUNT";
    /**
     * 消息类型
     */
    public static final String MESSAGE_ORDER = "ORDER";
    public static final String MESSAGE_SYSTEM = "SYSTEM";
    public static final String MAIN_PUSH = "MAIN_PUSH";
    public static final String MAIN_PUSH_MESSAGE = "MAIN_PUSH_MESSAGE";
    /**
     * 订单状态
     */
    public static final String MESSAGE_INCOME = "INCOME_SUCCESS";
    public static final String MESSAGE_REFUND = "REFUND_SUCCESS";
    /**
     * 极光推送
     */
    public static final String JPUSH_APP_KEY = "123d213c40753aebe5aa264e";
    public static final String JPUSH_MASTER_SECRET = "55684a9e6de8a40016a638e9";

    /**
     * 微信
     */
    public static final String WX_APP_ID = "wx1e1a1b2d28741ae6";
    /**
     * 百度语音
     */
    public static final String BD_VOICE_APP_ID = "15394299";
    public static final String BD_VOICE_API_KEY = "dmobRBlIZHdbn9BtPA7qoMtG";
    public static final String BD_VOICE_SECRET_KEY = "ZNnY1W4nWFOBXPoxPHNaMnzKRIZ2PdEY";
    /**
     * sp关键字
     */
    public static final String SHARED_PREFERENCES = "shared_preferences";
    public static final String SP_ACCOUNT = "sp_account";
    public static final String SP_PASSWORD = "sp_password";
    public static final String SP_TOKEN = "sp_token";
    public static final String SP_SPEECH = "sp_speech";

    /**
     * 未申请审核
     */
    public static final String UN_APPLY = "UN_APPLY";
    /**
     * 待审核
     */
    public static final String UN_CHECK = "UN_CHECK";
    /**
     * 审核通过
     */
    public static final String CHECK_PASS = "CHECK_PASS";
    /**
     * 审核不通过
     */
    public static final String CHECK_UN_PASS = "CHECK_UNPASS";
    /**
     * (对公)
     */
    public static final String WAY_PUBLIC = "PUBLIC";
    /**
     * 对私同法人
     */
    public static final String WAY_PRIVATE_SELF = "PRIVATE_SELF";
    /**
     * 对私非法人
     */
    public static final String WAY_PRIVATE_NOT_SELF = "PRIVATE_NOT_SELF";
    /**
     * 小微商户认证
     */
    public static final String WAY_PRIVATE_SMALL_SHOP = "PRIVATE_SMALL_SHOP";
    /**
     * 实名认证
     */
    public static final String WAY_CERTIFICATION = "CERTIFICATION";

    /**
     * 用户token
     */
    private UserEntity userEntity;
    private StatusEntity statusEntity;

    public static Constants getInstance() {
        if (instance == null) {
            synchronized (Constants.class) {
                if (instance == null) {
                    instance = new Constants();
                }
            }
        }
        return instance;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

/*
    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
        //登录时进行绑定
        if (userEntity != null) {
            JPushInterface.setAlias(BaseApp.getInstance(), 0, String.valueOf(userEntity.getUserId()));
        }
    }*/

    public void setStatusEntity(StatusEntity statusEntity) {
        this.statusEntity = statusEntity;
    }

    public StatusEntity getStatusEntity() {
        return statusEntity;
    }

    public String getAccount() {
        return userEntity != null ? userEntity.getLoginName() : "";
    }

    public String getUserToken() {
        return userEntity != null ? userEntity.getToken() : "";
    }

    public Integer getUserId() {
        return userEntity != null ? userEntity.getUserId() : -1;
    }


    public String getUserRate() {
        return userEntity != null ? userEntity.getRate() : "";
    }

 /*   public void setNull() {
        instance = null;
        //退出登录进行解除绑定（即不再接收根据别名推送的消息）
        JPushInterface.deleteAlias(BaseApp.getInstance(), 0);
    }*/

    /**
     * 从未未实名认证
     *
     * @return t f
     */
    public boolean isNotApply() {
        return statusEntity == null || UN_APPLY.equals(statusEntity.getIdentityVerifyStatus());
    }

    /**
     * 获取认证账号类型
     *
     * @return t f
     */
    public String getVerifiedType() {
        return statusEntity != null ? statusEntity.getAccountType() : "";
    }

    public String getVerifyStatus() {
        return statusEntity != null ? statusEntity.getIdentityVerifyStatus() : UN_CHECK;
    }


}
