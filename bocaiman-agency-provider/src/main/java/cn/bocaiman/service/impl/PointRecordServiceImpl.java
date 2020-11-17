package cn.bocaiman.service.impl;

import cn.bocaiman.dao.PointRecordDao;

import cn.bocaiman.pojo.agency.entity.PointRecord;
import cn.bocaiman.pojo.agency.vo.PointRecordVO;
import cn.bocaiman.service.PointRecordService;
import cn.bocaiman.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-旅行社管理-积分记录业务层接口实现类</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@Service("pointRecordService")
@Transactional
public class PointRecordServiceImpl implements PointRecordService {
	@Autowired
	private PointRecordDao dao;
	@Autowired
	private IdGenerator idGenerator;

	/**
	 * <b>根据查询视图查询对象</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<PointRecordVO> getByList(PointRecordVO queryVO) throws Exception  {
		return PointRecordVO.parseFromVOList(dao.findListByQuery(PointRecord.parseFromEntity(queryVO)));
	}
	/**
	 * <b>保存对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean save(PointRecordVO vo) throws Exception{
		// 将视图转换成实体
		PointRecord entity = PointRecord.parseFromEntity(vo);
		// 设置主键
		entity.setId(idGenerator.nextId());
		Integer count = dao.save(entity);
		if (count != null && count > 0) {
			return true;
		}
		return false;
	}
}
