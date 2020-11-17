package cn.bocaiman.base.pojo.vo;

import java.io.Serializable;
/**
 * <b>系统查询传递视图信息</b>
 * <p>
 *     当进行分页查询时，将分页视图和查询视图进行统一的封装为该视图对象
 * </p>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public class QueryParamVO implements Serializable {
	private static final long serialVersionUID = 6750243071282784224L;
	private PageVO pageVO;
	private BaseVO queryVO;

	public QueryParamVO() {}
	public QueryParamVO(PageVO pageVO, BaseVO queryVO) {
		this.pageVO = pageVO;
		this.queryVO = queryVO;
	}

	public PageVO getPageVO() {
		return pageVO;
	}

	public void setPageVO(PageVO pageVO) {
		this.pageVO = pageVO;
	}

	public BaseVO getQueryVO() {
		return queryVO;
	}

	public void setQueryVO(BaseVO queryVO) {
		this.queryVO = queryVO;
	}
}
