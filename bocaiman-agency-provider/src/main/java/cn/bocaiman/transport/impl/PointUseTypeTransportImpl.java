package cn.bocaiman.transport.impl;

import cn.bocaiman.base.pojo.vo.PageVO;
import cn.bocaiman.base.pojo.vo.QueryParamVO;
import cn.bocaiman.pojo.agency.vo.PointUseTypeVO;
import cn.bocaiman.service.PointUseTypeService;
import cn.bocaiman.transport.agency.PointUseTypeTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-旅行社管理-积分使用类型传输层接口实现类</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController("pointUseTypeTransport")
@RequestMapping("/agency/point/usetype/trans")
public class PointUseTypeTransportImpl implements PointUseTypeTransport {
	@Autowired
	private PointUseTypeService service;

	/**
	 * <b>根据分页信息查询分页对象</b>
	 * @param queryParamVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	@Override
	public PageVO<PointUseTypeVO> getByPage(@RequestBody QueryParamVO queryParamVO) throws Exception {
		return service.geBypage(queryParamVO);
	}

	/**
	 * <b>根据查询兑现查询列表</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	@Override
	public List<PointUseTypeVO> getByList(@RequestBody PointUseTypeVO queryVO) throws Exception{
		return service.getByList(queryVO);
	}

	/**
	 * <b>保存对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	@Override
	public Boolean save(@RequestBody PointUseTypeVO vo) throws Exception {
		return service.save(vo);
	}

	/**
	 * <b>修改对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@PostMapping("update")
	@Override
	public Boolean update(@RequestBody PointUseTypeVO vo) throws Exception {
		return service.update(vo);
	}
}
