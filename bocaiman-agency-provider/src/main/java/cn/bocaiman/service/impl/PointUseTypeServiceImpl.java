package cn.bocaiman.service.impl;

import cn.bocaiman.base.pojo.vo.PageVO;
import cn.bocaiman.base.pojo.vo.QueryParamVO;
import cn.bocaiman.dao.PointUseTypeDao;
import cn.bocaiman.pojo.agency.entity.PointUseType;
import cn.bocaiman.pojo.agency.vo.PointUseTypeVO;
import cn.bocaiman.service.PointUseTypeService;
import cn.bocaiman.util.IdGenerator;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-旅行社管理-积分使用类型业务层接口实现类</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@Service("pointUseTypeService")
@Transactional
public class PointUseTypeServiceImpl implements PointUseTypeService {
	@Autowired
	private PointUseTypeDao dao;
	@Autowired
	private IdGenerator idGenerator;

	/**
	 * <b>根据分页信息查询分页对象</b>
	 * @param queryParamVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public PageVO<PointUseTypeVO> geBypage(QueryParamVO queryParamVO) throws Exception {
		PageVO<PointUseTypeVO> pageVO = queryParamVO.getPageVO();
		PointUseTypeVO queryVO = (PointUseTypeVO) queryParamVO.getQueryVO();
		// 开启 PageHelper 分页过滤器
		PageHelper.startPage(pageVO.getPageNum(), pageVO.getPageSize());
		// 进行分页查询
		List<PointUseType> entityList = dao.findListByQuery(PointUseType.parseFromEntity(queryVO));
		// 创建 PageInfo 对象
		PageInfo<PointUseType> pageInfo = new PageInfo<PointUseType>(entityList);
		// 切换数据
		pageVO.setList(PointUseTypeVO.parseFromVOList(pageInfo.getList()));
		pageVO.setTotalCount(pageInfo.getTotal());
		pageVO.setTotalPage(pageInfo.getPages());

		return pageVO;
	}

	/**
	 * <b>根据查询兑现查询列表</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<PointUseTypeVO> getByList(PointUseTypeVO queryVO) throws Exception {

		return PointUseTypeVO.parseFromVOList(dao.findListByQuery(PointUseType.parseFromEntity(queryVO)));
	}

	/**
	 * <b>保存对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@Override
	public Boolean save(PointUseTypeVO vo) throws Exception {
		// 将视图切换成实体对象
		PointUseType entity = PointUseType.parseFromEntity(vo);
		// 设置主键
		entity.setId(idGenerator.nextId());
		// 保存对象
		Integer count = dao.save(entity);
		if (count != null && count > 0) {
			return true;
		}
		return false;
	}

	/**
	 * <b>修改对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@Override
	public Boolean update(PointUseTypeVO vo) throws Exception {
		// 将视图切换成实体对象
		PointUseType entity = PointUseType.parseFromEntity(vo);
		// 保存对象
		Integer count = dao.update(entity);
		if (count != null && count > 0) {
			return true;
		}
		return false;
	}


}
