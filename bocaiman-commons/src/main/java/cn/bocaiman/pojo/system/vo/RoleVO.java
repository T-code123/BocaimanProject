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
 * <b>菠菜侠旅游租赁平台-系统管理-角色视图信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@ApiModel("菠菜侠旅游租赁平台-系统管理-角色视图信息")
public class RoleVO extends BaseVO {
	private static final long serialVersionUID = 457135895093196880L;
	@ApiModelProperty(value = "主键")
	private String id;                      // 主键
	@ApiModelProperty(value = "名称")
	private String name;                    // 名称
	@ApiModelProperty(value = "编码")
	private String code;                    // 编码
	@ApiModelProperty(value = "菜单列表")
	private List<Menu> menuList;            // 菜单列表

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
	 * <b>将实体对象切换成视图对象</b>
	 * @param entity
	 * @return
	 */
	public static RoleVO parseFromVO(Role entity){
		// 创建实体对象
		RoleVO vo = new RoleVO();
		// 进行普通属性切换
		BeanUtils.copyProperties(entity,vo);

		return vo;
	}

	/**
	 * <b>将实体列表切换为视图列表</b>
	 * @param entityList
	 * @return
	 */
	public static List<RoleVO> parseFromVOList(List<Role> entityList){
		// 创建视图列表
		List<RoleVO> voList = new ArrayList<RoleVO>();
		// 实体列表可用
		if (entityList != null && !entityList.isEmpty()){
			for (Role entity: entityList) {
				voList.add(parseFromVO(entity));
			}
		}
		return voList;
	}
}
