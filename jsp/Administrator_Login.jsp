<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者用ログイン</title>
</head>
<body>
<form action="/keijiban/Administrator_Login_Controller" method="post">
<label>
管理者ＩＤ:	<input type="text" name="ID" required><br>
パスワード:	<input type="password" name="pass"required><br>
</label>
<p><c:out value="${ msg }" /></p>
<input type="submit" value="ログイン" onClick="alert('所定の画面に移動します');"><br>

</form>
</body>
</html>