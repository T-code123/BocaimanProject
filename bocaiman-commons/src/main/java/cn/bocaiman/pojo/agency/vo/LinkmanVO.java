package cn.bocaiman.pojo.agency.vo;

import cn.bocaiman.base.pojo.vo.BaseVO;
import cn.bocaiman.pojo.agency.entity.Linkman;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-旅行社管理-常用联系人视图信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@ApiModel("菠菜侠旅游租赁平台-旅行社管理-常用联系人视图信息")
public class LinkmanVO extends BaseVO {
	private static final long serialVersionUID = -5121710496707093384L;
	@ApiModelProperty(value = "主键")
	private String id;                      // 主键
	@ApiModelProperty(value = "所属旅行社")
	private String travelAgencyId;          // 所属旅行社
	@ApiModelProperty(value = "所属旅行社名称")
	private String travelAgency;            // 所属旅行社名称
	@ApiModelProperty(value = "联系人姓名")
	private String name;                    // 联系人姓名
	@ApiModelProperty(value = "手机号码")
	private String cellphone;               // 手机号码
	@ApiModelProperty(value = "身份证号码")
	private String idCard;                  // 身份证号码
	@ApiModelProperty(value = "身份证照片")
	private String idCardImage;             // 身份证照片
	@ApiModelProperty(value = "审核状态主键")
	private String auditStatusId;           // 审核状态主键
	@ApiModelProperty(value = "审核状态文本")
	private String auditStatus;             // 审核状态文本
	@ApiModelProperty(value = "审核人主键")
	private String auditAdminId;            // 审核人主键
	@ApiModelProperty(value = "审核人姓名")
	private String auditAdminName;          // 审核人姓名
	@ApiModelProperty(value = "审核时间")
	private Date auditDate;                 // 审核时间

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getIdCardImage() {
		return idCardImage;
	}

	public void setIdCardImage(String idCardImage) {
		this.idCardImage = idCardImage;
	}

	public String getAuditStatusId() {
		return auditStatusId;
	}

	public void setAuditStatusId(String auditStatusId) {
		this.auditStatusId = auditStatusId;
	}

	public String getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}

	public String getAuditAdminId() {
		return auditAdminId;
	}

	public void setAuditAdminId(String auditAdminId) {
		this.auditAdminId = auditAdminId;
	}

	public String getAuditAdminName() {
		return auditAdminName;
	}

	public void setAuditAdminName(String auditAdminName) {
		this.auditAdminName = auditAdminName;
	}

	public Date getAuditDate() {
		return auditDate;
	}

	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}

	/**
	 * <b>将实体对象转换成视图对象</b>
	 * @param entity
	 * @return
	 */
	public static LinkmanVO parseFromVO(Linkman entity) {
		// 创建视图对象
		LinkmanVO vo = new LinkmanVO();
		// 进行普通属性切换
		BeanUtils.copyProperties(entity,vo);
		// 关联属性的转换
		if (entity.getTravelAgency() != null) {
			vo.setTravelAgencyId(entity.getTravelAgency().getId());
			vo.setTravelAgency(entity.getTravelAgency().getName());
		}

		if (entity.getAuditStatus() != null) {
			vo.setAuditStatusId(entity.getAuditStatus().getId());
			vo.setAuditStatus(entity.getAuditStatus().getCode());
			vo.setAuditStatus(entity.getAuditStatus().getText());
		}

		if (entity.getAuditAdmin() != null) {
			vo.setAuditAdminId(entity.getAuditAdmin().getId());
			vo.setAuditAdminName(entity.getAuditAdmin().getName());
		}
		return vo;
	}

	/**
	 * <b>将实体列表切换成视图列表</b>
	 * @param entityList
	 * @return
	 */
	public static List<LinkmanVO> parseFromVOList(List<Linkman> entityList) throws Exception{
		List<LinkmanVO> voList = new ArrayList<LinkmanVO>();
		// 实体列表可用
		if (entityList != null && !entityList.isEmpty()) {
			for (Linkman entity : entityList) {
				LinkmanVO vo = parseFromVO(entity);
				voList.add(vo);
			}
		}
		return voList;
	}
}
