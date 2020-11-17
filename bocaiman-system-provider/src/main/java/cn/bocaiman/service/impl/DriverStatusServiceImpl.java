package cn.bocaiman.service.impl;

import cn.bocaiman.base.pojo.vo.PageVO;
import cn.bocaiman.base.pojo.vo.QueryParamVO;
import cn.bocaiman.dao.DriverStatusDao;
import cn.bocaiman.pojo.system.entity.DriverStatus;
import cn.bocaiman.pojo.system.vo.DriverStatusVO;
import cn.bocaiman.service.DriverStatusService;
import cn.bocaiman.util.IdGenerator;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-系统管理-司机状态传输层接口实现类</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@Service("driverStatusService")
@Transactional
public class DriverStatusServiceImpl implements DriverStatusService {
	@Autowired
	private DriverStatusDao dao;
	@Autowired
	private IdGenerator idGenerator;

	/**
	 * <b>根据查询视图和分页信息进行分页查询</b>
	 * @param queryParamVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public PageVO<DriverStatusVO> getByPage(QueryParamVO queryParamVO) throws Exception {
		// 分别获得分页视图和查询视图
		PageVO<DriverStatusVO> pageVO = new PageVO<DriverStatusVO>();
		DriverStatusVO queryVO = (DriverStatusVO) queryParamVO.getQueryVO();
		// 开启 PageHelper 分页过滤器
		PageHelper.startPage(pageVO.getPageNum(), pageVO.getPageSize());
		// 进行分页查询
		List<DriverStatus> entityList = dao.findListByQuery(DriverStatus.parseFromEntity(queryVO));
		// 创建 PageInfo 对象
		PageInfo<DriverStatus> pageInfo = new PageInfo<DriverStatus>(entityList);
		// 切换数据
		pageVO.setList(DriverStatusVO.parseFromListVO(pageInfo.getList()));
		pageVO.setTotalCount(pageInfo.getTotal());
		pageVO.setTotalPage(pageInfo.getPages());
		return pageVO;
	}

	/**
	 * <b>根据查询视图进行列表查询</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<DriverStatusVO> getByList(DriverStatusVO queryVO) throws Exception {
		return DriverStatusVO.parseFromListVO(dao.findListByQuery(DriverStatus.parseFromEntity(queryVO)));
	}

	/**
	 * <b>保存对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@Override
	public Boolean save(DriverStatusVO vo) throws Exception {
		// 将视图对象切换成实体对象
		DriverStatus entity = DriverStatus.parseFromEntity(vo);
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
	public Boolean update(DriverStatusVO vo) throws Exception {
		// 将视图对象转换成实体对象
		DriverStatus entity = DriverStatus.parseFromEntity(vo);
		// 修改对象
		Integer count = dao.update(entity);
		if (count != null && count > 0) {
			return true;
		}
		return false;
	}
}
