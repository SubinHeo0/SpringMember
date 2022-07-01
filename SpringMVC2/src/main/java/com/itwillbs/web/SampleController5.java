package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itwillbs.domain.MemberVO;

@Controller
public class SampleController5 {
	
	private static final Logger log = LoggerFactory.getLogger(SampleController5.class);
	
	// http://localhost:8088/web/doF
	@RequestMapping(value = "/doF")
	public @ResponseBody MemberVO doF() {
		log.info(" doF() 호출 ");
		log.info("void String 형태만 리턴 가능");
		
		MemberVO vo = new MemberVO();
		vo.setUserid("itwill");
		vo.setUserpw("1234");
		
		return vo;
	}
	
}
