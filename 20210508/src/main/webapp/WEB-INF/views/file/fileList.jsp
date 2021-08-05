<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function fileDown(orgFile, downFile) {
		frm.orgFile.value = orgFile;
		frm.downFile.value = downFile;
		frm.submit();
		
	}
</script>
</head>
<body>
	<div align="center">
		<div>
			<h1>File List</h1>
		</div>
		<div>
			<table border="1">
				<tr>
					<th width="100">File num</th>
					<th width="200">File name</th>
					<th width="300">subject</th>
				</tr>
				<c:forEach var="file" items="${files }">
					<tr>
						<td align="center">${file.num }</td>
						<td onclick="fileDown('${file.fileName }','${file.downFile }')" style="cursor: pointer;">
						${file.fileName }<input type="hidden" value="${file.downFile }">
						</td>
						<td>${file.subject }</td>
				</c:forEach>
			</table>

		</div>
		<form id="frm" name="frm" action="fileDownLoad.do" method="post">
			<input id="orgFile" name="orgFile" type="hidden"> <input
				id="downFile" name="downFile" type="hidden">
		</form>

	</div>
</body>
</html>