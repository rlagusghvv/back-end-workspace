<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 검색 결과</title>
</head>
<body>
	<h1>회원 검색 결과</h1>
	<%-- <% Member member = (Member) request.getAttribute("member"); %> --%>
	${requestScope.member}
	<ul>
		<%-- <li>아이디 : <%=member.getId() %></li> --%> 
		<li>아이디 : ${member.id}</li>
		<%-- <li>비밀번호 : <%=member.getPassword() %></li> --%>
		<li>비밀번호 : ${member.password}</li>
		<%-- <li>이름 : <%=member.getName() %></li> --%>
		<li>이름 : ${member.name}</li>
	</ul>
	<a href="/">메인 페이지로 이동</a>
</body>
</html>