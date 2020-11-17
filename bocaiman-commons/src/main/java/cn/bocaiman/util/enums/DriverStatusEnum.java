package cn.bocaiman.util.enums;
/**
 * <b>菠菜侠旅游租赁平台-司机状态枚举信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public enum DriverStatusEnum {
	DRIVER_STATUS_AVAILABLE("0","司机可用"),
	DRIVER_STATUS_DISPATCH("1","司机出车"),
	DRIVER_STATUS_VACATION("2","司机休假");
	private String code;                       // 编码
	private String remark;                      // 说明

	private DriverStatusEnum(String code, String remark) {
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
