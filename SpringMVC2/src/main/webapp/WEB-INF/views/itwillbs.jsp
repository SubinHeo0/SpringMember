<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>WEB-INF/view/itwillbs.jsp</h1>
	<% String id = request.getParameter("id"); %>
	
	아이디(JSP 표현식) : <%=id %> <hr>
	아이디(EL 표현식) : ${param.id } <hr>
	아이디(spring) : ${id } <hr>
	이름 : ${name }, 전화번호 : ${tel } <hr>
	
</body>
</html>