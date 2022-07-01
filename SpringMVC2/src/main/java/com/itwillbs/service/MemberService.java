package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.MemberVO;

public interface MemberService {
	
	// 회원가입
	public void memberInsert(MemberVO vo);
	
	// 로그인체크
	public MemberVO loginCheck(MemberVO vo);
	
	// 회원정보조회
	public MemberVO getMember(String userid);
	
	// 회원정보수정
	public Integer updateMember(MemberVO vo);
	
	// 회원정보삭제
	public void deleteMember(MemberVO vo);
	
	// 회원정보 조회
	public List<MemberVO> getMemberList(String userid);
	
}
