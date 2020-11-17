package cn.bocaiman.base.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;
import java.util.Properties;

/**
 * <b>菠菜侠旅游租赁平台-基础功能-系统分页视图信息</b>
 * <p>
 *     当前端进行分页查询时，必须返回本分页视图
 * </p>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@ApiModel("系统分页视图信息")
public class PageVO<E> implements Serializable {
	private static final long serialVersionUID = 5051218747028118494L;
	@ApiModelProperty(value = "当前页码", dataType = "Integer", example = "1")
	private Integer pageNum;
	@ApiModelProperty(value = "每页显示数量", dataType = "Integer", example = "10")
	private Integer pageSize;
	@ApiModelProperty(value = "分页列表")
	private List<E> list;
	@ApiModelProperty(value = "总数量", dataType = "Long", example = "1000")
	private Long totalCount;
	@ApiModelProperty(value = "总页数", dataType = "Integer", example = "100")
	private Integer totalPage;
	private static Properties props = new Properties();                     // Properties 对象

	static {
		try {
			// 通过使用静态代码块加载 properties 配置文件
			props.load(PageVO.class.getClassLoader().getResourceAsStream("props/system.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public PageVO() {}
	public PageVO(Integer pageNum, Integer pageSize) {
		if (pageNum != null && pageNum > 0) {
			this.pageNum = pageNum;
		} else {
			this.pageNum = Integer.parseInt(props.getProperty("system.page.num"));
		}

		if (pageSize != null && pageSize > 0) {
			this.pageSize = pageSize;
		} else {
			this.pageSize = Integer.parseInt(props.getProperty("system.page.size"));
		}
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public List<E> getList() {
		return list;
	}

	public void setList(List<E> list) {
		this.list = list;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
}
