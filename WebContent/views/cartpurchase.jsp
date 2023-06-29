<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DANRAKU_購入確認画面</title>
<%@include file="../header_user.jsp" %>
<link href="${pageContext.request.contextPath}/css/headerStyle_user.css?20230620" rel="stylesheet" media="all" type="text/css" />
<link href="${pageContext.request.contextPath}/css/style.css?20230620" rel="stylesheet" media="all" type="text/css" />
<link href="${pageContext.request.contextPath}/css/confirmStyle.css?20230627" rel="stylesheet" media="all" type="text/css" />
</head>
<body>
<p><button type="button" onclick="goBack()" class="back">戻る</button></p>
<div class = "mainContent">
	<%@page import = "jp.co.aforce.bean.ItemBean, java.util.List" %>
	<% List<ItemBean> cart = (List<ItemBean>)session.getAttribute("cart"); %>
	<%@page import = "jp.co.aforce.bean.MemberBean, java.util.List" %>
	<% MemberBean member = (MemberBean)session.getAttribute("member"); %>
	<% int total = 0; %>
	<% if(cart != null){ %> 
		<p class="message">下記の内容でよろしければ注文を確定するボタンを押してください。</p>
		<div class="listBox">
			<p class="addressText">■お届け先:<%=member.getHome_address() %></p>
			<p class="itemText">■注文内容</p>
			<% for(ItemBean i : cart){ %> 
				<p class="item">・<%=i.getItem_name() %>　<%=i.getPrice() %>円×<%=i.getCount() %></p>
				<% total += (i.getPrice() * i.getCount()); %>
			<% } %>
		<% } %> 
		<p class="numberText postage">送料：980円</p>
		<% total += 980; %>
		<p class="numberText">合計：<%= total %>円</p>
	</div>
	<form action = "cartpurchasetransition2" method = "post">
		<p class="underButton"><input type = "submit" value = "注文を確定する"></p>
	</form>
</div>
<script>
	<!-- 戻るボタン -->
	function goBack(){
	window.history.back();
	}
</script>
<%@include file="../footer.jsp" %>