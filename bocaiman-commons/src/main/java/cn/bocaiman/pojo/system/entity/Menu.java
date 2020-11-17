package cn.bocaiman.pojo.system.entity;

import cn.bocaiman.base.pojo.entity.BaseEntity;
import cn.bocaiman.pojo.system.vo.AdminVO;
import cn.bocaiman.pojo.system.vo.MenuVO;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-系统管理-菜单实体信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public class Menu extends BaseEntity {
	private static final long serialVersionUID = -2899539102949078451L;
	private String id;                      // 主键
	private Menu parent;                    // 上级菜单
	private String text;                    // 文本
	private String url;                     // 链接地址
	private String icon;                    // 图标
	private List<Menu> childList;           // 下级菜单
	private List<Role> roleList;            // 角色列表


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Menu getParent() {
		return parent;
	}

	public void setParent(Menu parent) {
		this.parent = parent;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public List<Menu> getChildList() {
		return childList;
	}

	public void setChildList(List<Menu> childList) {
		this.childList = childList;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	/**
	 * <b>将视图对象转换成实体对象</b>
	 * @param vo
	 * @return
	 */
	public static Menu parseFromEntity(MenuVO vo){
		Menu entity = new Menu();
		// 将 VO 中的属性提取，设定到 Entity 中
		// entity.setId(vo.getId());
		// 借助于 Spring 所提供的 BeanUtils 来拷贝属性值（仅限普通的,只有属性名和属性类型相同才拷贝）
		BeanUtils.copyProperties(vo,entity);
		// 创建关联属性


		return entity;

	}
}
