<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

 <c:choose>
 	<c:when test='${ param.c == "red"}'><h1 style = 'color:red'>hello jstl/el</h1></c:when>
 	<c:when test='${ param.c == "blue"}'></c:when>
 	<c:when test='${ param.c == "green"}'></c:when>
 	<c:when test='true'></c:when>
 	<c:otherwise></c:otherwise>
 </c:choose>
 

	<h1 style = 'color:blue'> hello hstl/el</h1>
</body>
</html>