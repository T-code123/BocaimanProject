package cn.bocaiman.util;

import org.springframework.stereotype.Component;

import java.security.MessageDigest;

/**
 * <b>菠菜侠旅游租赁平台-基础功能-主键生成工具类</b>
 * <p>
 *     为了系统以后升级能够更加方便的进行分表分库，不在采用数据库主键自增长方式产生主键，<br/>
 *     而是将当前时间戳进行 MD5 加密后作为主键。
 * </p>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@Component("idGenerator")
public class IdGenerator {
	private static final String KEY_MD5 = "MD5";

	/**
	 * <b>获得 ID</b>
	 * @return
	 * @throws Exception
	 */
	public synchronized String nextId() throws Exception {
		// 获得当前时间戳，并且转换为 String
		String currentMillis = String.valueOf(System.currentTimeMillis());
		// 对该时间戳进行 MD5 加密
		StringBuffer sb = new StringBuffer();
		try {
			MessageDigest md = MessageDigest.getInstance(KEY_MD5);
			byte[] inputData = currentMillis.getBytes("UTF-8");
			byte[] encryptionData = md.digest(inputData);
			for (int i = 0; i < encryptionData.length; i++) {
				int value = ((int) encryptionData[i]) & 0xff;
				if (value < 16) {
					sb.append("0");
				}
				sb.append(Integer.toHexString(value));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString().toUpperCase();
	}
}
