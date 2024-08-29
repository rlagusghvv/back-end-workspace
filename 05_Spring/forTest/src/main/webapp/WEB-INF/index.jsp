<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원가입</h1>
<form action="/register" method="post"><label>아이디 : <input type="text" name="id"> </label><br><br>
<label>비밀번호 : <input type="password" name="password"> </label><br><br>
<label>닉네임 : <input type="text" name="name"> </label>   <br><br>
<input type="submit" value="제출하기">
</form>
</body>
</html>