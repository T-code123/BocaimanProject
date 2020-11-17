package cn.bocaiman.transportimpl;

import cn.bocaiman.base.pojo.vo.PageVO;
import cn.bocaiman.base.pojo.vo.QueryParamVO;
import cn.bocaiman.pojo.order.vo.OrderStatusVO;
import cn.bocaiman.service.OrderStatusService;
import cn.bocaiman.transport.order.OrderStatusTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-订单管理-订单状态传输层接口实现类</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController("orderStatusTransport")
@RequestMapping("/order/orderstatus/trans")
public class OrderStatusTransportImpl implements OrderStatusTransport {
	@Autowired
	private OrderStatusService service;

	/**
	 * <b>根据分页信息查询分页对象</b>
	 * @param queryParamVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	@Override
	public PageVO<OrderStatusVO> getByPage(@RequestBody QueryParamVO queryParamVO) throws Exception {
		return service.getBypage(queryParamVO);
	}

	/**
	 * <b>根据查询兑现查询列表</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	@Override
	public List<OrderStatusVO> getByList(@RequestBody OrderStatusVO queryVO) throws Exception {
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
	public Boolean save(@RequestBody OrderStatusVO vo) throws Exception {
		return service.save(vo);
	}

	/**
	 * <b>修改对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@PostMapping("update")
	@Override
	public Boolean update(@RequestBody OrderStatusVO vo) throws Exception {
		return service.update(vo);
	}
}
