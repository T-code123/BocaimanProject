package cn.bocaiman.transport.impl;

import cn.bocaiman.base.pojo.vo.PageVO;
import cn.bocaiman.base.pojo.vo.QueryParamVO;
import cn.bocaiman.pojo.system.vo.AuditStatusVO;
import cn.bocaiman.service.AuditStatusService;
import cn.bocaiman.transport.system.AuditStatusTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-系统管理-审核状态控制器</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController("auditStatusTransport")
@RequestMapping("/system/auditstatus/trans")
public class AuditStatusTransportImpl implements AuditStatusTransport {
	@Autowired
	private AuditStatusService service;

	/**
	 * <b>根据分页信息查询分页对象</b>
	 * @param queryParamVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	@Override
	public PageVO<AuditStatusVO> getByPage(@RequestBody QueryParamVO queryParamVO) throws Exception {
		return service.getByPage(queryParamVO);
	}

	/**
	 * <b>根据查询兑现查询列表</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	@Override
	public List<AuditStatusVO> getByList(@RequestBody AuditStatusVO queryVO) throws Exception {
		return service.getByList(queryVO);
	}

	/**
	 * <b>保存对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	@Override
	public Boolean save(@RequestBody AuditStatusVO vo) throws Exception {
		return service.save(vo);
	}

	@Override
	public Boolean update(@RequestBody AuditStatusVO vo) throws Exception {
		return service.update(vo);
	}
}
