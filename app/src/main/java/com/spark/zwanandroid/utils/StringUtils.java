package com.spark.zwanandroid.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
    /**
     * 判断字符串是否为空
     *
     */
    public static boolean isEmpty(String str) {
        return str == null || "".equals(str) || str.trim().length() == 0;
    }

    /**
     * 判断str null,"","null" 均视为空.
     */
    public static boolean isNotEmpty(String str) {
        boolean bool = true;
        if (str == null || "null".equals(str) || "".equals(str) || str.length() == 0) {
            bool = false;
        }
        return bool;
    }


    public static boolean isNumber(String money){
        Pattern pattern  = Pattern.compile("^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,2})?$");
        Matcher match = pattern.matcher(money);
        return match.matches();
    }


}
