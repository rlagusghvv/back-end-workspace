
<%@page import="com.kh.modle.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원 검색 결과</h1>

<ul>
<li> 아이디 :${requestScope.member.id}</li>
<li> 비밀번호 : ${requestScope.member.pwd}</li>
<li> 이름 : ${requestScope.member.name} </li>
</ul>
</body>
</html>