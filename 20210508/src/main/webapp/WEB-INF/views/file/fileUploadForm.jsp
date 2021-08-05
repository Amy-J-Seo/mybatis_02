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
			<h1>File Upload Form</h1>
		</div>
		<div>
			<form id="frm" name="frm" action="fileUpload.do" method="post" enctype="multipart/form-data">
				<div>
					<table border="1">
						<tr>
							<th width="100">contents</th>
							<td width="400">
								<textarea id="subject" name="subject" rows="7" cols="80"></textarea>
							</td>
						</tr>
						<tr>
							<th width="100">file</th>
							<td width="200">
								<input type="file" id="fileName" name="fileName" size="60">
							</td>
						</tr>
					</table>
				</div><br>
				<div align="center">
					<input type="submit" value="Upload the file">
				</div>
			</form>
		</div>
	</div>
</body>
</html>