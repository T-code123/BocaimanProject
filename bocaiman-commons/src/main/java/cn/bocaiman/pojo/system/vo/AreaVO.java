package cn.bocaiman.pojo.system.vo;

import cn.bocaiman.base.pojo.vo.BaseVO;
import cn.bocaiman.pojo.system.entity.Area;
import cn.bocaiman.pojo.system.entity.Area;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-系统管理-区域视图信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@ApiModel("菠菜侠旅游租赁平台-系统管理-区域视图信息")
public class AreaVO extends BaseVO {
	private static final long serialVersionUID = 3632059068601315719L;
	@ApiModelProperty(value = "主键")
	private String id;                       // 主键
	@ApiModelProperty(value = "上级区域主键")
	private String parentId;                 // 上级区域主键
	@ApiModelProperty(value = "上级区域文本")
	private String parentText;               // 上级区域文本
	@ApiModelProperty(value = "上级区域编码")
	private String parentCode;               // 上级区域编码
	@ApiModelProperty(value = "区域文本")
	private String text;                     // 区域文本
	@ApiModelProperty(value = "区域编码")
	private String code;                     // 区域编码

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

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}


	/**
	 * <b>将实体对象转换成视图对象</b>
	 * @param entity
	 * @return
	 */
	public static AreaVO parseFromVO(Area entity) {
		// 创建视图对象
		AreaVO vo = new AreaVO();
		// 进行普通属性切换
		BeanUtils.copyProperties(entity,vo);
		// 进行关联属性的切换
		if (entity.getParent() != null) {
			vo.setParentId(entity.getParent().getId());
			vo.setText(entity.getText());
			vo.setCode(entity.getCode());
		}
		return vo;
	}

	/**
	 * <b>将实体列表切换成视图列表</b>
	 * @param entityList
	 * @return
	 */
	public static List<AreaVO> parseFromVOList(List<Area> entityList) {
		List<AreaVO> voList = new ArrayList<AreaVO>();
		// 实体列表可用
		if (entityList != null && !entityList.isEmpty()) {
			for (Area entity : entityList) {
				AreaVO vo = parseFromVO(entity);
				voList.add(vo);
			}
		}
		return voList;
	}
}
