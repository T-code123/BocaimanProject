package cn.bocaiman.transport.agency;


import cn.bocaiman.base.pojo.vo.PageVO;
import cn.bocaiman.base.pojo.vo.QueryParamVO;
import cn.bocaiman.pojo.agency.vo.TravelAgencyVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-旅行社管理-旅行社信息传输层接口</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@FeignClient("bocaiman-agency-provider")
@RequestMapping("/agency/trans")
public interface TravelAgencyTransport {

	/**
	 * <b>使用手机号码和登录密码进行登录</b>
	 * @param cellphone
	 * @param password
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/login")
	String login(@RequestParam String cellphone, @RequestParam String password) throws Exception;

	/**
	 * <b>根据分页信息查询分页对象</b>
	 * @param queryParamVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	PageVO<TravelAgencyVO> getByPage(@RequestBody QueryParamVO queryParamVO) throws Exception;

	/**
	 * <b>根据查询兑现查询列表</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	List<TravelAgencyVO> getList(@RequestBody TravelAgencyVO queryVO) throws Exception;

	/**
	 * <b>保存对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	Boolean save(@RequestBody TravelAgencyVO vo) throws Exception;

	/**
	 * <b>修改对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/update")
	Boolean update(@RequestBody TravelAgencyVO vo) throws Exception;
}
