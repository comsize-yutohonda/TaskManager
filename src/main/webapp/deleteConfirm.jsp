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
		//すべてのタスク
		List<TaskDisplayBean> beanList = (ArrayList<TaskDisplayBean>)session.getAttribute("taskDisplayBeanList");
		//削除対象のタスクID
		int[] deleteIdArray = (int[])session.getAttribute("deleteIdArray");
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
		<%
			for(TaskDisplayBean bean : beanList){ 
				if(bean.getTaskId())
		%>
		<tr>
			<!-- タスク名 -->
			<td class = "border">
				<%=bean.getTaskName() %>
			</td>
			<!-- カテゴリ情報 -->
			<td class = "border"><%=bean.getCategoryName()%></td>
			<!-- 期限 nullの場合「未入力」表示 -->
			<td class = "border">
				<%if(bean.getLimitDate() == null){ %>
					未入力
				<%}else{ %>
					<%=bean.getLimitDate()%>
				<%} %>
			</td>
			<!-- 担当者情報 -->
			<td class = "border"><%=bean.getUserName()%></td>
			<!-- ステータス情報 -->
			<td class = "border"><%=bean.getStatusName()%></td>
			<!-- メモ nullの場合「未入力」表示 -->
			<td class = "border">
				<%if(bean.getMemo() == null){ %>
					未入力
				<%}else{ %>
					<%=bean.getMemo()%>
				<%} %>
			</td>
		</tr>
	</table>
	<form action="task-delete-servlet" method="post">	
			<input type="submit" value="削除">
	</form>
		
	<%
		}
	%>
</body>
</html>