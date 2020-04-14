package com.spark.zwanandroid.model.beans;



/**
 * desc:
 *
 * @author Bian
 * create at 2018/12/26
 */
public class UserEntity {
    /**
     * 头像
     */
    private String headImg;
    /**
     * 账号
     */
    private String loginName;
    /**
     * 商家类型 code-name 1-AGENT 2-MERCHANT
     */

    /**
     * 昵称
     */
    private String nickName;
    /**
     * 费率
     */
    private String rate;
    /**
     * token
     */
    private String token;
    /**
     * 推荐人名
     */
    private String parentNickName;
    /**
     * 推荐人手机号
     */
    private String parentPhone;

    private Integer userId;

    public String getParentNickName() {
        return parentNickName;
    }

    public void setParentNickName(String parentNickName) {
        this.parentNickName = parentNickName;
    }

    public String getParentPhone() {
        return parentPhone;
    }

    public void setParentPhone(String parentPhone) {
        this.parentPhone = parentPhone;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
