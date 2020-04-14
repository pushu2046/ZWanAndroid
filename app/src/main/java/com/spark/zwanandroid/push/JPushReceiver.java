package com.spark.zwanandroid.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.gson.Gson;


import cn.jpush.android.api.JPushInterface;

/**
 * desc: 推送接收
 *
 * @author Bian
 * create at 2018/12/28
 */
public class JPushReceiver extends BroadcastReceiver {
    private static final String TAG = "JPush";

    @Override
    public void onReceive(Context context, Intent intent) {
        try {
            Bundle bundle = intent.getExtras();
            if (bundle == null) {
                return;
            }
            if (JPushInterface.ACTION_REGISTRATION_ID.equals(intent.getAction())) {
                String regId = bundle.getString(JPushInterface.EXTRA_REGISTRATION_ID);
                //KLog.d(TAG, "[MyReceiver] 接收Registration Id : " + regId);
                //send the Registration Id to your server...
            } else if (JPushInterface.ACTION_MESSAGE_RECEIVED.equals(intent.getAction())) {


              /*  KLog.d(TAG, "[MyReceiver] 接收到推送下来的自定义消息: " + bundle.getString(JPushInterface.EXTRA_MESSAGE));
                // 自定义消息不会展示在通知栏，完全要开发者写代码去处理
                String content = bundle.getString(JPushInterface.EXTRA_MESSAGE);
                String extra = bundle.getString(JPushInterface.EXTRA_EXTRA);
                PushExtraBean extraBean = new Gson().fromJson(extra, PushExtraBean.class);
                if (extraBean.getType().equals(Constants.MESSAGE_ORDER)) {


                    if("RECHARGE_SUCCESS".equals(extraBean.getStatus())){
                        //充值

                        EventBus.getDefault().post(new ChargeMoneyEvent());

                    }else{

                        //收款退款
                        EventBus.getDefault().post(new MessageEvent(content));
                    }


                }else if(extraBean.getType().equals(Constants.MAIN_PUSH_MESSAGE)){
                    String id = extraBean.getRemark();

                    //暂时不推送
                   // EventBus.getDefault().postSticky(new MainPushEvent(id));


                }*/
            } else if (JPushInterface.ACTION_NOTIFICATION_RECEIVED.equals(intent.getAction())) {
                int notificationId = bundle.getInt(JPushInterface.EXTRA_NOTIFICATION_ID);
                //KLog.d(TAG, "[MyReceiver] 接收到推送下来的通知的ID: " + notificationId);

            } else if (JPushInterface.ACTION_NOTIFICATION_OPENED.equals(intent.getAction())) {
               // KLog.d(TAG, "[MyReceiver] 用户点击打开了通知");
             /*   if (SystemUtils.isAppAlive(context,context.getPackageName())&&Constants.getInstance().getUserEntity()!=null) {
                    Intent newIntent=new Intent(context, MainActivity.class);
                    newIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    context.startActivity(newIntent);
                }else {
                    Constants.getInstance().setUserEntity(null);
                    Constants.getInstance().setNull();
                    ActivityUtils.getInstance().finishAllWithOutClass(null);
                    Intent newIntent=new Intent(context, LoginActivity.class);
                    newIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    context.startActivity(newIntent);
                }*/
            } else if (JPushInterface.ACTION_RICHPUSH_CALLBACK.equals(intent.getAction())) {
                //KLog.d(TAG, "[MyReceiver] 用户收到到RICH PUSH CALLBACK: " + bundle.getString(JPushInterface.EXTRA_EXTRA));
                //在这里根据 JPushInterface.EXTRA_EXTRA 的内容处理代码，比如打开新的Activity， 打开一个网页等..

            } else if (JPushInterface.ACTION_CONNECTION_CHANGE.equals(intent.getAction())) {
                boolean connected = intent.getBooleanExtra(JPushInterface.EXTRA_CONNECTION_CHANGE, false);
                //KLog.w(TAG, "[MyReceiver]" + intent.getAction() + " connected state change to " + connected);
            } else {
               // KLog.d(TAG, "[MyReceiver] Unhandled intent - " + intent.getAction());
            }
        } catch (Exception ignored) {

        }

    }
}
