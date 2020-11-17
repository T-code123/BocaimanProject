package cn.bocaiman.base.pojo.entity;


import java.io.Serializable;
import java.util.Date;

/**
 * <b>菠菜侠旅游租赁平台-基础功能-基础实体信息</b>
 * <p>
 *     基础实体设定通用的属性，其他实体信息必须继承于本基础实体
 * </p>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public class BaseEntity implements Serializable {
	private static final long serialVersionUID = -6512773907107427195L;
	private Integer status;                         // 系统状态：0-禁用，1-启用
	private String createAdmin;                     // 创建人
	private Date createTime;                        // 创建时间
	private String updateAdmin;                     // 修改人
	private Date updateTime;                        // 修改时间


	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCreateAdmin() {
		return createAdmin;
	}

	public void setCreateAdmin(String createAdmin) {
		this.createAdmin = createAdmin;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdateAdmin() {
		return updateAdmin;
	}

	public void setUpdateAdmin(String updateAdmin) {
		this.updateAdmin = updateAdmin;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
