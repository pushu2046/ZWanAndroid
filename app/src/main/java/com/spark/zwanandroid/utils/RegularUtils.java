package com.spark.zwanandroid.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegularUtils {
    /**
     * 正则：手机号（简单）
     */

    /**
     * 验证手机号（简单）
     *
     * @param string 待验证文本
     * @return {@code true}: 匹配<br>{@code false}: 不匹配
     */
    public static boolean isNotPhone(String string) {
        return !isMatch("^[1]\\d{10}$", string);
    }

    /**
     * string是否匹配regex正则表达式字符串
     *
     * @param regex  正则表达式字符串
     * @param string 要匹配的字符串
     * @return {@code true}: 匹配<br>{@code false}: 不匹配
     */
    private static boolean isMatch(String regex, String string) {
        return StringUtils.isNotEmpty(regex) && Pattern.matches(regex, string);
    }

    /**
     * 隐藏手机号码
     *
     * @param phone 手机号
     */
    public static String hidePhone(String phone) {
        if (isNotPhone(phone)) {
            return phone;
        }
        return phone.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
    }


    /**
     * 邮箱验证
     *
     * @param email email
     */
    public static boolean isNotEmail(String email) {
        String strPattern = "^[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$";
        return !isMatch(strPattern, email);
    }

    /**
     * 隐藏姓名
     *
     * @param name 姓名
     */
    public static String hideName(String name) {
        if (StringUtils.isEmpty(name)) {
            return "";
        }
        String reg = ".{1}";
        StringBuffer sb = new StringBuffer();
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(name);
        int i = 0;
        while (m.find()) {
            i++;
            if (i == 1)
                continue;
            m.appendReplacement(sb, "*");
        }
        m.appendTail(sb);
        return sb.toString();
    }

    public static boolean isIdNo(String idCardNo) {
        //记录错误信息
        String Ai = "";

        if (idCardNo.length() != 15 && idCardNo.length() != 18) {
            return false;
        }

        if (idCardNo.length() == 18) {
            Ai = idCardNo.substring(0, 17);
        } else {
            Ai = idCardNo.substring(0, 6) + "19" + idCardNo.substring(6, 15);
        }
        if (!isNumber(Ai)) {
            return false;
        }
        // 年份
        String strYear = Ai.substring(6, 10);
        // 月份
        String strMonth = Ai.substring(10, 12);
        // 月份
        String strDay = Ai.substring(12, 14);
        if (!isDate(strYear + "-" + strMonth + "-" + strDay)) {
            return false;
        }
        GregorianCalendar gc = new GregorianCalendar();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        try {
            if ((gc.get(Calendar.YEAR) - Integer.parseInt(strYear)) > 150
                    || (gc.getTime().getTime() - s.parse(
                    strYear + "-" + strMonth + "-" + strDay).getTime()) < 0) {
                return false;
            }
        } catch (NumberFormatException | java.text.ParseException e) {
            e.printStackTrace();
        }
        if (Integer.parseInt(strMonth) > 12 || Integer.parseInt(strMonth) == 0) {
            return false;
        }
        if (Integer.parseInt(strDay) > 31 || Integer.parseInt(strDay) == 0) {
            return false;
        }
        return true;
    }

        /**
         * 功能：判断字符串是否为日期格式
         */
        private static boolean isDate(String strDate) {
            String regxStr = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$";
            Pattern pattern = Pattern.compile(regxStr);
            Matcher m = pattern.matcher(strDate);
            if (m.matches()) {
                return true;
            } else {
                return false;
            }
        }

    /**
     * 参数是否是有效数字 （整数或者小数）
     *
     * @param obj 参数（对象将被调用string()转为字符串类型）
     * @return 是否是数字
     */
    private static boolean isNumber(Object obj) {
        if (obj instanceof Number) {
            return true;
        }
        return isInt(obj) || isDouble(obj);
    }

    /**
     * 参数是否是有效整数
     *
     * @param obj 参数（对象将被调用string()转为字符串类型）
     * @return 是否是整数
     */
    private static boolean isInt(Object obj) {
        if (isNullOrEmpty(obj)) {
            return false;
        }
        if (obj instanceof Integer) {
            return true;
        }
        return obj.toString().matches("[-+]?\\d+");
    }

    /**
     * 字符串参数是否是double
     *
     * @param obj 参数（对象将被调用string()转为字符串类型）
     * @return 是否是double
     */
    private static boolean isDouble(Object obj) {
        if (isNullOrEmpty(obj)) {
            return false;
        }
        if (obj instanceof Double || obj instanceof Float) {
            return true;
        }
        return compileRegex("[-+]?\\d+\\.\\d+").matcher(obj.toString()).matches();
    }

    /**
     * 对象是否为无效值
     *
     * @param obj 要判断的对象
     * @return 是否为有效值（不为null 和 "" 字符串）
     */
    private static boolean isNullOrEmpty(Object obj) {
        return obj == null || "".equals(obj.toString());
    }

    private static final Map<String, Pattern> PATTERN_CACHE = new ConcurrentHashMap<>();

    /**
     * 编译一个正则表达式，并且进行缓存,如果缓存已存在则使用缓存
     *
     * @param regex 表达式
     * @return 编译后的Pattern
     */
    private static Pattern compileRegex(String regex) {
        Pattern pattern = PATTERN_CACHE.get(regex);
        if (pattern == null) {
            pattern = Pattern.compile(regex);
            PATTERN_CACHE.put(regex, pattern);
        }
        return pattern;
    }
}
