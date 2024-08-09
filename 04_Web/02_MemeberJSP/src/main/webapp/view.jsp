<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.ArrayList"
	import="com.kh.model.vo.Member"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>회원 조회</h2>
	<form action="search">
		검색할 회원 아이디를 입력해주세요.
		<input type="text" name="id">
		<input type="submit" value="조회">
		
	</form>

	<h1>전체 리스트</h1>
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
		</tr>
		<%-- getAttribute 리스트로 가지고 와 for문 활용!--%>
		<%
		ArrayList<Member> member = (ArrayList<Member>)(request.getAttribute("list"));
		for (Member m : member) {
		%>
		<tr>
			<th><%=m.getId()%></th>
			<th><%=m.getPassword()%></th>
			<th><%=m.getName()%></th>
		</tr>
		<%
		}
		%>
	</table> 

</body>
</html>