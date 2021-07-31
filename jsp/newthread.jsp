<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/keijiban/css/style.css">
<title>新規スレッド作成</title>
</head>
<body>
<div class="dodai">
<p><a href="/keijiban/jsp/threadList.jsp" class="button" style="font-size:15px;">スレッド一覧に戻る</a></p>
<h1>新規スレッド作成</h1>
タイトル、名前、本文を入力して、［新規スレッド作成］をクリックしてください。
<form method="post" action="/keijiban/newthread_Controller">
	<ul>
		<li>
			<label>タイトル</label>
			<input type="text" name="title">
			<div class="check"><c:out value="${ msg1 }" /></div>
		</li>
		<li>
			<label>名前</label>
			<input type="text" name="name">
			<div class="check"><c:out value="${ msg2 }" /></div>
		</li>
		<li>
			<label>本文</label>
			<textarea name="contents" style="width: 80%; height: 400px;"></textarea>
			<div class="check"><c:out value="${ msg3 }" /></div>
		</li>
	</ul>
	<button>新規スレッド作成</button>
</form>
</div>
</body>
</html>