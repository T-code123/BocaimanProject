package cn.bocaiman.pojo.agency.vo;

import cn.bocaiman.base.pojo.vo.BaseVO;
import cn.bocaiman.pojo.agency.entity.Linkman;
import cn.bocaiman.pojo.agency.entity.TravelAgency;
import cn.bocaiman.pojo.system.entity.Admin;
import cn.bocaiman.pojo.system.entity.AuditStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-旅行社管理-旅行社视图信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@ApiModel("菠菜侠旅游租赁平台-旅行社管理-旅行社视图信息")
public class TravelAgencyVO extends BaseVO {
	private static final long serialVersionUID = -5335119950555140756L;
	@ApiModelProperty(value = "主键")
	private String id;                          // 主键
	@ApiModelProperty(value = "旅行社名称")
	private String name;                        // 旅行社名称
	@ApiModelProperty(value = "旅行许可证编号")
	private String travelLicence;               // 旅行许可证编号
	@ApiModelProperty(value = "旅行许可证照片")
	private String travelLicenceImage;          // 旅行许可证照片
	@ApiModelProperty(value = "统一社会信用代码")
	private String uscc;                        // 统一社会信用代码
	@ApiModelProperty(value = "法人代表")
	private String legalRep;                    // 法人代表
	@ApiModelProperty(value = "法人代表身份证号码")
	private String legalRepIdCard;              // 法人代表身份证号码
	@ApiModelProperty(value = "法人代表身份证照片")
	private String legalRepIdCardImage;         // 法人代表身份证照片
	@ApiModelProperty(value = "经营许可证")
	private String businessLicence;             // 经营许可证
	@ApiModelProperty(value = "经营许可证照片")
	private String businessLicenceImage;        // 经营许可证照片
	@ApiModelProperty(value = "联系人手机号码")
	private String cellphone;                   // 联系人手机号码
	@ApiModelProperty(value = "登录密码")
	private String password;                    // 登录密码
	@ApiModelProperty(value = "旅行社积分")
	private Integer point;                      // 旅行社积分
	@ApiModelProperty(value = "审核状态主键")
	private String auditStatusId;               // 审核状态主键
	@ApiModelProperty(value = "审核状态文本")
	private String auditStatus;                 // 审核状态文本
	@ApiModelProperty(value = "审核人主键")
	private String auditAdminId;                // 审核人主键
	@ApiModelProperty(value = "审核人姓名")
	private String auditAdminName;              // 审核人姓名
	@ApiModelProperty(value = "审核时间")
	private Date auditDate;                     // 审核时间

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTravelLicence() {
		return travelLicence;
	}

	public void setTravelLicence(String travelLicence) {
		this.travelLicence = travelLicence;
	}

	public String getTravelLicenceImage() {
		return travelLicenceImage;
	}

	public void setTravelLicenceImage(String travelLicenceImage) {
		this.travelLicenceImage = travelLicenceImage;
	}

	public String getUscc() {
		return uscc;
	}

	public void setUscc(String uscc) {
		this.uscc = uscc;
	}

	public String getLegalRep() {
		return legalRep;
	}

	public void setLegalRep(String legalRep) {
		this.legalRep = legalRep;
	}

	public String getLegalRepIdCard() {
		return legalRepIdCard;
	}

	public void setLegalRepIdCard(String legalRepIdCard) {
		this.legalRepIdCard = legalRepIdCard;
	}

	public String getLegalRepIdCardImage() {
		return legalRepIdCardImage;
	}

	public void setLegalRepIdCardImage(String legalRepIdCardImage) {
		this.legalRepIdCardImage = legalRepIdCardImage;
	}

	public String getBusinessLicence() {
		return businessLicence;
	}

	public void setBusinessLicence(String businessLicence) {
		this.businessLicence = businessLicence;
	}

	public String getBusinessLicenceImage() {
		return businessLicenceImage;
	}

	public void setBusinessLicenceImage(String businessLicenceImage) {
		this.businessLicenceImage = businessLicenceImage;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
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
	 * @throws Exception
	 */
	public static TravelAgencyVO parseFromVO(TravelAgency entity) throws Exception {
		TravelAgencyVO vo = new TravelAgencyVO();
		// 普通属性转换
		BeanUtils.copyProperties(entity,vo);
		// 关联属性的转换
		if (entity.getAuditStatus() != null ) {
			vo.setAuditStatus(entity.getAuditStatus().getId());
			vo.setAuditStatus(entity.getAuditStatus().getText());
			vo.setAuditStatus(entity.getAuditStatus().getCode());
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
	public static List<TravelAgencyVO> parseFromVOList(List<TravelAgency> entityList) throws Exception{
		List<TravelAgencyVO> voList = new ArrayList<TravelAgencyVO>();
		// 实体列表可用
		if (entityList != null && !entityList.isEmpty()) {
			for (TravelAgency entity : entityList) {
				TravelAgencyVO vo = parseFromVO(entity);
				voList.add(vo);
			}
		}
		return voList;
	}
}
