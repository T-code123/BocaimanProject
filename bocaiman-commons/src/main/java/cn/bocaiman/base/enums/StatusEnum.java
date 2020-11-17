package cn.bocaiman.base.enums;

/**
 * <b>菠菜侠旅游租赁平台-基础功能-系统状态枚举信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public enum StatusEnum {
	STATUS_ENABLE(1, "启用"),
	STATUS_DISABLE(0, "禁用");

	private Integer code;                       // 编码
	private String remark;                      // 说明

	private StatusEnum(Integer code, String remark) {
		this.code = code;
		this.remark = remark;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
