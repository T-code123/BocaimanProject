package cn.bocaiman.pojo.trade.entity;

import cn.bocaiman.base.pojo.entity.BaseEntity;
import cn.bocaiman.pojo.trade.vo.PaymentPlatformVO;
import org.springframework.beans.BeanUtils;

/**
 * <b>菠菜侠旅游租赁平台-交易管理-支付平台实体信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public class PaymentPlatform extends BaseEntity {
	private static final long serialVersionUID = 481715077944730219L;
	private String id;                      // 主键
	private String platform;                // 支付平台
	private String platformIcon;            // 平台图标

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getPlatformIcon() {
		return platformIcon;
	}

	public void setPlatformIcon(String platformIcon) {
		this.platformIcon = platformIcon;
	}


	/**
	 * <b>将 VO 对象转换成 Entity 对象</b>
	 * @param vo
	 * @return
	 */
	public static PaymentPlatform parseFromEntity(PaymentPlatformVO vo) {
		PaymentPlatform entity = new PaymentPlatform();
		// 将 VO 中的属性提取，设定到 Entity 中
		// entity.setId(vo.getId());
		// 借助于 Spring 所提供的 BeanUtils 来拷贝属性值（仅限普通的,只有属性名和属性类型相同才拷贝）
		BeanUtils.copyProperties(vo, entity);

		return entity;
	}
}
