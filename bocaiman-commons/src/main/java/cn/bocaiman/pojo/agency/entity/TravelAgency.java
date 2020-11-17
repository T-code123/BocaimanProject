package cn.bocaiman.pojo.agency.entity;

import cn.bocaiman.base.pojo.entity.BaseEntity;
import cn.bocaiman.pojo.agency.vo.TravelAgencyVO;
import cn.bocaiman.pojo.system.entity.Admin;
import cn.bocaiman.pojo.system.entity.AuditStatus;
import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * <b>菠菜侠旅游租赁平台-旅行社管理-旅行社实体信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public class TravelAgency extends BaseEntity {
	private static final long serialVersionUID = 8546300072902169367L;
	private String id;                          // 主键
	private String name;                        // 旅行社名称
	private String travelLicence;               // 旅行许可证编号
	private String travelLicenceImage;          // 旅行许可证照片
	private String uscc;                        // 统一社会信用代码
	private String legalRep;                    // 法人代表
	private String legalRepIdCard;              // 法人代表身份证号码
	private String legalRepIdCardImage;         // 法人代表身份证照片
	private String businessLicence;             // 经营许可证
	private String businessLicenceImage;        // 经营许可证照片
	private String cellphone;                   // 联系人手机号码
	private String password;                    // 登录密码
	private Integer point;                      // 旅行社积分
	private AuditStatus auditStatus;            // 审核状态
	private Admin auditAdmin;                   // 审核人
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

	public AuditStatus getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(AuditStatus auditStatus) {
		this.auditStatus = auditStatus;
	}

	public Admin getAuditAdmin() {
		return auditAdmin;
	}

	public void setAuditAdmin(Admin auditAdmin) {
		this.auditAdmin = auditAdmin;
	}

	public Date getAuditDate() {
		return auditDate;
	}

	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}

	/**
	 * <b>将视图对象转换成实体对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public static TravelAgency parseFromEntity(TravelAgencyVO vo) throws Exception {
		TravelAgency entity = new TravelAgency();
		// 普通属性转换
		BeanUtils.copyProperties(vo,entity);
		// 关联属性的转换
		AuditStatus auditStatus = new AuditStatus();
		auditStatus.setId(vo.getAuditStatusId());
		auditStatus.setText(vo.getAuditStatus());
		auditStatus.setCode(vo.getAuditStatus());
		entity.setAuditStatus(auditStatus);

		Admin admin = new Admin();
		admin.setId(vo.getAuditAdminId());
		admin.setName(vo.getAuditAdminName());
		entity.setAuditAdmin(admin);

		return entity;
	}

}
