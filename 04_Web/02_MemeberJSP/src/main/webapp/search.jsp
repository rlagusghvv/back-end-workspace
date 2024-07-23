<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.kh.model.vo.Member"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	Member m = (Member) (request.getAttribute("mem"));
	
	if(m.getName() != null) { %>
	<h1>검색하신 아이디의 사용자는</h1>
	<table border="1">
		<tr>
			<th>아이디</th>

			<th>이름</th>
		</tr>
		<tr>
			<th><%=m.getId()%></th>
			<th><%=m.getName()%></th>
		</tr>
	</table>
	<%} else { %>
	<h1>회원 정보가 없습니다.</h1>
	<%} %>
</body>
</html>