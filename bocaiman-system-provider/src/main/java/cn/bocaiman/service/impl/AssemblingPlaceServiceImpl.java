package cn.bocaiman.service.impl;

import cn.bocaiman.base.pojo.vo.PageVO;
import cn.bocaiman.base.pojo.vo.QueryParamVO;
import cn.bocaiman.dao.AssemblingPlaceDao;
import cn.bocaiman.pojo.system.entity.AssemblingPlace;
import cn.bocaiman.pojo.system.vo.AssemblingPlaceVO;
import cn.bocaiman.service.AssemblingPlaceService;
import cn.bocaiman.util.IdGenerator;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-系统管理-出发集合地点业务层接口实现类</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@Service("assemblingPlaceService")
@Transactional
public class AssemblingPlaceServiceImpl implements AssemblingPlaceService {
	@Autowired
	private AssemblingPlaceDao dao;
	@Autowired
	private IdGenerator idGenerator;

	/**
	 * <b>根据分页信息查询分页对象</b>
	 * @param queryParamVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public PageVO<AssemblingPlaceVO> getByPage(QueryParamVO queryParamVO) throws Exception {
		PageVO<AssemblingPlaceVO> pageVO = queryParamVO.getPageVO();
		AssemblingPlaceVO queryVO = (AssemblingPlaceVO) queryParamVO.getQueryVO();
		// 开启 PageHelper 分页过滤器
		PageHelper.startPage(pageVO.getPageNum(), pageVO.getPageSize());
		// 进行分页查询
		List<AssemblingPlace> entityList = dao.findListByQuery(AssemblingPlace.parseFromEntity(queryVO));
		// 创建 PageInfo 对象
		PageInfo<AssemblingPlace> pageInfo = new PageInfo<AssemblingPlace>(entityList);
		// 切换数据
		pageVO.setList(AssemblingPlaceVO.parseFromVOList(pageInfo.getList()));
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
	public List<AssemblingPlaceVO> getList(AssemblingPlaceVO queryVO) throws Exception {
		return AssemblingPlaceVO.parseFromVOList(dao.findListByQuery(AssemblingPlace.parseFromEntity(queryVO)));
	}

	/**
	 * <b>保存对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@Override
	public Boolean save(AssemblingPlaceVO vo) throws Exception {
		// 将视图对象切换为实体对象
		AssemblingPlace entity = AssemblingPlace.parseFromEntity(vo);
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
	public Boolean update(AssemblingPlaceVO vo) throws Exception {
		// 将视图对象切换为实体对象
		AssemblingPlace entity = AssemblingPlace.parseFromEntity(vo);
		// 保存对象
		Integer count = dao.update(entity);
		if (count != null && count > 0) {
			return true;
		}
		return false;
	}
}
