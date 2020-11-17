package cn.bocaiman.transport.agency;

import cn.bocaiman.base.pojo.vo.PageVO;
import cn.bocaiman.base.pojo.vo.QueryParamVO;
import cn.bocaiman.pojo.agency.vo.PointUseTypeVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-旅行社管理-积分使用类型传输层接口</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@FeignClient(name = "bocaiman-agency-provider")
@RequestMapping("/agency/point/usetype/trans")
public interface PointUseTypeTransport {
	/**
	 * <b>根据分页信息查询分页对象</b>
	 * @param queryParamVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	PageVO<PointUseTypeVO> getByPage(@RequestBody QueryParamVO queryParamVO) throws Exception;

	/**
	 * <b>根据查询兑现查询列表</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	List<PointUseTypeVO> getByList(@RequestBody PointUseTypeVO queryVO) throws Exception;

	/**
	 * <b>保存对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	Boolean save(@RequestBody PointUseTypeVO vo) throws Exception;

	/**
	 * <b>修改对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@PostMapping("update")
	Boolean update(@RequestBody PointUseTypeVO vo) throws Exception;
}
