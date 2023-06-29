<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DANRAKU_商品情報削除完了_管理者</title>
<%@include file="../headerAdmin.jsp" %>
<link href="${pageContext.request.contextPath}/css/headerStyle.css?20230628" rel="stylesheet" media="all" type="text/css" />
<link href="${pageContext.request.contextPath}/css/style.css?20230620" rel="stylesheet" media="all" type="text/css" />
</head>
<body>

	<h2>商品を削除しました。</h2><br>
	<a href="admin_itemSearch.jsp">続けて商品管理を行う</a><br>
	<a href="admin_index.jsp">管理者画面に戻る</a><br>
	<a href="itemsearch.jsp">ホームに戻る</a><br>

<%@include file="../footer.jsp" %>