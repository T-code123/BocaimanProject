package cn.bocaiman.util.enums;
/**
 * <b>菠菜侠旅游租赁平台-审核状态枚举信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public enum AuditStatusEnum {
	AUDIT_STATUS_AWAIT("0","待审核"),
	AUDIT_STATUS_PASS("1","审核通过"),
	AUDIT_STATUS_FAILURE("2","审核失败");
	private String code;                       // 编码
	private String remark;                      // 说明

	private AuditStatusEnum(String code, String remark) {
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
