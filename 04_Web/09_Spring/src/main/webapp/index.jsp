<%@page import="com.kh.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 관리</title>
</head>
<body>
	<h1>회원 관리 기능</h1>
	<!-- 클라이언트 단 -->
	<ul>
		<c:choose>
			<c:when test="${empty member}">
				<li><a href="/register">회원가입</a></li>
				<li><a href="/login">로그인</a></li>
			</c:when>
			<c:otherwise>
			<!-- 로그인 된 경우 -->
			<li><a href="/search">회원검색</a></li>
			<!-- 회원검색 : 검색할 아이디 입력받아서
						 호출 : /search, 방식 : get
						 SearchServlet
						 성공하면 views/search_ok.jsp 해당 정보 출력
						 실패하면 views/search_fail.jsp "검색 실패했습니다" 출력
			 -->
			<li><a href="/allMember">전체회원보기</a></li>
			<!-- 전체회원보기 : views/allMember.jsp에 리스트 출력 -->
			<li><a href="/logout">로그아웃</a></li>
			<!-- 로그아웃 : 로그아웃하고 index.jsp로! -->
			</c:otherwise>
		</c:choose>
	</ul>
</body>
</html>