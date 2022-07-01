<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>info.jsp</h1>
	
	<h2>회원정보 출력</h2>
	
	아이디 : ${memberVO.userid } <br>
	비밀번호 : ${memberVO.userpw } <br>
	이름 : ${memberVO.username } <br>
	이메일 : ${memberVO.useremail } <br>
	회원가입일 : ${memberVO.regdate } <br>
	
	<h3><a href="${pageContext.request.contextPath }/member/main">메인페이지로</a></h3>
	
</body>
</html>