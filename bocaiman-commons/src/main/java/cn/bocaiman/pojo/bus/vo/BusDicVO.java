package cn.bocaiman.pojo.bus.vo;

import cn.bocaiman.base.pojo.vo.BaseVO;
import cn.bocaiman.pojo.bus.entity.BusDic;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-大巴车管理-大巴车字典视图信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@ApiModel("菠菜侠旅游租赁平台-大巴车管理-大巴车字典视图信息")
public class BusDicVO extends BaseVO {
	private static final long serialVersionUID = 7184353468707572822L;
	@ApiModelProperty(value = "主键")
	private String id;                          // 主键
	@ApiModelProperty(value = "上级车辆字典主键")
	private String parentId;                    // 上级车辆字典主键
	@ApiModelProperty(value = "上级车辆字典名称")
	private String parentName;                  // 上级车辆字典名称
	@ApiModelProperty(value = "字典名称")
	private String name;                        // 字典名称

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

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * <b>将实体对象切换为视图对象</b>
	 * @param entity
	 * @return
	 */
	public static BusDicVO parseFromVO(BusDic entity) {
		// 创建实体对象
		BusDicVO vo = new BusDicVO();
		// 进行普通属性切换
		BeanUtils.copyProperties(entity, vo);
		// 切换关联属性
		if (entity.getParent() != null) {
			vo.setParentId(entity.getParent().getId());
			vo.setParentName(entity.getParent().getName());
		}

		return vo;
	}

	/**
	 * <b>将实体列表切换为视图列表</b>
	 * @param entityList
	 * @return
	 */
	public static List<BusDicVO> parseFromVOList(List<BusDic> entityList) {
		List<BusDicVO> voList = new ArrayList<BusDicVO>();
		// 实体列表可用
		if (entityList != null && !entityList.isEmpty()) {
			for (BusDic entity : entityList) {
				voList.add(parseFromVO(entity));
			}
		}

		return voList;
	}
}
