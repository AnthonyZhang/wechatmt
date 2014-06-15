package cn.wechatmt.demo.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.wechatmt.demo.model.MobileUsers;
import cn.wechatmt.demo.service.IMobileUserService;

@Controller
@RequestMapping(value = "/mobileUser")
public class MobileUserController {

	@Autowired
	@Qualifier("mobileUserService")
	private IMobileUserService mobileUserService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model mode, MobileUsers userLogin, HttpServletRequest request){
		if (null != userLogin.getAccount() && null != userLogin.getPassword() && "" != userLogin.getAccount() && "" != userLogin.getPassword()){
			MobileUsers user =  mobileUserService.getMobileUserByName(userLogin.getAccount());
			if (null != user && userLogin.getPassword().equals(user.getPassword()) ){
				 request.getSession().setAttribute("user", user);
			} else {
				return "redirect:/mobileUser/toLogin";
			}
		} else {
			return "redirect:/mobileUser/toLogin";
		}
		
		return "redirect:/news/list";
	}
	
	@RequestMapping(value = "/toLogin")
	public String toLogin(Model mode){
		return "/user/login";
	}
	
}
