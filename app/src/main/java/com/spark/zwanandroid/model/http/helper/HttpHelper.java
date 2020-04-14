package com.spark.zwanandroid.model.http.helper;


import com.spark.zwanandroid.model.beans.BannerEntity;
import com.spark.zwanandroid.model.beans.UserEntity;
import com.spark.zwanandroid.model.http.api.ApiService;
import com.spark.zwanandroid.model.http.api.BaseResponse;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * desc: 网络请求接口实现类
 *
 * @author Bian
 * create at 2018/12/17 16:45
 */
public class HttpHelper implements IHttpHelper {

    private ApiService mApis;
    private PacketsHelper mPackets;

    @Inject
    HttpHelper(ApiService apiService, PacketsHelper packetsHelper) {
        mApis = apiService;
        mPackets = packetsHelper;
    }

    @Override
    public Observable<BaseResponse<UserEntity>> login(String loginName, String password) {

        Object body = mPackets.login(loginName, password);
        return mApis.login(body);
    }

    @Override
    public Observable<BaseResponse<List<BannerEntity>>> homeBanner() {
        return mApis.homeBanner();
    }

/*    @Override
    public Observable<BaseResponse<UserEntity>> login(String loginName, String password) {
        Object body = mPackets.login(loginName, password);
        //登录
        return mApis.login(body);
    }*/

 /*   @Override
    public Observable<BaseResponse<String>> checkToken(String token) {
        return mApis.checkToken(token);
    }
*/
 /*   @Override
    public Observable<BaseResponse<String>> validateCode(String phone) {
        //验证码
        return mApis.validateCode(phone);
    }*/

/*    @Override
    public Observable<BaseResponse<AuthenticateStatusEntity>> authenticateStatus() {
        //账户实名认证状态
        return mApis.authenticateStatus();
    }*/

  /*  @Override
    public Observable<BaseResponse<String>> examplePicture(String picName) {
        return mApis.examplePicture(picName);
    }*/

/*    @Override
    public Observable<BaseResponse<AuthenticateEntity>> authenticateDetail() {
        //进件详情
        return mApis.authenticateDetail();
    }*/

/*
    @Override
    public Observable<BaseResponse<String>> applyAuthenticate(String idFrontImg, String idBackImg, String idName, String idNo, String idExpire,
                                                              String email, String bankCardImg, String bankAccountName, String bankNo, String bankAccountNo) {
        Object body = mPackets.applyAuthenticate(idFrontImg, idBackImg, idName, idNo, idExpire, email, bankCardImg, bankAccountName, bankNo, bankAccountNo);
        //        申请实名认证
        return mApis.applyAuthenticate(body);
    }
*/
/*
    @Override
    public Observable<BaseResponse<String>> applyPublic(String legalIdFront, String legalIdBehind, String legalPersonName,
                                                        String legalPersonIdNo, String legalPersonIdExpire, String mailBox, String storeName,
                                                        String storeAreaCode, String storeAddress, String businessLicense, String openAccount,
                                                        String businessLicenseNo, String businessLicenseName, String businessLicenseExpire,
                                                        String businessLicenseAddress, String bankAccountName, String bankNo, String settlementAccountNo,
                                                        List<OtherEntity> mData, String accountType) {
        Object body = mPackets.applyPublic(legalIdFront, legalIdBehind, legalPersonName, legalPersonIdNo, legalPersonIdExpire, mailBox, storeName,
                storeAreaCode, storeAddress, businessLicense, openAccount, businessLicenseNo, businessLicenseName, businessLicenseExpire, businessLicenseAddress,
                bankAccountName, bankNo, settlementAccountNo, mData, accountType);
        return mApis.applyPublic(body);
    }*/

 /*   @Override
    public Observable<BaseResponse<String>> applySmall(String legalIdFront, String legalIdBehind, String legalPersonName, String legalPersonIdNo,
                                                       String legalPersonIdExpire, String mailBox, String storeName, String storeAreaCode, String storeAddress,
                                                       String bankCard, String bankAccountName, String bankNo, String settlementAccountNo, List<OtherEntity> mData,
                                                       String accountType) {
        Object body = mPackets.applySmall(legalIdFront, legalIdBehind, legalPersonName, legalPersonIdNo, legalPersonIdExpire, mailBox, storeName,
                storeAreaCode, storeAddress, bankCard, bankAccountName, bankNo, settlementAccountNo, mData, accountType);
        return mApis.applyPublic(body);
    }
*/
/*    @Override
    public Observable<BaseResponse<String>> applyPrivateSelf(String legalIdFront, String legalIdBehind, String legalPersonName, String legalPersonIdNo,
                                                             String legalPersonIdExpire, String mailBox, String storeName, String storeAreaCode, String storeAddress,
                                                             String bankCard, String bankAccountName, String bankNo, String settlementAccountNo, String businessLicense,
                                                             String businessLicenseNo, String businessLicenseName, String businessLicenseExpire,
                                                             String businessLicenseAddress, List<OtherEntity> mData, String accountType) {
        Object body = mPackets.applyPrivateSelf(legalIdFront, legalIdBehind, legalPersonName, legalPersonIdNo, legalPersonIdExpire, mailBox, storeName,
                storeAreaCode, storeAddress, bankCard, bankAccountName, bankNo, settlementAccountNo, businessLicense, businessLicenseNo, businessLicenseName,
                businessLicenseExpire, businessLicenseAddress, mData, accountType);
        return mApis.applyPublic(body);
    }*/

 /*   @Override
    public Observable<BaseResponse<String>> applyPrivateNotSelf(String legalIdFront, String legalIdBehind, String legalPersonName, String legalPersonIdNo, String legalPersonIdExpire, String mailBox, String storeName, String storeAreaCode, String storeAddress, String settlementIdFront, String settlementIdBehind, String settlementPersonName, String settlementPersonIdNo, String settlementPersonIdExpire, String bankCard, String bankAccountName, String bankNo, String settlementAccountNo, String businessLicense, String businessLicenseNo, String businessLicenseName, String businessLicenseExpire, String businessLicenseAddress, List<OtherEntity> mData, String accountType) {
        Object body = mPackets.applyPrivateNotSelf(legalIdFront, legalIdBehind, legalPersonName, legalPersonIdNo, legalPersonIdExpire,
                mailBox, storeName, storeAreaCode, storeAddress, settlementIdFront, settlementIdBehind, settlementPersonName, settlementPersonIdNo,
                settlementPersonIdExpire, bankCard, bankAccountName, bankNo, settlementAccountNo, businessLicense, businessLicenseNo, businessLicenseName,
                businessLicenseExpire, businessLicenseAddress, mData, accountType);
        return mApis.applyPublic(body);
    }*/


 /*   @Override
    public Observable<BaseResponse<String>> register(String phone, String validateCode, String password, String linkMan) {
        Object body = mPackets.register(phone, validateCode, password, linkMan);
        //注册
        return mApis.register(body);
    }*/

/*    @Override
    public Observable<BaseResponse<String>> updatePassword(String phone, String validateCode, String password) {
        Map<String, String> map = mPackets.updatePassword(phone, validateCode, password);
        return mApis.updatePassword(map);
    }*/

 /*   @Override
    public Observable<BaseResponse<List<GradeEntity>>> gradeList() {
        //可分享等级
        return mApis.gradeList();
    }
*/
/*    @Override
    public Observable<BaseResponse<CodeEntity>> gradeCode(int grade) {
        //推广二维码
        if (grade == -1) {
            //商户用户推广
            return mApis.gradeMerchantCode();
        }
        return mApis.gradeCode(grade);
    }*/

 /*   @Override
    public Observable<BaseResponse<ListRes<ChannelEntity>>> channelMgrAgentList(int pageNum) {
        //渠道 代理商管理
        return mApis.channelMgrAgentList(pageNum, Constants.PAGE_SIZE);
    }
*/
 /*   @Override
    public Observable<BaseResponse<ListRes<ChannelEntity>>> channelMgrMerchantList(int pageNum) {
        //渠道 商户管理
        return mApis.channelMgrMerchantList(pageNum, Constants.PAGE_SIZE);
    }
*/
  /*  @Override
    public Observable<BaseResponse<ListRes<ChannelEntity>>> channelWaterList(int pageNum, String merchantType) {
        Map<String, String> map = mPackets.channelWater(pageNum, merchantType);
        return mApis.channelWaterList(map);
    }
*/
/*    @Override
    public Observable<BaseResponse> waterListTotal(int pageNum, String merchantType) {
        Observable<BaseResponse<String>> observable1 = mApis.waterCount(merchantType);
        Map<String, String> map = mPackets.channelWater(pageNum, merchantType);
        Observable<BaseResponse<ListRes<ChannelEntity>>> observable2 = mApis.channelWaterList(map);
        return Observable.mergeDelayError(observable1, observable2);
    }*/




 /*   @Override
    public Observable<BaseResponse<StatusEntity>> userStatus() {
        return mApis.userStatus();
    }

    @Override
    public Observable<BaseResponse<String>> channelExpand(int level, String linkName, String loginName, String password, String email, String rate) {
        Object body = mPackets.channelExpand(level, linkName, loginName, password, email, rate);
        //渠道拓展
        return mApis.channelExpand(body);
    }

    @Override
    public Observable<BaseResponse<ListRes<MessageEntity>>> messageList(String type, int pageNum) {
        //消息列表
        return mApis.messageList(type, pageNum, Constants.PAGE_SIZE);
    }

    @Override
    public Observable<BaseResponse<IncomeDetailEntity>> orderMessageInfo(String orderId) {
        //订单消息详情
        return mApis.orderMessageInfo(orderId);
    }

    @Override
    public Observable<BaseResponse<ModifyEntity>> modifyInfo(String nick, String head) {
        //修改个人信息
        Object body = mPackets.modify(nick, head);
        return mApis.modifyInfo(body);
    }

    @Override
    public Observable<BaseResponse<String>> modifyAccount(String newLoginName) {
        Object body = mPackets.modifyAccount(newLoginName);
        return mApis.modifyAccount(body);
    }

    @Override
    public Observable<BaseResponse<String>> uploadPicture(String path) {
        File file = new File(path);
        RequestBody requestFile = RequestBody.create(MediaType.parse("image/*"), file);
        MultipartBody.Part part = MultipartBody.Part.createFormData("file", file.getName(), requestFile);
        // 上传图片
        return mApis.uploadPic(part);
    }


    @Override
    public Observable<BaseResponse<ListRes<GuideEntity>>> guideList(int pageNum) {
        //新手入门
        return mApis.guideList(pageNum, Constants.PAGE_SIZE);
    }

    @Override
    public Observable<BaseResponse<VersionEntity>> versionInfo() {
        //版本信息
        return mApis.versionInfo();
    }


    @Override
    public Observable<BaseResponse<String>> exitLogin() {
        //退出登录
        return mApis.exitLogin();
    }

    @Override
    public Observable<BaseResponse<ListRes<WithdrawEntity>>> withDrawRecordList(String withdrawMonthDate, String withdrawType, int pageNum) {
        //指定时间提现列表
        if (StringUtils.isEmpty(withdrawMonthDate)) {
            return mApis.withDrawRecordList(withdrawType, pageNum, Constants.PAGE_SIZE);
        } else {
            return mApis.withDrawRecordList(withdrawMonthDate, withdrawType, pageNum, Constants.PAGE_SIZE);
        }
    }


    @Override
    public Observable<BaseResponse<BankEntity>> bankcardInformation() {
        //银行卡信息
        return mApis.bankcardInformation();
    }

    @Override
    public Observable<BaseResponse<WithdrawEntity>> withdrawDetail(int withdrawId) {
        //提现详情
        return mApis.withdrawDetail(withdrawId);
    }

    @Override
    public Observable<BaseResponse<List<EnumBean>>> verifyTypes() {
        //认证类型
        return mApis.verifyTypes();
    }

    @Override
    public Observable<BaseResponse<List<BankEntity>>> bankList(String bankName) {
        //支行列表
        return mApis.bankList(bankName);
    }

    @Override
    public Observable<BaseResponse<List<AreaEntity>>> areaList(String name) {
        //区域列表
        return mApis.areaList(name);
    }

    @Override
    public Observable<BaseResponse<WithdrawEntity>> withdrawAmount() {
        //提现查询开户行、可提现金额
        return mApis.withdrawAmount();
    }

    @Override
    public Observable<BaseResponse<String>> withdrawFee(String withdrawMoney) {
        //提现查询开户行、可提现金额
        return mApis.withdrawFee(withdrawMoney);
    }

    @Override
    public Observable<BaseResponse<RuleEntity>> withdrawRule() {
        return mApis.withdrawRule();
    }

    @Override
    public Observable<BaseResponse<String>> requestProfitIncome(String bankNo, String bankName, String withdrawMoney, boolean isIncome) {
        //申请提现
        if (isIncome) {
            return mApis.requestIncome(mPackets.requestProfit(bankNo, bankName, withdrawMoney));
        } else {
            return mApis.requestProfit(mPackets.requestProfit(bankNo, bankName, withdrawMoney));
        }
    }

    @Override
    public Observable<BaseResponse<ProfitEntity>> accountProfit() {
        //获取分润详情
        return mApis.accountProfit();
    }

    @Override
    public Observable<BaseResponse<IncomeEntity>> accountIncome() {
        //获取收入详情
        return mApis.accountIncome();
    }

    @Override
    public Observable<BaseResponse<String>> scanMoney(String payCode, String payChannel, String amount) {
        return mApis.scanMoney(payCode, payChannel, amount);
    }

    @Override
    public Observable<BaseResponse<Map<String, String>>> receiptMoney(String payChannel, String amount) {
        return mApis.receiptMoney(payChannel, amount);
    }

    @Override
    public Observable<BaseResponse<String>> orderStatus(String orderNumber) {
        return mApis.orderStatus(orderNumber);
    }

    @Override
    public Observable<BaseResponse<String>> mineCode() {
        //我的收款二维码
        return mApis.mineCode();
    }

    @Override
    public Observable<BaseResponse<ListRes<IncomeDetailEntity>>> incomeList(int pageNum, String startDate, String endDate, String onlineFlag, String payChannel, String orderStatus) {
        Map<String, String> map = mPackets.incomeList(pageNum, startDate, endDate, onlineFlag, payChannel, orderStatus);
        //收入列表
        return mApis.incomeList(map);
    }

    @Override
    public Observable<BaseResponse> incomeListTotal(int pageNum, String startDate, String endDate, String onlineFlag, String payChannel, String orderStatus) {
        Observable<BaseResponse<String>> observable1 = mApis.incomeCount();
        Map<String, String> map = mPackets.incomeList(pageNum, startDate, endDate, onlineFlag, payChannel, orderStatus);
        Observable<BaseResponse<ListRes<IncomeDetailEntity>>> observable2 = mApis.incomeList(map);
        return Observable.mergeDelayError(observable1, observable2);
    }

    @Override
    public Observable<BaseResponse<ListRes<ProfitDetailEntity>>> profitList(int pageNum, String merchantType) {
        //分润列表
        return mApis.profitList(pageNum, merchantType, Constants.PAGE_SIZE);
    }

    @Override
    public Observable<BaseResponse<String>> refundMoney(String orderNo) {
        //退款
        return mApis.refund(orderNo);
    }

    @Override
    public Observable<BaseResponse<ProfitEntity>> agentProfit() {
        //代理商分润
        return mApis.agentProfit();
    }

    @Override
    public Observable<BaseResponse<IncomeEntity>> merchantIncome() {
        //商户收入
        return mApis.merchantIncome();
    }

    @Override
    public Observable<BaseResponse<String>> contactService() {
        //客服电话
        return mApis.contactService();
    }

    @Override
    public Observable<BaseResponse<String>> deleteMessage(String messageType) {
        return mApis.deleteMessage(messageType);
    }

    @Override
    public Observable<BaseResponse<List<OrderItemEntity>>> getOrderList(int pageNum) {
        return mApis.getOrderList(pageNum);
    }

    @Override
    public Observable<BaseResponse<ListRes<SupplierOrderEntity>>> getSupplierOrderList(int pageNum) {
        Map<String, String> params  = mPackets.getSupplierOrderList(pageNum);
        return mApis.getSupplierOrderList(params);
    }

    @Override
    public Observable<BaseResponse<ListRes<OrderDetailEntity>>> getMerchantOrderList(int pageNum) {
        Map<String, String> params = mPackets.getMerchantOrderList(pageNum);
        return mApis.getMerchantOrderList(params);
    }

    @Override
    public Observable<BaseResponse<String>> chargeMoney(String Money) {

        Map<String, String> params = new HashMap<>();
        params.put("payment",Money);
        return mApis.chargeMoney(params);
    }

    @Override
    public Observable<BaseResponse<ListRes<ChargeMoneyEntity>>> getChargeMoneyList(int pageNum) {

        Map<String, String> params  = new HashMap<>();
        params.put("pageNum",pageNum+"");
        params.put("pageSize",Constants.PAGE_SIZE+"");

        return mApis.getChargeMoneyList(params);
    }

    @Override
    public Observable<BaseResponse<AppVersionEntity>> getAppVersion(String terminal) {
        return mApis.getAppVersion(terminal);
    }

    @Override
    public Observable<BaseResponse<OrderSimpleBean>> getOrderSimpleInfo(String startDate, String endDate) {
        return mApis.getOrderSimpleInfo(startDate,endDate);
    }

    @Override
    public Observable<BaseResponse<List<SimpleGoodsBean>>> getHotSell(String startDate, String endDate) {
        return mApis.getHotSell(startDate,endDate);
    }

    @Override
    public Observable<BaseResponse<List<SimpleGoodsBean>>> getColdSell(String startDate, String endDate) {
        return mApis.getColdSell(startDate,endDate);
    }

    @Override
    public Observable<BaseResponse<OrderSummaryBean>> getOrderSummary() {
        return mApis.getOrderSummary();
    }

    @Override
    public Observable<BaseResponse<MemberInfoBean>> getMemberInfo(String startDate, String endDate) {
        return mApis.getMemberInfo(startDate,endDate);
    }

    @Override
    public Observable<BaseResponse<ListRes<MainMsgBean>>> getMainPushMsg(int pageNum, int pageSize) {
        return mApis.getMainPushMsg(mPackets.getMainPushMsg(pageNum,pageSize));
    }

    @Override
    public Observable<BaseResponse<MsgSimpleDetail>> getMainPushDetail(String mainPushReceiveRecordId) {
        return mApis.getMainPushDetail(mainPushReceiveRecordId);
    }

    @Override
    public Observable<BaseResponse<SureMoneyBean>> getSureMoneyData() {
        return mApis.getSureMoneyData();
    }

    @Override
    public Observable<BaseResponse<String>> chargeSureMoney(String payment) {
        return mApis.chargeSureMoney(payment);
    }

    @Override
    public Observable<BaseResponse<String>> backSureMoney(String bankNo, String bankName, String backMoney) {
        return mApis.backSureMoney(mPackets.backSureMoney(bankNo,bankName,backMoney));
    }
*/

}
