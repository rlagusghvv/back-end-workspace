<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 비동기적으로 처리하는 방식 -->
	<!-- Ajax(Asynchronous JavaScript and XML) : 비동기적 정보 교환 기법 -->
	<h1>Show Count</h1>
	<input type="button" id="btn" value="count 증가" onClick="startRequest()">
	<p id="result"></p>
	
	<!-- 자바스크립트 방식으로 Ajax 쓰는 방법 -->
	<script>
	let xhr;
	
	function startRequest() { // 요청에 해당하는 로직을 담는 메서드
		xhr = new XMLHttpRequest();
		xhr.onreadystatechange = callback;
		// form 태그에서 지정 시 어떤 방식으로 보낼거냐(get이냐 post냐), action 어디로(url) 보낼거냐
		xhr.open("get", "/count");
		xhr.send(null); // 이때 서버로 전송된다.. 실질적인 요청이 들어간다.
	}
	
	function callback() { // 응답에 해당하는 로직을 담는 메서드
		//alert(xhr.readyState);
	 	if(xhr.readyState === 4) {
	 		if(xhr.status === 200) {
	 			const count = xhr.responseText;	// 변수에 담아놓기
	 			document.querySelector("#result").innerHTML = count;
	 		}
	 	}
	}
	</script>
</body>
</html>





