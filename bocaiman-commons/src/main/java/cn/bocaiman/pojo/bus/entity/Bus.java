package cn.bocaiman.pojo.bus.entity;

import cn.bocaiman.base.pojo.entity.BaseEntity;
import cn.bocaiman.pojo.bus.vo.BusVO;
import org.springframework.beans.BeanUtils;

import javax.xml.crypto.Data;

/**
 * <b>菠菜侠旅游租赁平台-大巴车管理-大巴车实体信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public class Bus extends BaseEntity {
	private static final long serialVersionUID = 3382377083332463090L;
	private String id;                              // 主键
	private BusDic seat;                            // 座位信息
	private BusDic category;                        // 车辆类别
	private BusDic brand;                           // 车辆品牌
	private String no;                              // 车牌号码
	private String engineNo;                        // 发动机号
	private String vin;                             // 车架号
	private String drivingLicence;                  // 行驶证编号
	private String drivingLicenceImage;             // 行驶证照片
	private String color;                           // 车辆颜色
	private Data purchaseDate;                      // 采购时间
	private String image;                           // 车辆照片
	private BusStatus busStatus;                    // 车辆状态

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BusDic getSeat() {
		return seat;
	}

	public void setSeat(BusDic seat) {
		this.seat = seat;
	}

	public BusDic getCategory() {
		return category;
	}

	public void setCategory(BusDic category) {
		this.category = category;
	}

	public BusDic getBrand() {
		return brand;
	}

	public void setBrand(BusDic brand) {
		this.brand = brand;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getEngineNo() {
		return engineNo;
	}

	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getDrivingLicence() {
		return drivingLicence;
	}

	public void setDrivingLicence(String drivingLicence) {
		this.drivingLicence = drivingLicence;
	}

	public String getDrivingLicenceImage() {
		return drivingLicenceImage;
	}

	public void setDrivingLicenceImage(String drivingLicenceImage) {
		this.drivingLicenceImage = drivingLicenceImage;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Data getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Data purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public BusStatus getBusStatus() {
		return busStatus;
	}

	public void setBusStatus(BusStatus busStatus) {
		this.busStatus = busStatus;
	}

	/**
	 * <b>将视图对象转换成实体对象</b>
	 * @param vo
	 * @return
	 */
	public static Bus parseToEntity(BusVO vo) {
		// 创建实体对象
		Bus entity = new Bus();
		// 拷贝普通属性
		BeanUtils.copyProperties(vo, entity);
		// 拷贝关联属性
		BusDic seat = new BusDic();
		seat.setId(vo.getSeatId());
		seat.setName(vo.getSeat());
		entity.setSeat(seat);

		BusDic category = new BusDic();
		category.setId(vo.getCategoryId());
		category.setName(vo.getCategory());
		entity.setCategory(category);

		BusDic brand = new BusDic();
		brand.setId(vo.getBrandId());
		brand.setName(vo.getBrand());
		entity.setBrand(brand);

		BusStatus busStatus = new BusStatus();
		busStatus.setId(vo.getBusStatusId());
		busStatus.setText(vo.getBusStatusText());
		busStatus.setCode(vo.getBusStatusCode());
		entity.setBusStatus(busStatus);

		return entity;
	}
}
