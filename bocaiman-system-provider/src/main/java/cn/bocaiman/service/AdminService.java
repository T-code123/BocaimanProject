package cn.bocaiman.service;

import cn.bocaiman.pojo.system.vo.AdminVO;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-系统管理-管理员信息业务层接口</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public interface AdminService {
	/**
	 * <b>根据查询兑现查询列表</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	List<AdminVO> getList(AdminVO queryVO) throws Exception;

	/**
	 * <b>保存对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	Boolean save(AdminVO vo) throws Exception;

	/**
	 * <b>修改对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	Boolean update(AdminVO vo) throws Exception;
}
