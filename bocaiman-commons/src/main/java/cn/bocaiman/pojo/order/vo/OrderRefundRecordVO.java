package cn.bocaiman.pojo.order.vo;

import cn.bocaiman.base.pojo.vo.BaseVO;
import cn.bocaiman.pojo.order.entity.OrderCancelRecord;
import cn.bocaiman.pojo.order.entity.OrderRefundRecord;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-大巴车订单管理-大巴车订单退款视图信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@ApiModel("菠菜侠旅游租赁平台-大巴车订单管理-大巴车订单退款视图信息")
public class OrderRefundRecordVO extends BaseVO {
	private static final long serialVersionUID = -6136546810552813447L;
	@ApiModelProperty(value = "主键")
	private String id;                          // 主键
	@ApiModelProperty(value = "订单信息主键")
	private String orderId;                     // 订单信息主键
	@ApiModelProperty(value = "订单编号")
	private String orderNo;                     // 订单编号
	@ApiModelProperty(value = "退款原因")
	private String reason;                      // 退款原因
	@ApiModelProperty(value = "审核状态主键")
	private String auditStatusId;               // 审核状态主键
	@ApiModelProperty(value = "审核状态文本")
	private String auditStatus;                 // 审核状态文本
	@ApiModelProperty(value = "审核人主键")
	private String auditAdminId;                // 审核人主键
	@ApiModelProperty(value = "审核人姓名")
	private String auditAdminName;              // 审核人姓名
	@ApiModelProperty(value = "审核时间")
	private Date auditDate;                     // 审核时间

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getAuditStatusId() {
		return auditStatusId;
	}

	public void setAuditStatusId(String auditStatusId) {
		this.auditStatusId = auditStatusId;
	}

	public String getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}

	public String getAuditAdminId() {
		return auditAdminId;
	}

	public void setAuditAdminId(String auditAdminId) {
		this.auditAdminId = auditAdminId;
	}

	public String getAuditAdminName() {
		return auditAdminName;
	}

	public void setAuditAdminName(String auditAdminName) {
		this.auditAdminName = auditAdminName;
	}

	public Date getAuditDate() {
		return auditDate;
	}

	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}

	/**
	 * <b>将实体对象转换成视图对象</b>
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public static OrderRefundRecordVO parseFromVO(OrderRefundRecord entity) throws Exception {
		OrderRefundRecordVO vo = new OrderRefundRecordVO();
		// 普通属性转换
		BeanUtils.copyProperties(entity,vo);
		// 关联属性的转换
		if (entity.getOrder() != null) {
			vo.setOrderId(entity.getId());
			vo.setOrderNo(entity.getOrder().getOrderNo());
		}

		if (entity.getAuditStatus() != null ) {
			vo.setAuditStatus(entity.getAuditStatus().getId());
			vo.setAuditStatus(entity.getAuditStatus().getText());
			vo.setAuditStatus(entity.getAuditStatus().getCode());
		}

		if (entity.getAuditAdmin() != null) {
			vo.setAuditAdminId(entity.getAuditAdmin().getId());
			vo.setAuditAdminName(entity.getAuditAdmin().getName());
		}
		return vo;
	}

	/**
	 * <b>将实体列表切换成视图列表</b>
	 * @param entityList
	 * @return
	 */
	public static List<OrderRefundRecordVO> parseFromVOList(List<OrderRefundRecord> entityList) throws Exception{
		List<OrderRefundRecordVO> voList = new ArrayList<OrderRefundRecordVO>();
		// 实体列表可用
		if (entityList != null && !entityList.isEmpty()) {
			for (OrderRefundRecord entity : entityList) {
				OrderRefundRecordVO vo = parseFromVO(entity);
				voList.add(vo);
			}
		}
		return voList;
	}
}
