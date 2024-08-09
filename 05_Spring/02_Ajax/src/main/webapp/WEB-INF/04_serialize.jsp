<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입</h1>

	<form id="frm">
		아이디 : <input type="text" name="id" id="id"><br> 
		비밀번호 : <input	type="password" name="password" id="password"><br>
		이름 : <input type="text" name="name" id="name"><br> 
		<input	type="button" value="가입" id="btn">
	</form>
	
	<div id="result"></div>
	
	<script>
	$("#btn").click(()=> {
		$.ajax({
		
		
		// 요청
		// post 방식으로
		type:"post",
		// /serial
		url: "/serial",
		// id, password, name 값 넘겨서 회원가입 하고
		/* { js에서 객체 보내는 법
			키 :값,
			키 :값,
			......
		} */
		data: $("#frm").serialize(),
		// 응답
		success: function(result){
			// 돌아와서 result에 정보 기재
			 $("#result").text("ID: " + result.id + ", Password: " + result.password + ", Name: " + result.name);
		},
		error: function(){
			alert("회원가입 실패!")
		}
		
		});
	});
	</script>
</body>
</html>