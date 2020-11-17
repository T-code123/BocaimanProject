package cn.bocaiman.controller;

import cn.bocaiman.base.controller.BaseController;
import cn.bocaiman.base.pojo.entity.BaseEntity;
import cn.bocaiman.base.pojo.vo.ResponseVO;
import cn.bocaiman.pojo.agency.vo.LinkmanVO;
import cn.bocaiman.pojo.agency.vo.LinkmanVO;
import cn.bocaiman.pojo.order.vo.OrderStatusVO;
import cn.bocaiman.pojo.system.vo.AdminVO;
import cn.bocaiman.transport.agency.LinkmanTransport;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-旅行社管理-常用联系人控制器</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@Api(value = "菠菜侠旅游租赁平台-旅行社管理-常用联系人控制器", tags = {"菠菜侠旅游租赁平台-旅行社管理-常用联系人交互接口"})
@RestController("linkmanController")
@RequestMapping("/travelagency/linkman")
public class LinkmanController extends BaseController {
	@Autowired
	private LinkmanTransport transport;

	/**
	 * <b>根据查询视图进行列表查询</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "根据查询视图进行列表查询", protocols = "application/json", httpMethod = "POST")
	@ApiImplicitParam(value = "查询视图", dataType = "LinkmanVO", required = true)
	@ApiResponse(code = 200, message = "系统响应视图")
	@PostMapping("/list")
	public ResponseVO queryList(@RequestBody LinkmanVO queryVO) throws Exception {
		return ResponseVO.success(transport.getByList(queryVO));
	}

	/**
	 * <b>根据编码查询对象</b>
	 * @param idCard
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "根据主键查询对象", httpMethod = "GET")
	@ApiResponse(code = 200, message = "系统响应视图")
	@PostMapping("/idCard/{idCard}")
	public ResponseVO queryByOrderNo(@PathVariable("idCard") String idCard) throws Exception {
		// 封装查询对象
		LinkmanVO queryVO = new LinkmanVO();
		queryVO.setIdCard(idCard);
		// 查询列表
		List<LinkmanVO> voList = transport.getByList(queryVO);
		if (voList != null && !voList.isEmpty()) {
			return ResponseVO.success(voList.get(0));
		}
		return ResponseVO.success(new OrderStatusVO());
	}

	/**
	 * <b>根据主键查询对象</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "根据编码查询对象", protocols = "application/json", httpMethod = "GET")
	@ApiResponse(code = 200, message = "系统响应视图")
	@PostMapping("/id/{id}")
	public ResponseVO queryById(@PathVariable("id") String id) throws Exception {
		// 封装查询对象
		LinkmanVO queryVO = new LinkmanVO();
		queryVO.setId(id);
		// 查询列表
		List<LinkmanVO> voList = transport.getByList(queryVO);
		if (voList != null && !voList.isEmpty()) {
			return ResponseVO.success(voList.get(0));
		}
		return ResponseVO.success(new OrderStatusVO());
	}

	/**
	 * <b>保存对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "保存对象", protocols = "application/json", httpMethod = "POST")
	@ApiParam(value = "保存视图", type = "LinkmanVO", required = true)
	@ApiResponse(code = 200, message = "系统响应视图")
	@PostMapping("/save")
	public ResponseVO save(@RequestBody LinkmanVO vo) throws Exception {
		// 信息是否有效
		if (vo.getCellphone() != null && !"".equals(vo.getCellphone().trim())
				&& vo.getIdCard() != null && !"".equals(vo.getIdCard().trim())) {
			// 查询手机号码信息
			LinkmanVO queryVO = new LinkmanVO();
			queryVO.setCellphone(vo.getCellphone());
			List<LinkmanVO> list1 = transport.getByList(queryVO);
			// 查询身份证号码信息
			queryVO.setCellphone(null);
			queryVO.setIdCard(vo.getIdCard());
			List<LinkmanVO> list2 = transport.getByList(queryVO);
			if ((list1 == null || list1.isEmpty()) && (list2 ==null || list2.isEmpty())) {
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
	@ApiOperation(value = "保存对象", protocols = "application/json", httpMethod = "POST")
	@ApiParam(value = "保存视图", type = "LinkmanVO", required = true)
	@ApiResponse(code = 200, message = "系统响应视图")
	@PostMapping("/update")
	public ResponseVO update(@RequestBody LinkmanVO vo) throws Exception {
		// 信息是否有效
		if (vo.getCellphone() == null || "".equals(vo.getCellphone().trim())
				|| vo.getIdCard() != null && !"".equals(vo.getIdCard().trim())) {
			return ResponseVO.failure("请填写有效信息");
		}
		// 查询手机号码信息
		LinkmanVO queryVO = new LinkmanVO();
		queryVO.setCellphone(vo.getCellphone());
		List<LinkmanVO> list1 = transport.getByList(queryVO);
		// 查询身份证号码信息
		queryVO.setCellphone(null);
		queryVO.setIdCard(vo.getIdCard());
		List<LinkmanVO> list2 = transport.getByList(queryVO);
		if (list1 != null || !list1.isEmpty() && list1.get(0).getId().equals(vo.getId())) {
			return ResponseVO.success("该信息已存在");
		}
		if (list2 != null || !list2.isEmpty() && list2.get(0).getId().equals(vo.getId())) {
			return ResponseVO.success("该信息已存在");
		}

		if (transport.save(vo)) {
			return ResponseVO.success("保存成功");
		}
			return ResponseVO.failure("保存失败");
		}

}
