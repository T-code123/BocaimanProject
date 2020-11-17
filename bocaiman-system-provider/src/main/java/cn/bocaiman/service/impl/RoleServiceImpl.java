package cn.bocaiman.service.impl;

import cn.bocaiman.base.pojo.vo.PageVO;
import cn.bocaiman.base.pojo.vo.QueryParamVO;
import cn.bocaiman.dao.RoleDao;
import cn.bocaiman.pojo.system.entity.Role;
import cn.bocaiman.pojo.system.vo.RoleVO;
import cn.bocaiman.service.RoleService;
import cn.bocaiman.util.IdGenerator;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-系统管理-角色信息业务层接口实现类</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleDao dao;
	@Autowired
	private IdGenerator idGenerator;
	/**
	 * <b>根据分页信息查询分页对象</b>
	 * @param queryParamVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public PageVO<RoleVO> getByPage(QueryParamVO queryParamVO) throws Exception {
		// 获得分页视图和查询视图
		PageVO<RoleVO> pageVO = queryParamVO.getPageVO();
		RoleVO queryVO = (RoleVO) queryParamVO.getQueryVO();
		// 开启 PageHelper 分页过滤器
		PageHelper.startPage(pageVO.getPageNum(),pageVO.getPageSize());
		// 进行分页查询
		List<Role> entityList = dao.findListByQuery(Role.parseFromEntity(queryVO));
		// 创建 PageInfo 对象
		PageInfo<Role> pageInfo = new PageInfo<Role>(entityList);
		// 切换数据
		pageVO.setList(RoleVO.parseFromVOList(pageInfo.getList()));
		pageVO.setTotalCount(pageInfo.getTotal());
		pageVO.setTotalPage(pageInfo.getPages());

		return pageVO;

	}

	/**
	 * <b>根据查询列表查询</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<RoleVO> getList(RoleVO queryVO) throws Exception {
		return RoleVO.parseFromVOList(dao.findListByQuery(Role.parseFromEntity(queryVO)));
	}

	/**
	 * <b>保存对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@Override
	public Boolean save(RoleVO vo) throws Exception {
		// 将视图对象切换为实体对象
		Role entity = Role.parseFromEntity(vo);
		// 设置主键
		entity.setId(idGenerator.nextId());
		// 保存对象
		Integer count = dao.save(entity);
		if (count != null && count > 0){
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
	public Boolean update(RoleVO vo) throws Exception {
		// 将视图对象切换为实体对象
		Role entity = Role.parseFromEntity(vo);
		// 设置主键
		entity.setId(idGenerator.nextId());
		// 保存对象
		Integer count = dao.update(entity);
		if (count != null && count > 0){
			return true;
		}
		return false;
	}
}
