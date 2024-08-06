<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>아티스트 찾기</title>
  </head>
  <body>
    <h1>아티스트 찾기</h1>
    <form action="addMusic" method="post">
      <label for="musicName">Music Name : </label>
      <input type="text" id="musicName" name="musicName" required />
      <button type="submit">Search</button>
    </form>
  </body>
</html>
