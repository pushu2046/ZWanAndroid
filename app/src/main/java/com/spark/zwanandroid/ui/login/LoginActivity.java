package com.spark.zwanandroid.ui.login;
import android.widget.ImageView;

import com.spark.zwanandroid.R;
import com.spark.zwanandroid.base.activity.BaseActivity;
import com.spark.zwanandroid.model.beans.BannerEntity;
import com.spark.zwanandroid.model.beans.UserEntity;
import com.spark.zwanandroid.mvp.contract.LoginContract;
import com.spark.zwanandroid.mvp.presenter.LoginPresenter;
import com.spark.zwanandroid.utils.GlideUtils;

import java.util.List;

import butterknife.BindView;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.View {


    @BindView(R.id.iv)
    ImageView mIv;
    @BindView(R.id.iv2)
    ImageView mIv2;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void activityInject() {
        activityComponent.inject(this);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initEvent() {
        //mPresenter.doLogin("XXX","XXXXX");

        /*加载banner图实例 */
        mPresenter.homeBan();
    }

    @Override
    public void loginSucceed(UserEntity userEntity) {
    }

    @Override
    public void showBan(List<BannerEntity> bans) {



        if(bans.size()>=2){

            GlideUtils.showBannerImage(this,mIv,bans.get(0).getPictUrl());

            GlideUtils.showBannerImage(this,mIv2,bans.get(1).getPictUrl());
        }


    }
}
