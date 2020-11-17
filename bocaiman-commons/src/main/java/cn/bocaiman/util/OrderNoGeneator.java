package cn.bocaiman.util;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <b>菠菜侠旅游租赁平台-基础功能-订单编号生成工具类</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@Component("orderNoGeneator")
public class OrderNoGeneator {
	/**
	 * <b>生成订单编号</b>
	 * <p>
	 *     订单编号生成规则：
	 *     1、获取当前时间
	 *     2、将当前时间格式化为：yyyyMMddHHmmssSSSSSS;</br>
	 *     最终获得20位订单编号
	 * </p>
	 * @return
	 * @throws Exception
	 */
	public String nextNo() throws Exception {
		// 创建 SimpleDateFormat 对象，并且设定时间格式化为 yyyyMMddHHmmssSSSSSS
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSSSSS");
		// 将当前时间进行格式化
		return dateFormat.format(new Date());
	}
}
