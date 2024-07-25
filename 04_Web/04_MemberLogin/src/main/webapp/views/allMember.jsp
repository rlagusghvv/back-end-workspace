<%@page import="com.kh.modle.vo.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>전체 회원 목록</h1>
<a href="/">메인 페이지로 이동</a>
<% List<Member> list = (List<Member>)request.getAttribute("list"); %>
<table border="1">
<tr>
<th>아이디</th>
<th>비밀번호</th>
<th>이름</th>
</tr>

<%for(Member m : list) {%>
<tr>
<td><%=m.getId() %></td>
<td><%=m.getPwd() %></td>
<td><%=m.getName() %></td>
</tr>
<%} %>

</table>
</body>
</html>