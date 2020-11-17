package cn.bocaiman.util.enums;
/**
 * <b>菠菜侠旅游租赁平台-支付宝交易状态枚举信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public enum AlipayTradeStatusEnum {
	WAIT_BUYER_PAY("WAIT_BUYER_PAY", "交易创建，等待买家付款"),
	TRADE_CLOSED("TRADE_CLOSED", "未付款交易超时关闭，或支付完成后全额退款"),
	TRADE_SUCCESS("TRADE_SUCCESS", "交易支付成功"),
	TRADE_FINISHED("TRADE_FINISHED", "交易结束，不可退款");

	private String code;                   // 状态码
	private String remark;                 // 状态说明

	private AlipayTradeStatusEnum(String code, String remark) {
		this.code = code;
		this.remark = remark;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
