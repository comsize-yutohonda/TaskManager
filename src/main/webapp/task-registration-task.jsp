<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク登録画面</title>
</head>
<body>

<font size="5">タスク登録画面</font><br>
　<br>

<font size="2">タスク情報を入力してください。</font><br>
　<br>

<form action = "task-register-servlet">

<table>
<tr>
<th>タスク名</th>
<td> <input type="text" name="taskName" maxlength="50" required></td>
</tr>

<tr>
<th>カテゴリ情報</th>
<td></td>
</tr>

<tr>
<th>期限</th>
<td><input type="date"></td>
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
<td><input type = "textarea" name= "memo" maxlength="100" rows="3"></td>
</tr>


</table>

<br>
<imput type="submit" name="登録">　<input type="reset" value="クリア">

</form>



</body>
</html>