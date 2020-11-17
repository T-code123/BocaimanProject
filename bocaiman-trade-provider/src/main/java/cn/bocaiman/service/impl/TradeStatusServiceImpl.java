package cn.bocaiman.service.impl;

import cn.bocaiman.base.pojo.vo.PageVO;
import cn.bocaiman.base.pojo.vo.QueryParamVO;
import cn.bocaiman.dao.TradeStatusDao;


import cn.bocaiman.pojo.trade.entity.TradeStatus;
import cn.bocaiman.pojo.trade.vo.TradeStatusVO;
import cn.bocaiman.service.TradeStatusService;
import cn.bocaiman.util.IdGenerator;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-支付管理-交易状态业务层接口实现类</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@Service("tradeStatusService")
@Transactional
public class TradeStatusServiceImpl implements TradeStatusService {
	@Autowired
	private TradeStatusDao dao;
	@Autowired
	private IdGenerator idGenerator;

	/**
	 * <b>根据查询视图和分页信息进行分页查询</b>
	 * @param queryParamVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public PageVO<TradeStatusVO> getByPage(QueryParamVO queryParamVO) throws Exception {
		// 分别获得分页视图和查询视图
		PageVO<TradeStatusVO> pageVO = new PageVO<TradeStatusVO>();
		TradeStatusVO queryVO = (TradeStatusVO) queryParamVO.getQueryVO();
		// 开启 PageHelper 分页过滤器
		PageHelper.startPage(pageVO.getPageNum(), pageVO.getPageSize());
		// 进行分页查询
		List<TradeStatus> entityList = dao.findListByQuery(TradeStatus.parseFromEntity(queryVO));
		// 创建 PageInfo 对象
		PageInfo<TradeStatus> pageInfo = new PageInfo<TradeStatus>(entityList);
		// 切换数据
		pageVO.setList(TradeStatusVO.parseFromListVO(pageInfo.getList()));
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
	public List<TradeStatusVO> getByList(TradeStatusVO queryVO) throws Exception {
		return TradeStatusVO.parseFromListVO(dao.findListByQuery(TradeStatus.parseFromEntity(queryVO)));
	}

	/**
	 * <b>保存对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@Override
	public Boolean save(TradeStatusVO vo) throws Exception {
		// 将视图对象切换成实体对象
		TradeStatus entity = TradeStatus.parseFromEntity(vo);
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
	public Boolean update(TradeStatusVO vo) throws Exception {
		// 将视图对象转换成实体对象
		TradeStatus entity = TradeStatus.parseFromEntity(vo);
		// 修改对象
		Integer count = dao.update(entity);
		if (count != null && count > 0) {
			return true;
		}
		return false;
	}
}
