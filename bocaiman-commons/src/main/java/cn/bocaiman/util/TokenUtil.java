package cn.bocaiman.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * <b>系统 Token 工具类</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public class TokenUtil {

	// 设置加密算法
	private static Algorithm algorithm = Algorithm.HMAC256(ConstantUtil.SECRET_PRIVATE_KEY);

	/**
	 * <b>通过使用当前用户的主键，生成对应的 Token 信息</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public static String generateToken(String id) throws Exception {
		// 创建 Token 生成对象
		JWTCreator.Builder builder = JWT.create();
		// 设定最终生成 Token 的头部信息
		Map<String, Object> header = new HashMap<String, Object>();
		// Token 采用了 JWT 形式，也就是最终形成 JSON
		header.put("type", "JWT");
		// 设定整个加密采用的加密算法
		header.put("alg", "HS256");
		builder.withHeader(header);

		// 设定有效载荷信息， 也就是将用户的id进行设定
		builder.withClaim("id", id);
		// 设定该 Token 的有效存活时间
		Date expireDate = new Date(new Date().getTime() + ConstantUtil.TOKEN_EXPIRE_MINUTE * 60 * 1000);
		builder.withExpiresAt(expireDate);

		// 对于整个结果进行算法签名加密
		return builder.sign(algorithm);
	}

	/**
	 * <b>校验 Token 信息</b>
	 * @param token
	 * @return
	 * @throws Exception
	 */
	public static String verityToken(String token) throws Exception {
		// 判断该 Token 是否为 null
		if (token != null && !"".equals(token)) {
			// 获得 JWT 解析工具
			JWTVerifier verifier = JWT.require(algorithm).build();
			try {
				// 校验对应的 Token，校验通过，说明该 token 属于系统生成，则可以进行解密，获取有效载荷信息
				String id = verifier.verify(token).getClaim("id").asString();
				return id;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

	public static void main(String[] args) throws Exception {
		//System.out.println(generateToken("1024"));
		System.out.println(verityToken("eyJ0eXAiOiJKV1QiLCJ0eXBlIjoiSldUIiwiYWxnIjoiSFMyNTYifQ.eyJpZCI6IjEwMjQiLCJleHAiOjE2MDM1Mjk1OTJ9.xmUExycF-Azr_ckcdyX0wVAJl0AmW5CseFSPpVeUt1w"));
	}
}
