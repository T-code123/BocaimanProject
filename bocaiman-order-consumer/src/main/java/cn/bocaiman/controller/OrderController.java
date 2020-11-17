package cn.bocaiman.controller;

import cn.bocaiman.base.controller.BaseController;
import cn.bocaiman.base.pojo.vo.ResponseVO;
import cn.bocaiman.pojo.bus.vo.BusVO;
import cn.bocaiman.pojo.order.entity.Order;
import cn.bocaiman.pojo.order.vo.OrderVO;
import cn.bocaiman.pojo.system.vo.DriverVO;
import cn.bocaiman.transport.bus.BusTransport;
import cn.bocaiman.transport.order.OrderTransport;
import cn.bocaiman.transport.system.DriverTransport;
import cn.bocaiman.util.OrderNoGeneator;
import cn.bocaiman.util.enums.BusStatusEnum;
import cn.bocaiman.util.enums.DriverStatusEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-订单管理-订单控制器</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@Api(value = "菠菜侠旅游租赁平台-订单管理-订单控制器", tags = "菠菜侠旅游租赁平台-订单管理-订单交互接口")
@RestController("orderController")
@RequestMapping("/order")
public class OrderController extends BaseController {
	@Autowired
	private OrderTransport ordertransport;
	@Autowired
	private BusTransport busTransport;
	@Autowired
	private DriverTransport driverTransport;
	@Autowired
	private OrderNoGeneator orderNoGeneator;
	/**
	 * <b>下单流程:
	 *      <p>
	 *          1、根据车辆的座位数、类别、品牌和车辆状态查询是否有可用车辆；
	 *          2、是，则发现有可用车辆，修改车辆状态为可用；否，返回无可用车辆；
	 *          3、通过司机状态判断是否有可用司机；
	 *          4、是，修改司机状态已出车；否，返回无可用司机；
	 *          5、保存信息，完成下单；
	 *          6、将订单编号返回给前端。
	 *      </p>
	 * </b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "下单", httpMethod = "POST")
	@ApiImplicitParam(value = "查询视图",dataTypeClass = OrderVO.class,required = true)
	@ApiResponse(code = 200, message = "系统响应视图")
	@PostMapping("/create")
	public ResponseVO createOrder(@RequestBody OrderVO vo) throws Exception {

		// 根据用户所选择的座位数、类别和品牌查询可用车辆
		BusVO busVO = new BusVO();
		busVO.setId(vo.getId());
//		busVO.setSeat(vo.getId());
//		busVO.setCategory(vo.getId());
//		busVO.setBrand(vo.getId());
		busVO.setBusStatusText(BusStatusEnum.BUS_STATUS_ENABLE.getRemark());
		// 如果可用则直接将车辆进行锁定操作,否则修改车辆状态为可用
		busVO.setBusStatusCode(BusStatusEnum.BUS_STATUS_ENABLE.getCode());
		List<BusVO> voList = busTransport.getByList(busVO);
		if (voList != null && !voList.isEmpty()) {
			BusVO busVO1 = voList.get(0);
			// 修改车辆状态为出车
			busVO1.setBusStatusCode(BusStatusEnum.BUS_STATUS_DISPATCH.getCode());
			if(busTransport.save(busVO1)) {
				// 根据司机状态进行同步匹配具体的司机信息，并且进行修改
				DriverVO driverVO = new DriverVO();
				// 修改司机状态为可用
				driverVO.setDriverStatusCode(DriverStatusEnum.DRIVER_STATUS_AVAILABLE.getCode());
				List<DriverVO> driverVOList = driverTransport.getList(driverVO);
//				System.out.println( "driverVO =" + driverVO);
//				System.out.println( "driverVOList =" + driverVOList);
				if (driverVOList != null && !driverVOList.isEmpty()) {
					DriverVO driverVO1 = driverVOList.get(0);
					// 修改司机状态为出车
					driverVO1.setDriverStatusCode(DriverStatusEnum.DRIVER_STATUS_DISPATCH.getCode());
					// 保存司机对象
					if (driverTransport.save(driverVO1)) {
						// 保存订单信息
						vo.setOrderNo(orderNoGeneator.nextNo());
						if (vo.getOrderNo() != null && !"".equals(vo.getOrderNo())) {
							if (ordertransport.save(vo)) {
								// 下单成功后，将订单信息返回给前端页面
								return ResponseVO.success(vo.getOrderNo());
							}
						}
						return ResponseVO.failure("保存失败");
					}
					return ResponseVO.failure("保存司机信息失败");
				}
				return ResponseVO.failure("无可用司机");
			}
			return ResponseVO.failure("修改司机状态失败");
		}
		return ResponseVO.failure("不存在可用车辆");

		// 车辆确定，则该车辆的日租金都可以进行确定，通过时间分别计算相应金额
		// 否则产生提示信息，或者返回 null 提示无车辆可用

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
	public ResponseVO getOrderByOrderNo(@PathVariable("orderNo") String orderNo) throws Exception {
		Order order = ordertransport.getOrderByOrderNo(orderNo);
		return ResponseVO.success(order);
	}
}
