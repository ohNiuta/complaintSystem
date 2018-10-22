<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Message: </br><textarea rows="500" form="complaintForm" name="complaint" style="height: 200px; font-size:14px">
	</textarea></br>
	
	<form action="/complaintSystem/submitComplaint" method="post" id="complaintForm" style="display:block;">
		
		Email :<input type="email" name="email" /></br>
		Name: <input type="text" name="name" /></br>
		<input type="submit" value="Submit"/>
		
	</form>
</body>
</html>