package cn.bocaiman.service.impl;

import cn.bocaiman.base.pojo.vo.PageVO;
import cn.bocaiman.base.pojo.vo.QueryParamVO;
import cn.bocaiman.dao.BusRentAmountDao;
import cn.bocaiman.pojo.bus.entity.BusRentAmount;
import cn.bocaiman.pojo.bus.vo.BusRentAmountVO;
import cn.bocaiman.service.BusRentAmountService;
import cn.bocaiman.util.IdGenerator;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-车辆管理-大巴车日租金业务层接口</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@Service("busRentAmountService")
@Transactional
public class BusRentAmountServiceImpl implements BusRentAmountService {
	@Autowired
	private BusRentAmountDao dao;
	@Autowired
	private IdGenerator idGenerator;

	/**
	 * <b>根据分页信息查询分页对象</b>
	 * @param queryParamVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public PageVO<BusRentAmountVO> getByPage(QueryParamVO queryParamVO) throws Exception {
		PageVO<BusRentAmountVO> pageVO = queryParamVO.getPageVO();
		BusRentAmountVO queryVO = (BusRentAmountVO) queryParamVO.getQueryVO();
		// 开启 PageHelper 分页过滤器
		PageHelper.startPage(pageVO.getPageNum(), pageVO.getPageSize());
		// 进行分页查询
		List<BusRentAmount> entityList = dao.findListByQuery(BusRentAmount.parseFromEntity(queryVO));
		// 创建 PageInfo 对象
		PageInfo<BusRentAmount> pageInfo = new PageInfo<BusRentAmount>(entityList);
		// 切换数据
		pageVO.setList(BusRentAmountVO.parseFromVOList(pageInfo.getList()));
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
	public List<BusRentAmountVO> getList(BusRentAmountVO queryVO) throws Exception {
		return BusRentAmountVO.parseFromVOList(dao.findListByQuery(BusRentAmount.parseFromEntity(queryVO)));
	}

	/**
	 * <b>保存对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@Override
	public Boolean save(BusRentAmountVO vo) throws Exception {
		// 将视图对象切换为实体对象
		BusRentAmount entity = BusRentAmount.parseFromEntity(vo);
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
	public Boolean update(BusRentAmountVO vo) throws Exception {
		// 将视图对象切换为实体对象
		BusRentAmount entity = BusRentAmount.parseFromEntity(vo);
		// 保存对象
		Integer count = dao.update(entity);
		if (count != null && count > 0) {
			return true;
		}
		return false;
	}
}
