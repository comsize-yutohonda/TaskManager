<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.time.LocalDate,java.time.format.DateTimeFormatter"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク登録画面</title>
</head>
<body>

	<font size="5">タスク登録画面</font>
	<br>
	<br>

	<font size="2">タスク情報を入力してください。</font>
	<br>
	<br>


	<%
    // 現在の日付を取得
    LocalDate today = LocalDate.now();
    
    // 日付を 'YYYY年MM月DD日' の形式にフォーマット
    DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String todayDate = today.format(date);
%>


	<form action="task-register-servlet" method="POST">

		<table border="1">
			<tr>
				<th>タスク名</th>
				<td><input type="text" name="taskName" maxlength="50" required></td>
			</tr>


			<tr>
				<th>カテゴリ情報</th>
				<td></td>
			</tr>

			<tr>
				<th>期限</th>
				<td><input type="date" name="limit" min=<%= todayDate %>></td>
			</tr>

			<tr>
				<th>担当者情報</th>
				<td></td>
			</tr>

			<tr>
				<th>ステータス情報</th>
				<td></td>
			</tr>

			<tr>
				<th>メモ</th>
				<td><textarea name="memo" rows="5" cols="50" maxlength="100"></textarea></td>
			</tr>


		</table>

		<br> <input type="submit" value="登録"> <input type="reset"
			value="クリア">

	</form>

	<form action="menu-servlet" method="POST">
		<input type="submit" value="メニュー画面に戻る">
	</form>



</body>
</html>