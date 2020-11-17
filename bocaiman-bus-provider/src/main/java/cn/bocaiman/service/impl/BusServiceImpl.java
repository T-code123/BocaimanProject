package cn.bocaiman.service.impl;

import cn.bocaiman.base.pojo.vo.PageVO;
import cn.bocaiman.base.pojo.vo.QueryParamVO;
import cn.bocaiman.dao.BusDao;
import cn.bocaiman.pojo.bus.entity.Bus;
import cn.bocaiman.pojo.bus.vo.BusVO;
import cn.bocaiman.service.BusService;
import cn.bocaiman.util.IdGenerator;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-车辆管理-车辆业务层接口实现类</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@Service("busService")
@Transactional
public class BusServiceImpl implements BusService {
	@Autowired
	private BusDao dao;
	@Autowired
	private IdGenerator idGenerator;


	/**
	 * <b>根据查询对象查询列表</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<BusVO> getByList(BusVO queryVO) throws Exception {
		// 将查询视图切换成查询实体
		Bus query = Bus.parseToEntity(queryVO);
		// 进行列表查询，并且将实体列表切换成视图列表
		List<Bus> entityList = dao.findListByQuery(query);
		// 将实体列表切换成视图列表
		List<BusVO> voList = BusVO.changeListForVo(entityList);
		return voList;
		//return BusVO.changeListForVo(dao.findListByQuery(Bus.parseToEntity(queryVO)));
	}

	/**
	 * <b>根据条件进行分页查询</b>
	 * @param queryParamVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public PageVO<BusVO> getByPage(QueryParamVO queryParamVO) throws Exception {
		// 分别获得分页视图和查询视图
		PageVO<BusVO> pageVO = queryParamVO.getPageVO();
		BusVO queryVO = (BusVO) queryParamVO.getQueryVO();
		// 开启 PageHelper 分页查询过滤器
		PageHelper.startPage(pageVO.getPageNum(), pageVO.getPageSize());
		List<Bus> list = dao.findListByQuery(Bus.parseToEntity(queryVO));
		// 获得 PageInfo 对象
		PageInfo<Bus> pageInfo = new PageInfo<Bus>(list);
		// 切换数据
		pageVO.setList(BusVO.changeListForVo(pageInfo.getList()));
		pageVO.setTotalCount(pageInfo.getTotal());
		pageVO.setTotalPage(pageInfo.getPages());

		return pageVO;
	}


	/**
	 * <b>保存对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean save(BusVO vo) throws Exception {
		Bus entity = Bus.parseToEntity(vo);
		//设定主键
		entity.setId(idGenerator.nextId());
		Integer count = dao.save(entity);
		if (count > 0) {
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
	public boolean update(BusVO vo) throws Exception {
		Integer count = dao.update(Bus.parseToEntity(vo));
		if (count > 0) {
			return true;
		}
		return false;
	}
}
