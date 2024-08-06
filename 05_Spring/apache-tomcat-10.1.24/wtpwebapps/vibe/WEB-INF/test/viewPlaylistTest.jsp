<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 플레이리스트 -->
    <form action="/viewPlaylist" method="post">
      <table border="1">
        <tr>
          <th>플리 코드</th>
          <th>제목명</th>
          <th>이미지</th>
          <th>날짜</th>
          <th>공개여부</th>
          <th>이메일</th>
        </tr>
        <tr>
          <td>${playlist.plCode}</td>
          <td>${playlist.plTitle}</td>
          <td>${playlist.plImg}</td>
          <td>${playlist.plDate}</td>
          <td>${playlist.plPublicYn}</td>
          <td>${playlist.userEmail}</td>
          <!-- <input type="email" id="userEmail" name="userEmail" required> -->
        </tr>
      </table>
    </form>
</body>
</html>