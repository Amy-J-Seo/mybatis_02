<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>원글과 댓글보기</title>
<script>
function editMainArticle(mainNo){
	editMain.mainNo.value=mainNo;
	editMain.submit();
}

</script>


</head>

<body>
	<div align="center">
	

		<div>
			<h1>원글</h1>
			${list[0].STitle } : ${list[0].SWriter } : ${list[0].SContents } 
			<button onclick="editMainArticle(${list[0].SNo})">Edit</button>
			<form id="editMain" name="editMain" action="editMainForm.do" method="post">
				<input id="mainNo" name="mainNo" type="hidden">
			</form>
		</div>
		<div>
			<h3>댓글</h3>
			<c:forEach var="comment" items="${list }">
		작성자: ${comment.CName } : ${comment.CSubject } <br>
			</c:forEach>
		</div>

	</div>
</body>
</html>