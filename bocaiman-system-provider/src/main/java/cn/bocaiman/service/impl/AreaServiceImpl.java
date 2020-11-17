package cn.bocaiman.service.impl;

import cn.bocaiman.base.pojo.vo.PageVO;
import cn.bocaiman.base.pojo.vo.QueryParamVO;
import cn.bocaiman.dao.AreaDao;
import cn.bocaiman.pojo.system.entity.Area;
import cn.bocaiman.pojo.system.vo.AreaVO;
import cn.bocaiman.service.AreaService;
import cn.bocaiman.util.IdGenerator;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-系统管理-区域信息业务层接口实现类</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@Service("areaService")
@Transactional
public class AreaServiceImpl implements AreaService {
	@Autowired
	private AreaDao dao;
	@Autowired
	private IdGenerator idGenerator;

	/**
	 * <b>根据分页信息查询分页对象</b>
	 * @param queryParamVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public PageVO<AreaVO> getByPage(QueryParamVO queryParamVO) throws Exception {
		PageVO<AreaVO> pageVO = queryParamVO.getPageVO();
		AreaVO queryVO = (AreaVO) queryParamVO.getQueryVO();
		// 开启 PageHelper 分页过滤器
		PageHelper.startPage(pageVO.getPageNum(), pageVO.getPageSize());
		// 进行分页查询
		List<Area> entityList = dao.findListByQuery(Area.parseFromEntity(queryVO));
		// 创建 PageInfo 对象
		PageInfo<Area> pageInfo = new PageInfo<Area>(entityList);
		// 切换数据
		pageVO.setList(AreaVO.parseFromVOList(pageInfo.getList()));
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
	public List<AreaVO> getList(AreaVO queryVO) throws Exception {
		return AreaVO.parseFromVOList(dao.findListByQuery(Area.parseFromEntity(queryVO)));
	}

	/**
	 * <b>保存对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@Override
	public Boolean save(AreaVO vo) throws Exception {
		// 将视图对象切换为实体对象
		Area entity = Area.parseFromEntity(vo);
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
	public Boolean update(AreaVO vo) throws Exception {
		// 将视图对象切换为实体对象
		Area entity = Area.parseFromEntity(vo);
		// 修改对象
		Integer count = dao.update(entity);
		if (count != null && count > 0) {
			return true;
		}
		return false;
	}
}
