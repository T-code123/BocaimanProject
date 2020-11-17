package cn.bocaiman.controller;

import cn.bocaiman.base.controller.BaseController;
import cn.bocaiman.base.pojo.vo.PageVO;
import cn.bocaiman.base.pojo.vo.QueryParamVO;
import cn.bocaiman.base.pojo.vo.ResponseVO;
import cn.bocaiman.pojo.agency.vo.TravelAgencyVO;
import cn.bocaiman.transport.agency.TravelAgencyTransport;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * <b>菠菜侠旅游租赁平台-旅行社管理-旅行社信息控制器</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@Api(value = "菠菜侠旅游租赁平台-旅行社管理-旅行社信息控制器", tags = {"菠菜侠旅游租赁平台-旅行社管理-旅行社信息交互接口"})
@RestController("travelAgencyController")
@RequestMapping("/agency")
public class TravelAgencyController extends BaseController {
	@Autowired
	private TravelAgencyTransport transport;

	/**
	 * <b>使用手机号码和登录密码进行登录</b>
	 * @param cellphone
	 * @param password
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "用户登录", httpMethod = "POST")
	@ApiParam(value = "手机号码，登录密码", type = "String", required = true)
	@ApiResponse(code = 200, message = "系统响应视图")
	@PostMapping("/login")
	public ResponseVO login(@RequestParam String cellphone, @RequestParam String password) throws Exception {
		// 校验用户所提交的信息是否有效
		if (cellphone != null && !"".equals(cellphone.trim())
				&& password != null && !"".equals(password.trim())) {
			//password = MD5EncryptUtil.encrypt(password);
			// 通过用户相关信息进行数据库查询，如果认证成功，则返回生成的 Token 信息
			String token = transport.login(cellphone, password);
			if (token != null) {
				// 用户登录成功，将生成的 Token 使用 response 对象写入到用户的消息头中
				response.setHeader("token", token);
				return ResponseVO.success("登录成功,token=" +token);
			}
			return ResponseVO.failure("登录失败");
		}
		return ResponseVO.failure("请填写有效登录信息");
	}

	/**
	 * <b>根据查询视图和分页信息进行分页查询</b>
	 * @param pageNum
	 * @param pageSize
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "根据查询视图和分页信息进行分页查询", protocols = "application/json", httpMethod = "POST")
	@ApiParam(value = "查询视图", type = "TravelAgencyVO", required = true)
	@ApiResponse(code = 200, message = "系统响应视图")
	@PostMapping("/page/{pageNum}/{pageSize}")
	public ResponseVO queryByPage(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize,
	                              @RequestBody TravelAgencyVO queryVO) throws Exception {
		// 根据 pageNum 和 pageSize 创建 PageVO 对象
		PageVO<TravelAgencyVO> pageVO = new PageVO<TravelAgencyVO>(pageNum, pageSize);
		// 进行分页查询，获得分页查询对象
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
	@ApiParam(value = "查询视图", type = "TravelAgencyVO", required = true)
	@ApiResponse(code = 200, message = "系统响应视图")
	@PostMapping("/list")
	public ResponseVO queryList(@RequestBody TravelAgencyVO queryVO) throws Exception {
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
		TravelAgencyVO queryVO = new TravelAgencyVO();
		queryVO.setId(id);
		// 查询列表
		List<TravelAgencyVO> voList = transport.getList(queryVO);
		if (voList != null && !voList.isEmpty()) {
			return ResponseVO.success(voList.get(0));
		}
		return ResponseVO.success(new TravelAgencyVO());
	}

	/**
	 * <b>保存对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "保存对象", protocols = "application/json", httpMethod = "POST")
	@ApiParam(value = "保存视图", type = "TravelAgencyVO", required = true)
	@ApiResponse(code = 200, message = "系统响应视图")
	@PostMapping("/save")
	public ResponseVO save(@RequestBody TravelAgencyVO vo) throws Exception {
		// 信息是否有效
		if (vo.getName() != null && !"".equals(vo.getName().trim())
				&& vo.getCellphone() != null && !"".equals(vo.getCellphone().trim()) ) {
			TravelAgencyVO queryVO = new TravelAgencyVO();
			queryVO.setName(vo.getName());
			List<TravelAgencyVO> voList1 = transport.getList(queryVO);
			queryVO.setName(null);
			queryVO.setCellphone(vo.getCellphone());
			List<TravelAgencyVO> voList2 = transport.getList(queryVO);
			if ((voList1 == null || voList1.isEmpty()) && (voList2 == null || voList2.isEmpty())) {
				if (transport.save(vo)) {
					return ResponseVO.success("保存成功");
				}
				return ResponseVO.failure("保存失败");
			}
			return ResponseVO.failure("该信息已存在");
		}
		return ResponseVO.failure("请填写有效的信息");
	}

	/**
	 * <b>修改对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "修改对象", protocols = "application/json", httpMethod = "POST")
	@ApiParam(value = "修改视图", type = "TravelAgencyVO", required = true)
	@ApiResponse(code = 200, message = "系统响应视图")
	@PostMapping("/update")
	public ResponseVO update(@RequestBody TravelAgencyVO vo) throws Exception {
		// 信息是否有效
		if (vo.getName() == null || "".equals(vo.getName().trim())
			|| vo.getCellphone() == null || "".equals(vo.getCellphone().trim())) {
			return ResponseVO.failure("请填写有效的信息");
		}
		// 查询文本信息
		TravelAgencyVO queryVO = new TravelAgencyVO();
		queryVO.setName(vo.getName());
		List<TravelAgencyVO> list1 = transport.getList(queryVO);
		queryVO.setName(null);
		queryVO.setCellphone(vo.getCellphone());
		List<TravelAgencyVO> list2 = transport.getList(queryVO);
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
