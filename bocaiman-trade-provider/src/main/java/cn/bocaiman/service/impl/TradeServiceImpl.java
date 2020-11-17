package cn.bocaiman.service.impl;

import cn.bocaiman.base.pojo.vo.PageVO;
import cn.bocaiman.base.pojo.vo.QueryParamVO;
import cn.bocaiman.dao.TradeDao;
import cn.bocaiman.pojo.trade.entity.Trade;
import cn.bocaiman.pojo.trade.vo.TradeVO;
import cn.bocaiman.service.TradeService;
import cn.bocaiman.util.IdGenerator;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-支付管理-订单支付传输层接口实现类</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@Service("tradeService")
@Transactional
public class TradeServiceImpl implements TradeService {
	@Autowired
	private TradeDao dao;
	@Autowired
	private IdGenerator idGenerator;
	/**
	 * <b>使用支付宝之后，保存交易信息</b>
	 * @param trade
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean saveByAlipayTradeVO(Trade trade) throws Exception {
		// 设定主键
		trade.setId(idGenerator.nextId());
		// 保存信息
		Integer count = dao.save(trade);
		if (count != null && count > 0) {
			return true;
		}
		return false;
	}

	/**
	 * <b>根据分页信息查询分页对象</b>
	 * @param queryParamVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public PageVO<TradeVO> getByPage(QueryParamVO queryParamVO) throws Exception {
		PageVO<TradeVO> pageVO = queryParamVO.getPageVO();
		TradeVO queryVO = (TradeVO) queryParamVO.getQueryVO();
		// 开启 PageHelper 分页过滤器
		PageHelper.startPage(pageVO.getPageNum(), pageVO.getPageSize());
		// 进行分页查询
		List<Trade> entityList = dao.findListByQuery(Trade.parseFromEntity(queryVO));
		// 创建 PageInfo 对象
		PageInfo<Trade> pageInfo = new PageInfo<Trade>(entityList);
		// 切换数据
		pageVO.setList(TradeVO.parseFromVOList(pageInfo.getList()));
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
	public List<TradeVO> getList(TradeVO queryVO) throws Exception {
		return TradeVO.parseFromVOList(dao.findListByQuery(Trade.parseFromEntity(queryVO)));
	}

	/**
	 * <b>保存对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@Override
	public Boolean save(TradeVO vo) throws Exception {
		// 将视图对象切换为实体对象
		Trade entity = Trade.parseFromEntity(vo);
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
	public Boolean update(TradeVO vo) throws Exception {
		// 将视图对象切换为实体对象
		Trade entity = Trade.parseFromEntity(vo);
		// 保存对象
		Integer count = dao.update(entity);
		if (count != null && count > 0) {
			return true;
		}
		return false;
	}
}
