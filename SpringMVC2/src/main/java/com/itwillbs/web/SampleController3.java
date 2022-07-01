package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.MemberVO;

@Controller
public class SampleController3 {
	
	private static final Logger log = LoggerFactory.getLogger(SampleController3.class);
	
	// http://localhost:8088/web/doC
	@RequestMapping(value = "/doC", method = RequestMethod.GET)
	public String doC(Model model) {
		log.info("doC() 호출!!!@@@@@@@@@@@@@@@@@@@");
		log.info(" 회원정보를 생성 -> memberInfo.jsp 페이지에 출력");
		
		// Model 객체 : 스프링MVC에서 기본으로 제공하는 클래스
		//				=> 객체를 연결된 뷰페이지로 이동시키는 클래스(컨네이터, 상자)
		
		MemberVO member 
			= new MemberVO("admin", "1234", "관리자", "admin@admin.com", null, null);
		// member.setUserid(null);
		
		// 전달할 정보를 저장
		//model.addAttribute("member", member);
		//model.addAttribute("이름", 값);
		// => 저장된 객체 정보를 view페이지에서 바로 사용 가능
		
		model.addAttribute(member);
		// => 이름 정보없이 객체만 저장하는 경우,
		//		이름 정보는 전달하는 객체의 클래스명 첫글자만 소문자로 바꿔서 이름으로 인식
		//		ex) MemberVO -> memberVO, ITWILL -> iTWILL
		
		//request.setAttribute( , );
		
		return "memberInfo";
	}

}
