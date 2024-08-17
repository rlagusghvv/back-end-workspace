<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous" />
</head>
<body>
	<div class="container">
		<div class="header">
			<h1>List page</h1>
			<a href="/write" class="btn btn-outline-warning">게시글 등록</a>
		</div>

		<table class="table">
			<thead>
				<tr>
					<th>#번호</th>
					<th>이미지</th>
					<th>제목</th>
					<th>작성시간</th>
				</tr>
			</thead>
			<c:forEach var="item" items="${list }">
				<tbody>
				<tr>
					<th>${item.no }</th>
					<th><img src="http://192.168.10.6:8080/img/user_img/${item.url }"  alt="이미지" style="width: 150px; height: 150px;"></th>
					<th>${item.title }</th>
					<th>${item.date }</th>
				</tr>
				</tbody>
			</c:forEach>
		</table>

	</div>
</body>
</html>