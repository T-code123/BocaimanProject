package cn.bocaiman.controller;

import cn.bocaiman.base.controller.BaseController;
import cn.bocaiman.base.pojo.vo.PageVO;
import cn.bocaiman.base.pojo.vo.QueryParamVO;
import cn.bocaiman.base.pojo.vo.ResponseVO;
import cn.bocaiman.pojo.trade.vo.TradeVO;
import cn.bocaiman.transport.trade.TradeTransport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * <b>菠菜侠旅游租赁平台-支付管理-订单支付控制器</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@Api(value = "菠菜侠旅游租赁平台-支付管理-订单支付控制器", tags = {"菠菜侠旅游租赁平台-支付管理-订单支付交互接口"})
@RestController("tradeController")
@RequestMapping("/trade")
public class TradeController extends BaseController {
	@Autowired
	private TradeTransport transport;

	/**
	 * <b>根据查询视图和分页信息进行分页查询</b>
	 * @param pageNum
	 * @param pageSize
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "根据查询视图和分页信息进行分页查询", protocols = "application/json", httpMethod = "POST")
	@ApiParam(value = "查询视图", type = "TradeRecordVO", required = true)
	@ApiResponse(code = 200, message = "系统响应视图")
	@PostMapping("/page/{pageNum}/{pageSize}")
	public ResponseVO queryByPage(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize,
	                              @RequestBody TradeVO queryVO) throws Exception {
		// 根据 pageNum 和 pageSize 创建 PageVO 对象
		PageVO<TradeVO> pageVO = new PageVO<TradeVO>(pageNum,pageSize);
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
	@ApiParam(value = "查询视图", type = "TradeRecordVO", required = true)
	@ApiResponse(code = 200, message = "系统响应视图")
	@PostMapping("/list")
	public ResponseVO queryList(@RequestBody TradeVO queryVO) throws Exception {
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
		TradeVO queryVO = new TradeVO();
		queryVO.setId(id);
		// 查询列表
		List<TradeVO> voList = transport.getList(queryVO);
		if (voList != null && !voList.isEmpty()) {
			return ResponseVO.success(voList.get(0));
		}
		return ResponseVO.success(new TradeVO());
	}

	/**
	 * <b>根据订单编号查询对象</b>
	 * @param orderNo
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "根据订单编号查询对象",httpMethod = "GET")
	@ApiResponse(code = 200, message = "系统响应视图")
	@PostMapping("/orderNo/{orderNo}")
	public ResponseVO queryByOrderNo(@PathVariable("orderNo") String orderNo) throws Exception {
		// 封装查询对象
		TradeVO queryVO = new TradeVO();
		queryVO.setOrderNo(orderNo);
		// 查询列表
		List<TradeVO> voList = transport.getList(queryVO);
		if (voList != null && !voList.isEmpty()) {
			return ResponseVO.success(voList.get(0));
		}
		return ResponseVO.success(new TradeVO());
	}

	/**
	 * <b>保存对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "保存对象", protocols = "application/json", httpMethod = "POST")
	@ApiParam(value = "保存视图", type = "TradeRecordVO", required = true)
	@ApiResponse(code = 200, message = "系统响应视图")
	@PostMapping("/save")
	public ResponseVO save(@RequestBody TradeVO vo) throws Exception {
		// 信息是否有效
		if (vo.getOrderNo() != null && !"".equals(vo.getOrderNo().trim())) {
			if (transport.save(vo)) {
				return ResponseVO.success("保存成功");
			}
			return ResponseVO.failure("保存失败");
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
	@ApiParam(value = "修改视图", type = "TradeRecordVO", required = true)
	@ApiResponse(code = 200, message = "系统响应视图")
	@PostMapping("/update")
	public ResponseVO update(@RequestBody TradeVO vo) throws Exception {
		// 信息是否有效
		if (vo.getOrderNo() == null || "".equals(vo.getOrderNo().trim())) {
			return ResponseVO.failure("请填写有效的信息");
		}

		if (transport.update(vo)) {
			return ResponseVO.success("保存成功");
		} else {
			return ResponseVO.failure("保存失败");
		}
	}
}
