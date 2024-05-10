package com.fsb.firstSpringBootApp.Contrllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Home_Controller {
	
	@GetMapping("/")
	public String ShowHome() {
		
		return "Login";
	}

}
