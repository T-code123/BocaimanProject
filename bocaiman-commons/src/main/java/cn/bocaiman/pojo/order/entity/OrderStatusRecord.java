package cn.bocaiman.pojo.order.entity;

import cn.bocaiman.base.pojo.entity.BaseEntity;
import cn.bocaiman.pojo.order.vo.OrderStatusRecordVO;
import org.springframework.beans.BeanUtils;

/**
 * <b>菠菜侠旅游租赁平台-大巴车订单管理-大巴车订单状态记录实体信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public class OrderStatusRecord extends BaseEntity {
	private static final long serialVersionUID = -1115035554653815443L;
	private String id;                          // 主键
	private Order order;                        // 订单信息
	private OrderStatus orderStatus;            // 订单状态

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

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	/**
	 * <b>将视图对象转换成实体对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public static OrderStatusRecord parseFromEntity(OrderStatusRecordVO vo) throws Exception {
		// 创建实体对象
		OrderStatusRecord entity = new OrderStatusRecord();
		// 普通属性转换
		BeanUtils.copyProperties(entity,vo);
		// 关联属性转换
		Order order = new Order();
		order.setId(vo.getOrderId());
		order.setOrderNo(vo.getOrderNo());
		entity.setOrder(order);

		OrderStatus orderStatus = new OrderStatus();
		orderStatus.setId(vo.getOrderStatusId());
		orderStatus.setText(vo.getOrderStatus());
		orderStatus.setCode(vo.getOrderStatus());
		entity.setOrderStatus(orderStatus);
		return entity;
	}
}
