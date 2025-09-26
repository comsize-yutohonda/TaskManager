<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List,java.util.ArrayList,model.entity.TaskBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録完了</title>
</head>
<body>

	<font size="5">タスク登録完了</font>
	<br>
	<br>

	<font size="2">以下のタスク情報を登録しました。</font>
	<br>
	<br>
	
	
	
	<table border="1">
		<tr>
			<th>タスク名</th>
			<td><%=session.getAttribute("taskName") %></td>
		</tr>
		
		<tr>
			<th>カテゴリ</th>
			<td><%=session.getAttribute("categoryName") %></td>
		</tr>
		
		<tr>
			<th>期限</th>
			<td><%=session.getAttribute("limit") %></td>
		</tr>
		
		<tr>
			<th>担当者</th>
			<td><%=session.getAttribute("userName") %></td>
		</tr>
		
		<tr>
			<th>ステータス</th>
			<td><%=session.getAttribute("statusName") %></td>
		</tr>
		
		<tr>
			<th>メモ</th>
			<td><%=session.getAttribute("memo") %></td>
		</tr>
		
	</table>
	
	<br>
	
	<form action="menu-servlet" method="POST">
	<input type="submit" value="メニュー画面に戻る">
	</form>


</body>
</html>