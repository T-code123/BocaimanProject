package cn.bocaiman.service.impl;

import cn.bocaiman.dao.OrderCancelRecordDao;
import cn.bocaiman.pojo.order.entity.OrderCancelRecord;
import cn.bocaiman.pojo.order.vo.OrderCancelRecordVO;
import cn.bocaiman.service.OrderCancelRecordService;
import cn.bocaiman.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-订单管理-订单取消业务层接口实现类</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@Service("orderCancelRecordService")
@Transactional
public class OrderCancelRecordServiceImpl implements OrderCancelRecordService {
	@Autowired
	private OrderCancelRecordDao dao;
	@Autowired
	private IdGenerator idGenerator;

	/**
	 * <b>根据查询视图查询对象</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */

	@Override
	public List<OrderCancelRecordVO> getByList(OrderCancelRecordVO queryVO) throws Exception {
		return OrderCancelRecordVO.parseFromVOList(dao.findListByQuery(OrderCancelRecord.parseFromEntity(queryVO)));
	}

	/**
	 * <b>保存对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean save(OrderCancelRecordVO vo) throws Exception{
		// 将视图转换成实体
		OrderCancelRecord entity = OrderCancelRecord.parseFromEntity(vo);
		// 设置主键
		entity.setId(idGenerator.nextId());
		Integer count = dao.save(entity);
		if (count != null && count > 0) {
			return true;
		}
		return false;
	}
}
