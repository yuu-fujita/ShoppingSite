<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DANRAKU_商品情報登録_管理者</title>
<%@include file="../headerAdmin.jsp" %>
<link href="${pageContext.request.contextPath}/css/headerStyle.css?20230628" rel="stylesheet" media="all" type="text/css" />
<link href="${pageContext.request.contextPath}/css/style.css?20230620" rel="stylesheet" media="all" type="text/css" />
</head>
<body>
<div class="mainContent">
<h2>商品情報の登録</h2>

	<form method="post" action="Item_registerServlet">

	  	<!-- 商品名 -->
		<label for="item_name">■商品名<br></label>
		<input type="text" id="item_name" name="item_name" required><br><br>
		
		<!-- 価格 -->
		<label for="price">■価格<br></label>
		<input type="text" id="price" name="price" required>円<br><br>
		
		<!-- 分類 -->
		<label for="category">■分類<br></label>
		<select id="category" name="category" required>
			<option value="">-- 選択してください --</option>
			<option value="漫才台本">漫才台本</option>
			<option value="コント台本">コント台本</option>
			<option value="ピンネタ台本">ピンネタ台本</option>
			<option value="一発ギャグ台本">一発ギャグ台本</option>
			<option value="エピソードトーク台本">エピソードトーク台本</option>
			<option value="舞台衣装">舞台衣装</option>
			<option value="その他">その他</option>
		</select><br><br>
	    
		<!-- 発売日 -->
		<label for="release_year">■発売日<br></label>
		<select id="release_year" name="release_year" required>
			<option value="">-- 年 --</option>
			<% for (int year = 1923; year <= 2024; year++) { %>
			<option value="<%= year %>"><%= year %></option>
			<% } %>
		</select>

	    <select id="release_month" name="release_month" required>
			<option value="">-- 月 --</option>
			<% for (int month = 1; month <= 12; month++) {%>
			<option value="<%= month %>"><%= month %></option>
			<% } %>
		</select>

		<select id="release_day" name="release_day" required>
			<option value="">-- 日 --</option>
			<% for (int day = 1; day <= 31; day++) {%>
			<option value="<%= day %>"><%= day %></option>
			<% } %>
		</select><br><br>
		
		<!-- 難易度 -->
		<label for="level">■難易度<br></label>
		<select id="level" name="level" required>
			<option value="">-- 選択してください --</option> 
			<option value="初心者向け">初心者向け</option>
			<option value="中級者向け">中級者向け</option>
			<option value="上級者向け">上級者向け</option>
			<option value="―">―</option>
		</select><br><br>
		
		<!-- 在庫 -->
		<label for="stock">■在庫<br></label>
		<input type="number" id="stock" name="stock" required>個<br><br>
	    
		<!-- ボタン -->
		<input type="submit" value="登録">
		<input type="reset" value="リセット">
		<button type="button" onclick="goBack()">戻る</button>
	</form>
</div>
	<script>
		<!-- 戻るボタンがrequiredを無視 -->
		function goBack(){
			window.history.back();
		}
	</script>

<%@include file="../footer.jsp" %>