package cn.bocaiman.transportimpl;

import cn.bocaiman.pojo.order.vo.OrderRefundRecordVO;
import cn.bocaiman.service.OrderRefundRecordService;
import cn.bocaiman.transport.order.OrderRefundRecordTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-订单管理-订单退款传输层接口实现类</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController("orderRefundRecordTransport")
@RequestMapping("/order/refund/trans")
public class OrderRefundRecordTransportImpl implements OrderRefundRecordTransport {
	@Autowired
	private OrderRefundRecordService service;

	/**
	 * <b>根据查询视图查询对象</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	@Override
	public List<OrderRefundRecordVO> getByList(@RequestBody OrderRefundRecordVO queryVO) throws Exception {
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
	public boolean save(@RequestBody OrderRefundRecordVO vo) throws Exception {
		return service.save(vo);
	}
}
