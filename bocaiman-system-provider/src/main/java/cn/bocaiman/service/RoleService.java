package cn.bocaiman.service;

import cn.bocaiman.base.pojo.vo.PageVO;
import cn.bocaiman.base.pojo.vo.QueryParamVO;
import cn.bocaiman.pojo.system.vo.RoleVO;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-系统管理-角色信息业务层接口</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public interface RoleService {
	/**
	 * <b>根据分页信息查询分页对象</b>
	 * @param queryParamVO
	 * @return
	 * @throws Exception
	 */
	PageVO<RoleVO> getByPage(QueryParamVO queryParamVO) throws Exception;

	/**
	 * <b>根据查询列表查询</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	List<RoleVO> getList(RoleVO queryVO) throws Exception;

	/**
	 * <b>保存对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	Boolean save(RoleVO vo) throws Exception;

	/**
	 * <b>修改对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	Boolean update(RoleVO vo) throws Exception;
}
