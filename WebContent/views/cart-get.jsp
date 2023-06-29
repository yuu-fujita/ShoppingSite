<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DANRAKU_カート画面</title>
<!--  <div id = "headerview">-->
<%@include file="../header_user.jsp" %>
<link href="${pageContext.request.contextPath}/css/headerStyle_user.css?20230620" rel="stylesheet" media="all" type="text/css" />
<link href="${pageContext.request.contextPath}/css/cartStyle.css?20230626" rel="stylesheet" media="all" type="text/css" />
<link href="${pageContext.request.contextPath}/css/style.css?20230626" rel="stylesheet" media="all" type="text/css" />
<!-- </div>-->
</head>
<body>
<!-- カート画面 -->
<form action = "carttransition" method = "post" >
	<p><input type = "submit" value = "戻る" class="button backButton"></p>
</form>
<div class="cartContent">
	<div class="cart">
		<table>
			<tr>
				<th class="imgTh">商品画像</th>
				<th>商品名</th>
				<th>価格</th>
				<th>個数</th>
				<th>カートから削除</th>
				<th>小計</th>
			</tr>
			<%
				List<ItemBean> cart = (List<ItemBean>) session.getAttribute("cart");
				int totalAmount = 0;
				if (cart != null) {
					for (ItemBean item : cart) {
						totalAmount += (item.getPrice() * item.getCount());
			%>
			<tr>
				<td class="imgTd"><img src="../img/<%= item.getItem_id() %>.jpg" height="96"></td>
				<td class="itemName"><%= item.getItem_name() %></td>
				<td class="price number"><%= item.getPrice() %>円</td>
				<td class="count">
					<!-- 個数を減らす -->
					<form action="cartgetreduce" method="post" class="button countButton">
						<input type="hidden" name="item_name" value="<%= item.getItem_name() %>">
						<input type="hidden" name="item_id" value="<%= item.getItem_id() %>">
						<input type="hidden" name="price" value="<%= item.getPrice() %>">
						<input type="submit" value="－">
					</form>			
					<%= item.getCount() %>個
					<!-- 個数を増やす -->
					<form action="cartgetadd" method="post" class="button countButton">
						<input type="hidden" name="item_name" value="<%= item.getItem_name() %>">
						<input type="hidden" name="item_id" value="<%= item.getItem_id() %>">
						<input type="hidden" name="price" value="<%= item.getPrice() %>">
						<input type="hidden" name="stock" value="<%= item.getStock() %>">
						<input type="submit" value="＋">
					</form>
					<% if (item.getStock() == item.getCount()) { %>
						<p class="countMessage">※購入上限です</p>
					<% } %>
					</td>
					<td class="delete">
					<!-- カートから削除する -->
					<form action="cartremoveaction" method="post" class="button deleteButton">
						<input type="hidden" name="item_id" value="<%= item.getItem_id() %>">	
						<input type="image" src="../img/ゴミ箱アイコン.png" alt="削除" height="32" width="70">
					</form>				
					<!-- 小計 -->
					<% 
						int subTotal = 0;
						subTotal = item.getPrice() * item.getCount();
					%>
					<td class="subTotal number"><%= subTotal %>円</td>
				</td>
			</tr>
			<%
					}
				}
			%>
		</table>
		<!-- カートの合計金額 -->
		<p class="total number">合計：<%= totalAmount %>円</p>
	</div>
	<!-- 決済方法の選択 -->
	<p class="text1">■決済方法</p>
	<select name="purchasemethod" required="required" class="selectBox">
		<option value="">※選択してください</option>
		<option value="カード">クレジットカード</option>
		<option value="代金引換">代金引換</option>
		<option value="銀行振込">銀行振込</option>
		<option value="コンビニ">コンビニ</option>
	</select>
	<%@page import = "jp.co.aforce.bean.MemberBean, java.util.List" %>
	<% MemberBean member = (MemberBean)session.getAttribute("member"); %>
	<%if(member != null){%>
		<!-- 購入ボタン -->
		<div class="buy">
			<form action="cartpurchasetransition" method="post" class="button buyButton">
				<p><input type="submit" value="購入"></p>
			</form>
		</div>
	<!-- 未ログイン時の処理 -->
	<%}else{ %>
		<div class="loginMessage">
			<p class="loginText">商品購入の際はログインしてください</p>
			<a href="${pageContext.request.contextPath}/views/login.jsp">ログイン</a>
		</div>
		<% } %>
	</div>
	<script src="../js/sample_javascript.js">
	</script>
	<script>
		<!-- 戻るボタンの挙動 -->
		function goBack() {
			window.history.back();
		}
	</script>
<%@include file="../footer.jsp" %>