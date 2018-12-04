<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/complaintSystem/showComplaints" method="post" id="passwordForm" style="display:block;">
		
		Password: <input type="password" name="pass" /></br>
		<input type="submit" value="Submit"/>
		
	</form>
	<h2>${ErrorMessage}</h2>

</body>
</html>