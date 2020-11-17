package cn.bocaiman.transportimpl;

import cn.bocaiman.pojo.order.vo.OrderStatusRecordVO;
import cn.bocaiman.service.OrderStatusRecordService;
import cn.bocaiman.transport.order.OrderStatusRecordTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-支付管理-订单状态传输层接口实现类</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController("orderStatusRecordTransport")
@RequestMapping("/orderStatus/trans")
public class OrderStatusRecordTransportImpl implements OrderStatusRecordTransport {
	@Autowired
	private OrderStatusRecordService service;

	/**
	 * <b>根据查询视图查询对象</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	@Override
	public List<OrderStatusRecordVO> getByList(@RequestBody OrderStatusRecordVO queryVO) throws Exception {
		return service.getByList(queryVO);
	}

	/**
	 * <b>保存对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	@Override
	public boolean save(@RequestBody OrderStatusRecordVO vo) throws Exception {
		return service.save(vo);
	}
}
