<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DANRAKU_お気に入り</title>
<%@include file="../header_user.jsp" %>
<link href="${pageContext.request.contextPath}/css/headerStyle.css?20230620" rel="stylesheet" media="all" type="text/css" />
<link href="${pageContext.request.contextPath}/css/style.css?20230620" rel="stylesheet" media="all" type="text/css" />
<link href="${pageContext.request.contextPath}/css/loginStyle.css?20230620" rel="stylesheet" media="all" type="text/css" />
</head>
<body>
	<div class="mainContent">
		<form action = "logout2" method = "post">
			<p class="logoutMessage">お気に入りの商品はありません</p>
			<p><input type = "submit" value = "トップページへ"></p>
		</form>
	</div>
<%@include file="../footer.jsp" %>