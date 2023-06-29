<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DANRAKU_会員情報削除</title>
<%@include file="../header_user.jsp" %>
<link href="${pageContext.request.contextPath}/css/style.css?20230620" rel="stylesheet" media="all" type="text/css" />
<link href="${pageContext.request.contextPath}/css/headerStyle_user.css?20230620" rel="stylesheet" media="all" type="text/css" />
</head>
<body>
   
   <!-- 登録削除画面作成 -->
   
     <!--  
     <p>名前</p>
    <input type= "text" disabled name = "member_name" required = "required">
    
     <p>住所</p>
     <input type= "text" disabled name = "home_address" required = "required">
     
     <p>生年月日<br>
  
  
    <select disabled name = "birth_year" required = "required">
      <c:forEach var = "i" begin = "1920" end = "2020">
       <option value = "${i}">${i} </option>
      </c:forEach></select> 年
  
    <select disabled name = "birth_month" required = "required">
      <c:forEach var = "i" begin = "1" end = "12">
       <option value = "${i}">${i} </option>
    </c:forEach></select> 月
  
    <select disabled name="birth_day" required = "required">
      <c:forEach var = "i" begin = "1" end = "31">
       <option value = "${i}">${i} </option>
      </c:forEach></select>　日
     </p>
     
     <p>職業<br>
    <select disabled name="job" required = "required">
      <option value="‐">‐</option>
      <option value="会社員">会社員</option>
      <option value="自営業">芸人</option>
      <option value="学生">学生</option>
      <option value="その他">その他</option>
    </select></p>
     
     <p>電話番号<br>
    <input type = "text" disabled name = "phone_number" required = "required"></p>
  
     <p>メールアドレス<br>
    <input type = "text" disabled name = "mail_address" required = "required"></p>
    -->
   
   <div class="mainContent">
   <form action = "delete3" method = "post"> 
   
    
     <p>会員情報削除</p>
     <p>ID</p>
    <input type= "text" name = "member_id" required = "required">
    
     <p>パスワード<br>
    <input type= "text" name = "password" required = "required"></p>
     
    <input type = "submit" value = "削除">
   </form>
    
		<div>
			<p><button type="button" onclick="goBack()" class="Button">戻る</button></p>
		</div>
   </div>
   
	<script>
		<!-- 戻るボタンの挙動 -->
		function goBack(){
			window.history.back();
		}
	</script>
<%@include file="../footer.jsp" %>