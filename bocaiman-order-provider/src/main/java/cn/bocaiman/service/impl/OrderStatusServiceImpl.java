package cn.bocaiman.service.impl;

import cn.bocaiman.base.pojo.vo.PageVO;
import cn.bocaiman.base.pojo.vo.QueryParamVO;
import cn.bocaiman.dao.OrderStatusDao;
import cn.bocaiman.pojo.order.entity.OrderStatus;
import cn.bocaiman.pojo.order.vo.OrderStatusVO;
import cn.bocaiman.service.OrderStatusService;
import cn.bocaiman.util.IdGenerator;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-订单管理-订单状态业务层接口</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@Service("orderStatusService")
@Transactional
public class OrderStatusServiceImpl implements OrderStatusService {
	@Autowired
	private OrderStatusDao dao;
	@Autowired
	private IdGenerator idGenerator;

	/**
	 * <b>根据分页信息查询分页对象</b>
	 * @param queryParamVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public PageVO<OrderStatusVO> getBypage(QueryParamVO queryParamVO) throws Exception {
		PageVO<OrderStatusVO> pageVO = queryParamVO.getPageVO();
		OrderStatusVO queryVO = (OrderStatusVO) queryParamVO.getQueryVO();
		// 开启 PageHelper 分页过滤器
		PageHelper.startPage(pageVO.getPageNum(), pageVO.getPageSize());
		// 进行分页查询
		List<OrderStatus> entityList = dao.findListByQuery(OrderStatus.parseFromEntity(queryVO));
		// 创建 PageInfo 对象
		PageInfo<OrderStatus> pageInfo = new PageInfo<OrderStatus>(entityList);
		// 切换数据
		pageVO.setList(OrderStatusVO.parseFromVOList(pageInfo.getList()));
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
	public List<OrderStatusVO> getByList(OrderStatusVO queryVO) throws Exception {
		return OrderStatusVO.parseFromVOList(dao.findListByQuery(OrderStatus.parseFromEntity(queryVO)));
	}

	/**
	 * <b>保存对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@Override
	public Boolean save(OrderStatusVO vo) throws Exception {
		// 将视图切换成实体对象
		OrderStatus entity = OrderStatus.parseFromEntity(vo);
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
	public Boolean update(OrderStatusVO vo) throws Exception {
		// 将视图切换成实体对象
		OrderStatus entity = OrderStatus.parseFromEntity(vo);
		// 保存对象
		Integer count = dao.update(entity);
		if (count != null && count > 0) {
			return true;
		}
		return false;
	}
}
