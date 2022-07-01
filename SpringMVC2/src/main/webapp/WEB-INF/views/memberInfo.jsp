<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>memberInfo.jsp</h1>
	
	${member }<hr>
	${member.userid }<hr>
	${member.userpw }<hr>
	${member.username }<hr>
	${member.useremail }<hr>
	
	<script type="text/javascript">
		alert('${member.userid}');
	</script>
	
	
	<hr>
	${memberVO.userid }<hr>
	
</body>
</html>