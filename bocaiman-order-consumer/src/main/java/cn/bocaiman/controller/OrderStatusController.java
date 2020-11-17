package cn.bocaiman.controller;

import cn.bocaiman.base.controller.BaseController;
import cn.bocaiman.base.pojo.vo.PageVO;
import cn.bocaiman.base.pojo.vo.QueryParamVO;
import cn.bocaiman.base.pojo.vo.ResponseVO;
import cn.bocaiman.pojo.order.vo.OrderStatusVO;
import cn.bocaiman.transport.order.OrderStatusTransport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-订单管理-订单状态控制器</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@Api(value = "菠菜侠旅游租赁平台-订单管理-订单状态控制器", tags = {"菠菜侠旅游租赁平台-订单管理-订单状态交互接口"})
@RestController("orderStatusController")
@RequestMapping("/order/orderstatus")
public class OrderStatusController extends BaseController {
	@Autowired
	private OrderStatusTransport transport;

	/**
	 * <b>根据查询视图和分页信息进行分页查询</b>
	 * @param pageNum
	 * @param pageSize
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "根据查询视图和分页信息进行分页查询", protocols = "application/json", httpMethod = "POST")
	@ApiImplicitParam(value = "查询视图", dataType = "OrderStatusVO", required = true)
	@ApiResponse(code = 200, message = "系统响应视图")
	@PostMapping("/page/{pageNum}/{pageSize}")
	public ResponseVO queryByPage(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize,
	                              @RequestBody OrderStatusVO queryVO) throws Exception {
		// 根据 pageNum 和 pageSize 创建 PageVO 对象
		PageVO<OrderStatusVO> pageVO = new PageVO<OrderStatusVO>(pageNum,pageSize);
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
	@ApiImplicitParam(value = "查询视图", dataType = "OrderStatusVO", required = true)
	@ApiResponse(code = 200, message = "系统响应视图")
	@PostMapping("/list")
	public ResponseVO queryList(@RequestBody OrderStatusVO queryVO) throws Exception {
		return ResponseVO.success(transport.getByList(queryVO));
	}

	/**
	 * <b>根据编码查询对象</b>
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "根据主键查询对象", httpMethod = "GET")
	@ApiResponse(code = 200, message = "系统响应视图")
	@PostMapping("/code/{code}")
	public ResponseVO queryByCode(@PathVariable("code") String code) throws Exception {
		// 封装查询对象
		OrderStatusVO queryVO = new OrderStatusVO();
		queryVO.setCode(code);
		// 查询列表
		List<OrderStatusVO> voList = transport.getByList(queryVO);
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
		OrderStatusVO queryVO = new OrderStatusVO();
		queryVO.setId(id);
		// 查询列表
		List<OrderStatusVO> voList = transport.getByList(queryVO);
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
	@ApiImplicitParam(value = "保存对象视图", dataType = "OrderStatusVO", required = true)
	@ApiResponse(code = 200, message = "系统响应视图")
	@PostMapping("/save")
	public ResponseVO save(@RequestBody OrderStatusVO vo) throws Exception {
		// 信息是否有效
		if (vo.getText() != null && !"".equals(vo.getText().trim()) && vo.getCode() != null
				&& !"".equals(vo.getCode().trim())) {
			// 查询文本信息
			OrderStatusVO queryVO = new OrderStatusVO();
			queryVO.setText(vo.getText());
			List<OrderStatusVO> list = transport.getByList(queryVO);
			// 查询编码信息
			queryVO.setText(null);
			queryVO.setCode(vo.getCode());
			List<OrderStatusVO> list1 = transport.getByList(queryVO);
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
	@ApiImplicitParam(value = "修改对象视图", dataType = "OrderStatusVO", required = true)
	@ApiResponse(code = 200, message = "系统响应视图")
	@PostMapping("/update")
	public ResponseVO update(@RequestBody OrderStatusVO vo) throws Exception {
		// 信息是否有效
		if (vo.getText() == null || "".equals(vo.getText().trim()) || vo.getCode() == null
				|| "".equals(vo.getCode().trim())) {
			return ResponseVO.failure("请填写有效信息");
		}
		// 查询文本信息
		OrderStatusVO queryVO = new OrderStatusVO();
		queryVO.setText(vo.getText());
		List<OrderStatusVO> list = transport.getByList(queryVO);
		// 查询编码信息
		queryVO.setText(null);
		queryVO.setCode(vo.getCode());
		List<OrderStatusVO> list1 = transport.getByList(queryVO);
		if (list != null || !list.isEmpty() && list.get(0).getId().equals(vo.getId())) {
			return ResponseVO.success("该信息已存在");
		}
		if (list1 != null || !list1.isEmpty() && list1.get(0).getId().equals(vo.getId())) {
			return ResponseVO.success("该信息已存在");
		}

		if (transport.update(vo)) {
			return ResponseVO.success("保存成功");
		} else {
			return ResponseVO.failure("保存失败");
		}
	}
}
