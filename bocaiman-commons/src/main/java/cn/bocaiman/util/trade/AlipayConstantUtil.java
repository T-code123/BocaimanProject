package cn.bocaiman.util.trade;

import java.util.Properties;

/**
 * <b>支付宝常量接口工具</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public class AlipayConstantUtil {
	private static Properties props = new Properties();

	static {
		try {
			props.load(AlipayConstantUtil.class.getClassLoader().getResourceAsStream("props/trade/alipay.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * <b>支付宝常量：支付宝网关</b>
	 */
	public static final String URL = props.getProperty("alipay.url");

	/**
	 * <b>支付宝常量：APPID</b>
	 */
	public static final String APPID = props.getProperty("alipay.appid");

	/**
	 * <b>支付宝常量：开发者私钥</b>
	 */
	public static final String APP_PRIVATE_KEY = props.getProperty("alipay.app.private.key");

	/**
	 * <b>支付宝常量：参数返回格式</b>
	 */
	public static final String FORMAT = props.getProperty("alipay.format");

	/**
	 * <b>支付宝常量：编码集</b>
	 */
	public static final String CHARSET = props.getProperty("alipay.charset");

	/**
	 * <b>支付宝常量：支付宝公钥</b>
	 */
	public static final String ALIPAY_PUBLIC_KEY = props.getProperty("alipay.alipay.public.key");

	/**
	 * <b>支付宝常量：商户生成签名字符串所使用的签名算法类型</b>
	 */
	public static final String SIGN_TYPE = props.getProperty("alipay.sign.type");

	/**
	 * <b>支付宝常量：销售产品码，与支付宝签约的产品码名称。</b>
	 * <P>
	 *     目前仅支持FAST_INSTANT_TRADE_PAY
	 * </P>
	 */
	public static final String PRODUCT_CODE = props.getProperty("alipay.product.code");

	/**
	 * <b>支付宝常量：支付完成重定向地址。</b>
	 */
	public static final String RETURN_URL = props.getProperty("alipay.return.url");

	/**
	 * <b>支付宝常量：支付完成异步通知地址。</b>
	 */
	public static final String NOTIFY_URL = props.getProperty("alipay.notify.url");
}
