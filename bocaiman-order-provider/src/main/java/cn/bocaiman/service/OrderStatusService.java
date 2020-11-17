package cn.bocaiman.service;

import cn.bocaiman.base.pojo.vo.PageVO;
import cn.bocaiman.base.pojo.vo.QueryParamVO;
import cn.bocaiman.pojo.order.vo.OrderStatusVO;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-订单管理-订单状态业务层接口</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public interface OrderStatusService {

	/**
	 * <b>根据分页信息查询分页对象</b>
	 * @param queryParamVO
	 * @return
	 * @throws Exception
	 */
	PageVO<OrderStatusVO> getBypage(QueryParamVO queryParamVO) throws Exception ;

	/**
	 * <b>根据查询兑现查询列表</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	List<OrderStatusVO> getByList(OrderStatusVO queryVO) throws Exception ;

	/**
	 * <b>保存对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	Boolean save(OrderStatusVO vo) throws Exception ;

	/**
	 * <b>修改对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	Boolean update(OrderStatusVO vo) throws Exception ;
}
