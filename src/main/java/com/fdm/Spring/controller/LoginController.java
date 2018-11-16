package com.fdm.Spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/mylogin")
public class LoginController {

	@RequestMapping(method = RequestMethod.GET)
public String goToLogin(Model model) {
		model.addAttribute("blank_user_login", new User());
		return "mylogin";
	}
	@RequestMapping(method = RequestMethod.POST)
public String Login(User user) {
	System.out.println(user);
	return "myindex";
}

}
