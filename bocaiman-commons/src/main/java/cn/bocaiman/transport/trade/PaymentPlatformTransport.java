package cn.bocaiman.transport.trade;

import cn.bocaiman.base.pojo.vo.PageVO;
import cn.bocaiman.base.pojo.vo.QueryParamVO;
import cn.bocaiman.pojo.trade.entity.PaymentPlatform;
import cn.bocaiman.pojo.trade.vo.PaymentPlatformVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-支付管理-支付平台传输层接口</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@FeignClient(name = "bocaiman-trade-provider")
@RequestMapping("/trade/paymentplatform/trans")
public interface PaymentPlatformTransport {

	/**
	 * <b>根据分页对象查询分页信息/b>
	 * @param queryParamVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	PageVO<PaymentPlatformVO> getByPage(@RequestBody QueryParamVO queryParamVO) throws Exception;

	/**
	 * <b>根据查询对象查询列表</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	List<PaymentPlatformVO> getListByQuery(@RequestBody PaymentPlatformVO queryVO) throws Exception;

	/**
	 * <b>根据主键查询对象</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/id")
	PaymentPlatformVO getById(@RequestParam String id) throws Exception;

	/**
	 * <b>保存信息</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	boolean save(@RequestBody PaymentPlatformVO vo) throws Exception;

	/**
	 * <b>修改信息</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/update")
	boolean update(@RequestBody PaymentPlatformVO vo) throws Exception;

	/**
	 * <b>按照平台名称进行查询</b>
	 * @param platform
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/platform")
	PaymentPlatform getByPaymentPlatform(@RequestParam String platform) throws Exception;
}
