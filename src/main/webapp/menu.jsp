<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="itemlistservlet" method="post">
		<h1>メニュー画面</h1><br>
		<hr>
		<%
UserBean bean = (UserBean)session.getAttribute("username");
	%>
	ようこそ!<%=bean.getUserName()%>さん<br>
		<input type=submit value=商品一覧>
	</form>
	<form action="itemAddServlet" method="GET">
		<input type="submit" value="商品登録">
	</form>
	<form action="logout-success.jsp" method="POST">
		<input type="submit" value="ログアウト">
	</form>
</body>
</html>