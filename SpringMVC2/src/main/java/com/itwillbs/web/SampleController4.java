package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SampleController4 {
	
	private static final Logger log = LoggerFactory.getLogger(SampleController4.class);
	
	// http://localhost:8088/web/doD?msg=hello
//	@RequestMapping(value = "/doD")
//	public String doD(@ModelAttribute("msg") String msg) {
//		log.info(" doD() 호출!!! ");
//		
//		//return "/doE";
//		//return "redirect: /doE"; (공백x)
//		return "redirect:/doE";
//		//return "forward:/doE";
//	}
	
	// http://localhost:8088/web/doD?msg=hello
	// http://localhost:8088/web/doD
//	@RequestMapping(value = "/doD")
//	public String doD(Model model, @ModelAttribute("msg") String msg) {
//		log.info(" doD() 호출!!! ");
//		
//		model.addAttribute("msg", msg);
//		
//		return "redirect:/doE";
//	}
	
	// http://localhost:8088/web/doD?msg=1234
	@RequestMapping(value = "/doD")
	public String doD(RedirectAttributes rttr) {
		log.info(" doD() 호출!!! ");
		
		//model.addAttribute("msg", msg);
		rttr.addFlashAttribute("msg", "test1234");
		
		return "redirect:/doE";
	}
	
	// model.addAttribute()
	//	=> Model 객체 사용, URI에 표시됨, F5-데이터 유지
	// rttr.addFlashAttribute()
	//	=> RedirectAttributes 객체 사용, URI에 표시안됨, F5-데이터 사라짐(일회성)
	// => redirect동작시 사용!!!
	
	
	
	// http://localhost:8088/web/doE
	@RequestMapping("/doE")
	public void doE(@ModelAttribute("msg") String msg) {
		log.info(" doE() 호출!!! ");
		log.info(msg);
	}
	
}
