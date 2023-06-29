<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DANRAKU_カート画面</title>
<%@include file="../header_user.jsp" %>
<link href="${pageContext.request.contextPath}/css/headerStyle_user.css?20230620" rel="stylesheet" media="all" type="text/css" />
<link href="${pageContext.request.contextPath}/css/style.css?20230620" rel="stylesheet" media="all" type="text/css" />
<link href="${pageContext.request.contextPath}/css/loginStyle.css?20230620" rel="stylesheet" media="all" type="text/css" />
</title>
</head>
<body>
	<div class="mainContent">
		<form action = "logout2" method = "post">
			<p class="logoutMessage">カートに商品がありません。</p>
			<p><input type = "submit" value = "検索ページへ戻る"></p>
		</form>
	</div>
<%@include file="../footer.jsp" %>