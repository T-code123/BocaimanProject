package cn.bocaiman.pojo.bus.vo;

import cn.bocaiman.base.pojo.vo.BaseVO;
import cn.bocaiman.pojo.bus.entity.Bus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.BeanUtils;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-大巴车管理-大巴车视图信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@ApiModel("菠菜侠旅游租赁平台-大巴车管理-大巴车视图信息")
public class BusVO extends BaseVO {
	private static final long serialVersionUID = 2788695832741537404L;
	@ApiModelProperty(value = "主键")
	private String id;                              // 主键
	@ApiModelProperty(value = "座位信息主键")
	private String seatId;                          // 座位信息主键
	@ApiModelProperty(value = "座位信息")
	private String seat;                            // 座位信息
	@ApiModelProperty(value = "车辆类别主键")
	private String categoryId;                      // 车辆类别主键
	@ApiModelProperty(value = "车辆类别")
	private String category;                        // 车辆类别
	@ApiModelProperty(value = "车辆品牌主键")
	private String brandId;                         // 车辆品牌主键
	@ApiModelProperty(value = "车辆品牌")
	private String brand;                           // 车辆品牌
	@ApiModelProperty(value = "车牌号码")
	private String no;                              // 车牌号码
	@ApiModelProperty(value = "发动机号")
	private String engineNo;                        // 发动机号
	@ApiModelProperty(value = "车架号")
	private String vin;                             // 车架号
	@ApiModelProperty(value = "行驶证编号")
	private String drivingLicence;                  // 行驶证编号
	@ApiModelProperty(value = "行驶证照片")
	private String drivingLicenceImage;             // 行驶证照片
	@ApiModelProperty(value = "车辆颜色")
	private String color;                           // 车辆颜色
	@ApiModelProperty(value = "采购时间")
	private Data purchaseDate;                      // 采购时间
	@ApiModelProperty(value = "车辆照片")
	private String image;                           // 车辆照片
	@ApiModelProperty(value = "车辆状态主键")
	private String busStatusId;                     // 车辆状态主键
	@ApiModelProperty(value = "车辆状态文本")
	private String busStatusText;                   // 车辆状态文本
	@ApiModelProperty(value = "车辆编号")
	private String busStatusCode;                   // 车辆状态编号

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSeatId() {
		return seatId;
	}

	public void setSeatId(String seatId) {
		this.seatId = seatId;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
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

	public String getBusStatusId() {
		return busStatusId;
	}

	public void setBusStatusId(String busStatusId) {
		this.busStatusId = busStatusId;
	}

	public String getBusStatusText() {
		return busStatusText;
	}

	public void setBusStatusText(String busStatusText) {
		this.busStatusText = busStatusText;
	}

	public String getBusStatusCode() {
		return busStatusCode;
	}

	public void setBusStatusCode(String busStatusCode) {
		this.busStatusCode = busStatusCode;
	}

	/**
	 * <b>将实体对象转换为视图对象</b>
	 * @param entity
	 * @return
	 */
	public static BusVO parseToVO(Bus entity) {
		// 创建相应的视图对象
		BusVO vo = new BusVO();
		// 切换普通属性
		BeanUtils.copyProperties(entity, vo);

		// 切换特有属性
		if (entity.getSeat() != null) {
			vo.setSeatId(entity.getSeat().getId());
			vo.setSeat(entity.getSeat().getName());
		}
		if (entity.getCategory() != null) {
			vo.setCategoryId(entity.getCategory().getId());
			vo.setCategory(entity.getCategory().getName());
		}
		if (entity.getBrand() != null) {
			vo.setBrandId(entity.getBrand().getId());
			vo.setBrand(entity.getBrand().getName());
		}
		if (entity.getBusStatus() != null) {
			vo.setBusStatusId(entity.getBusStatus().getId());
			vo.setBusStatusText(entity.getBusStatus().getText());
			vo.setBusStatusCode(entity.getBusStatus().getCode());
		}

		return vo;
	}

	/**
	 * <b>将实体列表转化成视图列表</b>
	 * @param entityList
	 * @return
	 */
	public static List<BusVO> changeListForVo(List<Bus> entityList) {
		// 创建视图列表
		List<BusVO> voList = new ArrayList<BusVO>();
		// 判断实体列表是否为null
		if (entityList != null && !entityList.isEmpty()) {
			for (Bus entity : entityList) {
				BusVO vo = parseToVO(entity);
				voList.add(vo);
			}
		}
		return voList;
	}
}
