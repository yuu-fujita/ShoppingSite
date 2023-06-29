<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DANRAKU_ホーム</title>
<%@include file="../header.jsp" %>
<link href="${pageContext.request.contextPath}/css/headerStyle.css?20230620" rel="stylesheet" media="all" type="text/css" />
<link href="${pageContext.request.contextPath}/css/style.css?20230620" rel="stylesheet" media="all" type="text/css" />
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>

	<div class="loginButton">
		<form action = "login2" method = "post">
			<p>初めての方はこちら</p>
			<p class="button"><input type = "submit" value = "新規会員登録"></p>
		</form>
		<form action = "login" method = "post">
			<p>ログインに進む</p>
			<p class="button"><input type = "submit" value = "　ログイン　"></p>
		</form>
	</div>
	<script src="../js/sample_javascript.js"></script>        
</body>
<%@include file="../footer.jsp" %>