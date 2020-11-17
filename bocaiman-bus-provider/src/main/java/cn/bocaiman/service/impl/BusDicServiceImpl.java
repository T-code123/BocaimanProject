package cn.bocaiman.service.impl;

import cn.bocaiman.base.pojo.vo.PageVO;
import cn.bocaiman.base.pojo.vo.QueryParamVO;
import cn.bocaiman.dao.BusDicDao;
import cn.bocaiman.service.BusDicService;
import cn.bocaiman.pojo.bus.entity.BusDic;
import cn.bocaiman.pojo.bus.vo.BusDicVO;
import cn.bocaiman.util.IdGenerator;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-车辆管理-大巴车字典业务层接口实现类</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@Service("busDicService")
@Transactional
public class BusDicServiceImpl implements BusDicService {
	@Autowired
	private BusDicDao dao;
	@Autowired
	private IdGenerator idGenerator;

	/**
	 * <b>根据分页信息查询分页对象</b>
	 * @param queryParamVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public PageVO<BusDicVO> getByPage(QueryParamVO queryParamVO) throws Exception {
		PageVO<BusDicVO> pageVO = queryParamVO.getPageVO();
		BusDicVO queryVO = (BusDicVO) queryParamVO.getQueryVO();
		// 开启 PageHelper 分页过滤器
		PageHelper.startPage(pageVO.getPageNum(), pageVO.getPageSize());
		// 进行分页查询
		List<BusDic> entityList = dao.findListByQuery(BusDic.parseFromEntity(queryVO));
		// 创建 PageInfo 对象
		PageInfo<BusDic> pageInfo = new PageInfo<BusDic>(entityList);
		// 切换数据
		pageVO.setList(BusDicVO.parseFromVOList(pageInfo.getList()));
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
	public List<BusDicVO> getList(BusDicVO queryVO) throws Exception {
		return BusDicVO.parseFromVOList(dao.findListByQuery(BusDic.parseFromEntity(queryVO)));
	}

	/**
	 * <b>保存对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@Override
	public Boolean save(BusDicVO vo) throws Exception {
		// 将视图对象切换为实体对象
		BusDic entity = BusDic.parseFromEntity(vo);
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
	public Boolean update(BusDicVO vo) throws Exception {
		// 将视图对象切换为实体对象
		BusDic entity = BusDic.parseFromEntity(vo);
		// 保存对象
		Integer count = dao.update(entity);
		if (count != null && count > 0) {
			return true;
		}
		return false;
	}
}
