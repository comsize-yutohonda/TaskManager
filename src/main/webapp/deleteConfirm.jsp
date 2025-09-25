<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.TaskDisplayBean, java.util.List, java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>タスク削除確認画面</title>
	<style type="text/css">
		.border {
			border:1px solid;
		}
	</style>
</head>
<body>
	<h1>タスク削除確認画面</h1>
	<hr>
	<p>タスク情報を削除します。よろしいですか？</p>
	
	<%
		//削除対象のタスク
		TaskDisplayBean deleteBean = (TaskDisplayBean)session.getAttribute("deleteBean");
	%>
	
	<table class = "border">
		<tr>
			<th class = "border">タスク名</th>
			<th class = "border">カテゴリ情報</th>
			<th class = "border">期限</th>
			<th class = "border">担当者情報</th>
			<th class = "border">ステータス情報</th>
			<th class = "border">メモ</th>
		</tr>
		<tr>
			<!-- タスク名 -->
			<td class = "border">
				<%=deleteBean.getTaskName() %>
			</td>
			<!-- カテゴリ情報 -->
			<td class = "border"><%=deleteBean.getCategoryName()%></td>
			<!-- 期限 nullの場合「未入力」表示 -->
			<td class = "border">
				<%if(deleteBean.getLimitDate() == null){ %>
					未入力
				<%}else{ %>
					<%=deleteBean.getLimitDate()%>
				<%} %>
			</td>
			<!-- 担当者情報 -->
			<td class = "border"><%=deleteBean.getUserName()%></td>
			<!-- ステータス情報 -->
			<td class = "border"><%=deleteBean.getStatusName()%></td>
			<!-- メモ nullの場合「未入力」表示 -->
			<td class = "border">
				<%if(deleteBean.getMemo() == null){ %>
					未入力
				<%}else{ %>
					<%=deleteBean.getMemo()%>
				<%} %>
			</td>
		</tr>
	</table>
	<form action="task-delete-servlet" method="post">	
			<input type="submit" value="削除">
	</form>
		
</body>
</html>