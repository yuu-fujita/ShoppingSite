<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DANRAKU_管理者画面</title>
<%@include file="../headerAdmin.jsp" %>
<link href="${pageContext.request.contextPath}/css/headerStyle.css?20230628" rel="stylesheet" media="all" type="text/css" />
<link href="${pageContext.request.contextPath}/css/style.css?20230620" rel="stylesheet" media="all" type="text/css" />
</head>
<body>
	<div class="mainContent">
		<h2>DANRAKU_管理者ページ</h2>
		<a href="admin_register.jsp" class="adminSelect">商品の登録</a><br>
		<a href="admin_itemSearchForm.jsp" class="adminSelect">商品の更新と削除</a><br>
		<a href="itemsearch.jsp" class="adminSelect">ホームに戻る</a><br>
	</div>
<%@include file="../footer.jsp" %>