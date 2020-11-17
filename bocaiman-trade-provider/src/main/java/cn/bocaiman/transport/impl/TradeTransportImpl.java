package cn.bocaiman.transport.impl;

import cn.bocaiman.base.pojo.vo.PageVO;
import cn.bocaiman.base.pojo.vo.QueryParamVO;
import cn.bocaiman.pojo.trade.entity.Trade;
import cn.bocaiman.pojo.trade.vo.TradeVO;
import cn.bocaiman.service.TradeService;
import cn.bocaiman.transport.trade.TradeTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-支付管理-订单支付传输层接口实现类</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController("tradeTransport")
@RequestMapping("/trade/trans")
public class TradeTransportImpl implements TradeTransport {
	@Autowired
	private TradeService service;
	/**
	 * <b>使用支付宝之后，保存交易信息</b>
	 * @param trade
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save/alipay")
	@Override
	public boolean saveByAlipayTradeVO(@RequestBody Trade trade) throws Exception{
		return service.saveByAlipayTradeVO(trade);
	}

	/**
	 * <b>根据分页信息查询分页对象</b>
	 * @param queryParamVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	@Override
	public PageVO<TradeVO> getByPage(@RequestBody QueryParamVO queryParamVO) throws Exception {
		return service.getByPage(queryParamVO);
	}

	/**
	 * <b>根据查询兑现查询列表</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	@Override
	public List<TradeVO> getList(@RequestBody TradeVO queryVO) throws Exception {
		return service.getList(queryVO);
	}

	/**
	 * <b>保存对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	@Override
	public Boolean save(@RequestBody TradeVO vo) throws Exception {
		return service.save(vo);
	}

	/**
	 * <b>修改对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/update")
	@Override
	public Boolean update(@RequestBody TradeVO vo) throws Exception {
		return service.update(vo);
	}
}
