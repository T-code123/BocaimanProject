package cn.bocaiman.service;

import cn.bocaiman.base.pojo.vo.PageVO;
import cn.bocaiman.base.pojo.vo.QueryParamVO;
import cn.bocaiman.pojo.system.vo.AuditStatusVO;


import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-系统管理-审核状态业务层接口</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public interface AuditStatusService {
	/**
	 * <b>根据分页信息查询分页对象</b>
	 * @param queryParamVO
	 * @return
	 * @throws Exception
	 */
	PageVO<AuditStatusVO> getByPage(QueryParamVO queryParamVO) throws Exception;

	/**
	 * <b>根据查询兑现查询列表</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	List<AuditStatusVO> getByList(AuditStatusVO queryVO) throws Exception ;

	/**
	 * <b>保存对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	Boolean save(AuditStatusVO vo) throws Exception ;

	/**
	 * <b>修改对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	Boolean update(AuditStatusVO vo) throws Exception ;


}
