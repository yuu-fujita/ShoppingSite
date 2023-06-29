<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DANRAKU_商品ページ</title>
<%@include file="../header_user.jsp" %>
<link href="${pageContext.request.contextPath}/css/headerStyle_user.css?20230620" rel="stylesheet" media="all" type="text/css" />
<link href="${pageContext.request.contextPath}/css/style.css?20230620" rel="stylesheet" media="all" type="text/css" />
</head>
<body>
	<div class="test">
		<form action = "itemtransition" method = "post">
			<p>メニュー画面</p>
			<p><input type = "submit" value = "検索に進む"></p>
		</form>
	  
		<form action = "itemtransition2" method = "post">
			<p><input type = "submit" value = "カート画面に進む"></p>
		</form>
	
	</div>
<script src="../js/sample_javascript.js"></script>
</body>
<%@include file="../footer.jsp" %>