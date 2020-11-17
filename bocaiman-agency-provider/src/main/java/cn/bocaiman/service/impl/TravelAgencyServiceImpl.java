package cn.bocaiman.service.impl;


import cn.bocaiman.base.pojo.vo.PageVO;
import cn.bocaiman.base.pojo.vo.QueryParamVO;
import cn.bocaiman.dao.TravelAgencyDao;
import cn.bocaiman.pojo.agency.entity.TravelAgency;


import cn.bocaiman.pojo.agency.vo.TravelAgencyVO;
import cn.bocaiman.service.TravelAgencyService;
import cn.bocaiman.util.ConstantUtil;
import cn.bocaiman.util.IdGenerator;
import cn.bocaiman.util.RedisUtil;
import cn.bocaiman.util.TokenUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * <b>菠菜侠旅游租赁平台-旅行社管理-旅行社信息业务层接口实现类</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@Service("travelAgencyService")
@Transactional
public class TravelAgencyServiceImpl implements TravelAgencyService {
	@Autowired
	private TravelAgencyDao dao;
	@Autowired
	private IdGenerator idGenerator;
	@Autowired
	private RedisUtil redisUtil;
	/**
	 *  <b>使用手机号码和登录密码进行登录</b>
	 * @param cellphone
	 * @param password
	 * @return
	 * @throws Exception
	 */
	@Override
	public String login(String cellphone, String password) throws Exception{
		// 通过手机号码和登录密码查找用户
		TravelAgency query = new TravelAgency();
		query.setCellphone(cellphone);
		query.setPassword(password);
		List<TravelAgency> list = dao.findListByQuery(query);
		if (list != null && !list.isEmpty()) {
			// 获得用户之后，通过该用户主键生成 token
			String token = TokenUtil.generateToken(query.getId());
			// 借助于 Redis 将token用户id，用户对象作为 value 存储到 Redis中
			redisUtil.saveToRedis(token,query, ConstantUtil.TOKEN_EXPIRE_MINUTE);
			// 返回生成的 token 信息
			return token;
		}
		return null;
	}

	/**
	 * <b>根据分页信息查询分页对象</b>
	 * @param queryParamVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public PageVO<TravelAgencyVO> getByPage(QueryParamVO queryParamVO) throws Exception {
		PageVO<TravelAgencyVO> pageVO = queryParamVO.getPageVO();
		TravelAgencyVO queryVO = (TravelAgencyVO) queryParamVO.getQueryVO();
		// 开启 PageHelper 分页过滤器
		PageHelper.startPage(pageVO.getPageNum(), pageVO.getPageSize());
		// 进行分页查询
		List<TravelAgency> entityList = dao.findListByQuery(TravelAgency.parseFromEntity(queryVO));
		// 创建 PageInfo 对象
		PageInfo<TravelAgency> pageInfo = new PageInfo<TravelAgency>(entityList);
		// 切换数据
		pageVO.setList(TravelAgencyVO.parseFromVOList(pageInfo.getList()));
		pageVO.setTotalCount(pageInfo.getTotal());
		pageVO.setTotalPage(pageInfo.getPages());

		return pageVO;
	}

	/**
	 * <b>根据查询兑现查询列表</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<TravelAgencyVO> getList(TravelAgencyVO queryVO) throws Exception {
		return TravelAgencyVO.parseFromVOList(dao.findListByQuery(TravelAgency.parseFromEntity(queryVO)));
	}

	/**
	 * <b>保存对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@Override
	public Boolean save(TravelAgencyVO vo) throws Exception {
		// 将视图对象切换为实体对象
		TravelAgency entity = TravelAgency.parseFromEntity(vo);
		// 设置主键
		entity.setId(idGenerator.nextId());
		// 保存对象
		Integer count = dao.save(entity);
		if (count != null && count > 0) {
			return true;
		}
		return false;
	}

	/**
	 * <b>修改对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@Override
	public Boolean update(TravelAgencyVO vo) throws Exception {
		// 将视图对象切换为实体对象
		TravelAgency entity = TravelAgency.parseFromEntity(vo);
		// 保存对象
		Integer count = dao.update(entity);
		if (count != null && count > 0) {
			return true;
		}
		return false;
	}
}
