<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<div>
			<form id="frm" name="frm" action="editMain.do" method="post">
				<input type="hidden" id="sNo" name="sNo" value="${sNo }">
				title: <input type="text" id="sTitle" name="sTitle"> <br>
				content: <input type="text" id="sContent" name="sContent"> <br>
				<button type="submit">수정</button>				
			</form>
		</div>
	</div>
</body>
</html>