package cn.bocaiman.pojo.system.entity;

import cn.bocaiman.base.pojo.entity.BaseEntity;
import cn.bocaiman.pojo.system.vo.MenuVO;
import cn.bocaiman.pojo.system.vo.RoleVO;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-系统管理-角色实体信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public class Role extends BaseEntity {
	private static final long serialVersionUID = -2420559807993884758L;
	private String id;                  // 主键
	private String name;                // 名称
	private String code;                // 编码
	private List<Menu> menuList;        // 菜单列表

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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}


	/**
	 * <b>将视图对象转换成实体对象</b>
	 * @param vo
	 * @return
	 */
	public static Role parseFromEntity(RoleVO vo){
		Role entity = new Role();
		// 将 VO 中的属性提取，设定到 Entity 中
		// entity.setId(vo.getId());
		// 借助于 Spring 所提供的 BeanUtils 来拷贝属性值（仅限普通的,只有属性名和属性类型相同才拷贝）
		BeanUtils.copyProperties(vo,entity);
		// 创建关联属性

		return entity;

	}
}
