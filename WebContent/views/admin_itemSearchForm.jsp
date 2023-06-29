<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DANRAKU_商品情報検索_管理者</title>
<%@include file="../headerAdmin.jsp" %>
<link href="${pageContext.request.contextPath}/css/headerStyle.css?20230628" rel="stylesheet" media="all" type="text/css" />
<link href="${pageContext.request.contextPath}/css/style.css?20230620" rel="stylesheet" media="all" type="text/css" />
</head>
<body>
<div class="mainContent">
	<h3>変更したい商品検索を検索してください。</h3>
	<form action="Item_searchServlet" method="post">
		<label for="item_name">商品名:</label>
		<input type="text" id="item_name" name="item_name">
		<input type="submit" value="検索">
	</form>
	<a href="admin_index.jsp">管理者画面に戻る</a><br>
</div>
<%@include file="../footer.jsp" %>