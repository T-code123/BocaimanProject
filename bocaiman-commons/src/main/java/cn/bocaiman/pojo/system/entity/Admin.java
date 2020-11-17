package cn.bocaiman.pojo.system.entity;

import cn.bocaiman.base.pojo.entity.BaseEntity;
import cn.bocaiman.pojo.system.vo.AdminVO;
import org.springframework.beans.BeanUtils;


/**
 * <b>菠菜侠旅游租赁平台-系统管理-管理员实体信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public class Admin extends BaseEntity {
	private static final long serialVersionUID = 5399545565057221468L;
	private String id;                          // 主键
	private String name;                        // 用户姓名
	private String cellphone;                   // 手机号码
	private String password;                    // 登录密码，MD5加密
	private Role role;                          // 对应角色
	private String idCard;                      // 身份证号码
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
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
	 * <b>将视图对象转换成实体对象</b>
	 * @param vo
	 * @return
	 */
	public static Admin parseFromEntity(AdminVO vo){
		Admin entity = new Admin();
		// 将 VO 中的属性提取，设定到 Entity 中
		// entity.setId(vo.getId());
		// 借助于 Spring 所提供的 BeanUtils 来拷贝属性值（仅限普通的,只有属性名和属性类型相同才拷贝）
		BeanUtils.copyProperties(vo,entity);
		// 创建关联属性
		Role role = new Role();
		role.setId(vo.getRoleId());
		role.setName(vo.getRoleName());
		role.setCode(vo.getRoleCode());
		entity.setRole(role);

		return entity;

	}


}
