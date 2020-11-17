package cn.bocaiman.service;

import cn.bocaiman.pojo.order.vo.OrderStatusRecordVO;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-支付管理-订单状态业务层接口</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public interface OrderStatusRecordService {

	/**
	 * <b>根据查询兑现查询列表</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	List<OrderStatusRecordVO> getByList(OrderStatusRecordVO queryVO) throws Exception;

	/**
	 * <b>保存对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	boolean save(OrderStatusRecordVO vo) throws Exception ;

}
