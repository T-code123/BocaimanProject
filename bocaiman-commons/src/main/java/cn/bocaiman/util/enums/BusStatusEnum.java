package cn.bocaiman.util.enums;


/**
 * <b>菠菜侠旅游租赁平台-大巴车管理-大巴车状态枚举信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public enum BusStatusEnum {
	BUS_STATUS_ENABLE("0", "车辆可用"),
	BUS_STATUS_DISPATCH("1","车辆出车"),
	BUS_STATUS_REPAIR("2","车辆维修"),
	BUS_STATUS_MAINTENANCE("3","车辆保养");
	private String code;
	private String remark;

	private BusStatusEnum(String code, String remark) {
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
