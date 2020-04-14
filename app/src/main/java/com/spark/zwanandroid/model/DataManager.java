package com.spark.zwanandroid.model;


import com.spark.zwanandroid.model.beans.BannerEntity;
import com.spark.zwanandroid.model.beans.UserEntity;
import com.spark.zwanandroid.model.http.api.BaseResponse;
import com.spark.zwanandroid.model.http.helper.HttpHelper;
import com.spark.zwanandroid.model.http.helper.IHttpHelper;
import com.spark.zwanandroid.model.sp.IPreferencesHelper;
import com.spark.zwanandroid.model.sp.PreferencesHelper;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * desc:数据获取管理类
 *
 * @author Bian
 * create at 2018/12/14 15:11
 */
@Singleton
public class DataManager implements IHttpHelper, IPreferencesHelper {

    private PreferencesHelper mPreferences;
    private HttpHelper mHttp;

    @Inject
    DataManager(HttpHelper mHttp, PreferencesHelper mPreferences) {
        this.mHttp = mHttp;
        this.mPreferences = mPreferences;
    }

    @Override
    public void setLoginAccount(String account) {
        
    }

    @Override
    public void setLoginPassword(String password) {

    }

    @Override
    public void setUserToken(String token) {

    }

    @Override
    public void setSpeechOpenStatus(boolean flag) {

    }

    @Override
    public String getLoginAccount() {
        return null;
    }

    @Override
    public String getLoginPassword() {
        return null;
    }

    @Override
    public String getUserToken() {
        return null;
    }

    @Override
    public Observable<BaseResponse<UserEntity>> login(String loginName, String password) {
        return mHttp.login(loginName,password);
    }

    @Override
    public Observable<BaseResponse<List<BannerEntity>>> homeBanner() {
        return mHttp.homeBanner();
    }

   /* @Override
    public Observable<BaseResponse<UserEntity>> login(String loginName, String password) {
        return mHttp.login(loginName, password);
    }

    @Override
    public Observable<BaseResponse<String>> checkToken(String token) {
        return mHttp.checkToken(token);
    }

    @Override
    public Observable<BaseResponse<String>> validateCode(String phone) {
        return mHttp.validateCode(phone);
    }

    @Override
    public Observable<BaseResponse<String>> register(String phone, String validateCode, String password, String linkMan) {
        return mHttp.register(phone, validateCode, password, linkMan);
    }

    @Override
    public Observable<BaseResponse<String>> updatePassword(String phone, String validateCode, String password) {
        return mHttp.updatePassword(phone, validateCode, password);
    }

    @Override
    public Observable<BaseResponse<List<GradeEntity>>> gradeList() {
        return mHttp.gradeList();
    }

    @Override
    public Observable<BaseResponse<CodeEntity>> gradeCode(int grade) {
        return mHttp.gradeCode(grade);
    }

    @Override
    public Observable<BaseResponse<ListRes<ChannelEntity>>> channelMgrAgentList(int pageNum) {
        return mHttp.channelMgrAgentList(pageNum);
    }

    @Override
    public Observable<BaseResponse<ListRes<ChannelEntity>>> channelMgrMerchantList(int pageNum) {
        return mHttp.channelMgrMerchantList(pageNum);
    }

    @Override
    public Observable<BaseResponse<ListRes<ChannelEntity>>> channelWaterList(int pageNum, String merchantType) {
        return mHttp.channelWaterList(pageNum, merchantType);
    }

    @Override
    public Observable<BaseResponse> waterListTotal(int pageNum, String merchantType) {
        return mHttp.waterListTotal(pageNum, merchantType);
    }

    @Override
    public Observable<BaseResponse<StatusEntity>> userStatus() {
        return mHttp.userStatus();
    }

    @Override
    public Observable<BaseResponse<AuthenticateStatusEntity>> authenticateStatus() {
        return mHttp.authenticateStatus();
    }

    @Override
    public Observable<BaseResponse<String>> examplePicture(String picName) {
        return mHttp.examplePicture(picName);
    }

    @Override
    public Observable<BaseResponse<AuthenticateEntity>> authenticateDetail() {
        return mHttp.authenticateDetail();
    }

    *//**
     * 申请实名认证
     *//*
    @Override
    public Observable<BaseResponse<String>> applyAuthenticate(String idFrontImg, String idBackImg,
                                                              String idName, String idNo, String idExpire, String email, String bankCardImg,
                                                              String bankAccountName, String bankNo, String bankAccountNo) {
        return mHttp.applyAuthenticate(idFrontImg, idBackImg, idName, idNo, idExpire, email, bankCardImg, bankAccountName, bankNo, bankAccountNo);
    }

    @Override
    public Observable<BaseResponse<String>> applyPublic(String legalIdFront, String legalIdBehind, String legalPersonName,
                                                        String legalPersonIdNo, String legalPersonIdExpire, String mailBox,
                                                        String storeName, String storeAreaCode, String storeAddress, String businessLicense,
                                                        String openAccount, String businessLicenseNo, String businessLicenseName,
                                                        String businessLicenseExpire, String businessLicenseAddress, String bankAccountName,
                                                        String bankNo, String settlementAccountNo, List<OtherEntity> mData, String accountType) {
        return mHttp.applyPublic(legalIdFront, legalIdBehind, legalPersonName, legalPersonIdNo, legalPersonIdExpire, mailBox, storeName, storeAreaCode, storeAddress,
                businessLicense, openAccount, businessLicenseNo, businessLicenseName, businessLicenseExpire, businessLicenseAddress, bankAccountName, bankNo, settlementAccountNo, mData, accountType);
    }

    @Override
    public Observable<BaseResponse<String>> applySmall(String legalIdFront, String legalIdBehind, String legalPersonName, String legalPersonIdNo,
                                                       String legalPersonIdExpire, String mailBox, String storeName, String storeAreaCode, String storeAddress,
                                                       String bankCard, String bankAccountName, String bankNo, String settlementAccountNo, List<OtherEntity> mData,
                                                       String accountType) {
        return mHttp.applySmall(legalIdFront, legalIdBehind, legalPersonName, legalPersonIdNo, legalPersonIdExpire, mailBox, storeName, storeAreaCode, storeAddress,
                bankCard, bankAccountName, bankNo, settlementAccountNo, mData, accountType);
    }

    @Override
    public Observable<BaseResponse<String>> applyPrivateSelf(String legalIdFront, String legalIdBehind, String legalPersonName,
                                                             String legalPersonIdNo, String legalPersonIdExpire, String mailBox,
                                                             String storeName, String storeAreaCode, String storeAddress, String bankCard,
                                                             String bankAccountName, String bankNo, String settlementAccountNo, String businessLicense,
                                                             String businessLicenseNo, String businessLicenseName, String businessLicenseExpire,
                                                             String businessLicenseAddress, List<OtherEntity> mData, String accountType) {
        return mHttp.applyPrivateSelf(legalIdFront, legalIdBehind, legalPersonName, legalPersonIdNo, legalPersonIdExpire, mailBox, storeName, storeAreaCode, storeAddress,
                bankCard, bankAccountName, bankNo, settlementAccountNo, businessLicense, businessLicenseNo, businessLicenseName, businessLicenseExpire,
                businessLicenseAddress, mData, accountType);
    }

    @Override
    public Observable<BaseResponse<String>> applyPrivateNotSelf(String legalIdFront, String legalIdBehind, String legalPersonName, String legalPersonIdNo, String legalPersonIdExpire, String mailBox, String storeName, String storeAreaCode, String storeAddress, String settlementIdFront, String settlementIdBehind, String settlementPersonName, String settlementPersonIdNo, String settlementPersonIdExpire, String bankCard, String bankAccountName, String bankNo, String settlementAccountNo, String businessLicense, String businessLicenseNo, String businessLicenseName, String businessLicenseExpire, String businessLicenseAddress, List<OtherEntity> mData, String accountType) {
        return mHttp.applyPrivateNotSelf(legalIdFront, legalIdBehind, legalPersonName, legalPersonIdNo, legalPersonIdExpire,
                mailBox, storeName, storeAreaCode, storeAddress, settlementIdFront, settlementIdBehind, settlementPersonName, settlementPersonIdNo,
                settlementPersonIdExpire, bankCard, bankAccountName, bankNo, settlementAccountNo, businessLicense, businessLicenseNo, businessLicenseName,
                businessLicenseExpire, businessLicenseAddress, mData, accountType);
    }

    @Override
    public Observable<BaseResponse<String>> channelExpand(int level, String linkName, String loginName, String password, String email, String rate) {
        return mHttp.channelExpand(level, linkName, loginName, password, email, rate);
    }

    @Override
    public Observable<BaseResponse<ListRes<MessageEntity>>> messageList(String type, int pageNum) {
        return mHttp.messageList(type, pageNum);
    }

    @Override
    public Observable<BaseResponse<IncomeDetailEntity>> orderMessageInfo(String orderId) {
        return mHttp.orderMessageInfo(orderId);
    }

    @Override
    public Observable<BaseResponse<ModifyEntity>> modifyInfo(String nick, String head) {
        return mHttp.modifyInfo(nick, head);
    }

    @Override
    public Observable<BaseResponse<String>> modifyAccount(String newLoginName) {
        return mHttp.modifyAccount(newLoginName);
    }

    @Override
    public Observable<BaseResponse<String>> uploadPicture(String path) {
        return mHttp.uploadPicture(path);
    }


    @Override
    public Observable<BaseResponse<ListRes<GuideEntity>>> guideList(int pageNum) {
        return mHttp.guideList(pageNum);
    }

    @Override
    public Observable<BaseResponse<VersionEntity>> versionInfo() {
        return mHttp.versionInfo();
    }


    @Override
    public Observable<BaseResponse<String>> exitLogin() {
        return mHttp.exitLogin();
    }


    *//**
     * 获取提现列表 指定时间
     *//*
    @Override
    public Observable<BaseResponse<ListRes<WithdrawEntity>>> withDrawRecordList(String withdrawMonthDate, String withdrawType, int pageNum) {
        return mHttp.withDrawRecordList(withdrawMonthDate, withdrawType, pageNum);
    }

    *//**
     * 获取银行卡信息
     *
     * @return Observable
     *//*
    @Override
    public Observable<BaseResponse<BankEntity>> bankcardInformation() {
        return mHttp.bankcardInformation();
    }

    @Override
    public Observable<BaseResponse<WithdrawEntity>> withdrawDetail(int withdrawId) {
        return mHttp.withdrawDetail(withdrawId);
    }

    @Override
    public Observable<BaseResponse<List<EnumBean>>> verifyTypes() {
        return mHttp.verifyTypes();
    }

    @Override
    public Observable<BaseResponse<List<BankEntity>>> bankList(String bankName) {
        return mHttp.bankList(bankName);
    }

    *//**
     * 查询开户行、可提现金额
     *
     * @return Observable
     *//*
    @Override
    public Observable<BaseResponse<WithdrawEntity>> withdrawAmount() {
        return mHttp.withdrawAmount();
    }

    *//**
     * 查询提现手续费
     *
     * @param withdrawMoney 提现金额
     * @return Observable
     *//*
    @Override
    public Observable<BaseResponse<String>> withdrawFee(String withdrawMoney) {
        return mHttp.withdrawFee(withdrawMoney);
    }

    @Override
    public Observable<BaseResponse<RuleEntity>> withdrawRule() {
        return mHttp.withdrawRule();
    }

    *//**
     * 申请提现
     *
     * @param bankNo        开户行卡号
     * @param bankName      开户行名称
     * @param withdrawMoney 提现金额
     * @param isIncome      是否是流水 ( true 是流水 false 是分润)
     * @return Observable
     *//*
    @Override
    public Observable<BaseResponse<String>> requestProfitIncome(String bankNo, String bankName, String withdrawMoney, boolean isIncome) {
        return mHttp.requestProfitIncome(bankNo, bankName, withdrawMoney, isIncome);
    }

    @Override
    public Observable<BaseResponse<List<AreaEntity>>> areaList(String name) {
        return mHttp.areaList(name);
    }

    *//**
     * 我的收入--今日收入、总收入、暂不可提现金额等
     *
     * @return Observable
     *//*
    @Override
    public Observable<BaseResponse<IncomeEntity>> accountIncome() {
        return mHttp.accountIncome();
    }

    @Override
    public Observable<BaseResponse<String>> scanMoney(String payCode, String payChannel, String amount) {
        return mHttp.scanMoney(payCode, payChannel, amount);
    }

    @Override
    public Observable<BaseResponse<Map<String, String>>> receiptMoney(String payChannel, String amount) {
        return mHttp.receiptMoney(payChannel, amount);
    }

    @Override
    public Observable<BaseResponse<String>> orderStatus(String orderNumber) {
        return mHttp.orderStatus(orderNumber);
    }

    @Override
    public Observable<BaseResponse<String>> mineCode() {
        return mHttp.mineCode();
    }

    @Override
    public Observable<BaseResponse<ListRes<IncomeDetailEntity>>> incomeList(int pageNum, String startDate, String endDate, String onlineFlag, String payChannel, String orderStatus) {
        return mHttp.incomeList(pageNum, startDate, endDate, onlineFlag, payChannel, orderStatus);
    }

    @Override
    public Observable<BaseResponse> incomeListTotal(int pageNum, String startDate, String endDate, String onlineFlag, String payChannel, String orderStatus) {
        return mHttp.incomeListTotal(pageNum, startDate, endDate, onlineFlag, payChannel, orderStatus);
    }

    @Override
    public Observable<BaseResponse<ListRes<ProfitDetailEntity>>> profitList(int pageNum, String merchantType) {
        return mHttp.profitList(pageNum, merchantType);
    }

    @Override
    public Observable<BaseResponse<String>> refundMoney(String orderNo) {
        return mHttp.refundMoney(orderNo);
    }

    @Override
    public Observable<BaseResponse<ProfitEntity>> agentProfit() {
        return mHttp.agentProfit();
    }

    @Override
    public Observable<BaseResponse<IncomeEntity>> merchantIncome() {
        return mHttp.merchantIncome();
    }


    @Override
    public Observable<BaseResponse<String>> contactService() {
        return mHttp.contactService();
    }

    @Override
    public Observable<BaseResponse<String>> deleteMessage(String messageType) {
        return mHttp.deleteMessage(messageType);
    }

    @Override
    public Observable<BaseResponse<List<OrderItemEntity>>> getOrderList(int pageNum) {
        return mHttp.getOrderList(pageNum);
    }

    @Override
    public Observable<BaseResponse<ListRes<SupplierOrderEntity>>> getSupplierOrderList(int pageNum) {
        return mHttp.getSupplierOrderList(pageNum);
    }

    @Override
    public Observable<BaseResponse<ListRes<OrderDetailEntity>>> getMerchantOrderList(int pageNum) {
        return mHttp.getMerchantOrderList(pageNum);
    }

    @Override
    public Observable<BaseResponse<String>> chargeMoney(String money) {
        return mHttp.chargeMoney(money);
    }

    @Override
    public Observable<BaseResponse<ListRes<ChargeMoneyEntity>>> getChargeMoneyList(int pageNum) {
        return mHttp.getChargeMoneyList(pageNum);
    }



    *//**
     * 我的账户分润信息（可提现分润、不可提现分润、已提现分润、今日总分润、累计总分润等）
     *
     * @return Observable
     *//*
    @Override
    public Observable<BaseResponse<ProfitEntity>> accountProfit() {
        return mHttp.accountProfit();
    }

    @Override
    public void setLoginAccount(String account) {
        mPreferences.setLoginAccount(account);
    }

    @Override
    public void setLoginPassword(String password) {
        mPreferences.setLoginPassword(password);
    }

    @Override
    public void setUserToken(String token) {
        mPreferences.setUserToken(token);
    }

    @Override
    public void setSpeechOpenStatus(boolean flag) {
        mPreferences.setSpeechOpenStatus(flag);
    }

    @Override
    public String getLoginAccount() {
        return mPreferences.getLoginAccount();
    }

    @Override
    public String getLoginPassword() {
        return mPreferences.getLoginPassword();
    }

    @Override
    public String getUserToken() {
        return mPreferences.getUserToken();
    }

    @Override
    public boolean getSpeechOpenStatus() {
        return mPreferences.getSpeechOpenStatus();
    }



    @Override
    public Observable<BaseResponse<AppVersionEntity>> getAppVersion(String terminal) {
        return mHttp.getAppVersion(terminal);
    }

    @Override
    public Observable<BaseResponse<OrderSimpleBean>> getOrderSimpleInfo(String startDate, String endDate) {
        return mHttp.getOrderSimpleInfo(startDate,endDate);
    }

    @Override
    public Observable<BaseResponse<List<SimpleGoodsBean>>> getHotSell(String startDate, String endDate) {
        return mHttp.getHotSell(startDate,endDate);
    }

    @Override
    public Observable<BaseResponse<List<SimpleGoodsBean>>> getColdSell(String startDate, String endDate) {
        return mHttp.getColdSell(startDate,endDate);
    }

    @Override
    public Observable<BaseResponse<OrderSummaryBean>> getOrderSummary() {
        return mHttp.getOrderSummary();
    }

    @Override
    public Observable<BaseResponse<MemberInfoBean>> getMemberInfo(String startDate, String endDate) {
        return mHttp.getMemberInfo(startDate,endDate);
    }

    @Override
    public Observable<BaseResponse<ListRes<MainMsgBean>>> getMainPushMsg(int pageNum, int pageSize) {
        return mHttp.getMainPushMsg(pageNum,pageSize);
    }

    @Override
    public Observable<BaseResponse<MsgSimpleDetail>> getMainPushDetail(String mainPushReceiveRecordId) {
        return mHttp.getMainPushDetail(mainPushReceiveRecordId);
    }

    @Override
    public Observable<BaseResponse<SureMoneyBean>> getSureMoneyData() {
        return mHttp.getSureMoneyData();
    }

    @Override
    public Observable<BaseResponse<String>> chargeSureMoney(String payment) {
        return mHttp.chargeSureMoney(payment);
    }

    @Override
    public Observable<BaseResponse<String>> backSureMoney(String bankNo, String bankName, String backMoney) {
        return mHttp.backSureMoney(bankNo,bankName,backMoney);
    }*/


}
