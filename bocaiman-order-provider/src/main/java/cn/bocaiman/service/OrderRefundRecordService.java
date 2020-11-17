package cn.bocaiman.service;

import cn.bocaiman.pojo.order.vo.OrderRefundRecordVO;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-订单管理-订单退款业务层接口</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public interface OrderRefundRecordService {

	/**
	 * <b>根据查询兑现查询列表</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	List<OrderRefundRecordVO> getByList(OrderRefundRecordVO queryVO) throws Exception;

	/**
	 * <b>保存对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	boolean save(OrderRefundRecordVO vo) throws Exception;
}
