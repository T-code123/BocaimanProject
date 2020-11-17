package cn.bocaiman.transport.impl;

import cn.bocaiman.pojo.agency.vo.PointRecordVO;
import cn.bocaiman.service.PointRecordService;
import cn.bocaiman.transport.agency.PointRecordTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-旅行社管理-积分记录传输层接口实现类</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController("pointRecordTransport")
@RequestMapping("/agency/pointrecord/trans")
public class PointRecordTransportImpl implements PointRecordTransport {
	@Autowired
	private PointRecordService service;

	/**
	 * <b>根据查询视图查询对象</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	@Override
	public List<PointRecordVO> getByList(@RequestBody PointRecordVO queryVO) throws Exception {
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
	public boolean save(@RequestBody PointRecordVO vo) throws Exception {
		return service.save(vo);
	}
}
