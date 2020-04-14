package com.spark.zwanandroid.model.http.helper;

import com.spark.zwanandroid.model.beans.BannerEntity;
import com.spark.zwanandroid.model.beans.UserEntity;
import com.spark.zwanandroid.model.http.api.BaseResponse;

import java.util.List;

import io.reactivex.Observable;

public interface IHttpHelper {


    /*登录接口---*/
    Observable<BaseResponse<UserEntity>> login(String loginName, String password);

    Observable<BaseResponse<List<BannerEntity>>> homeBanner();
}
