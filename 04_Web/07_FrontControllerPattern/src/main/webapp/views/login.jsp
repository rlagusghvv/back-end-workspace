<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>로그인</h1>
	<form action = "/front" method = "post">
	<input type="hidden" name="command" value="login">
	ID : <input type="text" name = "id"> <br>
	PassWord : <input type="password" name="pwd"><br>
	<input type="submit" value="로그인">
	</form>
</body>
</html>