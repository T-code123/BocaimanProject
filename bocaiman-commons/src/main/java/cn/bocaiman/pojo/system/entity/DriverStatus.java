package cn.bocaiman.pojo.system.entity;

import cn.bocaiman.base.pojo.entity.BaseEntity;
import cn.bocaiman.pojo.system.vo.DriverStatusVO;
import org.springframework.beans.BeanUtils;


/**
 * <b>菠菜侠旅游租赁平台-系统管理-司机状态实体信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public class DriverStatus extends BaseEntity {
	private static final long serialVersionUID = -5550141173484293624L;
	private String id;                      // 主键
	private String text;                    // 状态文本
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
	public static DriverStatus parseFromEntity(DriverStatusVO vo) {
		// 创建实体对象
		DriverStatus entity = new DriverStatus();
		// 拷贝普通属性
		BeanUtils.copyProperties(vo,entity);

		return entity;
	}

}
