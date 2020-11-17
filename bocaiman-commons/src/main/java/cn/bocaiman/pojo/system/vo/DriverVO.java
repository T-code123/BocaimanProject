package cn.bocaiman.pojo.system.vo;

import cn.bocaiman.base.pojo.vo.BaseVO;
import cn.bocaiman.pojo.system.entity.Admin;
import cn.bocaiman.pojo.system.entity.Driver;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-系统管理-司机视图信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@ApiModel("菠菜侠旅游租赁平台-系统管理-司机视图信息")
public class DriverVO extends BaseVO {
	private static final long serialVersionUID = 1651924984699097301L;
	@ApiModelProperty(value = "主键")
	private String id;                          // 主键
	@ApiModelProperty(value = "司机主键")
	private String DriverId;                    // 司机主键
	@ApiModelProperty(value = "用户姓名")
	private String name;                        // 用户姓名
	@ApiModelProperty(value = "手机号码")
	private String cellphone;                   // 手机号码
	@ApiModelProperty(value = "登录密码")
	private String password;                    // 登录密码
	@ApiModelProperty(value = "身份证")
	private String idCard;                      // 身份证
	@ApiModelProperty(value = "身份证照片")
	private String idCardImage;                 // 身份证照片
	@ApiModelProperty(value = "司机驾照")
	private String driverLicence;               // 司机驾照
	@ApiModelProperty(value = "驾照照片")
	private String driverLicenceImage;          // 驾照照片
	@ApiModelProperty(value = "司机状态主键")
	private String driverStatusId;              // 司机状态主键
	@ApiModelProperty(value = "司机状态文本")
	private String driverStatusText;            // 司机状态文本
	@ApiModelProperty(value = "司机状态编码")
	private String driverStatusCode;            // 司机状态编码

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDriverId() {
		return DriverId;
	}

	public void setDriverId(String driverId) {
		DriverId = driverId;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getDriverLicence() {
		return driverLicence;
	}

	public void setDriverLicence(String driverLicence) {
		this.driverLicence = driverLicence;
	}

	public String getDriverLicenceImage() {
		return driverLicenceImage;
	}

	public void setDriverLicenceImage(String driverLicenceImage) {
		this.driverLicenceImage = driverLicenceImage;
	}

	public String getDriverStatusId() {
		return driverStatusId;
	}

	public void setDriverStatusId(String driverStatusId) {
		this.driverStatusId = driverStatusId;
	}

	public String getDriverStatusText() {
		return driverStatusText;
	}

	public void setDriverStatusText(String driverStatusText) {
		this.driverStatusText = driverStatusText;
	}

	public String getDriverStatusCode() {
		return driverStatusCode;
	}

	public void setDriverStatusCode(String driverStatusCode) {
		this.driverStatusCode = driverStatusCode;
	}

	/**
	 * <b>将 Entity 对象转换成 VO 对象</b>
	 * @param entity
	 * @return
	 */
	public static DriverVO parseFromVO(Driver entity) {
		// 创建 VO 对象
		DriverVO vo = new DriverVO();
		// 将 Entity 中的属性提取，设定到 VO 中
		// 借助于 Spring 所提供的 BeanUtils 来拷贝属性值（仅限普通的,只有属性名和属性类型相同才拷贝）
		BeanUtils.copyProperties(entity, vo);
		// 设定关联属性值
		if (entity.getAdmin() != null) {
			vo.setDriverId(entity.getAdmin().getId());
			vo.setName(entity.getAdmin().getName());
			vo.setCellphone(entity.getAdmin().getCellphone());
			vo.setPassword(entity.getAdmin().getPassword());
			vo.setIdCard(entity.getAdmin().getIdCard());
			vo.setIdCardImage(entity.getAdmin().getIdCardImage());
		}
		if (entity.getDriverStatus() != null ){
			vo.setDriverStatusId(entity.getDriverStatus().getId());
			vo.setDriverStatusText(entity.getDriverStatus().getText());
			vo.setDriverStatusCode(entity.getDriverStatus().getCode());
		}
		return vo;
	}

	/**
	 * <b>将实体列表切换成视图列表</b>
	 * @param entityList
	 * @return
	 */
	public static List<DriverVO> parseFromVOList(List<Driver> entityList) {
		List<DriverVO> voList = new ArrayList<DriverVO>();
		// 实体列表可用
		if (entityList != null && !entityList.isEmpty()) {
			for (Driver entity : entityList) {
				DriverVO vo = parseFromVO(entity);
				voList.add(vo);
			}
		}
		return voList;
	}
}
