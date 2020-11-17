package cn.bocaiman.pojo.bus.entity;

import cn.bocaiman.base.pojo.entity.BaseEntity;
import cn.bocaiman.pojo.bus.vo.BusDicVO;
import cn.bocaiman.pojo.bus.vo.BusStatusVO;
import org.springframework.beans.BeanUtils;

/**
 * <b>菠菜侠旅游租赁平台-大巴车管理-大巴车字典实体信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public class BusDic extends BaseEntity {
	private static final long serialVersionUID = -2904748570603485448L;
	private String id;                           // 主键
	private BusDic parent;                      // 上级车辆字典
	private String name;                        // 字典名称

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BusDic getParent() {
		return parent;
	}

	public void setParent(BusDic parent) {
		this.parent = parent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	/**
	 * <b>将视图对象切换为实体对象</b>
	 * @param vo
	 * @return
	 */
	public static BusDic parseFromEntity(BusDicVO vo) {
		// 创建实体对象
		BusDic entity = new BusDic();
		// 进行普通属性切换
		BeanUtils.copyProperties(vo, entity);
		// 切换关联属性
		BusDic parent = new BusDic();
		parent.setId(vo.getParentId());
		parent.setName(vo.getParentName());
		entity.setParent(parent);

		return entity;
	}
}
