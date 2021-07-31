<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
import="java.util.List"
import="java.util.ListIterator"
import="keijiban.ResBean"
import="keijiban.Cast"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/keijiban/css/style.css">
<title>ニュース掲示板</title>
</head>
<%
List<ResBean> reslist = Cast.castList(session.getAttribute("reslist"));
int i = reslist.size() + 1;
 %>
<body>
<div class="dodai">
<p><a href="/keijiban/jsp/keijiban.jsp" class="button" style="font-size:15px;">掲示板に戻る</a></p>
<br>
<hr>
<c:set var="No" value="${ No }" />
<c:set var="reply_id" value="${ reply_id }" />
<c:set var="name" value="${ name }" />
<c:set var="contents" value="${ contents }" />
<c:set var="time" value="${ time }" />
<p>No：<c:out value="${ No }" />
<p><c:out value="${ reply_id }" />
<p>名前:<c:out value="${ name }" />
<p>内容:<c:out value="${ contents }" />
<p>日付:<c:out value="${ time }" />
<hr>
<ul>
<li>名前、内容を入力し、［書き込む］をクリックするとコメントが投稿できます。</li>
</ul>
<form method="post" name="form2" action="/keijiban/reply_Controller">
<input type="hidden" name="No" value="<%=i %>" />
<input type="hidden" name="reply_id" value="＞＞${ No }" />
	<ul>
		<li>
			<label>名前</label>
			<input type="text" name="name">
			<div class="check"><c:out value="${ msgname1 }" /><c:out value="${ msgname2 }" /></div>
		</li>
		<li>
			<label>内容</label>
			<textarea name="contents" style="width:80%; height:150px"></textarea>
			<div class="check"><c:out value="${ msgcontents }" /></div>
		</li>
	</ul>
	<button>書き込む</button>
	</form>
</div>
</body>
</html>