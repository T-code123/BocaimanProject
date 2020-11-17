package cn.bocaiman.transportimpl;

import cn.bocaiman.pojo.order.entity.Order;
import cn.bocaiman.pojo.order.vo.OrderVO;
import cn.bocaiman.service.OrderService;
import cn.bocaiman.transport.order.OrderTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <b>菠菜侠旅游租赁平台-支付管理-订单信息传输层接口实现类</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController("orderTransport")
@RequestMapping("/order/trans")
public class OrderTransportImpl implements OrderTransport {
	@Autowired
	private OrderService orderService;
	/**
	 * <b>根据订单编号查询订单信息</b>
	 * @param orderNo
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/orderNo")
	@Override
	public Order getOrderByOrderNo(@RequestParam String orderNo) throws Exception{
		return orderService.getOrderByOrderNo(orderNo);
	}

	/**
	 * <b>保存订单</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	@Override
	public boolean save(@RequestBody OrderVO vo) throws Exception {
		return orderService.save(vo);
	}
}
