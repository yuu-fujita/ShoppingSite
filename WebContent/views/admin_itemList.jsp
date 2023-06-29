<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>DANRAKU_商品情報検索結果_管理者</title>
<%@include file="../headerAdmin.jsp" %>
<link href="${pageContext.request.contextPath}/css/headerStyle.css?20230628" rel="stylesheet" media="all" type="text/css" />
<link href="${pageContext.request.contextPath}/css/style.css?20230620" rel="stylesheet" media="all" type="text/css" />
</head>
<body>
<%@ page import="jp.co.aforce.bean.ItemBean" %>
<%@ page import="java.util.List" %>

<%	try {
	List<ItemBean> item = (List<ItemBean>) request.getAttribute("item");
%>
<div class="mainContent">
	<h2>商品情報の更新と削除</h2>
    <table border="1">
		<tr>
			<th>商品名</th>
			<th>価格</th>
			<th>分類</th>
			<th>発売日</th>
			<th>難易度</th>
			<th>在庫</th>
			<th>操作</th>
		</tr>
		<%for (ItemBean i : item){ %>
			<tr>
				<td><%=i.getItem_name() %></td>
				<td><%=i.getPrice() %>円</td>
				<td><%=i.getCategory() %></td>
				<td><%=i.getRelease_year() %>/<%=i.getRelease_month() %>/<%=i.getRelease_day() %></td>
				<td><%=i.getLevel() %></td>
				<td><%=i.getStock() %>個</td>
				<td>
					<form action="Item_editServlet" method="post">
						<input type="hidden" name="item_id" value="<%=i.getItem_id() %>">
					<input type="submit" value="更新">
					</form>
					<form action="Item_DeleteServlet" method="post" onsubmit="return confirmDelete()">
						<input type="hidden" name="item_id" value="<%=i.getItem_id() %>">
						<input type="submit" value="削除">
				</form>
				</td>
			</tr>
		<% } %> 
	</table>
	
	<script>
		function confirmDelete() {
			return confirm("本当に削除しますか？");
		}
	</script>
	    
	<a href="admin_itemSearchForm.jsp">商品検索</a>
	<a href="admin_index.jsp">管理者画面に戻る</a><br>
</div>
	
<% 
} catch (Exception e) {
	e.printStackTrace();
}
%>
<%@include file="../footer.jsp" %>