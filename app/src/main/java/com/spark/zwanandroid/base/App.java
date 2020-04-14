package com.spark.zwanandroid.base;

import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;

import androidx.core.content.ContextCompat;
import androidx.multidex.MultiDex;

import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.spark.zwanandroid.R;
import com.spark.zwanandroid.di.component.ApplicationComponent;
import com.spark.zwanandroid.di.component.DaggerApplicationComponent;
import com.spark.zwanandroid.di.module.ApplicationModule;
import com.spark.zwanandroid.utils.Constants;
import com.spark.zwanandroid.utils.CrashHandler;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import java.lang.reflect.Field;

import cn.jpush.android.api.JPushInterface;
import okhttp3.OkHttpClient;

/*app*/
public class App extends Application {
    private ApplicationComponent applicationComponent;
    private static App instance;
    private IWXAPI api;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();

        instance = this;
        //KLog.init(BuildConfig.LOG_DEBUG, Constants.LOG_TAG);
       // initTextStyle();
       // initJPush();
     //   initWeChat();


        CrashHandler crashHandler = CrashHandler.getInstance();

        crashHandler.init(this);

    }

    private void initWeChat() {
        // 通过WXAPIFactory工厂，获取IWXAPI的实例
        api = WXAPIFactory.createWXAPI(this, Constants.WX_APP_ID, true);

        // 将应用的appId注册到微信
        api.registerApp(Constants.WX_APP_ID);
    }

    public IWXAPI getWXApi() {
        if (api == null) {
            // 通过WXAPIFactory工厂，获取IWXAPI的实例
            api = WXAPIFactory.createWXAPI(this, Constants.WX_APP_ID, true);

            // 将应用的appId注册到微信
            api.registerApp(Constants.WX_APP_ID);
        }
        return api;
    }

    private void initJPush() {
        // 设置开启日志,发布时请关闭日志
        JPushInterface.setDebugMode(true);
        // 初始化 JPush
        JPushInterface.init(this);
    }

    //static 代码段可以防止内存泄露
    static {
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreator((context, layout) -> {
            MaterialHeader header = new MaterialHeader(context);
            header.setColorSchemeColors(ContextCompat.getColor(context, R.color.gold_dark));
            header.setShowBezierWave(false);
            return header;
        });
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreator((context, layout) -> new ClassicsFooter(context));
    }

    /**
     * 修改字体样式
     */
    private void initTextStyle() {
        Typeface typeface = Typeface.createFromAsset(getAssets(), "PingFang_SC_Regular.ttf");
        try {
            Field field = Typeface.class.getDeclaredField("MONOSPACE");
            field.setAccessible(true);
            field.set(null, typeface);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    public OkHttpClient.Builder getClientBuilder() {
        return applicationComponent.getOkHttpClient();
    }

    public static synchronized App getInstance() {
        return instance;
    }
}
