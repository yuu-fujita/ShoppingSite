<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DANRAKU_新規会員登録</title>
<%@include file="../header.jsp" %>
<link href="${pageContext.request.contextPath}/css/style.css?20230620" rel="stylesheet" media="all" type="text/css" />
<link href="${pageContext.request.contextPath}/css/headerStyle.css?20230620" rel="stylesheet" media="all" type="text/css" />
<link href="${pageContext.request.contextPath}/css/registStyle.css?20230622" rel="stylesheet" media="all" type="text/css" />
</head>
<body>
	<%@page import = "jp.co.aforce.bean.MemberBean" %>
	<% MemberBean r = (MemberBean)session.getAttribute("register"); %>
	<!-- 登録画面作成 -->
	<div class="mainContent">
   <form action = "registservlet" method = "post">
     <h2>会員情報登録</h2>
     <p>■ID<span class="req">必須</span></p>
    <input type= "text" name = "member_id" maxlength="20" required = "required"  pattern="^[a-zA-Z0-9]+$" placeholder="※20文字以内の半角英数字" >
     <p>■パスワード<span class="req">必須</span></p>
    <input type= "password" name = "password" maxlength="20" required = "required"  pattern="^[a-zA-Z0-9]+$" placeholder="※20文字以内の半角英数字">
     
     <p>■名前<span class="req">必須</span></p>
    <input type= "text" name = "member_name" maxlength="30" required = "required" placeholder="例) 山田 太郎" >
    
     <p>■住所<span class="req">必須</span></p>
     <input type= "text" name = "home_address" maxlength="120" required = "required"  placeholder="例) 東京都千代田区飯田橋0-0-0">
     
     <p>■生年月日<span class="req">必須</span><br>
    <%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
  	<p class="birth">
    <select id="release_year" name="birth_year" required>
			<option value="">年</option>
			<% for (int year = 1923; year <= 2024; year++) { %>
			<option value="<%= year %>"><%= year %></option>
			<% } %>
	</select>
	<select id="release_month" name="birth_month" required>
			<option value="">月</option>
			<% for (int month = 1; month <= 12; month++) {%>
			<option value="<%= month %>"><%= month %></option>
			<% } %>
		</select>

		<select id="release_day" name="birth_day" required>
			<option value="">日</option>
			<% for (int day = 1; day <= 31; day++) {%>
			<option value="<%= day %>"><%= day %></option>
			<% } %>
		</select>
     </p>
     </p>
     
     <p>■職業<span class="req">必須</span><br>
    <select name="job" required = "required" placeholder="例) 山田 太郎">
      <option value="">※選択してください</option>
      <option value="会社員">会社員</option>
      <option value="自営業">芸人</option>
      <option value="学生">学生</option>
      <option value="その他">その他</option>
    </select></p>
     
     <p>■電話番号<span class="req">必須</span><br>
    <input type = "tel" name = "phone_number" maxlength="20" required = "required"  pattern="[\d\-]*" placeholder="例) 000-0000-0000" class="mail"></p>
  
     <p>■メールアドレス<span class="req">必須</span><br>
    <input type = "email" name = "mail_address" maxlength="30" required = "required" placeholder="例) info@example.com" class="mail"></p>
    <input type="reset" value="入力内容をリセット" class="miniButton" onclick="return confirmDelete()">
	
	<div class="buttons">
		<button type="button" onclick="goBack()" class="underButton">戻る</button>
		<input type = "submit" value = "登録" class="underButton">
	</div>
 
   </form>
   </div>
	<script>
		<!-- 戻るボタンがrequiredを無視 -->
		function goBack(){
			window.history.back();
		}

		<!-- リセットボタン押下時の確認 -->
		function confirmDelete() {
			return confirm("内容がリセットされますがよろしいですか？");
		}
	</script>
   
<%@include file="../footer.jsp" %>