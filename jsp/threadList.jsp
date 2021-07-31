<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/keijiban/css/style.css">
<title>スレッド一覧</title>
</head>
<body>
<div class="dodai">
<h1>ニュース掲示板</h1>
<h2>スレッド一覧</h2>
<p><a href="/keijiban/jsp/newthread.jsp" class="button" style="font-size:15px;">新規スレッド作成</a></p>
<br>
	<c:forEach var="newthreadlistitem" items="${ newthreadlist }">
		<input type="hidden" name="id" value="${ newthreadlistitem.thread_id }" />
		<input type="hidden" name="title" value="${ newthreadlistitem.title }" />
		<p><a href="/keijiban/newthread_Controller?thread_id=${ newthreadlistitem.thread_id }">・<c:out value="${ newthreadlistitem.title }" /></a></p>
		<br>
	</c:forEach>
</div>
</body>
</html>