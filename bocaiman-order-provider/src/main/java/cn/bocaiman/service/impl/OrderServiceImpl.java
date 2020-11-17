package cn.bocaiman.service.impl;

import cn.bocaiman.dao.OrderDao;
import cn.bocaiman.pojo.order.entity.Order;
import cn.bocaiman.pojo.order.vo.OrderVO;
import cn.bocaiman.service.OrderService;
import cn.bocaiman.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-支付管理-订单信息传输层接口实现类</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDao dao;
	@Autowired
	private IdGenerator idGenerator;
	/**
	 * <b>根据订单编号查询订单信息</b>
	 * @param orderNo
	 * @return
	 * @throws Exception
	 */
	@Override
	public Order getOrderByOrderNo(String orderNo) throws Exception {
		// 创建查询对象
		Order query = new Order();
		query.setOrderNo(orderNo);

		// 进行查询列表
		List<Order> list = dao.findListByQuery(query);
		// 提取数据
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}
	/**
	 * <b>保存订单</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean save(OrderVO vo) throws Exception {
		// 将视图对象转换成实体对象
		Order entity = Order.parseFromEntity(vo);
		// 设定主键
		entity.setId(idGenerator.nextId());
		Integer count = dao.save(entity);
		if (count != null && count > 0) {
			return true;
		}
		return false;
	}
}
