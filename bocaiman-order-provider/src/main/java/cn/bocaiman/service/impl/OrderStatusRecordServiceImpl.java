package cn.bocaiman.service.impl;

import cn.bocaiman.dao.OrderStatusRecordDao;
import cn.bocaiman.pojo.order.entity.OrderStatusRecord;
import cn.bocaiman.pojo.order.vo.OrderStatusRecordVO;
import cn.bocaiman.pojo.order.vo.OrderStatusVO;
import cn.bocaiman.service.OrderStatusRecordService;
import cn.bocaiman.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-支付管理-订单信状态传输层接口实现类</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@Service("orderStatusRecordService")
@Transactional
public class OrderStatusRecordServiceImpl implements OrderStatusRecordService {
	@Autowired
	private OrderStatusRecordDao dao;
	@Autowired
	private IdGenerator idGenerator;

	/**
	 * <b>根据查询视图查询对象</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<OrderStatusRecordVO> getByList(OrderStatusRecordVO queryVO) throws Exception  {
		return OrderStatusRecordVO.parseFromVOList(dao.findListByQuery(OrderStatusRecord.parseFromEntity(queryVO)));
	}
	/**
	 * <b>保存对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean save(OrderStatusRecordVO vo) throws Exception{
		// 将视图转换成实体
		OrderStatusRecord entity = OrderStatusRecord.parseFromEntity(vo);
		// 设置主键
		entity.setId(idGenerator.nextId());
		Integer count = dao.save(entity);
		if (count != null && count > 0) {
			return true;
		}
		return false;
	}

}
