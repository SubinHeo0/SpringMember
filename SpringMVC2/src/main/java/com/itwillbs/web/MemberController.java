package com.itwillbs.web;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.service.MemberService;

@Controller
@RequestMapping("/member/*")
// => 기능별 공통주소를 설계 (도메인)
public class MemberController {
	
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	
	// 서비스 객체가 필요하다
	@Inject
	private MemberService service;
	
	// http://localhost:8088/web/member/doA
	// http://localhost:8088/member/doA
//	@RequestMapping("/doA")
//	public void test() {
//		log.info("MemberController-test() doA");
//	}
	
	
	// http://localhost:8088/member/insert
	// 회원가입
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insertGET() {
		
		log.info(" insertGET() 호출 ");
		log.info("view 페이지 출력 -> 정보 입력");
		
		return "/member/insertForm";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertPOST(MemberVO vo, HttpServletRequest request) throws UnsupportedEncodingException {
		log.info(" insertPOST() 호출 ");
		
		// MemberVO(도메인객체) 전달인자로 사용할 경우 @ ModelAttribute가 붙은 것처럼 생각
		// 전달된 파라메터 데이터를 알아서 각각의 데이터공간에 찾아서 저장
		// vo.setUserid(request.getParameter("userid")); (x)
		// => 위 동작 없이 스프링이 알아서 전달되는 데이터를 저장
		//	(전달되는 파라미터명과 변수명(프로퍼티)이 동일한 경우)
		
		
		// 한글처리
		//request.setCharacterEncoding("UTF-8");
		// 정보 저장
		log.info(vo+"");
		// DB에 회원정보 저장 => 서비스 계층 호출 => DAO 호출
		// DAO 객체 주입? (동작가능) => 강한결합 (종속적인 상황이 발생)
		service.memberInsert(vo);
		
		log.info("회원가입 완료 -> 로그인 페이지로 이동");
		
		// 페이지 이동( 로그인 페이지 )
		return "redirect:/member/login";
		
		
	}
	
	// http://localhost:8088/member/login
	// 로그인 /login
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginGet() {
		log.info("loginGet() 호출");
		log.info(" /member/loginForm.jsp 페이지로 이동");
		
		return "/member/loginForm";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPOST(MemberVO vo, HttpSession session/*@ModelAttribute("userid") String id*/) {
		
		log.info("loginPOST() 호출");
		// 전달정보 저장(id,pw)
		//log.info("id : "+id);
		log.info(vo+"");
		
		// db동작 호출을 위해서 서비스 동작을 호출 - loginCheck()
		MemberVO resultVO = service.loginCheck(vo);
		
		// 로그인 실패 - 페이지 이동(로그인페이지)
		if(resultVO == null) {
			log.info("로그인 정보 없음! 페이지 이동");
			return "redirect:/member/login";
		}
		
		// 로그인 성공 - 아이디를 세션객체에 저장
		session.setAttribute("id", resultVO.getUserid());
		
		// 메인페이지로 이동
		return "redirect:/member/main";
	}
	
	// http://localhost:8088/member/main
	// 메인페이지
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public void mainGET() {
		log.info("mainGET() 호출");
		
	}
	
	// http://localhost:8088/member/logout
	// 로그아웃
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutGET(HttpSession session) {
		log.info("logoutGET() 호출");
		
		// 로그아웃 => 세션졍보 초기화
		session.invalidate();
		
		// 페이지이동
		return "redirect:/member/main";
	}
	
	// http://localhost:8088/member/info
	// 회원정보 조회
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public void infoGET(HttpSession session, Model model) {
		log.info("infoGET() 호출");
		
		// 아이디 값 가져오기
		String id = (String) session.getAttribute("id");
		
		// 아이디 값에 해당하는 회원정보 모두 조회 -> 서비스 동작 호출
		MemberVO vo = service.getMember(id);
		
		// 가져온 회원정보 확인
		log.info(vo+"");
		
		// DB에서 전달받은 정보를 view 페이지로 전달
		//model.addAttribute("memberVO", vo);
		model.addAttribute(vo);
		
	}
	
	
	// http://localhost:8088/member/update
	// 회원정보 수정
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updateGET(HttpSession session, Model model) {
		log.info("updateGET() 호출");
		
		String id = (String) session.getAttribute("id");

		// 서비스-회원정보를 가져오는 동작
		MemberVO vo = service.getMember(id);
		
		// view 페이지로 전달
		//model.addAttribute(vo);
		model.addAttribute(service.getMember(id));
		
		return "/member/updateForm";
	}
	
	// 회원정보 수정
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updatePOST(MemberVO vo) {
		// 수정할 정보를 저장(전달정보 저장)
		log.info("수정 데이터 : "+vo);
		
		// 서비스 - 정보 수정동작 호출
		int result = service.updateMember(vo);
		
		if(result != 1) {
			return "redirect:/member/update";
		}
		
		// 페이지 이동(main)
		return "redirect:/member/main";
	}
	
	
	// http://localhost:8088/member/delete
	// 회원정보 삭제(탈퇴)
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteGET() {
		log.info(" deleteGET()  호출 ");
		
		return "/member/deleteForm";
	}
	
	// 회원정보 삭제(탈퇴)
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String deletePOST(HttpSession session, MemberVO vo/*@ModelAttribute("userpw") String userpw*/) {
		log.info("deletePOST() 호출");
		//log.info(userpw);
		vo.setUserid((String)session.getAttribute("id"));
		log.info(vo+"");
		
		// 서비스 - 회원삭제동작
		service.deleteMember(vo);
		
		// 회원정보(세션) 초기화
		session.invalidate();
		
		// 페이지 이동
		return "redirect:/member/main";
	}
	
	
	// 회원정보 목록보기
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listGET(HttpSession session, Model model) {
		log.info(" listGET() 호출 ");
		
		// 로그인 세션처리
		String id = (String) session.getAttribute("id");
		if(id == null || !id.equals("admin")) {
			return "redirect:/member/main";
		}
		
		// 서비스 - 회원정보 목록을 조회하는 동작
		//service.getMemberList(id);
		
		// 정보를 저장 - view 페이지로 전달
		model.addAttribute("memberList", service.getMemberList(id));
		
		// 페이지 이동
		return "/member/list";
	}
	
	
	
	
}
