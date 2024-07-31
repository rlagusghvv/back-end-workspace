<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<table border="1">
<tr>
<th>번호</th>
<th>아이디</th>
<th>비밀번호</th>
<th>이름</th>
</tr>

<c:forEach var="member" items="${list}" varStatus="status">
<tr>
<td>${status.index}</td>
<td>${member.id}</td>
<td>${member.pwd}</td>
<td>${member.name}</td>
</tr>
</c:forEach>

</table>
</body>
</html>