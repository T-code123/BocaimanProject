package cn.bocaiman.pojo.trade.vo;

import cn.bocaiman.base.pojo.vo.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * <b>菠菜侠旅游租赁平台-交易管理-支付宝异步通知参数视图信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@ApiModel("菠菜侠旅游租赁平台-交易管理-支付宝异步通知参数视图信息")
public class AlipayNotifyVO extends BaseVO {
	private static final long serialVersionUID = 5346652223566770721L;
	@ApiModelProperty(value = "通知时间")
	private Date notify_time;
	@ApiModelProperty(value = "通知类型")
	private String notify_type;
	@ApiModelProperty(value = "通知校验ID")
	private String notify_id;
	@ApiModelProperty(value = "编码格式")
	private String charset;
	@ApiModelProperty(value = "接口版本")
	private String version;
	@ApiModelProperty(value = "签名类型")
	private String sign_type;
	@ApiModelProperty(value = "签名")
	private String sign;
	@ApiModelProperty(value = "授权方的app_id")
	private String auth_app_id;
	@ApiModelProperty(value = "支付宝交易号")
	private String trade_no;
	@ApiModelProperty(value = "开发者的app_id")
	private String app_id;
	@ApiModelProperty(value = "商户订单号")
	private String out_trade_no;
	@ApiModelProperty(value = "交易状态")
	private String trade_status;

	public Date getNotify_time() {
		return notify_time;
	}

	public void setNotify_time(Date notify_time) {
		this.notify_time = notify_time;
	}

	public String getNotify_type() {
		return notify_type;
	}

	public void setNotify_type(String notify_type) {
		this.notify_type = notify_type;
	}

	public String getNotify_id() {
		return notify_id;
	}

	public void setNotify_id(String notify_id) {
		this.notify_id = notify_id;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getSign_type() {
		return sign_type;
	}

	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getAuth_app_id() {
		return auth_app_id;
	}

	public void setAuth_app_id(String auth_app_id) {
		this.auth_app_id = auth_app_id;
	}

	public String getTrade_no() {
		return trade_no;
	}

	public void setTrade_no(String trade_no) {
		this.trade_no = trade_no;
	}

	public String getApp_id() {
		return app_id;
	}

	public void setApp_id(String app_id) {
		this.app_id = app_id;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getTrade_status() {
		return trade_status;
	}

	public void setTrade_status(String trade_status) {
		this.trade_status = trade_status;
	}
}
