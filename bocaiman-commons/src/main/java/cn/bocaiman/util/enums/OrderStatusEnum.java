package cn.bocaiman.util.enums;

/**
 * <b>菠菜侠旅游租赁平台-订单状态枚举信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public enum OrderStatusEnum {
	ORDER_STATUS_CREATE("0", "已下单，未支付"),
	ORDER_STATUS_PAYING("1", "支付中"),
	ORDER_STATUS_PAYED("2", "已支付"),
	ORDER_STATUS_FINISH("3", "已完成"),
	ORDER_STATUS_PAY_FAILURE("4", "支付失败"),
	ORDER_STATUS_APPLY_CANCEL("5","申请取消"),
	ORDER_STATUS_CANCEL_SUCCESS("6","取消成功"),
	ORDER_STATUS_CANCEL_FAILURE("7","取消失败"),
	ORDER_STATUS_APPLY_BACK("8", "申请退款"),
	ORDER_STATUS_BACKING("9", "退款中"),
	ORDER_STATUS_BACK_SUCCESS("10", "退款成功"),
	ORDER_STATUS_BACK_FAILURE("11", "退款失败")
	;
	private String code;                       // 编码
	private String remark;                      // 说明

	private OrderStatusEnum(String code, String remark) {
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
