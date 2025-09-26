<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.TaskDisplayBean, java.util.List, java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>タスク削除完了画面</title>
	<style type="text/css">
		.border {
			border:1px solid;
		}
	</style>
</head>
<body>
	<h1>タスク削除完了画面</h1>
	<hr>
	<p>タスク情報の削除に成功しました。</p>
	
	<form action="menu-servlet" method="post">	
			<input type="submit" value="メニュー画面へ">
	</form>
		
</body>
</html>