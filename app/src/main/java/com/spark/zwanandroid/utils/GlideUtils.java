package com.spark.zwanandroid.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;


public class GlideUtils {

    public static void showBannerImage(Context context, ImageView imageView, String url){
        RequestOptions requestOptions =new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC);
        Glide.with(context).load(url).apply(requestOptions).into(imageView);
    }

}
