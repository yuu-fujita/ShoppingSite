<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DANRAKU_ホーム</title>
<%@include file="../header_user.jsp" %>
<link href="${pageContext.request.contextPath}/css/headerStyle_user.css?20230620" rel="stylesheet" media="all" type="text/css" />
<link href="${pageContext.request.contextPath}/css/homeStyle.css?20230623" rel="stylesheet" media="all" type="text/css" />
</head>
<body>
	<div class="mainContent">
		<div class="titleText">
			<h1 class="logo">DANRAKU</h1>
			<h2 class="logo">台本販売サイト</h2>
			<p class="mainText">
				当店は台本販売サイトとなっております。<br>
				お客様のスタイルに合わせた台本を適切な価格で販売いたします。<br>
				※返品、返金は承りませんのでご了承ください。
			</p>
		</div>
		<!-- キーワード検索 -->
		<div class="keywordSearch">
			<p>▼商品名で探す</p>
			<form action = "itemsearch" method = "post" class="search">
				<p><input type = "text" name = "item_name" required = "required" placeholder="キーワードを入力"></p>
				<p><input type = "submit" value = "検索"  class="searchButton"></p>
			</form>
		</div>
		<!--  
		<form action = "carttransition" method = "post">
			<p><input type = "submit" value = "戻る"  class="returnButton"></p>
		</form>
		-->
		
		<!-- 分類絞り込み -->
		<div class="cetegorySearch">
			<p>▼カテゴリーで探す</p>
			<div class="cetegorySearchButtonContainer">
				<form action = "searchall" method = "post">
					<p><input type = "submit" value = "すべて" class="cetegorySearchButton"></p>
				</form> 
			    
				<form action = "searchcategory" method = "post">
					<input type="hidden" name="keyword" value="漫才台本">
					<p><input type = "submit" value = "漫才台本" class="cetegorySearchButton"></p>
				</form>
			   
				<form action = "searchcategory" method = "post">
					<input type="hidden" name="keyword" value="コント台本">
						<p><input type = "submit" value = "コント台本" class="cetegorySearchButton"></p>
				</form>
			   
				<form action = "searchcategory" method = "post">
					<input type="hidden" name="keyword" value="ピンネタ台本">
					<p><input type = "submit" value = "ピンネタ台本" class="cetegorySearchButton"></p>
				</form>
			</div>
			<div class="cetegorySearchButtonContainer">
				<form action = "searchcategory" method = "post">
					<input type="hidden" name="keyword" value="一発ギャグ台本"> 
					<p><input type = "submit" value = "一発ギャグ台本" class="cetegorySearchButton"></p>
				</form>
			   
				<form action = "searchcategory" method = "post">
					<input type="hidden" name="keyword" value="エピソードトーク台本">
					<p><input type = "submit" value = "エピソードトーク台本" class="cetegorySearchButton"></p>
				</form> 
			    
				<form action = "searchcategory" method = "post">
				   <input type="hidden" name="keyword" value="舞台衣装"> 
					<p><input type = "submit" value = "舞台衣装" class="cetegorySearchButton"></p>
				</form>
			   
				<form action = "searchcategory" method = "post">
					<input type="hidden" name="keyword" value="その他"> 
					<p><input type = "submit" value = "その他" class="cetegorySearchButton"></p>
				</form> 
			</div>
		</div>
		
		<!-- 価格絞り込み -->
		<div class="priceSearch">
			<p>▼価格で探す</p>
			<div class="cetegorySearchButtonContainer">
				<form action = "searchprice" method = "post">
					<input type="hidden" name="pricemin" value="0">
					<input type="hidden" name="pricemax" value="999">
			    	<p><input type = "submit" value = "0-999円" class="priceSearchButton"></p>
				 </form>
			   
				<form action = "searchprice" method = "post">
					<input type="hidden" name="pricemin" value="1000">
					<input type="hidden" name="pricemax" value="4999">
					<p><input type = "submit" value = "1,000-4,999円" class="priceSearchButton"></p>
				</form>
			   
				<form action = "searchprice" method = "post">
					<input type="hidden" name="pricemin" value="5000">
					<input type="hidden" name="pricemax" value="9999">
					<p><input type = "submit" value = "5,000-9,999円" class="priceSearchButton"></p>
				</form>
			   
				<form action = "searchprice" method = "post">
					<input type="hidden" name="pricemin" value="10000">
					<input type="hidden" name="pricemax" value="100000">
					<p><input type = "submit" value = "10,000-100,000円" class="priceSearchButton"></p>
				</form>
			</div>
		</div>
	</div>
<%@include file="../footer.jsp" %>