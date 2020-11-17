package cn.bocaiman.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <b>菠菜侠旅游租赁平台-基础功能-基础控制器</b>
 * <p>
 *     基础控制器依赖注入了&nbsp;<b>HttpServletRequest</b>&nbsp;、&nbsp;<b>HttpServletResponse</b>&nbsp;
 *     和&nbsp;<b>HttpSession</b>&nbsp;<br/>
 *     其他控制器都应当继承于本基础控制器。
 * </p>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@Controller("baseController")
public class BaseController {
	@Autowired
	protected HttpServletRequest request;
	@Autowired
	protected HttpServletResponse response;
	@Autowired
	protected HttpSession session;
}
