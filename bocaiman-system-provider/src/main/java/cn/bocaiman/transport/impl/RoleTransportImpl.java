package cn.bocaiman.transport.impl;

import cn.bocaiman.base.pojo.vo.PageVO;
import cn.bocaiman.base.pojo.vo.QueryParamVO;
import cn.bocaiman.pojo.system.vo.RoleVO;
import cn.bocaiman.service.RoleService;
import cn.bocaiman.transport.system.RoleTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-系统管理-角色信息传输层接口实现类</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController("roleTransport")
@RequestMapping("/system/role/trans")
public class RoleTransportImpl implements RoleTransport {
	@Autowired
	private RoleService service;
	/**
	 * <b>根据分页信息查询分页对象</b>
	 * @param queryParamVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	@Override
	public PageVO<RoleVO> getByPage(@RequestBody QueryParamVO queryParamVO) throws Exception {
		return service.getByPage(queryParamVO);
	}

	/**
	 * <b>根据查询列表查询</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	@Override
	public List<RoleVO> getList(@RequestBody RoleVO queryVO) throws Exception {
		return service.getList(queryVO);
	}

	/**
	 * <b>保存对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	@Override
	public Boolean save(@RequestBody RoleVO vo) throws Exception {
		return service.save(vo);
	}

	/**
	 * <b>修改对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/update")
	@Override
	public Boolean update(@RequestBody RoleVO vo) throws Exception {
		return service.update(vo);
	}
}
