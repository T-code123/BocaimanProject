package cn.bocaiman.transport.trade;

import cn.bocaiman.base.pojo.vo.PageVO;
import cn.bocaiman.base.pojo.vo.QueryParamVO;

import cn.bocaiman.pojo.trade.entity.Trade;
import cn.bocaiman.pojo.trade.vo.TradeVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-支付管理-订单支付传输层接口</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@FeignClient(name = "bocaiman-trade-provider")
@RequestMapping("/trade/trans")
public interface TradeTransport {
	
	/**
	 * <b>使用支付宝之后，保存交易信息</b>
	 * @param trade
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save/alipay")
	boolean saveByAlipayTradeVO(@RequestBody Trade trade) throws Exception;

	/**
	 * <b>根据分页信息查询分页对象</b>
	 * @param queryParamVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	PageVO<TradeVO> getByPage(@RequestBody QueryParamVO queryParamVO) throws Exception;

	/**
	 * <b>根据查询兑现查询列表</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	List<TradeVO> getList(@RequestBody TradeVO queryVO) throws Exception;

	/**
	 * <b>保存对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	Boolean save(@RequestBody TradeVO vo) throws Exception;

	/**
	 * <b>修改对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/update")
	Boolean update(@RequestBody TradeVO vo) throws Exception;
}
