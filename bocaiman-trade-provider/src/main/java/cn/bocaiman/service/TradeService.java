package cn.bocaiman.service;

import cn.bocaiman.base.pojo.vo.PageVO;
import cn.bocaiman.base.pojo.vo.QueryParamVO;
import cn.bocaiman.pojo.trade.entity.Trade;
import cn.bocaiman.pojo.trade.vo.TradeVO;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-支付管理-订单支付业务层接口</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public interface TradeService {
	/**
	 * <b>使用支付宝之后，保存交易信息</b>
	 * @param trade
	 * @return
	 * @throws Exception
	 */
	boolean saveByAlipayTradeVO(Trade trade) throws Exception ;

	/**
	 * <b>根据分页信息查询分页对象</b>
	 * @param queryParamVO
	 * @return
	 * @throws Exception
	 */
	PageVO<TradeVO> getByPage(QueryParamVO queryParamVO) throws Exception;

	/**
	 * <b>根据查询兑现查询列表</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	List<TradeVO> getList(TradeVO queryVO) throws Exception;

	/**
	 * <b>保存对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	Boolean save(TradeVO vo) throws Exception;

	/**
	 * <b>修改对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	Boolean update(TradeVO vo) throws Exception;
}
