package cn.bocaiman.pojo.bus.entity;

import cn.bocaiman.base.pojo.entity.BaseEntity;
import cn.bocaiman.pojo.bus.vo.BusRentAmountVO;
import cn.bocaiman.pojo.bus.vo.BusVO;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

/**
 * <b>菠菜侠旅游租赁平台-大巴车管理-大巴车日租金实体信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public class BusRentAmount extends BaseEntity {
	private static final long serialVersionUID = 5777579437735101387L;
	private String id;                              // 主键
	private BusDic seat;                            // 座位信息
	private BusDic category;                        // 车辆类别
	private BusDic brand;                           // 车辆品牌
	private BigDecimal dailyAmount;                 // 日租金

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

	public BigDecimal getDailyAmount() {
		return dailyAmount;
	}

	public void setDailyAmount(BigDecimal dailyAmount) {
		this.dailyAmount = dailyAmount;
	}

	/**
	 * <b>将视图对象转换成实体对象</b>
	 * @param vo
	 * @return
	 */
	public static BusRentAmount parseFromEntity(BusRentAmountVO vo) {
		// 创建实体对象
		BusRentAmount entity = new BusRentAmount();
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

		return entity;
	}
}
