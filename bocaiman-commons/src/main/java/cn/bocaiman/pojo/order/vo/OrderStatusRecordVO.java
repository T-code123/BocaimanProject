package cn.bocaiman.pojo.order.vo;

import cn.bocaiman.base.pojo.vo.BaseVO;
import cn.bocaiman.pojo.order.entity.OrderStatusRecord;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-大巴车订单管理-大巴车订单状态记录视图信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@ApiModel("菠菜侠旅游租赁平台-大巴车订单管理-大巴车订单状态记录视图信息")
public class OrderStatusRecordVO extends BaseVO {
	private static final long serialVersionUID = 4598328068208557523L;
	@ApiModelProperty(value = "主键")
	private String id;                          // 主键
	@ApiModelProperty(value = "订单信息主键")
	private String orderId;                     // 订单信息主键
	@ApiModelProperty(value = "订单编号")
	private String orderNo;                     // 订单编号
	@ApiModelProperty(value = "订单状态主键")
	private String orderStatusId;               // 订单状态主键
	@ApiModelProperty(value = "订单状态")
	private String orderStatus;                 // 订单状态

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

	public String getOrderStatusId() {
		return orderStatusId;
	}

	public void setOrderStatusId(String orderStatusId) {
		this.orderStatusId = orderStatusId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	/**
	 * <b>将视图对象转换成实体对象</b>
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public static OrderStatusRecordVO parseFromVO(OrderStatusRecord entity) throws Exception {
		// 创建视图对象
		OrderStatusRecordVO vo = new OrderStatusRecordVO();
		// 普通属性转换
		BeanUtils.copyProperties(vo,entity);

		// 关联属性转换
		if (entity.getOrder() != null) {
			vo.setOrderId(entity.getOrder().getId());
			vo.setOrderNo(entity.getOrder().getOrderNo());
		}
		if (entity.getOrderStatus() != null) {
			vo.setOrderStatusId(entity.getOrderStatus().getId());
			vo.setOrderStatus(entity.getOrderStatus().getCode());
			vo.setOrderStatus(entity.getOrderStatus().getText());
		}
		return vo;
	}

	/**
	 * <b>将实体列表转换成视图列表</b>
	 * @param entityList
	 * @return
	 * @throws Exception
	 */
	public static List<OrderStatusRecordVO> parseFromVOList(List<OrderStatusRecord> entityList) throws Exception {
		// 创建视图列表
		List<OrderStatusRecordVO> voList = new ArrayList<OrderStatusRecordVO>();
		// 实体列表可用
		if (entityList != null && !entityList.isEmpty()) {
			for (OrderStatusRecord entity : entityList) {
				OrderStatusRecordVO vo = parseFromVO(entity);
				voList.add(vo);
			}
		}
		return voList;
	}
}
