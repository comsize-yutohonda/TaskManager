<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action = "LoginServlet" method = "post">
<h1>ログイン画面</h1><br>
<hr>
<h1>ユーザIDとパスワードを入力してください</h1><br>
<%
	String message = (String)request.getAttribute("message");
	if(message != null){
%>

	<h3> <%=message%></h3>
<%
	}else
%>
ユーザID<input type="text" name="usreId" required><br>
パスワード<input type="password" name="password" required><br>
<input type = submit value ="ログイン">
<input type="reset" value="取消">
</form>
</body>
</html>