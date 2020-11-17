package cn.bocaiman.service;

import cn.bocaiman.base.pojo.vo.PageVO;
import cn.bocaiman.base.pojo.vo.QueryParamVO;
import cn.bocaiman.pojo.agency.vo.TravelAgencyVO;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-旅行社管理-旅行社信息业务层接口</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public interface TravelAgencyService {
	/**
	 *  <b>使用手机号码和登录密码进行登录</b>
	 * @param cellphone
	 * @param password
	 * @return
	 * @throws Exception
	 */
	String login(String cellphone, String password) throws Exception;

	/**
	 * <b>根据分页信息查询分页对象</b>
	 * @param queryParamVO
	 * @return
	 * @throws Exception
	 */
	PageVO<TravelAgencyVO> getByPage(QueryParamVO queryParamVO) throws Exception;

	/**
	 * <b>根据查询兑现查询列表</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	List<TravelAgencyVO> getList(TravelAgencyVO queryVO) throws Exception;

	/**
	 * <b>保存对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	Boolean save(TravelAgencyVO vo) throws Exception;

	/**
	 * <b>修改对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	Boolean update(TravelAgencyVO vo) throws Exception;
}
