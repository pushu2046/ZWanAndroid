package com.spark.zwanandroid.di.module;

import android.content.Context;


import androidx.annotation.NonNull;

import com.spark.zwanandroid.BuildConfig;
import com.spark.zwanandroid.base.App;
import com.spark.zwanandroid.di.qualifier.ApplicationContext;
import com.spark.zwanandroid.model.http.api.ApiService;
import com.spark.zwanandroid.model.http.helper.PacketsHelper;
import com.spark.zwanandroid.utils.Constants;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * desc:
 *
 * @author Bian
 * create at 2018/12/14 15:30
 */
@Module
public class ApplicationModule {
    private App application;

    public ApplicationModule(App application) {
        this.application = application;
    }

    @Provides
    @Singleton
    App provideApplication() {
        return application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return application;
    }

    @Singleton
    @Provides
    Retrofit.Builder provideRetrofitBuilder() {
        return new Retrofit.Builder();
    }

    @Singleton
    @Provides
    OkHttpClient.Builder provideOkHttpBuilder() {
        return new OkHttpClient.Builder();
    }

    /*okhttp对象---*/
    @Provides
    @Singleton
    OkHttpClient provideClient(OkHttpClient.Builder builder) {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(BuildConfig.LOG_DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
        return builder
                .connectTimeout(40, TimeUnit.SECONDS)
                .readTimeout(40, TimeUnit.SECONDS)
                .writeTimeout(40, TimeUnit.SECONDS)
                .addNetworkInterceptor(loggingInterceptor)
                .addInterceptor(chain -> {//动态修改BaseUrl
                    //获取request
                    Request request = chain.request();
                    //从request中获取原有的HttpUrl实例oldHttpUrl
                    HttpUrl oldHttpUrl = request.url();
                    //获取request的创建者builder
                    Request.Builder builder1 = request.newBuilder();
                    //从request中获取headers，通过给定的键url_name
                    List<String> headerValues = request.headers(Constants.TAODIAN_HEADER);
                    if (headerValues.size() > 0) {
                        builder1.removeHeader(Constants.TAODIAN_HEADER);
                        //匹配获得新的BaseUrl，通过domin值，判断这个是哪一个方法需要使用什么baseUrl
                        String headerValue = headerValues.get(0);
                        HttpUrl newBaseUrl = HttpUrl.parse(Constants.BASE_URL);
                        if (Constants.TAODIAN.equals(headerValue)) {
                            newBaseUrl = HttpUrl.parse(Constants.TAODIAN_URL);
                        }
                        //重建新的HttpUrl，修改需要修改的url部分
                        HttpUrl newFullUrl = oldHttpUrl
                                .newBuilder()
                                .scheme(Objects.requireNonNull(newBaseUrl).scheme())
                                .host(newBaseUrl.host())
                                .port(newBaseUrl.port())
                                .build();
                        return chain.proceed(builder1.url(newFullUrl).build());
                    }
                    return chain.proceed(request);
                })
                .addInterceptor(new Interceptor() {
                    @NonNull
                    @Override
                    public Response intercept(@NonNull Chain chain) throws IOException {
                        return chain.proceed(chain.request().newBuilder()
                                .addHeader("token", "xxxxxxxx").build());
                    }
                })
                .build();
    }


    /*retrofit对象 */
    @Provides
    @Singleton
    Retrofit provideRetrofit(Retrofit.Builder builder, OkHttpClient okhttpClient) {
        return builder
                .baseUrl(Constants.BASE_URL)
                .client(okhttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }


    //api对象 ----
    @Provides
    @Singleton
    ApiService provideApiService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }


    /*参数组装对象*/
    @Provides
    @Singleton
    PacketsHelper providePacketsHelper() {
        return new PacketsHelper();
    }
}
