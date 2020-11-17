package cn.bocaiman.pojo.system.entity;

import cn.bocaiman.base.pojo.entity.BaseEntity;
import cn.bocaiman.pojo.system.vo.DriverVO;
import org.springframework.beans.BeanUtils;

/**
 * <b>菠菜侠旅游租赁平台-系统管理-司机实体信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public class Driver extends BaseEntity {
	private static final long serialVersionUID = -8768313340517342593L;
	private String id;                          // 主键
	private Admin admin;                        // 司机信息
	private String driverLicense;               // 司机驾照
	private String driverLicenceImage;          // 驾照照片
	private DriverStatus driverStatus;          // 司机状态

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public String getDriverLicense() {
		return driverLicense;
	}

	public void setDriverLicense(String driverLicense) {
		this.driverLicense = driverLicense;
	}

	public String getDriverLicenceImage() {
		return driverLicenceImage;
	}

	public void setDriverLicenceImage(String driverLicenceImage) {
		this.driverLicenceImage = driverLicenceImage;
	}

	public DriverStatus getDriverStatus() {
		return driverStatus;
	}

	public void setDriverStatus(DriverStatus driverStatus) {
		this.driverStatus = driverStatus;
	}

	/**
	 * <b>将视图对象转换成实体对象</b>
	 * @param vo
	 * @return
	 */
	public static Driver parseFromEntity(DriverVO vo){
		Driver entity = new Driver();
		// 将 VO 中的属性提取，设定到 Entity 中
		// entity.setId(vo.getId());
		// 借助于 Spring 所提供的 BeanUtils 来拷贝属性值（仅限普通的,只有属性名和属性类型相同才拷贝）
		BeanUtils.copyProperties(vo,entity);
		// 创建关联属性
		Admin admin = new Admin();
		admin.setId(vo.getDriverId());
		admin.setName(vo.getName());
		admin.setCellphone(vo.getCellphone());
		admin.setPassword(vo.getPassword());
		admin.setIdCard(vo.getIdCard());
		admin.setIdCardImage(vo.getIdCardImage());
		entity.setAdmin(admin);

		DriverStatus driverStatus = new DriverStatus();
		driverStatus.setId(vo.getDriverStatusId());
		driverStatus.setText(vo.getDriverStatusText());
		driverStatus.setCode(vo.getDriverStatusCode());
		entity.setDriverStatus(driverStatus);

		return entity;

	}
}
