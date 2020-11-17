package cn.bocaiman.pojo.agency.entity;

import cn.bocaiman.base.pojo.entity.BaseEntity;
import cn.bocaiman.pojo.agency.vo.LinkmanVO;
import cn.bocaiman.pojo.agency.vo.PointUseTypeVO;
import cn.bocaiman.pojo.system.entity.Admin;
import cn.bocaiman.pojo.system.entity.AuditStatus;
import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * <b>菠菜侠旅游租赁平台-旅行社管理-常用联系人实体信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public class Linkman extends BaseEntity {
	private static final long serialVersionUID = -3654436639299023229L;
	private String id;                      // 主键
	private TravelAgency travelAgency;      // 所属旅行社
	private String name;                    // 联系人姓名
	private String cellphone;               // 手机号码
	private String idCard;                  // 身份证号码
	private String idCardImage;             // 身份证照片
	private AuditStatus auditStatus;        // 审核状态
	private Admin auditAdmin;               // 审核人
	private Date auditDate;                 // 审核时间

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
	 */
	public static Linkman parseFromEntity(LinkmanVO vo) {
		// 创建实体对象
		Linkman entity = new Linkman();
		// 进行普通属性切换
		BeanUtils.copyProperties(vo,entity);
		// 关联属性的转换
		TravelAgency travelAgency = new TravelAgency();
		travelAgency.setId(vo.getTravelAgencyId());
		travelAgency.setName(vo.getTravelAgency());
		entity.setTravelAgency(travelAgency);

		AuditStatus auditStatus = new AuditStatus();
		auditStatus.setId(vo.getAuditAdminId());
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
