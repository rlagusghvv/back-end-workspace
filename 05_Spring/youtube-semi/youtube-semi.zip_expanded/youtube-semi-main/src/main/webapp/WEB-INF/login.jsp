<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/login.css"></link>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>
	<div class="container">
		<h1>로그인</h1>
		<form action="/login" method="post" onsubmit="return validate()">
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">아이디</label> <input
					type="text" class="form-control" id="id"
					aria-describedby="emailHelp">
				<div id="idCheck" class="form-text"></div>
			</div>
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">패스워드</label> <input
					type="password" class="form-control" id="password">
				<div id="pwdCheck" class="form-text"></div>
			</div>
			<button type="submit" class="btn btn-dark">로그인</button>
		</form>

	</div>
	<script src="${pageContext.request.contextPath}/js/login.js"></script>
</body>
</html>