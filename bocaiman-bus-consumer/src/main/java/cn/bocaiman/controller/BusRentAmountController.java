package cn.bocaiman.controller;

import cn.bocaiman.base.controller.BaseController;
import cn.bocaiman.base.pojo.vo.PageVO;
import cn.bocaiman.base.pojo.vo.QueryParamVO;
import cn.bocaiman.base.pojo.vo.ResponseVO;
import cn.bocaiman.pojo.bus.vo.BusRentAmountVO;
import cn.bocaiman.pojo.bus.vo.BusVO;
import cn.bocaiman.transport.bus.BusRentAmountTransport;
import cn.bocaiman.util.enums.BusStatusEnum;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-车辆管理-大巴车日租金控制器</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@Api(value = "菠菜侠旅游租赁平台-车辆管理-大巴车日租金控制器", tags = {"菠菜侠旅游租赁平台-车辆管理-大巴车日租金交互接口"})
@RestController("busRentAmountController")
@RequestMapping("/bus/rentamount")
public class BusRentAmountController extends BaseController {
	@Autowired
	private BusRentAmountTransport transport;

	/**
	 * <b>根据查询视图和分页信息进行分页查询</b>
	 * @param pageNum
	 * @param pageSize
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "根据查询视图和分页信息进行分页查询", protocols = "application/json", httpMethod = "POST")
	@ApiParam(value = "查询视图", type = "BusRentAmountVO", required = true)
	@ApiResponse(code = 200, message = "系统响应视图")
	@PostMapping("/page/{pageNum}/{pageSize}")
	public ResponseVO queryByPage(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize,
	                              @RequestBody BusRentAmountVO queryVO) throws Exception {
		// 根据 pageNum 和 pageSize 创建 PageVO 对象
		PageVO<BusRentAmountVO> pageVO = new PageVO<BusRentAmountVO>(pageNum,pageSize);
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
	@ApiParam(value = "查询视图", type = "BusRentAmountVO", required = true)
	@ApiResponse(code = 200, message = "系统响应视图")
	@PostMapping("/list")
	public ResponseVO queryList(@RequestBody BusRentAmountVO queryVO) throws Exception {
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
		BusRentAmountVO queryVO = new BusRentAmountVO();
		queryVO.setId(id);
		// 查询列表
		List<BusRentAmountVO> voList = transport.getList(queryVO);
		if (voList != null && !voList.isEmpty()) {
			return ResponseVO.success(voList.get(0));
		}
		return ResponseVO.success(new BusRentAmountVO());
	}

	/**
	 * <b>保存对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "保存对象", protocols = "application/json", httpMethod = "POST")
	@ApiParam(value = "保存视图", type = "BusRentAmountVO", required = true)
	@ApiResponse(code = 200, message = "系统响应视图")
	@PostMapping("/save")
	public ResponseVO save(@RequestBody BusRentAmountVO vo) throws Exception {
		// 信息是否有效
		if (vo.getDailyAmount() != null && vo.getDailyAmount().doubleValue() >0) {
			// 查询文本信息
			BusRentAmountVO queryVO = new BusRentAmountVO();
			queryVO.setSeatId(vo.getSeatId());
			queryVO.setCategoryId(vo.getCategoryId());
			queryVO.setBrandId(vo.getBrandId());

			List<BusRentAmountVO> list = transport.getList(queryVO);
			if ((list == null || list.isEmpty())) {
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
	@ApiParam(value = "修改视图", type = "BusRentAmountVO", required = true)
	@ApiResponse(code = 200, message = "系统响应视图")
	@PostMapping("/update")
	public ResponseVO update(@RequestBody BusRentAmountVO vo) throws Exception {
		// 信息是否有效
		if (vo.getDailyAmount() == null || vo.getDailyAmount().doubleValue() <= 0) {
			return ResponseVO.failure("请填写有效的信息");
		}
		// 查询文本信息
		BusRentAmountVO queryVO = new BusRentAmountVO();
		queryVO.setSeatId(vo.getSeatId());
		queryVO.setCategoryId(vo.getCategoryId());
		queryVO.setBrandId(vo.getBrandId());
		List<BusRentAmountVO> list = transport.getList(queryVO);
		if (list != null && list.size() > 1) {
			return ResponseVO.failure("该信息已存在");
		}

		if (transport.update(vo)) {
			return ResponseVO.success("保存成功");
		} else {
			return ResponseVO.failure("保存失败");
		}
	}


	/**
	 * <b>根据座位数、类别和品牌查询具体的日租金信息</b>
	 * @param seatId
	 * @param categoryId
	 * @param brandId
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "根据座位数、类别和品牌查询是否有可用车辆", httpMethod = "POST", protocols = "application/json")
	@ApiImplicitParam(value = "查询视图",dataTypeClass = BusVO.class, required = true)
	@ApiResponses({
			@ApiResponse(code = 200, message = "系统响应视图"),
			@ApiResponse(code = 500, message = "系统响应异常")
	})
	@PostMapping("/{seat}/{category}/{brand}")
	public ResponseVO queryBusRentAmountByBusDic(@PathVariable("seatId") String seatId, @PathVariable("categoryId") String categoryId,
	                                        @PathVariable("brandId") String brandId) throws Exception {
		// 根据查询条件封装查询视图
		BusRentAmountVO queryVO = new BusRentAmountVO();
		queryVO.setSeatId(seatId);
		queryVO.setCategoryId(categoryId);
		queryVO.setBrandId(brandId);

		// 进行信息查询
		List<BusRentAmountVO> voList = transport.getList(queryVO);
		if (voList != null && !voList.isEmpty()) {
			// 此时存在可用车辆
			return ResponseVO.success(voList.get(0));
		}
		return ResponseVO.failure("不存在可用车辆");
	}
}
