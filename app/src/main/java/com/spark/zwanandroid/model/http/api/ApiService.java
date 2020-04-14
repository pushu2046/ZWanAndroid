package com.spark.zwanandroid.model.http.api;


import com.spark.zwanandroid.model.beans.BannerEntity;
import com.spark.zwanandroid.model.beans.UserEntity;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/*api 请求 - -- */
public interface ApiService {

    @POST("/app/v1/login")
    Observable<BaseResponse<UserEntity>> login(@Body Object object);


    /*支持了 不同的域名 例如淘点 --- 拦截器实现 ----*/
    @Headers({"domin:taodian", "Content-Type:application/json"})
    @GET("/soukeAppTttService/service/tbk/img")
    Observable<BaseResponse<List<BannerEntity>>> homeBanner();


    /*图片上传 -----*/
    @Multipart
    @POST("/upload/image")
    Observable<BaseResponse<String>> uploadPic(@Part() MultipartBody.Part file);
}
