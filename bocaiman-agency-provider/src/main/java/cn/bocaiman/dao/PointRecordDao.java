package cn.bocaiman.dao;

import cn.bocaiman.pojo.agency.entity.PointRecord;
import cn.bocaiman.pojo.order.entity.OrderStatusRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-旅行社管理-积分记录数据持久层接口</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@Repository
public interface PointRecordDao {
	/**
	 * <b>根据查询对象查询列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	List<PointRecord> findListByQuery(PointRecord query) throws Exception;

	/**
	 * <b>保存对象</b>
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Integer save(PointRecord entity) throws Exception;
}
