<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
var msg;
if(msg != "")
alert(msg)
</script>
</head>
<body>
<h1>게시판</h1>
${resMsg}
<table border = 1>
	<c:forEach items="${list }" var="list">
	<tr>
		<td>${list.bno }</td>
		<td><c:out value="${list.title }"/></td>
		<td><c:out value="${list.writer }"/></td>
		<td><c:out value="${list.regdate }"/></td>
	</tr>
	</c:forEach>
</table>
















</body>
</html>