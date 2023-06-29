<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DANRAKU_ログアウト</title>
<%@include file="../header.jsp" %>
<link href="${pageContext.request.contextPath}/css/headerStyle.css?20230620" rel="stylesheet" media="all" type="text/css" />
<link href="${pageContext.request.contextPath}/css/style.css?20230620" rel="stylesheet" media="all" type="text/css" />
<link href="${pageContext.request.contextPath}/css/loginStyle.css?20230620" rel="stylesheet" media="all" type="text/css" />
</head>
<body>
	<div class="mainContent">
		<form action = "logout2" method = "post">
			<p class="logoutMessage">削除しました。</p>
			<p><input type = "submit" value = "トップページへ"></p>
		</form>
	</div>
<%@include file="../footer.jsp" %>