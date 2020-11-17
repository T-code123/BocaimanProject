package cn.bocaiman.pojo.bus.vo;

import cn.bocaiman.base.pojo.vo.BaseVO;
import cn.bocaiman.pojo.bus.entity.Bus;
import cn.bocaiman.pojo.bus.entity.BusDic;
import cn.bocaiman.pojo.bus.entity.BusRentAmount;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-大巴车管理-大巴车日租金视图信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@ApiModel("菠菜侠旅游租赁平台-大巴车管理-大巴车日租金视图信息")
public class BusRentAmountVO extends BaseVO {
	private static final long serialVersionUID = 4612000502603401851L;
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
	@ApiModelProperty(value = "日租金")
	private BigDecimal dailyAmount;                 // 日租金

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

	public BigDecimal getDailyAmount() {
		return dailyAmount;
	}

	public void setDailyAmount(BigDecimal dailyAmount) {
		this.dailyAmount = dailyAmount;
	}

	/**
	 * <b>将实体对象转换为视图对象</b>
	 * @param entity
	 * @return
	 */
	public static BusRentAmountVO parseFromVO(BusRentAmount entity) {
		// 创建相应的视图对象
		BusRentAmountVO vo = new BusRentAmountVO();
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

		return vo;
	}

	/**
	 * <b>将实体列表转化成视图列表</b>
	 * @param entityList
	 * @return
	 */
	public static List<BusRentAmountVO> parseFromVOList(List<BusRentAmount> entityList) {
		// 创建视图列表
		List<BusRentAmountVO> voList = new ArrayList<BusRentAmountVO>();
		// 判断实体列表是否为null
		if (entityList != null && !entityList.isEmpty()) {
			for (BusRentAmount entity : entityList) {
				BusRentAmountVO vo = parseFromVO(entity);
				voList.add(vo);
			}
		}
		return voList;
	}
}
