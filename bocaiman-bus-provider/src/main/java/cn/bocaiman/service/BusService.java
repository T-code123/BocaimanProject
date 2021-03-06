package cn.bocaiman.service;

import cn.bocaiman.base.pojo.vo.PageVO;
import cn.bocaiman.base.pojo.vo.QueryParamVO;
import cn.bocaiman.pojo.bus.vo.BusVO;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-车辆管理-车辆业务层接口</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public interface BusService {
	/**
	 * <b>根据条件进行分页查询</b>
	 * @param queryParamVO
	 * @return
	 * @throws Exception
	 */
	PageVO<BusVO> getByPage(QueryParamVO queryParamVO) throws Exception;

	/**
	 * <b>根据查询对象获得列表</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	List<BusVO> getByList(BusVO queryVO) throws Exception;
	/**
	 * <b>保存对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	boolean save(BusVO vo) throws Exception;

	/**
	 * <b>修改对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	boolean update(BusVO vo) throws Exception;
}
