package cn.bocaiman.pojo.system.vo;

import cn.bocaiman.base.pojo.vo.BaseVO;
import cn.bocaiman.pojo.system.entity.Menu;
import cn.bocaiman.pojo.system.entity.Role;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-系统管理-菜单视图信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@ApiModel("菠菜侠旅游租赁平台-系统管理-菜单视图信息")
public class MenuVO extends BaseVO {
	private static final long serialVersionUID = 6022559256025873920L;
	@ApiModelProperty(value = "主键")
	private String id;                      // 主键
	@ApiModelProperty(value = "上级菜单主键")
	private String parentId;                // 上级菜单主键
	@ApiModelProperty(value = "上级菜单文本")
	private String parentText;              // 上级菜单文本
	@ApiModelProperty(value = "上级菜单连接地址")
	private String parentUrl;               // 上级菜单连接地址
	@ApiModelProperty(value = "上级菜单图标")
	private String parentIcon;              // 上级菜单图标
	@ApiModelProperty(value = "文本")
	private String text;                    // 文本
	@ApiModelProperty(value = "连接地址")
	private String url;                     // 连接地址
	@ApiModelProperty(value = "图标")
	private String icon;                    // 图标
	@ApiModelProperty(value = "下级菜单")
	private List<Menu> childList;           // 下级菜单
	@ApiModelProperty(value = "角色列表")
	private List<Role> roleList;            // 角色列表

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getParentText() {
		return parentText;
	}

	public void setParentText(String parentText) {
		this.parentText = parentText;
	}

	public String getParentUrl() {
		return parentUrl;
	}

	public void setParentUrl(String parentUrl) {
		this.parentUrl = parentUrl;
	}

	public String getParentIcon() {
		return parentIcon;
	}

	public void setParentIcon(String parentIcon) {
		this.parentIcon = parentIcon;
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
	 * <b>将实体对象切换成视图对象</b>
	 * @param entity
	 * @return
	 */
	public static MenuVO parseFromVO(Menu entity){
		// 创建实体对象
		MenuVO vo = new MenuVO();
		// 进行普通属性切换
		BeanUtils.copyProperties(entity,vo);
		// 切换关联属性
		if (entity.getParent() != null){
			vo.setParentId(entity.getParent().getId());
			vo.setParentText(entity.getParent().getText());
			vo.setParentUrl(entity.getParent().getUrl());
			vo.setParentIcon(entity.getParent().getIcon());
		}

		return vo;
	}

	/**
	 * <b>将实体列表切换为视图列表</b>
	 * @param entityList
	 * @return
	 */
	public static List<MenuVO> parseFromVOList(List<Menu> entityList){
		// 创建视图列表
		List<MenuVO> voList = new ArrayList<MenuVO>();
		// 实体列表可用
		if (entityList != null && !entityList.isEmpty()){
			for (Menu entity: entityList) {
				voList.add(parseFromVO(entity));
			}
		}
		return voList;
	}
}
