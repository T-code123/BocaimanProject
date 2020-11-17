package cn.bocaiman.controller;

import cn.bocaiman.base.controller.BaseController;
import cn.bocaiman.pojo.order.entity.Order;
import cn.bocaiman.pojo.order.entity.OrderStatus;
import cn.bocaiman.pojo.order.vo.OrderStatusVO;
import cn.bocaiman.pojo.trade.entity.PaymentPlatform;
import cn.bocaiman.pojo.trade.entity.Trade;
import cn.bocaiman.pojo.trade.vo.AlipayNotifyVO;
import cn.bocaiman.pojo.trade.vo.AlipayTradeVO;
import cn.bocaiman.transport.order.OrderStatusTransport;
import cn.bocaiman.transport.order.OrderTransport;
import cn.bocaiman.transport.trade.PaymentPlatformTransport;
import cn.bocaiman.transport.trade.TradeTransport;
import cn.bocaiman.util.enums.AlipayTradeStatusEnum;
import cn.bocaiman.util.enums.OrderStatusEnum;
import cn.bocaiman.util.trade.AlipayConstantUtil;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


/**
 * <b>菠菜侠旅游租赁平台-支付管理-支付宝支付控制器</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@Api(value = "菠菜侠旅游租赁平台-支付管理-支付宝支付控制器",tags = "菠菜侠旅游租赁平台-支付管理- 支付交互接口")
@RestController("alipayTradeController")
@RequestMapping("/trade/alipay")
public class AlipayTradeController extends BaseController {
	@Autowired
	private TradeTransport tradeTransport;
	@Autowired
	private OrderTransport orderTransport;
	@Autowired
	private PaymentPlatformTransport paymentPlatformTransport;
	@Autowired
	private OrderStatusTransport orderStatusTransport;

	@ApiOperation(value = "统一收单下单并支付页面接口", httpMethod = "POST")
	@PostMapping("/pay")
	public void pay(@RequestBody AlipayTradeVO alipayTradeVO) throws Exception {
		// 判断支付金额是否有效
		if (alipayTradeVO.getTotal_amount() != null && alipayTradeVO.getTotal_amount().doubleValue() > 0) {
			// 设定销售产品码信息
			alipayTradeVO.setProduct_code(AlipayConstantUtil.PRODUCT_CODE);
			// 设定超时时间
			alipayTradeVO.setTime_expire();
			// 将此时的支付信息存入支付表
			// 将 AlipayTradeVO 切换为 Trade 对象
			Trade trade = new Trade();
			trade.setTradeNo(alipayTradeVO.getOut_trade_no());
			// 根据交易编号查询订单信息
			Order order = orderTransport.getOrderByOrderNo(alipayTradeVO.getOut_trade_no());
			trade.setOrder(order);
			// 设定交易金额
			trade.setAmount(alipayTradeVO.getTotal_amount());
			// 设定支付平台
			PaymentPlatform paymentPlatform = paymentPlatformTransport.getByPaymentPlatform("支付宝");
			trade.setPaymentPlatform(paymentPlatform);
			trade.setStartTime(new Date());
			// 将订单此时的状态变为待支付
			if (tradeTransport.saveByAlipayTradeVO(trade)) {
				// 修改订单状态为支付中
				/*OrderStatusRecord orderStatusRecord = new OrderStatusRecord();
				orderStatusRecord.setOrder(order);
				orderStatusRecord.setOrderStatus(OrderStatusEnum.ORDER_STATUS_PAYING.getRemark());
				orderStatusRecord.setStatus(OrderStatusEnum.ORDER_STATUS_PAYING.getCode());*/
				OrderStatus orderStatus = new OrderStatus();
				orderStatus.setId("A1956BA73EF087F0A328DBB8F6A8CA71");
				orderStatus.setText(OrderStatusEnum.ORDER_STATUS_PAYED.getRemark());
				orderStatus.setCode(OrderStatusEnum.ORDER_STATUS_PAYED.getCode());
				if (orderStatusTransport.save(OrderStatusVO.parseFromVO(orderStatus))) {
					// 交易信息入库成功
				}
				// 入库成功，调用支付宝接口进行支付
				payTrade(alipayTradeVO);
			}
		}
	}

	/**
	 * <b>支付宝交易异步通知地址</b>
	 * @throws Exception
	 */
	@PostMapping("notify")
	public void tradeNotify(AlipayNotifyVO alipayNotifyVO) throws Exception {
		// 获得此时订单编号，通过订单编号查询对应的订单信息
		Order order = orderTransport.getOrderByOrderNo(alipayNotifyVO.getOut_trade_no());
		// 获得此时的交易信息
		String tradeStatus = alipayNotifyVO.getTrade_status();
		// 根据状态进行判断
		if (AlipayTradeStatusEnum.TRADE_SUCCESS.getCode().equals(tradeStatus)
				|| AlipayTradeStatusEnum.TRADE_CLOSED.getCode().equals(tradeStatus)) {
			// 交易成功，进行状态修改
			// 修改订单状态为支付中
			/*OrderStatusRecord orderStatusRecord = new OrderStatusRecord();
			orderStatusRecord.setOrder(order);
			orderStatusRecord.setOrderStatus(OrderStatusEnum.ORDER_STATUS_PAYED.getRemark());
			orderStatusRecord.setStatus(OrderStatusEnum.ORDER_STATUS_PAYED.getCode());*/
			OrderStatus orderStatus = new OrderStatus();
			orderStatus.setId("A1956BA73EF087F0A328DBB8F6A8CA71");
			orderStatus.setText(OrderStatusEnum.ORDER_STATUS_PAYED.getRemark());
			orderStatus.setCode(OrderStatusEnum.ORDER_STATUS_PAYED.getCode());
			orderStatusTransport.save(OrderStatusVO.parseFromVO(orderStatus));
		}
	}

	/**
	 * <b>调用支付宝接口进行支付操作</b>
	 * @param alipayTradeVO
	 * @throws Exception
	 */
	private void payTrade(AlipayTradeVO alipayTradeVO) throws Exception {
		AlipayClient alipayClient =  new DefaultAlipayClient(AlipayConstantUtil.URL, AlipayConstantUtil.APPID,
				AlipayConstantUtil.APP_PRIVATE_KEY, AlipayConstantUtil.FORMAT, AlipayConstantUtil.CHARSET,
				AlipayConstantUtil.ALIPAY_PUBLIC_KEY, AlipayConstantUtil.SIGN_TYPE);  //获得初始化的AlipayClient
		AlipayTradePagePayRequest alipayRequest =  new  AlipayTradePagePayRequest(); //创建API对应的request
		alipayRequest.setReturnUrl(AlipayConstantUtil.RETURN_URL);
		alipayRequest.setNotifyUrl(AlipayConstantUtil.NOTIFY_URL); //在公共参数中设置回跳和通知地址

		// 将 AlipayTradeVO 变为 JSON
		JsonMapper jsonMapper = new JsonMapper();
		String alipayTradeVOJSON = jsonMapper.writeValueAsString(alipayTradeVO);
		// 设定相关参数
		alipayRequest.setBizContent(alipayTradeVOJSON);

		String form= alipayClient.pageExecute(alipayRequest).getBody();  //调用SDK生成表单
		response.setContentType( "text/html;charset="  + AlipayConstantUtil.CHARSET);
		response.getWriter().write(form); //直接将完整的表单html输出到页面
		response.getWriter().flush();
		response.getWriter().close();
	}
}
