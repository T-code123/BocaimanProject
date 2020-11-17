package cn.bocaiman.pojo.agency.entity;

import cn.bocaiman.base.pojo.entity.BaseEntity;
import cn.bocaiman.pojo.agency.vo.PointUseTypeVO;
import org.springframework.beans.BeanUtils;

/**
 * <b>菠菜侠旅游租赁平台-旅行社管理-积分使用类型实体信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public class PointUseType extends BaseEntity {
	private static final long serialVersionUID = -2413904203727091811L;
	private String id;                      // 主键
	private String text;                    // 文本
	private String code;                    // 编码

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
	public static PointUseType parseFromEntity(PointUseTypeVO vo) {
		// 创建实体对象
		PointUseType entity = new PointUseType();
		// 进行普通属性切换
		BeanUtils.copyProperties(vo,entity);

		return entity;
	}

	
}
