<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Insert title here</title>
<style type="text/css">
table, tr, td {
border: 1px solid black;
}
</style>
</head>
<body>
	<table >
		<c:forEach items="${complaints}" var="complaint">
		<tr>
			<td>Id</td>
			<td>Name</td>
			<td>Email</td>
			<td>Message</td>
		</tr>
		
		<tr style="border: 1px solid black;">
			<td><c:out value="${complaint.complaintId}" /></td>
			<td><c:out value="${complaint.senderName}" /></td>
			<td><c:out value="${complaint.senderEmail}" /></td>
			<td><c:out value="${complaint.complaintMessage}" /></td>
		</tr>
		
		</c:forEach>
	</table>
</body>
</html>