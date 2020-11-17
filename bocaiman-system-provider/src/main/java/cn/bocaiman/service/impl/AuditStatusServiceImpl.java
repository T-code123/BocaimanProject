package cn.bocaiman.service.impl;

import cn.bocaiman.base.pojo.vo.PageVO;
import cn.bocaiman.base.pojo.vo.QueryParamVO;
import cn.bocaiman.dao.AuditStatusDao;
import cn.bocaiman.pojo.order.entity.OrderStatus;
import cn.bocaiman.pojo.order.vo.OrderStatusVO;
import cn.bocaiman.pojo.system.entity.AuditStatus;
import cn.bocaiman.pojo.system.vo.AuditStatusVO;
import cn.bocaiman.service.AuditStatusService;
import cn.bocaiman.util.IdGenerator;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-系统管理-审核状态业务层接口实现类</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@Service("auditStatusService")
@Transactional
public class AuditStatusServiceImpl implements AuditStatusService {
	@Autowired
	private AuditStatusDao dao;
	@Autowired
	private IdGenerator idGenerator;

	/**
	 * <b>根据分页信息查询分页对象</b>
	 * @param queryParamVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public PageVO<AuditStatusVO> getByPage(QueryParamVO queryParamVO) throws Exception {
		PageVO<AuditStatusVO> pageVO = queryParamVO.getPageVO();
		AuditStatusVO queryVO = (AuditStatusVO) queryParamVO.getQueryVO();
		// 开启 PageHelper 分页过滤器
		PageHelper.startPage(pageVO.getPageNum(), pageVO.getPageSize());
		// 进行分页查询
		List<AuditStatus> entityList = dao.findListByQuery(AuditStatus.parseFromEntity(queryVO));
		// 创建 PageInfo 对象
		PageInfo<AuditStatus> pageInfo = new PageInfo<AuditStatus>(entityList);
		// 切换数据
		pageVO.setList(AuditStatusVO.parseFromVOList(pageInfo.getList()));
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
	public List<AuditStatusVO> getByList(AuditStatusVO queryVO) throws Exception {
		return AuditStatusVO.parseFromVOList(dao.findListByQuery(AuditStatus.parseFromEntity(queryVO)));
	}

	/**
	 * <b>保存对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@Override
	public Boolean save(AuditStatusVO vo) throws Exception {
		// 将视图切换成实体对象
		AuditStatus entity = AuditStatus.parseFromEntity(vo);
		// 设置主键
		entity.setId(idGenerator.nextId());
		// 保存对象
		Integer count = dao.save(entity);
		if (count != null && count > 0) {
			return true;
		}
		return false;
	}


	@Override
	public Boolean update(AuditStatusVO vo) throws Exception {
		// 将视图切换成实体对象
		AuditStatus entity = AuditStatus.parseFromEntity(vo);
		// 保存对象
		Integer count = dao.update(entity);
		if (count != null && count > 0) {
			return true;
		}
		return false;
	}
}
