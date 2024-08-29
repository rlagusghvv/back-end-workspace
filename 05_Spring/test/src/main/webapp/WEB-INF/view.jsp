<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원정보</h1>
<table>
<tr>
<td>아이디</td>
<td>이름</td>
</tr>
<c:forEach var="user" items="${user}">
<tr>
<td>${user.id }</td>
<td>${user.name }</td>
</tr>
</c:forEach>
</table>
</body>
</html>