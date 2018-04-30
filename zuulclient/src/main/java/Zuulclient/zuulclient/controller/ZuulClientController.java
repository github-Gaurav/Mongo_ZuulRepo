package Zuulclient.zuulclient.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZuulClientController {
	
	@RequestMapping("/get")
	public String getDetails(){
		
		return "Welcome to zuul client !";
	}

}
