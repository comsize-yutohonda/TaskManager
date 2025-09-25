<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.time.LocalDate,java.time.format.DateTimeFormatter,java.util.List,java.util.ArrayList,model.dao.TaskDAO"%>
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
    
    // 日付をString型に
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
				<td><select name = "categoryName" required>
				
					<option value="" selected>選択してください</option>
					
					<%
					
					TaskDAO dao = new TaskDAO();
					List<String> categoryList = new ArrayList<>();
					categoryList = dao.categoryList(0);
					
					for(String category:categoryList){
					
					%>
					
					<option value="<%=category%>"><%=category %></option>
					
					<%
					}
					%>
					
					</select>
				
				</td>
			</tr>

			<tr>
				<th>期限</th>
				<td><input type="date" name="limit" min=<%= todayDate %>></td>
			</tr>

			<tr>
				<th>担当者情報</th>
				<td><select name="userName" required>
					<option value="" selected>選択してください</option>
					
					<%
					List<String> userList = new ArrayList<>();
					userList = dao.userList(0);
					
					for(String userName:userList){
					
					%>
					<option value="<%=userName%>"><%=userName %></option>
					
					<%
					}
					%>
					</select>
				</td>
			</tr>

			<tr>
				<th>ステータス情報</th>
				<td><select name = "statusName" required>
					<option value="" selected>選択してください</option>
					
					<%
					List<String> statusList = new ArrayList<>();
					statusList = dao.statusList(0);
					
					for(String statusName : statusList){
					%>
					
					<option value="<%=statusName%>"><%=statusName%></option>
					<%
					}
					%>
					</select>
				</td>
			</tr>

			<tr>
				<th>メモ</th>
				<td><textarea name="memo" rows="5" cols="50" maxlength="100"></textarea></td>
			</tr>


		</table>

		<br> <input type="submit" value="登録"> <input type="reset"value="クリア">

	</form>

	<form action="menu-servlet" method="POST">
		<input type="submit" value="メニュー画面に戻る">
	</form>



</body>
</html>