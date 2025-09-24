<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.TaskDisplayBean, java.util.List, java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>タスク一覧表示画面</title>
	<style type="text/css">
		.border {
			border:1px solid;
		}
	</style>
</head>
<body>
	<h1>タスク一覧表示画面</h1>
	<hr>
	<%
		//TaskDisplayBean beans = (CategoryBean[])session.getAttribute("cateBeans");
		List<TaskDisplayBean> beanList = (ArrayList<TaskDisplayBean>)session.getAttribute("taskDisplayBeanList");
		// タスク情報の取得に失敗した場合
		if(beanList == null){
	%>
	<p>タスク情報が取得できません</p>
	
	<!-- 一覧表示 -->
	<%
		}else{
	%>
	<form action="task-delete-confirm-servlet" method="post">
		<table class = "border">
			<tr>
				<th class = "border"><!-- 削除用チェックボックス --></th>
				<th class = "border">タスク名</th>
				<th class = "border">カテゴリ情報</th>
				<th class = "border">期限</th>
				<th class = "border">担当者情報</th>
				<th class = "border">ステータス情報</th>
				<th class = "border">メモ</th>
			</tr>
			<%
				for(TaskDisplayBean bean : beanList){ 
			%>
			<tr>
				<!-- 削除用チェックボックス -->
				<td class = "border">
					<input type="checkbox" value=<%=bean.getTaskId() %> name="taskId">
				</td>
				<!-- タスク名 編集画面へのリンク -->
				<td class = "border">
					<a href="task-edit-servlet?taskId=<%=bean.getTaskId() %>"><%=bean.getTaskName() %></a>
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
			<%
				} 
			%>
		</table>
		
			<input type="submit" value="削除">
	</form>
		
	<%
		}
	%>
</body>
</html>