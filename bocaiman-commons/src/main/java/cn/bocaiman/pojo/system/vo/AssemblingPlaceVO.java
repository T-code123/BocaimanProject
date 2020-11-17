package cn.bocaiman.pojo.system.vo;

import cn.bocaiman.base.pojo.vo.BaseVO;
import cn.bocaiman.pojo.system.entity.Area;
import cn.bocaiman.pojo.system.entity.AssemblingPlace;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-系统管理-出发集合地点视图信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@ApiModel("菠菜侠旅游租赁平台-系统管理-出发集合地点视图信息")
public class AssemblingPlaceVO extends BaseVO {
	private static final long serialVersionUID = -7642244874111387807L;
	@ApiModelProperty(value = "主键")
	private String id;                      // 主键
	@ApiModelProperty(value = "区域主键")
	private String areaId;                  // 区域主键
	@ApiModelProperty(value = "区域名称")
	private String areaText;                // 区域名称
	@ApiModelProperty(value = "区域编号")
	private String areaCode;                // 区域编号
	@ApiModelProperty(value = "详细地址")
	private String detail;                  // 详细地址

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public String getAreaText() {
		return areaText;
	}

	public void setAreaText(String areaText) {
		this.areaText = areaText;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	/**
	 * <b>将实体对象转换成视图对象</b>
	 * @param entity
	 * @return
	 */
	public static AssemblingPlaceVO parseFromVO(AssemblingPlace entity) {
		// 创建视图对象
		AssemblingPlaceVO vo = new AssemblingPlaceVO();
		// 拷贝普通属性
		BeanUtils.copyProperties(entity,vo);

		// 关联属性的转化
		if (entity.getArea() != null) {
			vo.setAreaId(entity.getArea().getId());
			vo.setAreaText(entity.getArea().getText());
			vo.setAreaCode(entity.getArea().getCode());
		}
		return vo;
	}

	/**
	 * <b>将实体列表转换成视图列表</b>
	 * @param entityList
	 * @return
	 */
	public static List<AssemblingPlaceVO> parseFromVOList(List<AssemblingPlace> entityList) {
		// 创建视图列表
		List<AssemblingPlaceVO> voList = new ArrayList<AssemblingPlaceVO>();
		// 实体列表可用
		if (entityList != null && !entityList.isEmpty()) {
			for (AssemblingPlace entity: entityList) {
				AssemblingPlaceVO vo = parseFromVO(entity);
				voList.add(vo);
			}
		}
		return voList;
	}
}
