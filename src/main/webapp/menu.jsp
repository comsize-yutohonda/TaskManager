<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="task-register-servlet" method="post">
		<h1>メニュー画面</h1><br>
		<hr>
		<input type=submit value="タスク登録">
	</form>
	<form action="task-display-servlet" method="GET">
		<input type="submit" value="タスク一覧表示">
	</form>
	<form action="logout-servlet" method="POST">
		<input type="submit" value="ログアウト">
	</form>
</body>
</html>