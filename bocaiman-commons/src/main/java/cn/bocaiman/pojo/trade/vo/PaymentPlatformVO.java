package cn.bocaiman.pojo.trade.vo;

import cn.bocaiman.base.pojo.vo.BaseVO;
import cn.bocaiman.pojo.system.entity.Area;
import cn.bocaiman.pojo.system.vo.AreaVO;
import cn.bocaiman.pojo.trade.entity.PaymentPlatform;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-交易管理-支付平台视图信息</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@ApiModel("菠菜侠旅游租赁平台-交易管理-支付平台视图信息")
public class PaymentPlatformVO extends BaseVO {
	private static final long serialVersionUID = -8271557503766171933L;
	@ApiModelProperty(value = "主键")
	private String id;                      // 主键
	@ApiModelProperty(value = "支付平台")
	private String platform;                // 支付平台
	@ApiModelProperty(value = "平台图标")
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
	 * <b>将 Entity 对象转换成 VO 对象</b>
	 * @param entity
	 * @return
	 */
	public static PaymentPlatformVO parseFromVO(PaymentPlatform entity) {
		// 创建 VO 对象
		PaymentPlatformVO vo = new PaymentPlatformVO();
		// 将 Entity 中的属性提取，设定到 VO 中
		// 借助于 Spring 所提供的 BeanUtils 来拷贝属性值（仅限普通的,只有属性名和属性类型相同才拷贝）
		BeanUtils.copyProperties(entity, vo);

		return vo;

	}

	/**
	 * <b>将实体列表切换成视图列表</b>
	 * @param entityList
	 * @return
	 */
	public static List<PaymentPlatformVO> parseFromVOList(List<PaymentPlatform> entityList) {
		List<PaymentPlatformVO> voList = new ArrayList<PaymentPlatformVO>();
		// 实体列表可用
		if (entityList != null && !entityList.isEmpty()) {
			for (PaymentPlatform entity : entityList) {
				PaymentPlatformVO vo = parseFromVO(entity);
				voList.add(vo);
			}
		}
		return voList;
	}
}
