package cn.bocaiman.service;



import cn.bocaiman.pojo.order.vo.OrderCancelRecordVO;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-订单管理-订单取消业务层接口</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public interface OrderCancelRecordService {

	/**
	 * <b>根据查询兑现查询列表</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	List<OrderCancelRecordVO> getByList(OrderCancelRecordVO queryVO) throws Exception;

	/**
	 * <b>保存对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	boolean save(OrderCancelRecordVO vo) throws Exception;
}
