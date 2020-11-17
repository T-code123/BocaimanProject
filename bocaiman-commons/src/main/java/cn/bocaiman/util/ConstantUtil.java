package cn.bocaiman.util;

import java.util.Properties;

/**
 * <b>菠菜侠旅游租赁平台-基础功能-系统常量工具类</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public class ConstantUtil {
	private static Properties props = new Properties();

	static {
		try {
			props.load(ConstantUtil.class.getClassLoader().getResourceAsStream("props/system.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * <b>订单超时时间（分钟）</b>
	 */
	public static final Integer ORDER_EXPIRE_MINUTE = Integer.parseInt(props.getProperty("order.expire.minute"));

	/**
	 * <b>Token 加密私钥</b>
	 */
	public static final String SECRET_PRIVATE_KEY = props.getProperty("secret.private.key");
	/**
	 * <b>Token 超时时间（分钟）</b>
	 */
	public static final Long TOKEN_EXPIRE_MINUTE = Long.parseLong(props.getProperty("token.expire.minute"));
}
