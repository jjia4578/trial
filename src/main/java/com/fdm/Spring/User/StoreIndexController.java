package com.fdm.Spring.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StoreIndexController {
	@RequestMapping(value = {"/","index"}, method = RequestMethod.GET)
	public String goToIndex() {
		return "index";
	}
	

}
