package cn.bocaiman.transport.impl;

import cn.bocaiman.base.pojo.vo.PageVO;

import cn.bocaiman.base.pojo.vo.QueryParamVO;
import cn.bocaiman.pojo.trade.entity.PaymentPlatform;
import cn.bocaiman.pojo.trade.vo.PaymentPlatformVO;
import cn.bocaiman.service.PaymentPlatformService;
import cn.bocaiman.transport.trade.PaymentPlatformTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-支付管理-支付平台传输层接口实现类</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController("paymentPlatformTransport")
@RequestMapping("/trade/paymentplatform/trans")
public class PaymentPlatformTransportImpl implements PaymentPlatformTransport {
	@Autowired
	private PaymentPlatformService service;
	/**
	 * <b>根据分页对象查询分页信息/b>
	 * @param queryParamVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	@Override
	public PageVO<PaymentPlatformVO> getByPage(@RequestBody QueryParamVO queryParamVO) throws Exception {
		return service.getBypage(queryParamVO);
	}
	/**
	 * <b>根据查询对象查询列表</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	@Override
	public List<PaymentPlatformVO> getListByQuery(@RequestBody PaymentPlatformVO queryVO) throws Exception {
		return service.getListByQuery(queryVO);
	}
	/**
	 * <b>根据主键查询对象</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/id")
	@Override
	public PaymentPlatformVO getById(@RequestParam String id) throws Exception {
		return service.getById(id);
	}
	/**
	 * <b>保存信息</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	@Override
	public boolean save(@RequestBody PaymentPlatformVO vo) throws Exception {
		return service.save(vo);
	}

	/**
	 * <b>修改信息</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/update")
	@Override
	public boolean update(@RequestBody PaymentPlatformVO vo) throws Exception {
		return service.update(vo);
	}

	/**
	 * <b>按照平台名称进行查询</b>
	 * @param platform
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/platform")
	public PaymentPlatform getByPaymentPlatform(@RequestParam String platform) throws Exception{
		return service.getByPaymentPlatform(platform);
	}
}
