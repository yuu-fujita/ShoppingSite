<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="../header_user.jsp" %>
<link href="${pageContext.request.contextPath}/css/headerStyle_user.css?20230620" rel="stylesheet" media="all" type="text/css" />
<link href="${pageContext.request.contextPath}/css/style.css?20230620" rel="stylesheet" media="all" type="text/css" />
<link href="${pageContext.request.contextPath}/css/loginStyle.css?20230620" rel="stylesheet" media="all" type="text/css" />
</head>
<body>
		
	<div class="mainContent">
	
		<form action = "delete3" method = "post">
			<h3 class = "logoutMessage">削除に進みますか？</h3>
			<p><input type = "submit" value = "はい" class = "deleteyes"></p>
		</form>
		<form action = "itemtransition" method = "post">
			<p><input type = "submit" value = "いいえ" ></p>
		</form>
		
	</div>
		
</body>
<%@include file="../footer.jsp" %>
</html>