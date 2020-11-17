package cn.bocaiman.service;

import cn.bocaiman.base.pojo.vo.PageVO;
import cn.bocaiman.base.pojo.vo.QueryParamVO;
import cn.bocaiman.pojo.trade.entity.PaymentPlatform;
import cn.bocaiman.pojo.trade.vo.PaymentPlatformVO;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-支付管理-支付平台业务层接口</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public interface PaymentPlatformService {
	/**
	 * <b>根据分页对象查询分页信息/b>
	 * @param pageVO
	 * @return
	 * @throws Exception
	 */
	PageVO<PaymentPlatformVO> getBypage(QueryParamVO queryParamVO) throws Exception;
	/**
	 * <b>根据查询对象查询列表</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	List<PaymentPlatformVO> getListByQuery(PaymentPlatformVO queryVO) throws Exception;

	/**
	 * <b>根据主键查询对象</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	PaymentPlatformVO getById(String id) throws Exception;

	/**
	 * <b>保存信息</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	boolean save(PaymentPlatformVO vo) throws Exception ;

	/**
	 * <b>修改信息</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	boolean update(PaymentPlatformVO vo) throws Exception;
	/**
	 * <b>按照平台名称进行查询</b>
	 * @param platform
	 * @return
	 * @throws Exception
	 */
	PaymentPlatform getByPaymentPlatform(String platform) throws Exception ;
}
