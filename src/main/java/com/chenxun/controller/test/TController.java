package com.chenxun.controller.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @Author：chenxun
 * @Date：2016年9月10日 下午10:40:48
 * @参考：
 * @说明：
 */
@Controller
@RequestMapping("/tcontroller")
public class TController implements EnvironmentAware {

	private final Log logger = LogFactory.getLog(this.getClass());
	
	private Environment environment;

	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}

	@RequestMapping(value = { "/ajax"}, method = { RequestMethod.GET })
	public @ResponseBody String index(Model model) {
		logger.info("[into....]chenxun="+environment.getProperty("chenxun"));
		return "go.jsp";
	}
	
	@RequestMapping(value = {"/topage"}, method = { RequestMethod.GET })
	public  String page(Model model) {
		model.addAttribute("msg", "测试");
		return "tcontroller";
	}
}
