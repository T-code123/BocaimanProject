package cn.bocaiman.service;



import cn.bocaiman.pojo.agency.vo.PointRecordVO;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-旅行社管理-积分记录业务层接口</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public interface PointRecordService {

	/**
	 * <b>根据查询兑现查询列表</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	List<PointRecordVO> getByList(PointRecordVO queryVO) throws Exception;

	/**
	 * <b>保存对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	boolean save(PointRecordVO vo) throws Exception;

}
