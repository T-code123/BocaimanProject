package cn.bocaiman.pojo.trade.vo;

import cn.bocaiman.base.pojo.vo.BaseVO;
import cn.bocaiman.pojo.trade.entity.Trade;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-交易管理-交易记录视图信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@ApiModel("菠菜侠旅游租赁平台-交易管理-交易记录视图信息")
public class TradeVO extends BaseVO {
	private static final long serialVersionUID = -4811353372789965511L;
	@ApiModelProperty(value = "主键")
	private String id;                          // 主键
	@ApiModelProperty(value = "交易编号")
	private String tradeNo;                     // 交易编号:和订单编号相同
	@ApiModelProperty(value = "订单主键")
	private String orderId;                     // 订单主键
	@ApiModelProperty(value = "订单信息编号")
	private String orderNo;                     // 订单信息编号
	@ApiModelProperty(value = "交易金额")
	private BigDecimal amount;                  // 交易金额
	@ApiModelProperty(value = "支付平台主键")
	private String paymentPlatformId;           // 支付平台主键
	@ApiModelProperty(value = "支付平台")
	private String paymentPlatform;             // 支付平台
	@ApiModelProperty(value = "交易结束时间")
	private Date startTime;                     // 交易结束时间
	@ApiModelProperty(value = "交易结束时间")
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

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getPaymentPlatformId() {
		return paymentPlatformId;
	}

	public void setPaymentPlatformId(String paymentPlatformId) {
		this.paymentPlatformId = paymentPlatformId;
	}

	public String getPaymentPlatform() {
		return paymentPlatform;
	}

	public void setPaymentPlatform(String paymentPlatform) {
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
	 * <b>将实体对象转换成视图对象</b>
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public static TradeVO parseFromVO(Trade entity) throws Exception{
		// 创建视图对象
		TradeVO vo = new TradeVO();
		// 普通属性的转换
		BeanUtils.copyProperties(entity,vo);

		// 关联属性的转换
		if (entity.getOrder() != null ) {
			vo.setOrderId(entity.getOrder().getId());
			vo.setOrderNo(entity.getOrder().getOrderNo());
		}

		if (entity.getPaymentPlatform() != null) {
			vo.setPaymentPlatformId(entity.getPaymentPlatform().getId());
			vo.setPaymentPlatform(entity.getPaymentPlatform().getPlatform());
		}
		return vo;
	}

	/**
	 * <b>将实体列表转换成视图列表</b>
	 * @param entityList
	 * @return
	 * @throws Exception
	 */
	public static List<TradeVO> parseFromVOList(List<Trade> entityList) throws Exception {
		// 创建视图列表
		List<TradeVO> voList = new ArrayList<TradeVO>();
		// 实体列表可用
		if (entityList != null && !entityList.isEmpty()) {
			for (Trade entity : entityList) {
				TradeVO vo = parseFromVO(entity);
				voList.add(vo);
			}
		}
		return voList;
	}
}
