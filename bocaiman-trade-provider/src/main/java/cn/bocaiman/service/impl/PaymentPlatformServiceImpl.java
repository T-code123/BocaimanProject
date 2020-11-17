package cn.bocaiman.service.impl;

import cn.bocaiman.base.pojo.vo.PageVO;
import cn.bocaiman.base.pojo.vo.QueryParamVO;
import cn.bocaiman.dao.PaymentPlatformDao;
import cn.bocaiman.pojo.system.entity.Area;
import cn.bocaiman.pojo.system.vo.AreaVO;
import cn.bocaiman.pojo.trade.entity.PaymentPlatform;
import cn.bocaiman.pojo.trade.vo.PaymentPlatformVO;
import cn.bocaiman.service.PaymentPlatformService;
import cn.bocaiman.util.IdGenerator;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-支付管理-支付平台传输层接口实现类</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@Service("paymentPlatformService")
@Transactional
public class PaymentPlatformServiceImpl implements PaymentPlatformService {
	@Autowired
	private PaymentPlatformDao dao;
	@Autowired
	private IdGenerator idGenerator;

	/**
	 * <b>根据分页对象查询分页信息/b>
	 * @param queryParamVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public PageVO<PaymentPlatformVO> getBypage(QueryParamVO queryParamVO) throws Exception {
		PageVO<PaymentPlatformVO> pageVO = queryParamVO.getPageVO();
		PaymentPlatformVO queryVO = (PaymentPlatformVO) queryParamVO.getQueryVO();
		// 开启 PageHelper 分页过滤器
		PageHelper.startPage(pageVO.getPageNum(), pageVO.getPageSize());
		// 进行分页查询
		List<PaymentPlatform> entityList = dao.findListByQuery(PaymentPlatform.parseFromEntity(queryVO));
		// 创建 PageInfo 对象
		PageInfo<PaymentPlatform> pageInfo = new PageInfo<PaymentPlatform>(entityList);
		// 切换数据
		pageVO.setList(PaymentPlatformVO.parseFromVOList(pageInfo.getList()));
		pageVO.setTotalCount(pageInfo.getTotal());
		pageVO.setTotalPage(pageInfo.getPages());

		return pageVO;
	}
	/**
	 * <b>根据查询对象查询列表</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<PaymentPlatformVO> getListByQuery(PaymentPlatformVO queryVO) throws Exception {
		return PaymentPlatformVO.parseFromVOList(dao.findListByQuery(PaymentPlatform.parseFromEntity(queryVO)));
	}

	/**
	 * <b>根据主键查询对象</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public PaymentPlatformVO getById(String id) throws Exception {
		// 创建查询实体
		PaymentPlatform query = new PaymentPlatform();
		query.setId(id);
		// 进行列表查询
		List<PaymentPlatform> list = dao.findListByQuery(query);
		if (list != null && !list.isEmpty()) {
			PaymentPlatform entity = list.get(0);
			return PaymentPlatformVO.parseFromVO(entity);
		}
		return null;
	}

	/**
	 * <b>保存信息</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean save(PaymentPlatformVO vo) throws Exception {
		// 将 vo 转换为 entity
		PaymentPlatform entity = PaymentPlatform.parseFromEntity(vo);
		// 设定主键
		entity.setId(idGenerator.nextId());
		// 保存
		Integer count = dao.save(entity);

		if (count != null && count > 0) {
			return true;
		}
		return false;
	}

	/**
	 * <b>修改信息</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean update(PaymentPlatformVO vo) throws Exception {
		// 将 vo 转换为 entity
		PaymentPlatform entity = PaymentPlatform.parseFromEntity(vo);
		// 设定主键
		entity.setId(idGenerator.nextId());
		// 保存
		Integer count = dao.update(entity);

		if (count != null && count > 0) {
			return true;
		}
		return false;
	}

	/**
	 * <b>按照平台名称进行查询</b>
	 * @param platform
	 * @return
	 * @throws Exception
	 */
	@Override
	public PaymentPlatform getByPaymentPlatform(String platform) throws Exception {
		// 创建查询实体
		PaymentPlatform query = new PaymentPlatform();
		query.setPlatform(platform);
		// 进行列表查询
		List<PaymentPlatform> list = dao.findListByQuery(query);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}
}
