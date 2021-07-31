<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スレッド一覧</title>
</head>
<h1>ニュース掲示板</h1>
<p><a href="/keijiban/jsp/Administrator_Login.jsp">ログアウト</a></p>
<h2>スレッド一覧</h2>
	<table>
		<c:forEach var="newthreadlistitem" items="${ newthreadlist }">
		<tr>
			<td><input type="hidden" name="id" value="${ newthreadlistitem.thread_id }" />
			<input type="hidden" name="title" value="${ newthreadlistitem.title }" />
			<a href="/keijiban/Administrator_newthread_Controller?thread_id=${ newthreadlistitem.thread_id }"><c:out value="${ newthreadlistitem.title }" /></a></td>
			<td><a href="/keijiban/Administrator_thread_delete_Controller?thread_id=${ newthreadlistitem.thread_id }">削除</a></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>