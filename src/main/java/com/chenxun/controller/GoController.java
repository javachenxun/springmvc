package com.chenxun.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @Author：chenxun
 * @Date：2016年9月10日 下午10:40:48
 * @参考：
 * @说明：
 */
//@Controller
public class GoController implements EnvironmentAware {

	private final Log logger = LogFactory.getLog(this.getClass());

	@RequestMapping(value = { "/index", "/" }, method = { RequestMethod.GET })
	public String index(Model model) {
		model.addAttribute("msg", "Go  Go  Go");
		return "go.jsp";
	}

	Environment environment;

	public void setEnvironment(Environment environment) {
		this.environment = environment;

	}
}
