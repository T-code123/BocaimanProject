package cn.bocaiman.controller;

import cn.bocaiman.base.controller.BaseController;
import cn.bocaiman.base.pojo.vo.PageVO;
import cn.bocaiman.base.pojo.vo.QueryParamVO;
import cn.bocaiman.base.pojo.vo.ResponseVO;
import cn.bocaiman.pojo.bus.entity.BusDic;
import cn.bocaiman.pojo.bus.vo.BusDicVO;
import cn.bocaiman.pojo.bus.vo.BusVO;
import cn.bocaiman.transport.bus.BusTransport;
import cn.bocaiman.util.enums.BusStatusEnum;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-车辆管理-车辆控制器</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@Api(value = "菠菜侠旅游租赁平台-车辆管理-车辆控制器", tags = "菠菜侠旅游租赁平台-车辆管理-车辆交互接口")
@RestController("busController")
@RequestMapping("/bus")
public class BusController extends BaseController {
	@Autowired
	private BusTransport transport;

	/**
	 * <b>根据座位数、类别和品牌查询是否有可用车辆</b>
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
	@PostMapping("/enable/{seat}/{category}/{brand}")
	public ResponseVO queryEnableBusByQuery(@PathVariable("seatId") String seatId, @PathVariable("categoryId") String categoryId,
	                                        @PathVariable("brandId") String brandId) throws Exception {
		// 根据查询条件封装查询视图
		BusVO queryVO = new BusVO();
		queryVO.setSeatId(seatId);
		queryVO.setCategoryId(categoryId);
		queryVO.setBrandId(brandId);
		// 设定车辆状态可使用
		queryVO.setBusStatusCode(BusStatusEnum.BUS_STATUS_ENABLE.getCode());
		// 进行信息查询
		List<BusVO> voList = transport.getByList(queryVO);
		if (voList != null && !voList.isEmpty()) {
			// 此时存在可用车辆
			return ResponseVO.success(voList);
		}
		return ResponseVO.failure("不存在可用车辆");
	}

	/**
	 * <b>根据条件进行分页查询</b>
	 * @param pageNum
	 * @param pageSize
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "根据条件进行分页查询", httpMethod = "POST", protocols = "application/json")
	@ApiImplicitParam(value = "查询视图",dataTypeClass = BusVO.class, required = true)
	@ApiResponses({
			@ApiResponse(code = 200, message = "系统响应视图"),
			@ApiResponse(code = 500, message = "系统响应异常")
	})
	@PostMapping("/page/{pageNum}/{pageSize}")
	public ResponseVO queryByPage(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize,
	                              @RequestBody BusVO queryVO) throws Exception {
		// 根据分页信息创建分页查询视图
		PageVO<BusVO> pageVO = new PageVO<BusVO>(pageNum, pageSize);
		// 将pageVO 和 queryVO 放入 QueryParamVO中
		QueryParamVO queryParamVO = new QueryParamVO(pageVO, queryVO);
		pageVO = transport.getByPage(queryParamVO);

		return ResponseVO.success(pageVO);
	}


	/**
	 * <b>根据主键获得列表</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "根据主键获得列表", httpMethod = "GET", protocols = "application/json")
	@ApiResponses({
			@ApiResponse(code = 200, message = "系统响应视图"),
			@ApiResponse(code = 500, message = "系统响应异常")
	})
	@GetMapping("/id/{id}")
	public ResponseVO queryById(@PathVariable("id") String id) throws Exception {
		// 通过 id 创建查询视图
		BusVO queryVO = new BusVO();
		queryVO.setId(id);
		// 进行列表查询
		List<BusVO> list = transport.getByList(queryVO);
		if (list != null && !list.isEmpty()) {
			return ResponseVO.success(list.get(0));
		}
		return ResponseVO.failure("未查到相应信息");
	}

	/**
	 * <b>根据查询视图进行列表查询</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "根据查询视图进行列表查询", protocols = "application/json", httpMethod = "POST")
	@ApiParam(value = "查询视图", type = "BusDicVO", required = true)
	@ApiResponse(code = 200, message = "系统响应视图")
	@PostMapping("/list")
	public ResponseVO queryList(@RequestBody BusVO queryVO) throws Exception {
		return ResponseVO.success(transport.getByList(queryVO));
	}

	/**
	 * <b>保存对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "保存对象", httpMethod = "POST", protocols = "application/json")
	@ApiImplicitParam(value = "对象视图",dataTypeClass = BusVO.class, required = true)
	@ApiResponses({
			@ApiResponse(code = 200, message = "系统响应视图"),
			@ApiResponse(code = 500, message = "系统响应异常")
	})
	@PostMapping("/save")
	public ResponseVO save(@RequestBody BusVO vo) throws Exception {
		if (vo.getNo() != null && !"".equals(vo.getNo().trim())) {
			// 校验车牌号码不能重复
			BusVO queryVO = new BusVO();
			queryVO.setNo(vo.getNo());
			List<BusVO> voList = transport.getByList(queryVO);
			if (voList == null || voList.isEmpty()) {
				if (transport.save(vo)) {
					return ResponseVO.success("车辆添加成功");
				} else {
					return ResponseVO.failure("车辆添加失败");
				}
			} else {
				return ResponseVO.failure("该车辆已添加");
			}
		} else {
			return ResponseVO.failure("请填写有效信息");
		}
	}

	/**
	 * <b>修改对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "修改对象", httpMethod = "POST", protocols = "application/json")
	@ApiImplicitParam(value = "对象视图",dataTypeClass = BusVO.class, required = true)
	@ApiResponses({
			@ApiResponse(code = 200, message = "系统响应视图"),
			@ApiResponse(code = 500, message = "系统响应异常")
	})
	@PostMapping("/update")
	public ResponseVO update(@RequestBody BusVO vo) throws Exception {
		// 校验车牌号码不能重复
		BusVO queryVO = new BusVO();
		queryVO.setNo(vo.getNo());
		List<BusVO> voList = transport.getByList(queryVO);
		if ((voList == null || voList.isEmpty()) || (voList != null && !voList.isEmpty() && vo.getId() == voList.get(0).getId())) {
			if (transport.update(vo)) {
				return ResponseVO.success("车辆修改成功");
			} else {
				return ResponseVO.failure("车辆修改失败");
			}
		} else {
			return ResponseVO.failure("车辆不存在");
		}
	}
}
