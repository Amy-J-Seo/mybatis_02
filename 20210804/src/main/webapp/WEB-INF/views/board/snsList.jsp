<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SNS LIST</title>
</head>
<body>
<div align="center">
<div>
<h1>게시글 목록</h1>
</div>
<div>
	<c:forEach var="sns" items="${list }">
		title: ${sns.STitle }<br>
	</c:forEach>
	<br>
	<hr>
	<div>
		<form id="frm" name="frm" action="snsSelect.do" method="post">
			댓글을 보고싶은 원글의 넘버를 입력하세용:
			<input id="sno" name="sno" type="text">
			<button type="submit">찾기!!</button>
		</form>
	</div>
</div>

</div>
</body>
</html>