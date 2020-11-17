package cn.bocaiman.service.impl;

import cn.bocaiman.dao.AdminDao;
import cn.bocaiman.pojo.system.entity.Admin;
import cn.bocaiman.pojo.system.vo.AdminVO;
import cn.bocaiman.service.AdminService;
import cn.bocaiman.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-系统管理-管理员信息业务层接口实现类</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@Service("AdminService")
@Transactional
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDao dao;
	@Autowired
	private IdGenerator idGenerator;

	/**
	 * <b>根据查询兑现查询列表</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<AdminVO> getList(AdminVO queryVO) throws Exception {
		return AdminVO.parseFromVOList(dao.findListByQuery(Admin.parseFromEntity(queryVO)));
	}

	/**
	 * <b>保存对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@Override
	public Boolean save(AdminVO vo) throws Exception {
		// 将视图对象切换为实体对象
		Admin entity = Admin.parseFromEntity(vo);
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
	public Boolean update(AdminVO vo) throws Exception {
		// 将视图对象切换为实体对象
		Admin entity = Admin.parseFromEntity(vo);
		// 修改对象
		Integer count = dao.update(entity);
		if (count != null && count > 0) {
			return true;
		}
		return false;
	}
}
