package cn.bocaiman.transport.impl;

import cn.bocaiman.pojo.system.vo.AdminVO;
import cn.bocaiman.service.AdminService;
import cn.bocaiman.transport.system.AdminTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-系统管理-管理员传输层接口实现类</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController("AdminTransport")
@RequestMapping("/system/admin/trans")
public class AdminTransportImpl implements AdminTransport {
	@Autowired
	private AdminService service;

	/**
	 * <b>根据查询兑现查询列表</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	@Override
	public List<AdminVO> getList(@RequestBody AdminVO queryVO) throws Exception {
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
	public Boolean save(@RequestBody AdminVO vo) throws Exception {
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
	public Boolean update(@RequestBody AdminVO vo) throws Exception {
		return service.update(vo);
	}
}
