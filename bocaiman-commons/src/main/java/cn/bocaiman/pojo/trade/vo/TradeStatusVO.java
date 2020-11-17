package cn.bocaiman.pojo.trade.vo;

import cn.bocaiman.base.pojo.vo.BaseVO;
import cn.bocaiman.pojo.system.entity.DriverStatus;
import cn.bocaiman.pojo.trade.entity.TradeStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-支付管理-交易状态视图信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@ApiModel("菠菜侠旅游租赁平台-支付管理-交易状态视图信息")
public class TradeStatusVO extends BaseVO {
	private static final long serialVersionUID = 4866577921851159787L;
	@ApiModelProperty(value = "主键")
	private String id;                      // 主键
	@ApiModelProperty(value = "状态文本")
	private String text;                    // 状态文本
	@ApiModelProperty(value = "编码")
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
	 * <b>将实体对象转换成视图对象</b>
	 * @param entity
	 * @return
	 */
	public static TradeStatusVO parseFromVO(TradeStatus entity) {
		// 创建视图对象
		TradeStatusVO vo = new TradeStatusVO();
		// 进行普通属性切换
		BeanUtils.copyProperties(entity,vo);

		return vo;
	}

	/**
	 * <b>将实体列表转换成视图列表</b>
	 * @param entityList
	 * @return
	 */
	public static List<TradeStatusVO> parseFromListVO(List<TradeStatus> entityList) {
		// 先创建视图列表
		List<TradeStatusVO> voList = new ArrayList<TradeStatusVO>();
		// 实体列表可用
		if (entityList != null && !entityList.isEmpty()) {
			for (TradeStatus entity : entityList) {
				TradeStatusVO vo = parseFromVO(entity);
				voList.add(vo);
			}
		}
		return voList;
	}
}
