package com.fdm.Spring.User;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/login")
public class StoreLoginController {



		@Resource(name = "userDaoBean")
		private UserDao uDao;
		

		@RequestMapping(method = RequestMethod.GET)
		public String goToLogin(Model model) {
			model.addAttribute("blank_user_login", new User());
			return "login";
		}

		@RequestMapping(method = RequestMethod.POST)
		public String Login(User user) {
			String name = user.getUsername();
			String password = user.getPassword();
			User user2 = uDao.get(name);
			
			if(user2 == null) {
				return "wrongpassword";
				
			}
			
			else if (user2.getPassword().equals(password)) {
				return "welcome";
				
			}
			else {
				return "wrongpassword";
			}

		}
}

