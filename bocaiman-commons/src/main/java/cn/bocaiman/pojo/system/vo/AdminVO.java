package cn.bocaiman.pojo.system.vo;

import cn.bocaiman.base.pojo.vo.BaseVO;
import cn.bocaiman.pojo.system.entity.Admin;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-系统管理-管理员视图信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@ApiModel("菠菜侠旅游租赁平台-系统管理-管理员视图信息")
public class AdminVO extends BaseVO {
	private static final long serialVersionUID = 8114179208347148114L;
	@ApiModelProperty(value = "主键")
	private String id;                          // 主键
	@ApiModelProperty(value = "用户姓名")
	private String name;                        // 用户姓名
	@ApiModelProperty(value = "手机号码")
	private String cellphone;                   // 手机号码
	@ApiModelProperty(value = "登录密码")
	private String password;                    // 登录密码，MD5加密
	@ApiModelProperty(value = "对应角色主键")
	private String roleId;                      // 对应角色主键
	@ApiModelProperty(value = "角色名称")
	private String roleName;                    // 角色名称
	@ApiModelProperty(value = "角色编号")
	private String roleCode;                    // 角色编号
	@ApiModelProperty(value = "身份证")
	private String idCard;                      // 身份证
	@ApiModelProperty(value = "身份证照片")
	private String idCardImage;                 // 身份证照片

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

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
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

	/**
	 * <b>将 Entity 对象转换成 VO 对象</b>
	 * @param entity
	 * @return
	 */
	public static AdminVO parseFromVO(Admin entity) {
		// 创建 VO 对象
		AdminVO vo = new AdminVO();
		// 将 Entity 中的属性提取，设定到 VO 中
		// 借助于 Spring 所提供的 BeanUtils 来拷贝属性值（仅限普通的,只有属性名和属性类型相同才拷贝）
		BeanUtils.copyProperties(entity, vo);
		// 设定关联属性值
		if (entity.getRole() != null) {
			vo.setRoleId(entity.getRole().getId());
			vo.setRoleName(entity.getRole().getName());
			vo.setRoleCode(entity.getRole().getCode());
		}
		return vo;
	}

	/**
	 * <b>将实体列表切换成视图列表</b>
	 * @param entityList
	 * @return
	 */
	public static List<AdminVO> parseFromVOList(List<Admin> entityList) {
		List<AdminVO> voList = new ArrayList<AdminVO>();
		// 实体列表可用
		if (entityList != null && !entityList.isEmpty()) {
			for (Admin entity : entityList) {
				AdminVO vo = parseFromVO(entity);
				voList.add(vo);
			}
		}
		return voList;
	}
}
