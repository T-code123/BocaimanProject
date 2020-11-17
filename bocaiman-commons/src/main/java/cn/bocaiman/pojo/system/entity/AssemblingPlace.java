package cn.bocaiman.pojo.system.entity;

import cn.bocaiman.base.pojo.entity.BaseEntity;
import cn.bocaiman.pojo.system.vo.AssemblingPlaceVO;
import org.springframework.beans.BeanUtils;

/**
 * <b>菠菜侠旅游租赁平台-系统管理-出发集合地点实体信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public class AssemblingPlace extends BaseEntity {
	private static final long serialVersionUID = 6025486679181586308L;
	private String id;                      // 主键
	private Area area;                      // 区域信息
	private String detail;                  // 详细地址

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	/**
	 * <b>将视图对象转换成实体对象</b>
	 * @param vo
	 * @return
	 */
	public static AssemblingPlace parseFromEntity(AssemblingPlaceVO vo) {
		// 创建实体对象
		AssemblingPlace entity = new AssemblingPlace();
		// 进行普通属性的切换
		BeanUtils.copyProperties(vo,entity);

		// 关联属性的转换
		Area area = new Area();
		area.setId(vo.getId());
		area.setText(vo.getAreaText());
		area.setCode(vo.getAreaCode());
		entity.setArea(area);

		return entity;
	}
}
