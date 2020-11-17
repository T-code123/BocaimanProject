package cn.bocaiman.pojo.trade.entity;

import cn.bocaiman.base.pojo.entity.BaseEntity;
import cn.bocaiman.pojo.order.entity.Order;
import cn.bocaiman.pojo.trade.vo.TradeVO;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <b>菠菜侠旅游租赁平台-交易管理-交易记录实体信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public class Trade extends BaseEntity {
	private static final long serialVersionUID = 5372335507950226568L;
	private String id;                          // 主键
	private String tradeNo;                     // 交易编号:和订单编号相同
	private Order order;                        // 订单信息
	private BigDecimal amount;                  // 交易金额
	private PaymentPlatform paymentPlatform;    // 支付平台
	private Date startTime;                     // 交易开始时间
	private Date endTime;                       // 交易结束时间

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public PaymentPlatform getPaymentPlatform() {
		return paymentPlatform;
	}

	public void setPaymentPlatform(PaymentPlatform paymentPlatform) {
		this.paymentPlatform = paymentPlatform;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	/**
	 * <b>将视图信息转换成实体信息</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public static Trade parseFromEntity(TradeVO vo) throws Exception {
		// 创建实体对象
		Trade entity = new Trade();
		// 转换普通属性
		BeanUtils.copyProperties(vo,entity);
		// 关联属性的转换
		Order order = new Order();
		order.setId(vo.getOrderId());
		order.setOrderNo(vo.getOrderNo());
		entity.setOrder(order);


		PaymentPlatform paymentPlatform = new PaymentPlatform();
		paymentPlatform.setId(vo.getPaymentPlatformId());
		paymentPlatform.setPlatform(vo.getPaymentPlatform());
		paymentPlatform.setPlatformIcon(vo.getPaymentPlatform());
		entity.setPaymentPlatform(paymentPlatform);
		return entity;
	}
}
