<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DANRAKU_購入完了画面</title>
<%@include file="../header_user.jsp" %>
<link href="${pageContext.request.contextPath}/css/headerStyle_user.css?20230620" rel="stylesheet" media="all" type="text/css" />
<link href="${pageContext.request.contextPath}/css/style.css?20230620" rel="stylesheet" media="all" type="text/css" />
<link href="${pageContext.request.contextPath}/css/loginStyle.css?20230620" rel="stylesheet" media="all" type="text/css" />
</head>
<body>
	<div class="mainContent">
		<p>お買い上げありがとうございました！</p>
		<p>商品の到着までお待ちください。</p>
		<form action = "itemsearch.jsp" method = "post">
			<p><input type = "submit" value = "ホームに戻る"></p>
		</form>
	</div>
<%@include file="../footer.jsp" %>