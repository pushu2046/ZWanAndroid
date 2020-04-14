package com.spark.zwanandroid.model.beans;

/**
 * desc:
 *
 * @author Bian
 * create at 2019/1/5
 */
public class StatusEntity {
    /**
     * 对公对私类型
     * PUBLIC营业执照认证(对公)，
     * PRIVATE_SELF营业执照认证(对私同法人)，
     * PRIVATE_NOT_SELF营业执照认证(对私非法人)，
     * PRIVATE_SMALL_SHOP小微商户认证
     * CERTIFICATION    实名认证
     */
    private String accountType;
    /**
     * 进件审核状态
     * UN_APPLY(1, "未申请审核"),
     * UN_CHECK(2, "待审核"),
     * CHECK_PASS(3, "审核通过"),
     * CHECK_UN_PASS(4,"审核不通过"),
     * REGISTER_PASS(5,"进件注册成功"),
     * REGISTER_UNPASS(6,"进件注册失败"),
     * UPLOAD_PASS(7,"图片上传成功"),
     * UPLOAD_UNPASS(8,"图片上传失败"),
     * SUBMIT_PASS(9,"提交成功"),
     * SUBMIT_UNPASS(10,"提交失败"),
     * INTO_PASS(11,"进件成功"),
     * INTO_UNPASS(12,"进件失败");
     */
    private String identityVerifyStatus;


    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getIdentityVerifyStatus() {
        return identityVerifyStatus;
    }

    public void setIdentityVerifyStatus(String identityVerifyStatus) {
        this.identityVerifyStatus = identityVerifyStatus;
    }

}
