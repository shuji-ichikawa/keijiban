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
<title>ニュース掲示板</title>
</head>
<body>
<h1>ニュース掲示板</h1>
<p><a href="/keijiban/jsp/Administrator_threadList.jsp">スレッド一覧に戻る</a></p>
<hr>
<h2>スレッド内容</h2>
<c:forEach var="newthreadlist1item" items="${ newthreadlist1 }">
	<p>タイトル:<input type="hidden" value="${ newthreadlist1item.title }" />
		<c:out value="${ newthreadlist1item.title }" /></p>
	<p>名前:<input type="hidden" value="${ newthreadlist1item.name }" />
		<c:out value="${ newthreadlist1item.name }" /></p>
	<p>内容:<input type="hidden" value="${ newthreadlist1item.contents }" />
		<c:out value="${ newthreadlist1item.contents }" /></p>
	<p>日付:<input type="hidden" value="${ newthreadlist1item.time }" />
		<c:out value="${ newthreadlist1item.time }" /></p>
</c:forEach>
<hr>
<h2>コメント内容</h2>
<%
List<ResBean> reslist = Cast.castList(session.getAttribute("reslist"));
if(reslist != null){
ListIterator<ResBean> iterator = reslist.listIterator(reslist.size());
while(iterator.hasPrevious()){
ResBean res = iterator.previous();
%>
<table>
<tr>
	<td>No：<%=res.getNo() %></td>
	<td></td>
	<td></td>
	<td></td>
	<td><a href="/keijiban/Administrator_keijiban_Controller?thread_id=<%=res.getThread_id() %>&No=<%=res.getNo() %>">削除</a></td>
</tr>
<tr>
	<td><%=res.getReply_id() %></td>
</tr>
<tr>
	<td>名前:<%=res.getName() %></td>
</tr>
<tr>
	<td>内容:<%=res.getContents() %></td>
</tr>
<tr>
	<td>日付:<%=res.getTime() %></td>
</tr>
</table>
<hr>
 <%}
}%>
</body>
</html>