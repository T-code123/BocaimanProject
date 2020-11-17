package cn.bocaiman.pojo.order.entity;

import cn.bocaiman.base.pojo.entity.BaseEntity;
import cn.bocaiman.pojo.agency.entity.Linkman;
import cn.bocaiman.pojo.agency.entity.TravelAgency;
import cn.bocaiman.pojo.bus.entity.Bus;
import cn.bocaiman.pojo.order.vo.OrderVO;
import cn.bocaiman.pojo.system.entity.Admin;
import cn.bocaiman.pojo.system.entity.AssemblingPlace;
import cn.bocaiman.pojo.system.entity.Driver;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <b>菠菜侠旅游租赁平台-大巴车订单管理-大巴车订单实体信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public class Order extends BaseEntity {
	private static final long serialVersionUID = 3680999455402472837L;
	private String id;                          // 订单主键
	private String orderNo;                     // 订单编号
	private TravelAgency travelAgency;          // 旅行社信息
	private Bus bus;                            // 车辆信息
	private Driver driver;                      // 司机信息
	private Linkman linkman;                    // 联系人信息
	private AssemblingPlace assemblingPlace;    // 出发集合地点
	private Date startTime;                     // 出发时间
	private Date expectFinishTime;              // 预计返回时间
	private Date actualFinishTime;              // 实际返回时间
	private String route;                       // 途径路线
	private BigDecimal dailyAmount;             // 车辆日租金
	private BigDecimal discount;                // 优惠折扣
	private BigDecimal totalAmount;             // 总金额
	private Date orderCreateDate;               // 下单日期
	private Date orderFinishDate;               // 订单结束时间
	private OrderStatus orderStatus;            // 订单状态

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

	public TravelAgency getTravelAgency() {
		return travelAgency;
	}

	public void setTravelAgency(TravelAgency travelAgency) {
		this.travelAgency = travelAgency;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public Linkman getLinkman() {
		return linkman;
	}

	public void setLinkman(Linkman linkman) {
		this.linkman = linkman;
	}

	public AssemblingPlace getAssemblingPlace() {
		return assemblingPlace;
	}

	public void setAssemblingPlace(AssemblingPlace assemblingPlace) {
		this.assemblingPlace = assemblingPlace;
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

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	/**
	 * <b>将视图对象转换成实体对象</b>
	 * @param vo
	 * @return
	 */
	public static Order parseFromEntity(OrderVO vo) {
		// 创建实体对象
		Order entity = new Order();
		// 进行普通属性切换
		BeanUtils.copyProperties(vo,entity);

		// 关联属性转换
		TravelAgency travelAgency = new TravelAgency();
		travelAgency.setId(vo.getTravelAgencyId());
		travelAgency.setName(vo.getTravelAgency());
		entity.setTravelAgency(travelAgency);

		Bus bus = new Bus();
		bus.setId(vo.getBusId());
		bus.setNo(vo.getBusNo());
		entity.setBus(bus);

		Driver driver = new Driver();
		driver.setId(vo.getDriverId());
		Admin admin = new Admin();
		admin.setName(vo.getDriver());
		driver.setAdmin(admin);
		entity.setDriver(driver);


		Linkman linkman = new Linkman();
		linkman.setId(vo.getLinkmanId());
		linkman.setName(vo.getLinkman());
		entity.setLinkman(linkman);

		AssemblingPlace assemblingPlace = new AssemblingPlace();
		assemblingPlace.setId(vo.getAssemblingPlaceId());
		assemblingPlace.setDetail(vo.getAssemblingPlaceDetail());
		entity.setAssemblingPlace(assemblingPlace);

		OrderStatus orderStatus = new OrderStatus();
		orderStatus.setId(vo.getOrderStatusId());
		orderStatus.setText(vo.getOrderStatus());
		orderStatus.setCode(vo.getOrderStatus());

		return entity;
	}
}
