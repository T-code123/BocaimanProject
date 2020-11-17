package cn.bocaiman.service.impl;

import cn.bocaiman.dao.OrderRefundRecordDao;
import cn.bocaiman.pojo.order.entity.OrderRefundRecord;
import cn.bocaiman.pojo.order.vo.OrderRefundRecordVO;
import cn.bocaiman.service.OrderRefundRecordService;
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
@Service("orderRefundRecordService")
@Transactional
public class OrderRefundRecordServiceImpl implements OrderRefundRecordService {
	@Autowired
	private OrderRefundRecordDao dao;
	@Autowired
	private IdGenerator idGenerator;

	/**
	 * <b>根据查询视图查询对象</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */

	@Override
	public List<OrderRefundRecordVO> getByList(OrderRefundRecordVO queryVO) throws Exception {
		return OrderRefundRecordVO.parseFromVOList(dao.findListByQuery(OrderRefundRecord.parseFromEntity(queryVO)));
	}

	/**
	 * <b>保存对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean save(OrderRefundRecordVO vo) throws Exception{
		// 将视图转换成实体
		OrderRefundRecord entity = OrderRefundRecord.parseFromEntity(vo);
		// 设置主键
		entity.setId(idGenerator.nextId());
		Integer count = dao.save(entity);
		if (count != null && count > 0) {
			return true;
		}
		return false;
	}
}
