package cn.bocaiman.transport.order;

import cn.bocaiman.pojo.order.vo.OrderStatusRecordVO;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-支付管理-订单状态传输层接口</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@FeignClient(name = "bocaiman-order-provider")
@RequestMapping("/orderStatus/trans")
public interface OrderStatusRecordTransport {


	/**
	 * <b>根据查询视图查询对象</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	List<OrderStatusRecordVO> getByList(@RequestBody OrderStatusRecordVO queryVO) throws Exception;

	/**
	 * <b>保存对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	boolean save(@RequestBody OrderStatusRecordVO vo) throws Exception ;
}
