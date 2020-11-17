package cn.bocaiman.pojo.trade.entity;

import cn.bocaiman.base.pojo.entity.BaseEntity;
import cn.bocaiman.pojo.system.vo.DriverStatusVO;
import cn.bocaiman.pojo.trade.vo.TradeStatusVO;
import org.springframework.beans.BeanUtils;


/**
 * <b>菠菜侠旅游租赁平台-支付管理-交易状态实体信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public class TradeStatus extends BaseEntity {
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
	public static TradeStatus parseFromEntity(TradeStatusVO vo) {
		// 创建实体对象
		TradeStatus entity = new TradeStatus();
		// 拷贝普通属性
		BeanUtils.copyProperties(vo,entity);

		return entity;
	}

}
