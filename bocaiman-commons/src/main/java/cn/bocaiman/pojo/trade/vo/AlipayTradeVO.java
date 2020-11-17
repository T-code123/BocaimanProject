package cn.bocaiman.pojo.trade.vo;

import cn.bocaiman.util.ConstantUtil;
import cn.bocaiman.util.trade.AlipayConstantUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <b>菠菜侠旅游租赁平台-支付管理-支付宝支付视图信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@ApiModel("菠菜侠旅游租赁平台-支付管理-支付宝支付视图信息")
public class AlipayTradeVO implements Serializable {
	private static final long serialVersionUID = -3471870703225520631L;
	@ApiModelProperty(value = "商户订单号", required = true)
	private String out_trade_no;
	@ApiModelProperty(value = "销售产品码")
	private String product_code = AlipayConstantUtil.PRODUCT_CODE;
	@ApiModelProperty(value = "订单总金额，单位为元，精确到小数点后两位", required = true)
	private BigDecimal total_amount;
	@ApiModelProperty(value = "订单标题", required = true)
	private String subject;
	@ApiModelProperty(value = "订单描述",required = true)
	private String body;
	@ApiModelProperty(value = "绝对超时时间，格式为yyyy-MM-dd HH:mm:ss")
	private String time_expire;

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getProduct_code() {
		return product_code;
	}

	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}

	public BigDecimal getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(BigDecimal total_amount) {
		this.total_amount = total_amount;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getTime_expire() {
		return time_expire;
	}

	public void setTime_expire(String time_expire) {
		this.time_expire = time_expire;
	}

	public void setTime_expire() {
		// 获得当前时间
		Date nowDate = new Date();
		// 根据订单超时时间计算到期时间，并且进行格式化
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.time_expire = dateFormat.format(new Date(nowDate.getTime() + ConstantUtil.ORDER_EXPIRE_MINUTE * 60 * 1000));
	}
}
