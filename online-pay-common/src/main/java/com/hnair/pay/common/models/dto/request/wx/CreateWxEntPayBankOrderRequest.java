package com.hnair.pay.common.models.dto.request.wx;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

@ApiModel("创建微信企业付款银行订单-请求")
public class CreateWxEntPayBankOrderRequest {

    /**
     * <pre>
     * 商户企业付款单号.
     * 变量名：partner_trade_no
     * 是否必填：是
     * 示例值：1212121221227
     * 类型：string(32)
     * 描述：商户订单号，需保持唯一（只允许数字[0~9]或字母[A~Z]和[a~z]，最短8位，最长32位）
     * </pre>
     */
    @ApiModelProperty(value = "商户企业付款单号", required = true)
    @NotBlank(message = "商户企业付款单号，不允许为空")
    private String partnerTradeNo;

    /**
     * <pre>
     * 收款方银行卡号.
     * 传值时请传原始值
     * 变量名：enc_bank_no
     * 是否必填：是
     * 示例值：8609cb22e1774a50a930e414cc71eca06121bcd266335cda230d24a7886a8d9f
     * 类型：string(64)
     * 描述：收款方银行卡号（采用标准RSA算法，公钥由微信侧提供）,详见获取RSA加密公钥API
     * </pre>
     */
    @ApiModelProperty(value = "收款方银行卡号", required = true)
    @NotBlank(message = "收款方银行卡号，不允许为空")
    private String encBankNo;

    /**
     * <pre>
     * 收款方用户名.
     * 传值时请传原始值
     * 变量名：enc_true_name
     * 是否必填：是
     * 示例值：ca775af5f841bdf424b2e6eb86a6e21e
     * 类型：string(64)
     * 描述：收款方用户名（采用标准RSA算法，公钥由微信侧提供）详见获取RSA加密公钥API
     * </pre>
     */
    @ApiModelProperty(value = "收款方用户名", required = true)
    @NotBlank(message = "收款方用户名，不允许为空")
    private String encTrueName;

    /**
     * <pre>
     * 收款方开户行.
     * 变量名：bank_code
     * 是否必填：是
     * 示例值：1001
     * 类型：string(64)
     * 描述：银行卡所在开户行编号,详见银行编号列表
     * </pre>
     */
    @ApiModelProperty(value = "收款方开户行", required = true)
    @NotBlank(message = "收款方开户行，不允许为空")
    private String bankCode;

    /**
     * <pre>
     * 付款金额.
     * 变量名：amount
     * 是否必填：是
     * 示例值：100000
     * 类型：int
     * 描述：付款金额：RMB分（支付总额，不含手续费） 注：大于0的整数
     * </pre>
     */
    @ApiModelProperty(value = "付款金额(单位分,不含手续费)", required = true)
    @NotNull
    private Integer amount;

    /**
     * <pre>
     * 付款说明.
     * 变量名：desc
     * 是否必填：否
     * 示例值：理财
     * 类型：string
     * 描述：企业付款到银行卡付款说明,即订单备注（UTF8编码，允许100个字符以内）
     * </pre>
     */
    @ApiModelProperty(value = "付款说明")
    private String description;

    public String getPartnerTradeNo() {
        return partnerTradeNo;
    }

    public void setPartnerTradeNo(String partnerTradeNo) {
        this.partnerTradeNo = partnerTradeNo;
    }

    public String getEncBankNo() {
        return encBankNo;
    }

    public void setEncBankNo(String encBankNo) {
        this.encBankNo = encBankNo;
    }

    public String getEncTrueName() {
        return encTrueName;
    }

    public void setEncTrueName(String encTrueName) {
        this.encTrueName = encTrueName;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
