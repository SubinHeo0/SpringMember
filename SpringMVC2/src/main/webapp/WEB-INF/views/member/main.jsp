<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>main.jsp</h1>
	
	${id }님 환영합니다. <br>
	${sessionScope.id }님 환영합니다. <br>
	
	<c:if test="${ sessionScope.id == null }">
		<c:redirect url="${pageContext.request.contextPath }/member/login" />	
	</c:if>
	
	<input type="button" value="로그아웃" onclick=" location.href='/member/logout'; ">
	
	<%
// 	 String id = (String) session.getAttribute("id");
	
// 	 if(id==null){
// 		System.out.println("@@@@@@@@@@@@JSP@@@@@@@@@@@");
// 	 	response.se ndRedirect("/member/login");
// 	 }
	%>
	
	<h3><a href="/member/info">회원정보 조회</a></h3>
	<h3><a href="/member/update">회원정보 수정</a></h3>
	<h3><a href="/member/delete">회원정보 삭제</a></h3>
	
	<c:if test="${id == 'admin' }">
		<h3><a href="/member/list">회원정보 목록 조회</a></h3>
	</c:if>
	
</body>
</html>