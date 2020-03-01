package main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController{
	@RequestMapping("/index.do")
	public String main(){
		return "index";
	}
	@RequestMapping("/admin/index.do")
	public String adminMain(){
		return "admin/index";
	}
}