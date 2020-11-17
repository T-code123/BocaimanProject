package cn.bocaiman.pojo.order.vo;

import cn.bocaiman.base.pojo.vo.BaseVO;
import cn.bocaiman.pojo.agency.entity.Linkman;
import cn.bocaiman.pojo.order.entity.Order;
import cn.bocaiman.pojo.order.entity.OrderStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.BeanUtils;
import org.yaml.snakeyaml.events.Event;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-大巴车订单管理-大巴车订单视图信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@ApiModel("菠菜侠旅游租赁平台-大巴车订单管理-大巴车订单视图信息")
public class OrderVO extends BaseVO {
	private static final long serialVersionUID = 3466023219715378319L;
	@ApiModelProperty(value = "订单主键")
	private String id;                          // 订单主键
	@ApiModelProperty(value = "订单编号")
	private String orderNo;                     // 订单编号
	@ApiModelProperty(value = "旅行社主键")
	private String travelAgencyId;              // 旅行社主键
	@ApiModelProperty(value = "旅行社信息")
	private String travelAgency;                // 旅行社信息
	@ApiModelProperty(value = "车辆信息主键")
	private String busId;                       // 车辆信息主键
	@ApiModelProperty(value = "车牌号码")
	private String busNo;                       // 车牌号码
	@ApiModelProperty(value = "司机信息主键")
	private String driverId;                    // 司机信息主键
	@ApiModelProperty(value = "司机信息")
	private String driver;                      // 司机信息
	@ApiModelProperty(value = "联系人信息主键")
	private String linkmanId;                   // 联系人信息主键
	@ApiModelProperty(value = "联系人信息")
	private String linkman;                    // 联系人信息
	@ApiModelProperty(value = "出发地点主键")
	private String assemblingPlaceId;           // 出发地点主键
	@ApiModelProperty(value = "详细地址")
	private String assemblingPlaceDetail;       // 出发地点详细地址
	@ApiModelProperty(value = "出发时间")
	private Date startTime;                     // 出发时间
	@ApiModelProperty(value = "预计返回时间")
	private Date expectFinishTime;              // 预计返回时间
	@ApiModelProperty(value = "实际返回时间")
	private Date actualFinishTime;              // 实际返回时间
	@ApiModelProperty(value = "途径路线")
	private String route;                       // 途径路线
	@ApiModelProperty(value = "车辆日租金")
	private BigDecimal dailyAmount;             // 车辆日租金
	@ApiModelProperty(value = "优惠折扣")
	private BigDecimal discount;                // 优惠折扣
	@ApiModelProperty(value = "总金额")
	private BigDecimal totalAmount;             // 总金额
	@ApiModelProperty(value = "下单日期")
	private Date orderCreateDate;               // 下单日期
	@ApiModelProperty(value = "订单结束时间")
	private Date orderFinishDate;               // 订单结束时间
	@ApiModelProperty(value = "订单状态主键")
	private String orderStatusId;               // 订单状态主键
	@ApiModelProperty(value = "订单状态")
	private String orderStatus;                 // 订单状态

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getTravelAgencyId() {
		return travelAgencyId;
	}

	public void setTravelAgencyId(String travelAgencyId) {
		this.travelAgencyId = travelAgencyId;
	}

	public String getTravelAgency() {
		return travelAgency;
	}

	public void setTravelAgency(String travelAgency) {
		this.travelAgency = travelAgency;
	}

	public String getBusId() {
		return busId;
	}

	public void setBusId(String busId) {
		this.busId = busId;
	}

	public String getBusNo() {
		return busNo;
	}

	public void setBusNo(String busNo) {
		this.busNo = busNo;
	}

	public String getDriverId() {
		return driverId;
	}

	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getLinkmanId() {
		return linkmanId;
	}

	public void setLinkmanId(String linkmanId) {
		this.linkmanId = linkmanId;
	}

	public String getLinkman() {
		return linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public String getAssemblingPlaceId() {
		return assemblingPlaceId;
	}

	public void setAssemblingPlaceId(String assemblingPlaceId) {
		this.assemblingPlaceId = assemblingPlaceId;
	}

	public String getAssemblingPlaceDetail() {
		return assemblingPlaceDetail;
	}

	public void setAssemblingPlaceDetail(String assemblingPlaceDetail) {
		this.assemblingPlaceDetail = assemblingPlaceDetail;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getExpectFinishTime() {
		return expectFinishTime;
	}

	public void setExpectFinishTime(Date expectFinishTime) {
		this.expectFinishTime = expectFinishTime;
	}

	public Date getActualFinishTime() {
		return actualFinishTime;
	}

	public void setActualFinishTime(Date actualFinishTime) {
		this.actualFinishTime = actualFinishTime;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public BigDecimal getDailyAmount() {
		return dailyAmount;
	}

	public void setDailyAmount(BigDecimal dailyAmount) {
		this.dailyAmount = dailyAmount;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Date getOrderCreateDate() {
		return orderCreateDate;
	}

	public void setOrderCreateDate(Date orderCreateDate) {
		this.orderCreateDate = orderCreateDate;
	}

	public Date getOrderFinishDate() {
		return orderFinishDate;
	}

	public void setOrderFinishDate(Date orderFinishDate) {
		this.orderFinishDate = orderFinishDate;
	}

	public String getOrderStatusId() {
		return orderStatusId;
	}

	public void setOrderStatusId(String orderStatusId) {
		this.orderStatusId = orderStatusId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	/**
	 * <b>将实体对象转换成视图对象</b>
	 * @param entity
	 * @return
	 */
	public static OrderVO parseFromVO(Order entity) {
		// 创建视图对象
		OrderVO vo = new OrderVO();
		// 进行普通属性切换
		BeanUtils.copyProperties(entity,vo);

		if (entity.getTravelAgency() != null) {
			vo.setTravelAgencyId(entity.getId());
			vo.setTravelAgency(entity.getTravelAgency().getName());
		}

		if (entity.getBus() != null) {
			vo.setBusId(entity.getBus().getId());
			vo.setBusNo(entity.getBus().getNo());
		}

		if (entity.getDriver() != null) {
			vo.setDriverId(entity.getDriver().getId());
			vo.setDriver(entity.getDriver().getDriverLicense());
		}

		if (entity.getLinkman() != null) {
			vo.setLinkmanId(entity.getId());
			vo.setLinkman(entity.getLinkman().getName());
		}

		if (entity.getAssemblingPlace() != null) {
			vo.setAssemblingPlaceId(entity.getId());
			vo.setAssemblingPlaceDetail(entity.getAssemblingPlace().getDetail());
		}

		if (entity.getOrderStatus() != null) {
			vo.setOrderStatusId(entity.getOrderStatus().getId());
			vo.setOrderStatus(entity.getOrderStatus().getText());
			vo.setOrderStatus(entity.getOrderStatus().getCode());
		}
		return vo;
	}

	/**
	 * <b>将实体列表切换成视图列表</b>
	 * @param entityList
	 * @return
	 */
	public static List<OrderVO> parseFromVOList(List<Order> entityList) {
		List<OrderVO> voList = new ArrayList<OrderVO>();
		// 实体列表可用
		if (entityList != null && !entityList.isEmpty()) {
			for (Order entity : entityList) {
				OrderVO vo = parseFromVO(entity);
				voList.add(vo);
			}
		}
		return voList;
	}

}
