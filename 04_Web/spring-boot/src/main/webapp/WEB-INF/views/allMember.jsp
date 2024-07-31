<%@page import="com.kh.model.vo.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
</head>
<body>
	<h1>전체 회원 목록</h1>
	<form action="/front" method="post">
	<input type="hidden" name="command" value="allMember">
	<a href="/">메인 페이지로 이동</a>
	<%-- <% List<Member> list = (List<Member>) request.getAttribute("list"); %> --%>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
		</tr>
		<%-- <% for(Member m : list) { %> --%>
		<c:forEach items="${list}" var="m" varStatus="status"> 
			<tr>
				<%-- index : 0부터, count : 1부터 시작 --%>
				<td>${status.count}</td> <%-- <td>${status.index + 1}</td> --%>
				<td>${m.id}</td> <%-- <td><%=m.getId() %></td> --%>
				<td>${m.password}</td> <%-- <td><%=m.getPassword() %></td> --%>
				<td>${m.name}</td> <%-- <td><%=m.getName() %></td> --%>
			</tr>
		</c:forEach>
		<%-- <% } %> --%>
	</table>
</body>
</html>