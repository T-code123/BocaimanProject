package cn.bocaiman.controller;

import cn.bocaiman.base.controller.BaseController;

import cn.bocaiman.base.pojo.vo.PageVO;
import cn.bocaiman.base.pojo.vo.QueryParamVO;
import cn.bocaiman.base.pojo.vo.ResponseVO;
import cn.bocaiman.pojo.trade.vo.PaymentPlatformVO;
import cn.bocaiman.transport.trade.PaymentPlatformTransport;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-支付管理-支付平台控制器</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@Api(value = "菠菜侠旅游租赁平台-支付管理-支付平台控制器", tags = "菠菜侠旅游租赁平台-支付管理-支付平台交互接口")
@RestController("paymentPlatformController")
@RequestMapping("/trade/paymentplatform")
public class PaymentPlatformController extends BaseController {
	@Autowired
	private PaymentPlatformTransport transport;

	@ApiOperation(value = "根据分页信息分页查询", httpMethod = "POST")
	@ApiImplicitParams({
			@ApiImplicitParam(value = "当前页码", dataType = "Integer", dataTypeClass = Integer.class, required = false),
			@ApiImplicitParam(value = "每页显示数量", dataType = "Integer", dataTypeClass = Integer.class, required = false)
	})
	@ApiResponse(code = 200, message = "响应成功")
	@PostMapping("/page/{pageNum}/{pageSize}")
	public ResponseVO queryListByPage(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize,
	                                  @RequestBody PaymentPlatformVO queryVO) throws Exception {
		// 根据 pageNum 和 pageSize 创建 PageVO 对象
		PageVO<PaymentPlatformVO> pageVO = new PageVO<PaymentPlatformVO>(pageNum,pageSize);
		// 进行分页查询，获得分页查询对象
		QueryParamVO queryParamVO = new QueryParamVO();
		queryParamVO.setPageVO(pageVO);
		queryParamVO.setQueryVO(queryVO);
		return ResponseVO.success(transport.getByPage(queryParamVO));
	}

	@ApiOperation(value = "根据查询对象查询列表", httpMethod = "POST")
	@ApiImplicitParam(value = "查询视图", dataType = "PaymentPlatformVO",dataTypeClass =PaymentPlatformVO.class, required = true)
	@ApiResponse(code = 200, message = "响应成功")
	@PostMapping("/list")
	public ResponseVO queryListByQuery(@RequestBody PaymentPlatformVO queryVO) throws Exception{
		// 使用 Transport 层进行列表查询
		List<PaymentPlatformVO> list = transport.getListByQuery(queryVO);
		return ResponseVO.success(list);
	}

	@ApiOperation(value = "根据主键查询对象", httpMethod = "GET")
	@ApiResponse(code = 200, message = "响应成功")
	@PostMapping("/id/{id}")
	public ResponseVO queryById(@PathVariable("id") String id) throws Exception{
		// 使用 Transport 层进行列表查询
		PaymentPlatformVO paymentPlatformVO = transport.getById(id);
		return ResponseVO.success(paymentPlatformVO);
	}

	@ApiOperation(value = "保存信息", httpMethod = "POST")
	@ApiImplicitParam(value = "保存视图", dataType = "PaymentPlatformVO", dataTypeClass =PaymentPlatformVO.class, required = true)
	@ApiResponse(code = 200, message = "响应成功")
	@PostMapping("/save")
	public ResponseVO save(@RequestBody PaymentPlatformVO vo) throws Exception {
		// 判断此时用户所填写的名称不能为空
		if (vo.getPlatform() != null && !"".equals(vo.getPlatform().trim())) {
			// 校验名字是否唯一
			PaymentPlatformVO queryVO = new PaymentPlatformVO();
			queryVO.setPlatform(vo.getPlatform());
			List<PaymentPlatformVO> list = transport.getListByQuery(queryVO);
			if (list == null || list.isEmpty()) {
				// 此时的名字可用，保存信息
				boolean flag = transport.save(vo);
				if (flag) {
					return ResponseVO.success();
				} else {
					return ResponseVO.failure("添加失败");
				}
			} else {
				return  ResponseVO.failure("该支付平台已经添加");
			}
		} else {
			return ResponseVO.failure("请填写有效的支付平台名称");
		}
	}

	@ApiOperation(value = "修改信息", httpMethod = "POST")
	@ApiImplicitParam(value = "修改视图", dataType = "PaymentPlatformVO",dataTypeClass =PaymentPlatformVO.class, required = true)
	@ApiResponse(code = 200, message = "响应成功")
	@PostMapping("/update")
	public ResponseVO update(@RequestBody PaymentPlatformVO vo) throws Exception {
		boolean flag = transport.update(vo);
		if (flag) {
			return ResponseVO.success();
		} else {
			return ResponseVO.failure("添加失败");
		}
	}

	@ApiOperation(value = "根据名称查询对象", httpMethod = "GET")
	@ApiResponse(code = 200, message = "响应成功")
	@PostMapping("/platform/{platform}")
	public ResponseVO queryByPaymentPlatform(@PathVariable("platform") String platform) throws Exception{
		// 使用 Transport 层进行列表查询
		return ResponseVO.success(transport.getByPaymentPlatform(platform));
	}
}
