package cn.bocaiman.util.enums;
/**
 * <b>菠菜侠旅游租赁平台-积分使用类型枚举信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public enum PointUseTypeEnum {
	POINT_EXPENSE("0","消费积分"),
	POINT_CUMULATIVE("1","累计积分");
	private String code;
	private String remark;

	private PointUseTypeEnum(String code, String remark) {
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
