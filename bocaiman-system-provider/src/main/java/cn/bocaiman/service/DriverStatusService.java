package cn.bocaiman.service;

import cn.bocaiman.base.pojo.vo.PageVO;
import cn.bocaiman.base.pojo.vo.QueryParamVO;
import cn.bocaiman.pojo.system.vo.DriverStatusVO;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-系统管理-司机状态业务层接口</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public interface DriverStatusService {

	/**
	 * <b>根据查询视图和分页信息进行分页查询</b>
	 * @param queryParamVO
	 * @return
	 * @throws Exception
	 */
	PageVO<DriverStatusVO> getByPage(QueryParamVO queryParamVO) throws Exception ;

	/**
	 * <b>根据查询视图进行列表查询</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	List<DriverStatusVO> getByList(DriverStatusVO queryVO) throws Exception;

	/**
	 * <b>保存对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	Boolean save(DriverStatusVO vo) throws Exception;

	/**
	 * <b>修改对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	Boolean update(DriverStatusVO vo) throws Exception;
}
