package com.spark.zwanandroid.mvp.presenter;

import com.spark.zwanandroid.base.presenter.BasePresenter;
import com.spark.zwanandroid.model.DataManager;
import com.spark.zwanandroid.model.beans.BannerEntity;
import com.spark.zwanandroid.model.beans.UserEntity;
import com.spark.zwanandroid.model.http.control.BaseObserver;
import com.spark.zwanandroid.mvp.contract.LoginContract;
import com.spark.zwanandroid.utils.RxUtils;
import com.spark.zwanandroid.utils.StringUtils;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/**
 * desc: 登录逻辑处理
 *
 * @author Bian
 * create at 2018/12/20
 */
public class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter {

    @Inject
    public LoginPresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void doLogin(String loginName, String password) {
        if (StringUtils.isEmpty(loginName)) {
            mView.showToast("登录名称为空");
            return;
        }

        mView.showLoadingDialog();
        addSubscribe(mDataManager.login(loginName, password)
                .compose(RxUtils.rxScheduler())
                .compose(RxUtils.handleEvent())
                .filter(s -> mView != null)
                .subscribeWith(new BaseObserver<UserEntity>(mView) {
                    @Override
                    public void onNext(UserEntity userEntity) {
                        super.onNext(userEntity);
                        //保存用户名密码
                       // mView.loginSucceed(userEntity);
                        //save(loginName, password, userEntity.getToken());
                        //Constants.getInstance().setUserEntity(userEntity);
                    }
                }));
    }

    @Override
    public void clearToken() {
        mDataManager.setUserToken("");
    }

    @Override
    public void homeBan() {

        addSubscribe(mDataManager.homeBanner()
                .compose(RxUtils.rxScheduler())
                .compose(RxUtils.handleEvent())
                .filter(s -> mView != null)
                .subscribeWith(new BaseObserver<List<BannerEntity>>(mView) {
                    @Override
                    public void onNext(List<BannerEntity> bans) {
                        super.onNext(bans);
                        mView.showBan(bans);
                        //保存用户名密码
                        // mView.loginSucceed(userEntity);
                        //save(loginName, password, userEntity.getToken());
                        //Constants.getInstance().setUserEntity(userEntity);
                    }
                }));

    }

    private void save(String loginName, String password, String token) {
        addSubscribe(Observable.just(loginName, password)
                .subscribeOn(Schedulers.io())
                .subscribe(s -> {
                    mDataManager.setLoginAccount(loginName);
                    mDataManager.setLoginPassword(password);
                    mDataManager.setUserToken(token);
                }));
    }
}
