package cn.bocaiman.transport.impl;

import cn.bocaiman.base.pojo.vo.PageVO;
import cn.bocaiman.base.pojo.vo.QueryParamVO;
import cn.bocaiman.pojo.system.vo.DriverStatusVO;
import cn.bocaiman.service.DriverStatusService;
import cn.bocaiman.transport.system.DriverStatusTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-系统管理-司机状态传输层接口实现类</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController("driverStatusTransport")
@RequestMapping("/system/driverstatus/trans")
public class DriverStatusTransportImpl implements DriverStatusTransport {
	@Autowired
	private DriverStatusService service;

	/**
	 * <b>根据查询视图和分页信息进行分页查询</b>
	 * @param queryParamVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	@Override
	public PageVO<DriverStatusVO> getByPage(@RequestBody QueryParamVO queryParamVO) throws Exception {
		return service.getByPage(queryParamVO);
	}

	/**
	 * <b>根据查询视图进行列表查询</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	@Override
	public List<DriverStatusVO> getByList(@RequestBody DriverStatusVO queryVO) throws Exception {
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
	public Boolean save(@RequestBody DriverStatusVO vo) throws Exception {
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
	public Boolean update(@RequestBody DriverStatusVO vo) throws Exception {
		return service.update(vo);
	}
}
