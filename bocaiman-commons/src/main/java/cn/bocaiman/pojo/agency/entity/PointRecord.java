package cn.bocaiman.pojo.agency.entity;

import cn.bocaiman.base.pojo.entity.BaseEntity;
import cn.bocaiman.pojo.agency.vo.PointRecordVO;
import org.springframework.beans.BeanUtils;

/**
 * <b>菠菜侠旅游租赁平台-旅行社管理-积分记录实体信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public class PointRecord extends BaseEntity {
	private static final long serialVersionUID = -2349402337272920101L;
	private String id;                      // 主键
	private TravelAgency travelAgency;      // 旅行社信息
	private String orderNo;                 // 订单信息
	private Integer usePoint;               // 使用积分
	private PointUseType pointUseType;      // 使用类型
	private Integer currentTotalPoint;      // 当前剩余积分

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TravelAgency getTravelAgency() {
		return travelAgency;
	}

	public void setTravelAgency(TravelAgency travelAgency) {
		this.travelAgency = travelAgency;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getUsePoint() {
		return usePoint;
	}

	public void setUsePoint(Integer usePoint) {
		this.usePoint = usePoint;
	}

	public PointUseType getPointUseType() {
		return pointUseType;
	}

	public void setPointUseType(PointUseType pointUseType) {
		this.pointUseType = pointUseType;
	}

	public Integer getCurrentTotalPoint() {
		return currentTotalPoint;
	}

	public void setCurrentTotalPoint(Integer currentTotalPoint) {
		this.currentTotalPoint = currentTotalPoint;
	}

	/**
	 * <b>将视图对象转换成实体对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public static PointRecord parseFromEntity(PointRecordVO vo) throws Exception {
		PointRecord entity = new PointRecord();
		// 普通属性转换
		BeanUtils.copyProperties(vo,entity);
		// 关联属性的转换
		TravelAgency travelAgency = new TravelAgency();
		travelAgency.setId(vo.getTravelAgencyId());
		travelAgency.setName(vo.getTravelAgency());
		entity.setTravelAgency(travelAgency);

		PointUseType pointUseType = new PointUseType();
		pointUseType.setId(vo.getPointUseTypeId());
		pointUseType.setText(vo.getPointUseTypeText());
		entity.setPointUseType(pointUseType);
		return entity;
	}
}
