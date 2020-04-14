package com.spark.zwanandroid.utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import java.util.Stack;

/**
 * desc:
 *
 * @author Bian
 * create at 2018/12/18
 */
public class ActivityUtils {

    private static ActivityUtils activityUtils;

    public synchronized static ActivityUtils getInstance() {
        if (activityUtils == null) {
            synchronized (ActivityUtils.class) {
                if (activityUtils == null) {
                    activityUtils = new ActivityUtils();
                }
            }
        }
        return activityUtils;
    }

    /**
     * 存储ActivityStack
     */
    private Stack<Activity> activityStack;

    /**
     * 将Act纳入推栈集合中
     *
     * @param act Act对象
     */
    public void addActivity(Activity act) {
        if (activityStack == null) {
            activityStack = new Stack<>();
        }
        activityStack.add(act);
    }

    public boolean checkApplication(Context context) {
        String packageName = "com.spark.zwanandroid";
        try {
            ApplicationInfo info = context.getPackageManager().getApplicationInfo(packageName, PackageManager.GET_UNINSTALLED_PACKAGES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }


    /**
     * 堆栈中移除
     *
     * @param act 指定Act对象
     */
    public void removeActivity(Activity act) {
        if (activityStack != null) {
            activityStack.remove(act);
        }
    }

    /**
     * 关闭界面并艺术
     *
     * @param act 指定Act对象
     */
    public void finishActivity(Activity act) {
        if (null != act && activityStack.contains(act)) {
            act.finish();
            activityStack.remove(act);
        }
    }

    /**
     * 除登录界面全部关闭
     */
    public void finishAllWithOutClass(Class<?> clazz) {
        if (activityStack == null) {
            return;
        }
        for (int i = 0; i < activityStack.size(); i++) {
            if (activityStack.get(i).getClass().equals(clazz)) {
                continue;
            }
            activityStack.get(i).finish();
            removeActivity(activityStack.get(i));
            i--;
        }
    }
}
