package com.spark.zwanandroid.mvp.contract;

import com.spark.zwanandroid.base.BaseView;
import com.spark.zwanandroid.base.presenter.AbstractPresenter;
import com.spark.zwanandroid.model.beans.BannerEntity;
import com.spark.zwanandroid.model.beans.UserEntity;

import java.util.List;

public class LoginContract {
    public interface View extends BaseView {

        void loginSucceed(UserEntity userEntity);
        void showBan(List<BannerEntity> bans);
    }

    public interface Presenter extends AbstractPresenter<View> {

        void doLogin(String loginName, String password);

        void clearToken();

        void homeBan();
    }
}
