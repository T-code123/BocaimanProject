package cn.bocaiman.dao;

import cn.bocaiman.pojo.bus.entity.Bus;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-车辆管理-车辆数据持久层接口</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@Repository
public interface BusDao {
	/**
	 * <b>根据查询对象查询列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	List<Bus> findListByQuery(Bus query) throws Exception;

	/**
	 * <b>保存对象</b>
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Integer save(Bus entity) throws Exception;

	/**
	 * <b>修改对象</b>
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Integer update(Bus entity) throws Exception;
}
