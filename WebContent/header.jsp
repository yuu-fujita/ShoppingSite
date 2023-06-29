<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Permanent+Marker&display=swap" rel="stylesheet">
<!DOCTYPE html>
<html>
<head>
<link href="${pageContext.request.contextPath}/css/headerStyle.css?20230620" rel="stylesheet" media="all" type="text/css" />
<meta charset="UTF-8">
<title>header</title>
</head>
	<body>
		<header>
			<div class="title">
				<a href="${pageContext.request.contextPath}/views/itemsearch.jsp">
					<h1>DANRAKU</h1>
					<h2>-台本販売サイト-</h2>
				</a>
			</div>
			<div class="button">
				<a href="login.jsp">ログイン</a>
			</div>
		</header>
	</body>
</html>
