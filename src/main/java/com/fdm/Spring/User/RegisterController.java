package com.fdm.Spring.User;
import javax.annotation.Resource;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fdm.Spring.User.User;

@Controller
@RequestMapping(value = "/register")
public class RegisterController {

	@Resource(name = "userDaoBean")
	private UserDao uDao;
	

	@RequestMapping(method = RequestMethod.GET)
	public String goToRegister(Model model) {
		model.addAttribute("user_register", new User());
		return "register";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String Register(User user) {
		String name = user.getUsername();
		String password = user.getPassword();
		if (password.equals("") 
				|| uDao.get(name) != null 
				|| name.isEmpty()) {
			
			return "failure";
		}
		else {
			uDao.add(user);
			return "index";
		}

	}
}