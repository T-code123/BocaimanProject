package cn.bocaiman.dao;

import cn.bocaiman.pojo.system.entity.AuditStatus;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-系统管理-审核状态数据持久层接口</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@Repository
public interface AuditStatusDao {
	/**
	 * <b>根据查询对象查询列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	List<AuditStatus> findListByQuery(AuditStatus query) throws Exception;

	/**
	 * <b>保存对象</b>
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Integer save(AuditStatus entity) throws Exception;

	/**
	 * <b>修改对象</b>
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Integer update(AuditStatus entity) throws Exception;
}
