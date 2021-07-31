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
<body>
<div class="dodai">
<p><a href="/keijiban/jsp/keijiban.jsp" class="button" style="font-size:15px;">掲示板に戻る</a></p>
<br>
<hr>
<%
List<ResBean> replylist = Cast.castList(session.getAttribute("replylist"));
String nocomment = "返信先のコメントは存在しません。";
if(replylist != null){
ListIterator<ResBean> iterator = replylist.listIterator(replylist.size());
while(iterator.hasPrevious()){
ResBean res = iterator.previous();
%>
 <p>No：<%=res.getNo() %></p>
 <p><a href="/keijiban/replyContents_Controller?No=<%=res.getNo() %>&reply_id=<%=res.getReply_id() %>&name=<%=res.getName() %>&contents=<%=res.getContents() %>&time=<%=res.getTime() %>"><%=res.getReply_id() %></a></p>
 <p>名前:<%=res.getName() %></p>
 <p>内容:<%=res.getContents() %></p>
 <p>日付:<%=res.getTime() %></p>
 <%}
}else{%>
	<p><%=nocomment %></p>
<%}%>
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
</div>
</body>
</html>