package cn.bocaiman.transport.order;

import cn.bocaiman.pojo.order.entity.Order;
import cn.bocaiman.pojo.order.vo.OrderVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <b>菠菜侠旅游租赁平台-支付管理-订单信息传输层接口</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@FeignClient(name = "bocaiman-order-provider")
@RequestMapping("/order/trans")
public interface OrderTransport {
	/**
	 * <b>根据订单编号查询订单信息</b>
	 * @param orderNo
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/orderNo")
	Order getOrderByOrderNo(@RequestParam String orderNo) throws Exception;

	/**
	 * <b>保存订单</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	boolean save(@RequestBody OrderVO vo) throws Exception;
}
