package cn.bocaiman.base.controller;

import cn.bocaiman.util.IdGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <b>菠菜侠旅游租赁平台-基础功能-id 生成控制器</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@Api(value = "菠菜侠旅游租赁平台-基础功能-id 生成接口",tags = {"菠菜侠旅游租赁平台-基础功能-id 生成接口"})
@RestController("idController")
@RequestMapping("/id")
public class IdController {
	@Autowired
	private IdGenerator idGenerator;

	@ApiOperation(value = "生成数据库主键", response = String.class, httpMethod = "GET")
	@ApiResponse(code = 200,message = "生成主键字符串")
	@GetMapping("/create")
	public String createId() throws Exception{
		return idGenerator.nextId();
	}
}
