package cn.bocaiman.controller;

import cn.bocaiman.base.controller.BaseController;
import cn.bocaiman.base.pojo.vo.ResponseVO;
import cn.bocaiman.pojo.system.vo.AdminVO;
import cn.bocaiman.transport.system.AdminTransport;
import cn.bocaiman.util.MD5EncryptUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-系统管理-管理员信息控制器</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@Api(value = "菠菜侠旅游租赁平台-系统管理-管理员信息控制器", tags = {"菠菜侠旅游租赁平台-系统管理-管理员信息交互接口"})
@RestController("adminController")
@RequestMapping("/system/admin")
public class AdminController extends BaseController {
	@Autowired
	private AdminTransport transport;

	/**
	 * <b>根据查询视图进行列表查询</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "根据查询视图进行列表查询", protocols = "application/json", httpMethod = "POST")
	@ApiParam(value = "查询视图", type = "AdminVO", required = true)
	@ApiResponse(code = 200, message = "系统响应视图")
	@PostMapping("/list")
	public ResponseVO queryList(@RequestBody AdminVO queryVO) throws Exception {
		return ResponseVO.success(transport.getList(queryVO));
	}

	/**
	 * <b>根据主键查询对象</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "根据主键查询对象", httpMethod = "GET")
	@ApiResponse(code = 200, message = "系统响应视图")
	@PostMapping("/id/{id}")
	public ResponseVO queryById(@PathVariable("id") String id) throws Exception {
		// 封装查询对象
		AdminVO queryVO = new AdminVO();
		queryVO.setId(id);
		// 查询列表
		List<AdminVO> voList = transport.getList(queryVO);
		if (voList != null && !voList.isEmpty()) {
			return ResponseVO.success(voList.get(0));
		}
		return ResponseVO.success(new AdminVO());
	}

	/**
	 * <b>根据电话号码查询对象</b>
	 * @param cellphone
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "根据编码查询对象", httpMethod = "GET")
	@ApiResponse(code = 200, message = "系统响应视图")
	@PostMapping("/cellphone/{cellphone}")
	public ResponseVO queryByCellphone(@PathVariable("cellphone") String cellphone) throws Exception {
		// 封装查询对象
		AdminVO queryVO = new AdminVO();
		queryVO.setCellphone(cellphone);
		// 查询列表
		List<AdminVO> voList = transport.getList(queryVO);
		if (voList != null && !voList.isEmpty()) {
			return ResponseVO.success(voList.get(0));
		}
		return ResponseVO.success(new AdminVO());
	}

	/**
	 * <b>根据身份证号查询对象</b>
	 * @param idCard
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "根据编码查询对象", httpMethod = "GET")
	@ApiResponse(code = 200, message = "系统响应视图")
	@PostMapping("/idCard/{idCard}")
	public ResponseVO queryByIdCard(@PathVariable("idCard") String idCard) throws Exception {
		// 封装查询对象
		AdminVO queryVO = new AdminVO();
		queryVO.setIdCard(idCard);
		// 查询列表
		List<AdminVO> voList = transport.getList(queryVO);
		if (voList != null && !voList.isEmpty()) {
			return ResponseVO.success(voList.get(0));
		}
		return ResponseVO.success(new AdminVO());
	}

	/**
	 * <b>保存对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "保存对象", protocols = "application/json", httpMethod = "POST")
	@ApiParam(value = "保存视图", type = "AdminVO", required = true)
	@ApiResponse(code = 200, message = "系统响应视图")
	@PostMapping("/save")
	public ResponseVO save(@RequestBody AdminVO vo) throws Exception {
		// 信息是否有效
		if (vo.getCellphone() != null && !"".equals(vo.getCellphone().trim())
				&& vo.getIdCard() != null && !"".equals(vo.getIdCard().trim())) {
			// 查询手机号码信息
			AdminVO queryVO = new AdminVO();
			queryVO.setCellphone(vo.getCellphone());
			List<AdminVO> list1 = transport.getList(queryVO);
			// 查询身份证号信息
			queryVO.setCellphone(null);
			queryVO.setIdCard(vo.getIdCard());
			List<AdminVO> list2 = transport.getList(queryVO);
			if ((list1 == null || list1.isEmpty()) && (list2 == null || list2.isEmpty())) {
				// MD5加密
				String password = MD5EncryptUtil.encrypt(vo.getPassword());
				vo.setPassword(password);
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
	@ApiParam(value = "修改视图", type = "AdminVO", required = true)
	@ApiResponse(code = 200, message = "系统响应视图")
	@PostMapping("/update")
	public ResponseVO update(@RequestBody AdminVO vo) throws Exception {
		// 信息是否有效
		if (vo.getCellphone() == null || "".equals(vo.getCellphone().trim())
			|| (vo.getIdCard() == null || "".equals(vo.getIdCard().trim()))) {
			return ResponseVO.failure("请填写有效的信息");
		}
		// 查询电话号码信息
		AdminVO queryVO = new AdminVO();
		queryVO.setCellphone(vo.getCellphone());
		List<AdminVO> list1 = transport.getList(queryVO);
		// 查询身份证号信息
		queryVO.setCellphone(null);
		queryVO.setIdCard(vo.getIdCard());
		List<AdminVO> list2 = transport.getList(queryVO);
		if (list1 != null && !list1.isEmpty() && list1.get(0).getId().equals(vo.getId())) {
			return ResponseVO.failure("该信息已存在");
		}
		if (list2 != null && !list2.isEmpty() && list2.get(0).getId().equals(vo.getId())) {
			return ResponseVO.failure("该信息已存在");
		}

		if (transport.update(vo)) {
			return ResponseVO.success("保存成功");
		} else {
			return ResponseVO.failure("保存失败");
		}
	}
}
