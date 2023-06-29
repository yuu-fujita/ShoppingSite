<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="jp.co.aforce.bean.MemberBean" %>
<%@page import = "jp.co.aforce.bean.ItemBean, java.util.List" %>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Permanent+Marker&display=swap" rel="stylesheet">
<!DOCTYPE html>
<html>
<head>
<link href="${pageContext.request.contextPath}/css/headerStyle_user.css?20230620" rel="stylesheet" media="all" type="text/css" />
<meta charset="UTF-8">
<title>header_user</title>
</head>
	<body>
	<% List<ItemBean> cart2 = (List<ItemBean>)session.getAttribute("cart"); %>
	<% int cartCount = 0; %>
	<% if(cart2 != null){ %> 
		<% for(ItemBean i : cart2){ %> 
			<%  cartCount += (i.getCount()) ; %> 
		<% } %>
	<% } %> 
		<header>
			<div class="title2">
				<a href="${pageContext.request.contextPath}/views/itemsearch.jsp">
					<h1>DANRAKU</h1>
					<h2>-台本販売サイト-</h2>
				</a>
			</div>
			<div class="actionButtons">
				<% if(session.getAttribute("member")!=null){ %>
					<span class="welcomeMessage"><%= ((MemberBean)session.getAttribute("member")).getMember_name() %>でログイン中</span>
					<div class="hoverMenu">
						<a class="myPageButton">
							<img src="${pageContext.request.contextPath}/img/人物アイコン.png" alt="マイページ" width="40" height="40">
							<div class="menuContent">
								<a href="${pageContext.request.contextPath}/views/update.jsp">登録情報の変更</a>
								<a href="${pageContext.request.contextPath}/views/deletecheck.jsp">登録情報の削除</a>
								<a href="${pageContext.request.contextPath}/views/logout">ログアウト</a>
							</div>
						</a>
					</div>
					<a href="${pageContext.request.contextPath}/views/favoriteview" class="cartButton">
						<img src="${pageContext.request.contextPath}/img/お気に入りアイコン.png" alt="お気に入り" width="40" height="40">
					</a>
					<a href="${pageContext.request.contextPath}/views/historyget" class="cartButton">
						<img src="${pageContext.request.contextPath}/img/購入履歴アイコン.png" alt="購入履歴" width="40" height="40">
					</a>
				<% }else { %>
					<div class="button welcomeMessage">
						<a href="${pageContext.request.contextPath}/views/login.jsp">ログイン</a>
					</div>

				<% } %>
				<a href="${pageContext.request.contextPath}/views/itemtransition2" class="cartButton">
					<img src="${pageContext.request.contextPath}/img/カートのアイコン素材.png" alt="カート" width="40" height="40">
					<div class="cartCount"><%=cartCount %></div>
				</a>
		</header>
	</body>
</html>
