package com.spark.zwanandroid.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;

import android.text.InputFilter;
import android.text.Spanned;
import android.util.DisplayMetrics;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;


import androidx.core.content.FileProvider;

import com.spark.zwanandroid.base.App;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;


public class CommonUtils {


    /**
     * 将每三个数字加上逗号处理（通常使用金额方面的编辑）
     *
     * @param str 需要处理的字符串
     * @return 处理完之后的字符串
     */
    public static String formatMoney(String str) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        return decimalFormat.format(Double.parseDouble(str));
    }

    /**
     * 2为有效数字
     */
    public static String formatDecimal(String str) {
        return new DecimalFormat("0.00").format(new BigDecimal(str));
    }

    /**
     * 禁止EditText输入空格
     *
     * @param editText 编辑框
     */
    public static void setInputNoSpace(EditText editText) {
        InputFilter filter = new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                if (" ".contentEquals(source)) {
                    return "";
                } else {
                    return null;
                }
            }
        };
        editText.setFilters(new InputFilter[]{filter});
    }


    public static String getFileMD5(File file){
        BigInteger bigInt = null;

        try {
            FileInputStream fis = new FileInputStream(file);
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] buffer = new byte[1024];
            int length = -1;
            while ((length = fis.read(buffer, 0, 1024)) != -1) {
                md.update(buffer, 0, length);
            }
            bigInt = new BigInteger(1, md.digest());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bigInt.toString(16);
    }

    public static boolean canInsertKeyboardNum(EditText mTvMoney, String num) {
        String currentNumber = mTvMoney.getText().toString();
        if (currentNumber.contains(".") && ".".equals(num)) {
            return false;
        }
        currentNumber = currentNumber + num;
        if (currentNumber.contains(".")) {
            if (currentNumber.length() - 1 - currentNumber.indexOf(".") > 2) {
                return false;
            }
        }
        if (currentNumber.startsWith("0") && currentNumber.length() > 1) {
            if (!".".equals(currentNumber.substring(1, 2))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 隐藏动画
     *
     * @param view 控件
     */
    public static void setGoneTrans(View view) {
        TranslateAnimation animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF,
                0.0f, Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                1.0f);
        animation.setDuration(300);
        view.startAnimation(animation);
        view.setVisibility(View.GONE);
    }

    /**
     * 显示动画
     *
     * @param view 控件
     */
    public static void setVisibleTrans(View view) {
        TranslateAnimation animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                1.0f, Animation.RELATIVE_TO_SELF, 0.0f);
        animation.setDuration(500);
        view.startAnimation(animation);
        view.setVisibility(View.VISIBLE);
    }

    /**
     * 检查是否有可用网络
     */
    public static boolean isNetworkConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) App.getInstance().getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        assert connectivityManager != null;
        return connectivityManager.getActiveNetworkInfo() != null;
    }

    /**
     * 获取版本号
     */
    public static String getVersionName(Context context) {
        String verName = "";
        try {
            verName = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return verName;
    }

    /**
     * 获取版本号
     */
    public static int getVersionCode(Context context) {
        int verCode = 0;
        try {
            verCode = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return verCode;
    }

    /**
     * 获得屏幕宽度
     */
    public static int getScreenWidth(Context context) {
        WindowManager windowManager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics metrics = new DisplayMetrics();
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(metrics);
        }
        return metrics.widthPixels;
    }

    /**
     * 获得屏幕高度
     */
    public static int getScreenHeight(Context context) {
        WindowManager windowManager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics metrics = new DisplayMetrics();
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(metrics);
        }
        return metrics.heightPixels;
    }


    public static File getParentFile() {
        final File file = new File(Constants.DOWNLOAD_FILEPATH);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }


    /**
     * 安装Apk
     */
    public static void installApk(Context context, File apkFile) {
        if (apkFile != null) {
            Intent install = new Intent(Intent.ACTION_VIEW);
            Uri apkUri = null;
            //判断Android版本是否是Android7.0以上
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                install.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                apkUri = FileProvider.getUriForFile(context, "com.seocoo.retail.manager.provider", apkFile);
            } else {
                apkUri = Uri.fromFile(apkFile);
            }
            install.setDataAndType(apkUri, "application/vnd.android.package-archive");
            install.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(install);
        }
    }


    private final static String DEFAULT_FORMAT = "yyyy-MM-dd";
    public final static String DATE_YEAR_DAY = "yyyy-MM";

    public static String dateFormat(long time) {
        return toString(time, DEFAULT_FORMAT);
    }

    public static String dateFormat(long time, String dataFormat) {
        return toString(time, dataFormat);
    }

    public static long dateToLong(String date) {
        Date d = null;
        try {
            d = new SimpleDateFormat(DEFAULT_FORMAT, Locale.getDefault()).parse(date);
            return d.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 根据给定的格式化参数，将日期转换为字符串
     *
     * @param time       时间
     * @param dateFormat 格式
     * @return String
     */
    public static String toString(long time, String dateFormat) {
        DateFormat sdf = new SimpleDateFormat(dateFormat, Locale.getDefault());
        return sdf.format(time);
    }

    /**
     * 截屏
     *
     * @param view 界面
     * @return Bitmap
     */
    private static Bitmap takeScreen(View view) {
        //开启缓存功能
        view.setDrawingCacheEnabled(true);
        //创建缓存
        view.buildDrawingCache();
        //获取缓存Bitmap
        Bitmap bitmap = Bitmap.createBitmap(view.getDrawingCache());
        return bitmap;
    }

    /**
     * 截屏并保存
     *
     * @param activity 界面
     * @return 保存的路径
     */
    public static String shoot(Activity activity, View view) {
        String localPath = getFileName(activity);
        boolean ret = savePicture(takeScreen(view), localPath);
        if (ret) {
            return localPath;
        } else {
            return "";
        }
    }

    private static boolean savePicture(Bitmap bitmap, String strFileName) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(strFileName);
            bitmap.compress(Bitmap.CompressFormat.PNG, 90, fos);
            fos.flush();
            fos.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 获得文件名
     *
     * @param context 上下文
     * @return 文件名
     */
    private static String getFileName(Context context) {
        final String localPath;
        if (isExistsSD()) {
            File file = new File(Constants.DOWNLOAD_FILEPATH);
            if (!file.exists()) {
                file.mkdirs();
            }
            File picFile = new File(file, Constants.SHARE_SCREEN_PICTURE);
            localPath = picFile.getAbsolutePath();
        } else {
            localPath = context.getFilesDir() + Constants.SHARE_SCREEN_PICTURE;
        }
        return localPath;
    }

    /**
     * 是否存在sd卡
     *
     * @return 是否存在sd卡
     */
    private static Boolean isExistsSD() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    public static byte[] bmpToByteArray(final Bitmap bmp, final boolean needRecycle) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 100, output);
        if (needRecycle) {
            bmp.recycle();
        }
        byte[] result = output.toByteArray();
        try {
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void nullEdit(final EditText editText) {
        editText.setFocusable(false);
        editText.setFocusableInTouchMode(false);
        editText.setClickable(false);
        editText.setFocusable(false);
        editText.setCursorVisible(false);
        editText.setLongClickable(false);
        editText.setTextIsSelectable(false);
        editText.setImeOptions(EditorInfo.IME_FLAG_NO_EXTRACT_UI);

        editText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                editText.clearFocus();
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    setInsertionDisabled(editText);
                }
                return false;
            }
        });

        editText.setCustomSelectionActionModeCallback(new ActionMode.Callback() {
            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }
        });
    }

    private static void setInsertionDisabled(EditText editText) {
        try {
            Field editorField = TextView.class.getDeclaredField("mEditor");
            editorField.setAccessible(true);
            Object editorObject = editorField.get(editText);
            Class editorClass = Class.forName("android.widget.Editor");
            Field mInsertionControllerEnabledField = editorClass.getDeclaredField("mInsertionControllerEnabled");
            mInsertionControllerEnabledField.setAccessible(true);
            mInsertionControllerEnabledField.set(editorObject, false);
        } catch (Exception ignored) {
        }
    }

    /**
     * 本地资源图片
     *
     * @param context 对象
     * @param resId   id
     * @return bitmap
     */
    public static Bitmap getBitmapFromRes(Context context, int resId) {
        Bitmap bitmap = null;
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            Drawable vectorDrawable = context.getDrawable(resId);
            bitmap = Bitmap.createBitmap(Objects.requireNonNull(vectorDrawable).getIntrinsicWidth(),
                    vectorDrawable.getIntrinsicHeight(), Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(bitmap);
            vectorDrawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            vectorDrawable.draw(canvas);
        } else {
            bitmap = BitmapFactory.decodeResource(context.getResources(), resId);
        }
        return bitmap;
    }
}
