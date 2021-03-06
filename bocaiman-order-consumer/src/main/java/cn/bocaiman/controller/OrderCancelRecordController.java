package cn.bocaiman.controller;

import cn.bocaiman.base.controller.BaseController;
import cn.bocaiman.base.pojo.vo.ResponseVO;
import cn.bocaiman.pojo.order.vo.OrderCancelRecordVO;
import cn.bocaiman.pojo.order.vo.OrderStatusVO;
import cn.bocaiman.transport.order.OrderCancelRecordTransport;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-订单管理-订单取消控制器</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@Api(value = "菠菜侠旅游租赁平台-订单管理-订单取消控制器", tags = "菠菜侠旅游租赁平台-订单管理-订单取消交互接口")
@RestController("orderCancelRecordController")
@RequestMapping("/order/cancel")
public class OrderCancelRecordController extends BaseController {
	@Autowired
	private OrderCancelRecordTransport transport;

	/**
	 * <b>根据查询视图进行列表查询</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "根据查询视图进行列表查询", protocols = "application/json", httpMethod = "POST")
	@ApiImplicitParam(value = "查询视图", dataType = "OrderCancelRecordVO", required = true)
	@ApiResponse(code = 200, message = "系统响应视图")
	@PostMapping("/list")
	public ResponseVO queryList(@RequestBody OrderCancelRecordVO queryVO) throws Exception {
		return ResponseVO.success(transport.getByList(queryVO));
	}

	/**
	 * <b>根据编码查询对象</b>
	 * @param orderNo
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "根据主键查询对象", httpMethod = "GET")
	@ApiResponse(code = 200, message = "系统响应视图")
	@PostMapping("/orderNo/{orderNo}")
	public ResponseVO queryByOrderNo(@PathVariable("orderNo") String orderNo) throws Exception {
		// 封装查询对象
		OrderCancelRecordVO queryVO = new OrderCancelRecordVO();
		queryVO.setOrderNo(orderNo);
		// 查询列表
		List<OrderCancelRecordVO> voList = transport.getByList(queryVO);
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
		OrderCancelRecordVO queryVO = new OrderCancelRecordVO();
		queryVO.setId(id);
		// 查询列表
		List<OrderCancelRecordVO> voList = transport.getByList(queryVO);
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
	@ApiParam(value = "保存视图", type = "OrderCancelRecordVO", required = true)
	@ApiResponse(code = 200, message = "系统响应视图")
	@PostMapping("/save")
	public ResponseVO save(@RequestBody OrderCancelRecordVO vo) throws Exception {
		// 信息是否有效
		if (vo.getOrderNo() != null && !"".equals(vo.getOrderNo().trim()) && vo.getAuditStatus() != null
				&& !"".equals(vo.getAuditStatus().trim())) {
			// 查询订单编号信息
			OrderCancelRecordVO queryVO = new OrderCancelRecordVO();
			queryVO.setOrderNo(vo.getOrderNo());
			List<OrderCancelRecordVO> list = transport.getByList(queryVO);
			// 查询审核状态信息
			queryVO.setOrderNo(null);
			queryVO.setAuditStatus(vo.getAuditStatusId());
			List<OrderCancelRecordVO> list1 = transport.getByList(queryVO);
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
}
