package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SampleController2 {
	
	private static final Logger log = LoggerFactory.getLogger(SampleController2.class);
	
	// * 메서드의 리턴타입이 String인 경우 리턴된 문자열.jsp 페이지 호출
	
	// http://localhost:8088/web/doB
	@RequestMapping(value = "/doB", method = RequestMethod.GET)
	public String doB() {
		log.info("doB() 호출, 주소 : /doB");
		
		//return "";
		return "itwill";
	}
	
	// 주소 호출시 -> itwillbs.jsp 출력
	// http://localhost:8088/web/doB1
	@RequestMapping("/doB1")
	public String doBB() {
		log.info(" 주소 호출과 메서드명은 상관없음. (메서드는 동작의 의미를 표현)");
		log.info(" 리턴 시 찾고자하는 뷰페이지 이름만 리턴 ");
		log.info("리턴한 문자열.jsp 페이지로 자동 연결 ");
		
		return "itwillbs";
		//return "itwillbs.jsp"; (X)
	}
	
	// 'doB2' -> itwillbs.jsp
	// http://localhost:8088/web/doB2
	// http://localhost:8088/web/doB2?id=itwill
	@RequestMapping(value = "/doB2", method = RequestMethod.GET)
	public String doB2(@ModelAttribute("id") String id) {
		
		// @ModelAttribute("이름") String id
		// => 페이지 요청시 이름에 해당하는 정보(파라미터)를 저장 & 연결된 view 전달
		
		log.info("doB2() 호출, 주소 : /doB2");
		log.info("itwillbs.jsp 페이지 이동");
		
		log.info("id : "+id);
		
		return "itwillbs";
	}
	
	// 'doB3' -> itwillbs.jsp "이름 : 김학생, 전화번호 : 010-1234-1234"
	// http://localhost:8088/web/doB3?name=김학생&tel=010-1234-1234
	@RequestMapping(value = "/doB3", method = RequestMethod.GET)
	public String doB3(@ModelAttribute("name") String name, @ModelAttribute("tel") String tel) {
		log.info("doB3() 호출 ");
		log.info("name : "+name+", tel"+tel);
		
		return "itwillbs";
	}

}
