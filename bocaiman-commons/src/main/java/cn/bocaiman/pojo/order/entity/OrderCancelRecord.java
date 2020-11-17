package cn.bocaiman.pojo.order.entity;

import cn.bocaiman.base.pojo.entity.BaseEntity;
import cn.bocaiman.pojo.order.vo.OrderCancelRecordVO;
import cn.bocaiman.pojo.system.entity.Admin;
import cn.bocaiman.pojo.system.entity.AuditStatus;
import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * <b>菠菜侠旅游租赁平台-大巴车订单管理-大巴车订单取消实体信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public class  OrderCancelRecord extends BaseEntity {
	private static final long serialVersionUID = -7358274790724908674L;
	private String id;                      // 主键
	private Order order;                    // 订单信息
	private String reason;                  // 取消原因
	private AuditStatus auditStatus;        // 审核状态
	private Admin auditAdmin;               // 审核人
	private Date auditDate;                 // 审核时间

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public AuditStatus getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(AuditStatus auditStatus) {
		this.auditStatus = auditStatus;
	}

	public Admin getAuditAdmin() {
		return auditAdmin;
	}

	public void setAuditAdmin(Admin auditAdmin) {
		this.auditAdmin = auditAdmin;
	}

	public Date getAuditDate() {
		return auditDate;
	}

	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}

	/**
	 * <b>将视图对象转换成实体对象</b>
	 * @param vo
	 * @return
	 */
	public static OrderCancelRecord parseFromEntity(OrderCancelRecordVO vo) {
		// 创建实体对象
		OrderCancelRecord entity = new OrderCancelRecord();
		// 进行普通属性切换
		BeanUtils.copyProperties(vo,entity);
		// 关联属性的转换
		Order order = new Order();
		order.setId(vo.getOrderId());
		order.setOrderNo(vo.getOrderNo());
		entity.setOrder(order);

		AuditStatus auditStatus = new AuditStatus();
		auditStatus.setId(vo.getAuditStatusId());
		auditStatus.setText(vo.getAuditStatus());
		auditStatus.setCode(vo.getAuditStatus());
		entity.setAuditStatus(auditStatus);

		Admin admin = new Admin();
		admin.setId(vo.getAuditAdminId());
		admin.setName(vo.getAuditAdminName());
		entity.setAuditAdmin(admin);

		return entity;
	}
}
