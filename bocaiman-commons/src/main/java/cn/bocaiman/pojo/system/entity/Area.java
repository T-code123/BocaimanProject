package cn.bocaiman.pojo.system.entity;

import cn.bocaiman.base.pojo.entity.BaseEntity;
import cn.bocaiman.pojo.system.vo.AreaVO;
import org.springframework.beans.BeanUtils;

/**
 * <b>菠菜侠旅游租赁平台-系统管理-区域实体信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public class Area extends BaseEntity {
	private static final long serialVersionUID = -427082838858154407L;
	private String id;                      // 主键
	private Area parent;                    // 上级区域
	private String text;                    // 区域文本
	private String code;                    // 区域编码

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Area getParent() {
		return parent;
	}

	public void setParent(Area parent) {
		this.parent = parent;
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
	 * <b>将视图对象转换成实体对象</b>
	 * @param vo
	 * @return
	 */
	public static Area parseFromEntity(AreaVO vo) {
		// 创建实体对象
		Area entity = new Area();
		// 进行普通属性转换
		BeanUtils.copyProperties(vo,entity);
		// 进行特有属性转换
		Area parent = new Area();
		parent.setId(vo.getParentId());
		parent.setText(vo.getText());
		parent.setCode(vo.getCode());
		entity.setParent(parent);

		return entity;
	}
}
