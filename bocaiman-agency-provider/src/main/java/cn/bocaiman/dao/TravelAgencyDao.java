package cn.bocaiman.dao;

import cn.bocaiman.pojo.agency.entity.TravelAgency;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-旅行社管理-旅行社信息数据持久层接口</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@Repository
public interface TravelAgencyDao {

	/**
	 * <b>根据查询对象查询列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	List<TravelAgency> findListByQuery(TravelAgency query) throws Exception;

	/**
	 * <b>保存对象</b>
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Integer save(TravelAgency entity) throws Exception;

	/**
	 * <b>修改对象</b>
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Integer update(TravelAgency entity) throws Exception;
}
