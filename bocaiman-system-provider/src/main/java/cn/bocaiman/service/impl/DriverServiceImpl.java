package cn.bocaiman.service.impl;

import cn.bocaiman.base.pojo.vo.PageVO;
import cn.bocaiman.base.pojo.vo.QueryParamVO;
import cn.bocaiman.dao.DriverDao;
import cn.bocaiman.pojo.system.entity.Driver;
import cn.bocaiman.pojo.system.vo.DriverVO;
import cn.bocaiman.service.DriverService;
import cn.bocaiman.util.IdGenerator;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-系统管理-司机信息传输层接口实现类</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@Service("driverService")
@Transactional
public class DriverServiceImpl implements DriverService {
	@Autowired
	private DriverDao dao;
	@Autowired
	private IdGenerator idGenerator;

	/**
	 * <b>根据分页信息查询分页对象</b>
	 * @param queryParamVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public PageVO<DriverVO> getByPage(QueryParamVO queryParamVO) throws Exception {
		PageVO<DriverVO> pageVO = queryParamVO.getPageVO();
		DriverVO queryVO = (DriverVO) queryParamVO.getQueryVO();
		// 开启 PageHelper 分页过滤器
		PageHelper.startPage(pageVO.getPageNum(), pageVO.getPageSize());
		// 进行分页查询
		List<Driver> entityList = dao.findListByQuery(Driver.parseFromEntity(queryVO));
		// 创建 PageInfo 对象
		PageInfo<Driver> pageInfo = new PageInfo<Driver>(entityList);
		// 切换数据
		pageVO.setList(DriverVO.parseFromVOList(pageInfo.getList()));
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
	public List<DriverVO> getList(DriverVO queryVO) throws Exception {
		Driver driver = Driver.parseFromEntity(queryVO);
		List<Driver> voList = dao.findListByQuery(driver);
//		System.out.println("driver =" + driver);
//		System.out.println("voList =" + voList);
		return DriverVO.parseFromVOList(voList);
	}

	/**
	 * <b>保存对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@Override
	public Boolean save(DriverVO vo) throws Exception {
		// 将视图对象切换为实体对象
		Driver entity = Driver.parseFromEntity(vo);
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
	public Boolean update(DriverVO vo) throws Exception {
		// 将视图对象切换为实体对象
		Driver entity = Driver.parseFromEntity(vo);
		// 保存对象
		Integer count = dao.update(entity);
		if (count != null && count > 0) {
			return true;
		}
		return false;
	}
}
