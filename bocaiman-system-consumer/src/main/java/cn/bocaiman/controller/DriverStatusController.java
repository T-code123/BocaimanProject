package cn.bocaiman.controller;

import cn.bocaiman.base.controller.BaseController;
import cn.bocaiman.base.pojo.vo.PageVO;
import cn.bocaiman.base.pojo.vo.QueryParamVO;
import cn.bocaiman.base.pojo.vo.ResponseVO;
import cn.bocaiman.pojo.system.vo.DriverStatusVO;
import cn.bocaiman.transport.system.DriverStatusTransport;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * <b>菠菜侠旅游租赁平台-系统管理-司机状态控制器</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@Api(value = "菠菜侠旅游租赁平台-系统管理-司机状态控制器", tags = {"菠菜侠旅游租赁平台-系统管理-司机状态交互接口"})
@RestController("driverStatusController")
@RequestMapping("/system/driverstatus")
public class DriverStatusController extends BaseController {
	@Autowired
	private DriverStatusTransport transport;

	/**
	 * <b>根据查询信息和分页信息进行分页查询</b>
	 * @param pageNum
	 * @param pageSize
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "根据查询信息和分页信息进行分页查询", protocols = "application/json", httpMethod = "POST")
	@ApiParam(value = "查询视图", type = "DriverStatusVO", required = true)
	@ApiResponse(code = 200, message = "系统响应视图")
	@PostMapping("/page/{pageNum}/{pageSize}")
	public ResponseVO queryByPage(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize,
	                              @RequestBody DriverStatusVO queryVO) throws Exception {
		// 根据 pageNum 和 pageSize 创建 PageVO 对象
		PageVO<DriverStatusVO> pageVO = new PageVO<DriverStatusVO>(pageNum, pageSize);
		// 将 pageVO 和 pageSize 组装成 Map 集合
		//Map<String, Object> queryMap = new HashMap<String, Object>();
		//queryMap.put("pageVO", pageVO);
		//queryMap.put("queryVO", queryVO);

		// 将 pageVO 和 queryVO 封装成QueryParamVO， 进行分页查询
		QueryParamVO queryParamVO = new QueryParamVO();
		queryParamVO.setPageVO(pageVO);
		queryParamVO.setQueryVO(queryVO);
		return ResponseVO.success(transport.getByPage(queryParamVO));
	}

	/**
	 * <b>根据查询视图进行列表查询</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "根据查询视图进行列表查询", protocols = "application/json", httpMethod = "POST")
	@ApiParam(value = "查询视图", type = "DriverStatusVO", required = true)
	@ApiResponse(code = 200, message = "系统响应视图")
	@PostMapping("/list")
	public ResponseVO queryList(@RequestBody DriverStatusVO queryVO) throws Exception {
		return ResponseVO.success(transport.getByList(queryVO));
	}

	/**
	 * <b>根据主键查询对象</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "根据主键查询对象", httpMethod = "GET")
	@ApiResponse(code = 200, message = "系统响应视图")
	@GetMapping("/id/{id}")
	public ResponseVO queryById(@PathVariable("id") String id) throws Exception {
		// 封装查询对象
		DriverStatusVO queryVO = new DriverStatusVO();
		queryVO.setId(id);
		// 查询列表
		List<DriverStatusVO> voList = transport.getByList(queryVO);
		if (voList != null && !voList.isEmpty()) {
			return ResponseVO.success(voList.get(0));
		}
		return ResponseVO.success(new DriverStatusVO());
	}

	/**
	 * <b>根据编码查询对象</b>
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "根据主键查询对象", httpMethod = "POST")
	@ApiResponse(code = 200, message = "系统响应视图")
	@PostMapping("/code/{code}")
	public ResponseVO queryByCode(@PathVariable("code") String code) throws Exception {
		// 封装查询对象
		DriverStatusVO queryVO = new DriverStatusVO();
		queryVO.setCode(code);
		// 查询列表
		List<DriverStatusVO> voList = transport.getByList(queryVO);
		if (voList != null && !voList.isEmpty()) {
			return ResponseVO.success(voList.get(0));
		}
		return ResponseVO.success(new DriverStatusVO());
	}

	/**
	 * <b>保存对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "保存对象", protocols = "application/json", httpMethod = "POST")
	@ApiParam(value = "保存视图", type = "DriverStatusVO", required = true)
	@ApiResponse(code = 200, message = "系统响应视图")
	@PostMapping("/save")
	public ResponseVO save(@RequestBody DriverStatusVO vo) throws Exception {
		// 信息是否有效
		if (vo.getText() != null && !"".equals(vo.getText().trim())
			&& vo.getCode() != null && !"".equals(vo.getCode().trim())) {
			// 查询文本信息
			DriverStatusVO queryVO = new DriverStatusVO();
			queryVO.setText(vo.getText());
			List<DriverStatusVO> list = transport.getByList(queryVO);
			// 查询编码
			queryVO.setText(null);
			queryVO.setCode(vo.getCode());
			List<DriverStatusVO> list1 = transport.getByList(queryVO);
			if ((list == null || list.isEmpty()) && (list1 == null || list1.isEmpty())) {
				if (transport.save(vo)) {
					return ResponseVO.success("保存成功");
				}
				return ResponseVO.failure("保存失败");
			}
			return ResponseVO.failure("该信息已存在");
		}
		return ResponseVO.failure("请填写有效信息");
	}


	/**
	 * <b>修改对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "修改对象", protocols = "application/json", httpMethod = "POST")
	@ApiParam(value = "修改视图", type = "DriverStatusVO", required = true)
	@ApiResponse(code = 200, message = "系统响应视图")
	@PostMapping("/update")
	public ResponseVO update(@RequestBody DriverStatusVO vo) throws Exception {
		// 信息是否有效
		if (vo.getText() == null || "".equals(vo.getText().trim())
				|| vo.getCode() == null || "".equals(vo.getCode().trim())) {
			return ResponseVO.failure("请填写有效信息");
		}
		// 查询文本信息
		DriverStatusVO queryVO = new DriverStatusVO();
		queryVO.setText(vo.getText());
		List<DriverStatusVO> list = transport.getByList(queryVO);
		// 查询编码
		queryVO.setText(null);
		queryVO.setCode(vo.getCode());
		List<DriverStatusVO> list1 = transport.getByList(queryVO);
		if (list != null && !list.isEmpty() && list.get(0).getId().equals(vo.getId())) {
			return ResponseVO.failure("该信息已存在");
		}
		if (list1 != null && !list1.isEmpty() && list1.get(0).getId().equals(vo.getId())) {
			return ResponseVO.failure("该信息已存在");
		}

		if (transport.update(vo)) {
			return ResponseVO.success("保存成功");
		} else {
			return ResponseVO.failure("保存失败");
		}
	}
}
