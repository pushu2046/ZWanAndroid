package com.spark.zwanandroid.model.http.helper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

/**
 * desc:
 *
 * @author Bian
 * create at 2018/12/20
 */
public class PacketsHelper {

    @Inject
    public PacketsHelper() {
    }

    /**
     * 登录对象
     */
    Map<String, String> login(String loginName, String password) {
        Map<String, String> map = new HashMap<>(2);
        map.put("loginName", loginName);
        map.put("password", password);
        return map;
    }

    /**
     * 注册对象
     */
    Map<String, String> register(String phone, String validateCode, String password, String linkMan) {
        Map<String, String> map = new HashMap<>(4);
        map.put("phone", phone);
        map.put("validateCode", validateCode);
        map.put("password", password);
        map.put("linkMan", linkMan);
        return map;
    }

    /**
     * 修改密码
     */
/*    Map<String, String> updatePassword(String phone, String validateCode, String password) {
        Map<String, String> map = new HashMap<>(6);
        map.put("phone", phone);
        map.put("userId", String.valueOf(Constants.getInstance().getUserId()));
        map.put("validateCode", validateCode);
        map.put("password", password);
        map.put("checkPassword", password);
        return map;
    }*/

    /**
     * 修改个人信息
     */
 /*   public Map<String, String> modify(String nickName, String headImg) {
        Map<String, String> map = new HashMap<>(2);
        if (StringUtils.isNotEmpty(nickName)) {
            map.put("nickName", nickName);
        }
        if (StringUtils.isNotEmpty(headImg)) {
            map.put("headImg", headImg);
        }
        return map;
    }*/

    /**
     * 修改个人账号
     */
    public Map<String, String> modifyAccount(String newLoginName) {
        Map<String, String> map = new HashMap<>(2);
        map.put("newLoginName", newLoginName);
        return map;
    }

    /**
     * 渠道拓展
     */
    public Map<String, String> channelExpand(int level, String linkName, String loginName, String password, String email, String rate) {
        Map<String, String> map = new HashMap<>(8);
        if (level == 4) {
            map.put("merchantType", "MERCHANT");
        } else {
            map.put("merchantType", "AGENT");
        }
        map.put("level", String.valueOf(level));
        map.put("loginName", loginName);
        map.put("password", password);
        map.put("email", email);
        map.put("rate", rate);
        map.put("linkMan", linkName);
        return map;
    }

    /**
     * 申请实名认证
     */
/*    public AuthenticateBean applyAuthenticate(String idFrontImg, String idBackImg, String idName, String idNo,
                                              String idExpire, String email, String bankCardImg, String bankAccountName, String bankNo, String bankAccountNo) {
        AuthenticateBean bean = new AuthenticateBean();
        bean.setIdFrontImg(idFrontImg);
        bean.setIdBackImg(idBackImg);
        bean.setIdName(idName);
        bean.setIdNo(idNo);
        bean.setIdExpire(idExpire);
        bean.setEmail(email);
        bean.setBankCardImg(bankCardImg);
        bean.setBankAccountName(bankAccountName);
        bean.setBankNo(bankNo);
        bean.setBankAccountNo(bankAccountNo);
        return bean;
    }*/

    /**
     * 申请提现
     */
    public Map<String, String> requestProfit(String bankNo, String bankName, String withdrawMoney) {
        Map<String, String> map = new HashMap<>(2);
        map.put("bankNo", bankNo);
        map.put("bankName", bankName);
        map.put("withdrawAmount", withdrawMoney);
        return map;
    }

    /**
     * 对公账户
     */
  /*  public UploadDataBean applyPublic(String legalIdFront, String legalIdBehind, String legalPersonName,
                                      String legalPersonIdNo, String legalPersonIdExpire, String mailBox, String storeName,
                                      String storeAreaCode, String storeAddress, String businessLicense, String openAccount,
                                      String businessLicenseNo, String businessLicenseName, String businessLicenseExpire, String businessLicenseAddress,
                                      String bankAccountName, String bankNo, String settlementAccountNo, List<OtherEntity> mData, String accountType) {
        UploadDataBean uploadDataBean = new UploadDataBean();
        uploadDataBean.setAccountType(accountType);
        PictureBean pictureBean = new PictureBean();
        PictureFormBean bean1 = new PictureFormBean();
        bean1.setPicUrl(legalIdFront);
        pictureBean.setLegalIdFront(bean1);
        PictureFormBean bean2 = new PictureFormBean();
        bean2.setPicUrl(legalIdBehind);
        pictureBean.setLegalIdBehind(bean2);
        PictureFormBean bean3 = new PictureFormBean();
        bean3.setPicUrl(businessLicense);
        pictureBean.setBusinessLicense(bean3);
        PictureFormBean bean4 = new PictureFormBean();
        bean4.setPicUrl(openAccount);
        pictureBean.setOpenAccount(bean4);
        PictureFormBean formBean0 = new PictureFormBean();
        formBean0.setPicUrl(mData.get(0).getMip());
        pictureBean.setAgreement(formBean0);
        PictureFormBean formBean1 = new PictureFormBean();
        formBean1.setPicUrl(mData.get(1).getMip());
        pictureBean.setMerchantInfo(formBean1);
        PictureFormBean formBean2 = new PictureFormBean();
        formBean2.setPicUrl(mData.get(2).getMip());
        pictureBean.setDoor(formBean2);
        PictureFormBean formBean3 = new PictureFormBean();
        formBean3.setPicUrl(mData.get(3).getMip());
        pictureBean.setScene(formBean3);
        PictureFormBean formBean4 = new PictureFormBean();
        formBean4.setPicUrl(mData.get(4).getMip());
        pictureBean.setCashier(formBean4);
        uploadDataBean.setPictureBean(pictureBean);
        uploadDataBean.setLegalPersonName(legalPersonName);
        uploadDataBean.setLegalPersonIdNo(legalPersonIdNo);
        uploadDataBean.setLegalPersonIdExpire(legalPersonIdExpire);
        uploadDataBean.setMailBox(mailBox);
        uploadDataBean.setStoreName(storeName);
        uploadDataBean.setStoreAreaCode(storeAreaCode);
        uploadDataBean.setStoreAddress(storeAddress);
        uploadDataBean.setBusinessLicenseNo(businessLicenseNo);
        uploadDataBean.setBusinessLicenseName(businessLicenseName);
        uploadDataBean.setBusinessLicenseExpire(businessLicenseExpire);
        uploadDataBean.setBusinessLicenseAddress(businessLicenseAddress);
        uploadDataBean.setBankAccountName(bankAccountName);
        uploadDataBean.setBankNo(bankNo);
        uploadDataBean.setSettlementAccountNo(settlementAccountNo);
        return uploadDataBean;
    }*/

    /**
     * 小微商户
     */
  /*  public UploadDataBean applySmall(String legalIdFront, String legalIdBehind, String legalPersonName,
                                     String legalPersonIdNo, String legalPersonIdExpire, String mailBox, String storeName,
                                     String storeAreaCode, String storeAddress, String bankCard, String bankAccountName, String bankNo,
                                     String settlementAccountNo, List<OtherEntity> mData, String accountType) {
        UploadDataBean uploadDataBean = new UploadDataBean();
        uploadDataBean.setAccountType(accountType);
        PictureBean pictureBean = new PictureBean();
        PictureFormBean bean1 = new PictureFormBean();
        bean1.setPicUrl(legalIdFront);
        pictureBean.setLegalIdFront(bean1);
        PictureFormBean bean2 = new PictureFormBean();
        bean2.setPicUrl(legalIdBehind);
        pictureBean.setLegalIdBehind(bean2);
        PictureFormBean bean3 = new PictureFormBean();
        bean3.setPicUrl(bankCard);
        pictureBean.setBankCard(bean3);
        PictureFormBean formBean0 = new PictureFormBean();
        formBean0.setPicUrl(mData.get(0).getMip());
        pictureBean.setAgreement(formBean0);
        PictureFormBean formBean1 = new PictureFormBean();
        formBean1.setPicUrl(mData.get(1).getMip());
        pictureBean.setMerchantInfo(formBean1);
        PictureFormBean formBean2 = new PictureFormBean();
        formBean2.setPicUrl(mData.get(2).getMip());
        pictureBean.setDoor(formBean2);
        PictureFormBean formBean3 = new PictureFormBean();
        formBean3.setPicUrl(mData.get(3).getMip());
        pictureBean.setScene(formBean3);
        PictureFormBean formBean4 = new PictureFormBean();
        formBean4.setPicUrl(mData.get(4).getMip());
        pictureBean.setCashier(formBean4);
        PictureFormBean formBean5 = new PictureFormBean();
        formBean5.setPicUrl(mData.get(5).getMip());
        pictureBean.setLegalWithId(formBean5);
        uploadDataBean.setPictureBean(pictureBean);
        uploadDataBean.setLegalPersonName(legalPersonName);
        uploadDataBean.setLegalPersonIdNo(legalPersonIdNo);
        uploadDataBean.setLegalPersonIdExpire(legalPersonIdExpire);
        uploadDataBean.setMailBox(mailBox);
        uploadDataBean.setStoreName(storeName);
        uploadDataBean.setStoreAreaCode(storeAreaCode);
        uploadDataBean.setStoreAddress(storeAddress);
        uploadDataBean.setBankAccountName(bankAccountName);
        uploadDataBean.setBankNo(bankNo);
        uploadDataBean.setSettlementAccountNo(settlementAccountNo);
        return uploadDataBean;
    }*/

    /**
     * 对私同法人
     */
   /* public UploadDataBean applyPrivateSelf(String legalIdFront, String legalIdBehind, String legalPersonName, String legalPersonIdNo,
                                           String legalPersonIdExpire, String mailBox, String storeName, String storeAreaCode, String storeAddress,
                                           String bankCard, String bankAccountName, String bankNo, String settlementAccountNo, String businessLicense,
                                           String businessLicenseNo, String businessLicenseName, String businessLicenseExpire, String businessLicenseAddress,
                                           List<OtherEntity> mData, String accountType) {
        UploadDataBean uploadDataBean = new UploadDataBean();
        uploadDataBean.setAccountType(accountType);
        PictureBean pictureBean = new PictureBean();
        PictureFormBean bean1 = new PictureFormBean();
        bean1.setPicUrl(legalIdFront);
        pictureBean.setLegalIdFront(bean1);
        PictureFormBean bean2 = new PictureFormBean();
        bean2.setPicUrl(legalIdBehind);
        pictureBean.setLegalIdBehind(bean2);
        PictureFormBean bean3 = new PictureFormBean();
        bean3.setPicUrl(bankCard);
        pictureBean.setBankCard(bean3);
        PictureFormBean bean4 = new PictureFormBean();
        bean4.setPicUrl(businessLicense);
        pictureBean.setBusinessLicense(bean4);
        PictureFormBean formBean0 = new PictureFormBean();
        formBean0.setPicUrl(mData.get(0).getMip());
        pictureBean.setAgreement(formBean0);
        PictureFormBean formBean1 = new PictureFormBean();
        formBean1.setPicUrl(mData.get(1).getMip());
        pictureBean.setMerchantInfo(formBean1);
        PictureFormBean formBean2 = new PictureFormBean();
        formBean2.setPicUrl(mData.get(2).getMip());
        pictureBean.setDoor(formBean2);
        PictureFormBean formBean3 = new PictureFormBean();
        formBean3.setPicUrl(mData.get(3).getMip());
        pictureBean.setScene(formBean3);
        PictureFormBean formBean4 = new PictureFormBean();
        formBean4.setPicUrl(mData.get(4).getMip());
        pictureBean.setCashier(formBean4);
        uploadDataBean.setPictureBean(pictureBean);
        uploadDataBean.setLegalPersonName(legalPersonName);
        uploadDataBean.setLegalPersonIdNo(legalPersonIdNo);
        uploadDataBean.setLegalPersonIdExpire(legalPersonIdExpire);
        uploadDataBean.setMailBox(mailBox);
        uploadDataBean.setStoreName(storeName);
        uploadDataBean.setStoreAreaCode(storeAreaCode);
        uploadDataBean.setStoreAddress(storeAddress);
        uploadDataBean.setBankAccountName(bankAccountName);
        uploadDataBean.setBankNo(bankNo);
        uploadDataBean.setSettlementAccountNo(settlementAccountNo);
        uploadDataBean.setBusinessLicenseNo(businessLicenseNo);
        uploadDataBean.setBusinessLicenseName(businessLicenseName);
        uploadDataBean.setBusinessLicenseExpire(businessLicenseExpire);
        uploadDataBean.setBusinessLicenseAddress(businessLicenseAddress);
        return uploadDataBean;
    }*/

    /**
     * 对私非法人
     */
/*    public UploadDataBean applyPrivateNotSelf(String legalIdFront, String legalIdBehind, String legalPersonName, String legalPersonIdNo,
                                              String legalPersonIdExpire, String mailBox, String storeName, String storeAreaCode, String storeAddress,
                                              String settlementIdFront, String settlementIdBehind, String settlementPersonName, String settlementPersonIdNo,
                                              String settlementPersonIdExpire, String bankCard, String bankAccountName, String bankNo, String settlementAccountNo,
                                              String businessLicense, String businessLicenseNo, String businessLicenseName, String businessLicenseExpire,
                                              String businessLicenseAddress, List<OtherEntity> mData, String accountType) {
        UploadDataBean uploadDataBean = new UploadDataBean();
        uploadDataBean.setAccountType(accountType);
        PictureBean pictureBean = new PictureBean();
        PictureFormBean bean1 = new PictureFormBean();
        bean1.setPicUrl(legalIdFront);
        pictureBean.setLegalIdFront(bean1);
        PictureFormBean bean2 = new PictureFormBean();
        bean2.setPicUrl(legalIdBehind);
        pictureBean.setLegalIdBehind(bean2);
        PictureFormBean bean3 = new PictureFormBean();
        bean3.setPicUrl(settlementIdFront);
        pictureBean.setSettlementIdFront(bean3);
        PictureFormBean bean4 = new PictureFormBean();
        bean4.setPicUrl(settlementIdBehind);
        pictureBean.setSettlementIdBehind(bean4);
        PictureFormBean bean5 = new PictureFormBean();
        bean5.setPicUrl(bankCard);
        pictureBean.setBankCard(bean5);
        PictureFormBean bean6 = new PictureFormBean();
        bean6.setPicUrl(businessLicense);
        pictureBean.setBusinessLicense(bean6);
        PictureFormBean formBean0 = new PictureFormBean();
        formBean0.setPicUrl(mData.get(0).getMip());
        pictureBean.setAuthAccount(formBean0);
        PictureFormBean formBean1 = new PictureFormBean();
        formBean1.setPicUrl(mData.get(1).getMip());
        pictureBean.setAgreement(formBean1);
        PictureFormBean formBean2 = new PictureFormBean();
        formBean2.setPicUrl(mData.get(2).getMip());
        pictureBean.setMerchantInfo(formBean2);
        PictureFormBean formBean3 = new PictureFormBean();
        formBean3.setPicUrl(mData.get(3).getMip());
        pictureBean.setScene(formBean3);
        PictureFormBean formBean4 = new PictureFormBean();
        formBean4.setPicUrl(mData.get(4).getMip());
        pictureBean.setCashier(formBean4);
        PictureFormBean formBean5 = new PictureFormBean();
        formBean5.setPicUrl(mData.get(5).getMip());
        pictureBean.setDoor(formBean5);
        PictureFormBean formBean6 = new PictureFormBean();
        formBean6.setPicUrl(mData.get(6).getMip());
        pictureBean.setLegalWithId(formBean6);
        uploadDataBean.setPictureBean(pictureBean);
        uploadDataBean.setLegalPersonName(legalPersonName);
        uploadDataBean.setLegalPersonIdNo(legalPersonIdNo);
        uploadDataBean.setLegalPersonIdExpire(legalPersonIdExpire);
        uploadDataBean.setMailBox(mailBox);
        uploadDataBean.setStoreName(storeName);
        uploadDataBean.setStoreAreaCode(storeAreaCode);
        uploadDataBean.setStoreAddress(storeAddress);
        uploadDataBean.setSettlementPersonName(settlementPersonName);
        uploadDataBean.setSettlementPersonIdNo(settlementPersonIdNo);
        uploadDataBean.setSettlementPersonIdExpire(settlementPersonIdExpire);
        uploadDataBean.setBankAccountName(bankAccountName);
        uploadDataBean.setBankNo(bankNo);
        uploadDataBean.setSettlementAccountNo(settlementAccountNo);
        uploadDataBean.setBusinessLicenseNo(businessLicenseNo);
        uploadDataBean.setBusinessLicenseName(businessLicenseName);
        uploadDataBean.setBusinessLicenseExpire(businessLicenseExpire);
        uploadDataBean.setBusinessLicenseAddress(businessLicenseAddress);
        return uploadDataBean;
    }*/

    /**
     * 收入明细
     */
  /*  public Map<String, String> incomeList(int pageNum, String startDate, String endDate, String onlineFlag, String payChannel, String orderStatus) {
        Map<String, String> map = new HashMap<>(8);
        map.put("pageNum", String.valueOf(pageNum));
        if (StringUtils.isNotEmpty(startDate)) {
            map.put("startDate", startDate);
        }
        if (StringUtils.isNotEmpty(endDate)) {
            map.put("endDate", endDate);
        }
        if (StringUtils.isNotEmpty(onlineFlag)) {
            map.put("onlineFlag", onlineFlag);
        }
        if (StringUtils.isNotEmpty(payChannel)) {
            map.put("payChannel", payChannel);
        }
        if (StringUtils.isNotEmpty(orderStatus)) {
            map.put("orderStatus", orderStatus);
        }
        map.put("pageSize", String.valueOf(Constants.PAGE_SIZE));
        return map;
    }*/

  /*  public Map<String, String> channelWater(int pageNum, String merchantType) {
        Map<String, String> map = new HashMap<>(2);
        map.put("pageNum", String.valueOf(pageNum));
        map.put("pageSize", String.valueOf(Constants.PAGE_SIZE));
        map.put("merchantType", merchantType);
        return map;
    }
*/


    //供应商订单列表
    /*public Map<String, String> getSupplierOrderList(int pageNum) {
        Map<String, String> map = new HashMap<>(8);
        map.put("pageNum", String.valueOf(pageNum));
        map.put("pageSize", String.valueOf(Constants.PAGE_SIZE));
        return map;
    }*/

    //商户订单列表
  /*  public Map<String, String> getMerchantOrderList(int pageNum) {
        Map<String, String> map = new HashMap<>(8);
        map.put("pageNum", String.valueOf(pageNum));
        map.put("pageSize", String.valueOf(Constants.PAGE_SIZE));
        return map;
    }*/


 /*   public Map<String, String> getMainPushMsg(int pageNum, int pageSize){

        Map<String, String> map = new HashMap<>(8);

        map.put("pageNum", String.valueOf(pageNum));
        map.put("pageSize", String.valueOf(Constants.PAGE_SIZE));

        return map;
    }*/


/*    public PostBackSureMoneyBean backSureMoney(String bankNo, String bankName, String backMoney){
        PostBackSureMoneyBean body = new PostBackSureMoneyBean();
        body.setWithdrawAmount(backMoney);
        body.setBankName(bankName);
        body.setBankNo(bankNo);
        return body;
    }*/
}
