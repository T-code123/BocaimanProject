package cn.bocaiman.dao;

import cn.bocaiman.pojo.order.entity.OrderRefundRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-订单管理-订单退款数据持久层接口</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@Repository
public interface OrderRefundRecordDao {
	/**
	 * <b>根据查询对象查询列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	List<OrderRefundRecord> findListByQuery(OrderRefundRecord query) throws Exception;

	/**
	 * <b>保存对象</b>
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Integer save(OrderRefundRecord entity) throws Exception;
}
