package cn.bocaiman.service;

import cn.bocaiman.pojo.order.entity.Order;
import cn.bocaiman.pojo.order.vo.OrderVO;

/**
 * <b>菠菜侠旅游租赁平台-支付管理-订单信息业务层接口</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public interface OrderService {
	/**
	 * <b>根据订单编号查询订单信息</b>
	 * @param orderNo
	 * @return
	 * @throws Exception
	 */
	Order getOrderByOrderNo(String orderNo) throws Exception;
	/**
	 * <b>保存订单</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	boolean save(OrderVO vo) throws Exception;
}
