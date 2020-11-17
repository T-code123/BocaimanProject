package cn.bocaiman.pojo.agency.vo;

import cn.bocaiman.base.pojo.vo.BaseVO;
import cn.bocaiman.pojo.agency.entity.PointRecord;
import cn.bocaiman.pojo.agency.entity.TravelAgency;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-旅行社管理-积分记录视图信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@ApiModel("菠菜侠旅游租赁平台-旅行社管理-积分记录视图信息")
public class PointRecordVO extends BaseVO {
	private static final long serialVersionUID = -5117353976788587572L;
	@ApiModelProperty(value = "主键")
	private String id;                      // 主键
	@ApiModelProperty(value = "所属旅行社")
	private String travelAgencyId;          // 所属旅行社
	@ApiModelProperty(value = "所属旅行社名称")
	private String travelAgency;            // 所属旅行社名称
	@ApiModelProperty(value = "订单信息")
	private String orderNo;                 // 订单信息
	@ApiModelProperty(value = "使用积分")
	private Integer usePoint;               // 使用积分
	@ApiModelProperty(value = "使用类型")
	private String pointUseTypeId;          // 使用类型
	@ApiModelProperty(value = "使用类型文本")
	private String pointUseTypeText;        // 使用类型文本
	@ApiModelProperty(value = "当前剩余积分")
	private Integer currentTotalPoint;      // 当前剩余积分

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getPointUseTypeId() {
		return pointUseTypeId;
	}

	public void setPointUseTypeId(String pointUseTypeId) {
		this.pointUseTypeId = pointUseTypeId;
	}

	public String getPointUseTypeText() {
		return pointUseTypeText;
	}

	public void setPointUseTypeText(String pointUseTypeText) {
		this.pointUseTypeText = pointUseTypeText;
	}

	public Integer getCurrentTotalPoint() {
		return currentTotalPoint;
	}

	public void setCurrentTotalPoint(Integer currentTotalPoint) {
		this.currentTotalPoint = currentTotalPoint;
	}

	/**
	 * <b>将实体对象转换成视图对象</b>
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public static PointRecordVO parseFromVO(PointRecord entity) throws Exception {
		PointRecordVO vo = new PointRecordVO();
		// 普通属性转换
		BeanUtils.copyProperties(entity,vo);
		// 关联属性的转换
		if (entity.getPointUseType() != null ) {
			vo.setPointUseTypeId(entity.getPointUseType().getId());
			vo.setPointUseTypeText(entity.getPointUseType().getText());
		}

		if (entity.getTravelAgency() != null) {
			vo.setTravelAgencyId(entity.getTravelAgency().getId());
			vo.setTravelAgency(entity.getTravelAgency().getName());
		}

		return vo;
	}

	/**
	 * <b>将实体列表切换成视图列表</b>
	 * @param entityList
	 * @return
	 */
	public static List<PointRecordVO> parseFromVOList(List<PointRecord> entityList) throws Exception{
		List<PointRecordVO> voList = new ArrayList<PointRecordVO>();
		// 实体列表可用
		if (entityList != null && !entityList.isEmpty()) {
			for (PointRecord entity : entityList) {
				PointRecordVO vo = parseFromVO(entity);
				voList.add(vo);
			}
		}
		return voList;
	}

}
