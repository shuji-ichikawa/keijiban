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
<h1>ニュース掲示板</h1>
<form method="post" action="/keijiban/keijiban_Controller">
<p><a href="/keijiban/jsp/threadList.jsp" class="button" style="font-size:15px;">スレッド一覧に戻る</a></p>
<br>
<hr>
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
<ul>
<li>名前、内容を入力して、［書き込む］をクリックするとコメントが投稿できます。</li>
</ul>
<input type="hidden" name="No" value="<%=i %>" />
	<ul>
		<li>
			<label>名前</label>
			<input type="text" name="name">
			<div class="check"><c:out value="${ msgname1 }" /><c:out value="${ msgname2 }" /></div>
		</li>
		<li>
			<label>内容</label>
			<textarea name="contents" style="width:80%; height:150px" cols="30" wrap="hard"></textarea>
			<div class="check"><c:out value="${ msgcontents }" /></div>
		</li>
	</ul>
	<button>書き込む</button>
<br>
<hr>
<%
if(reslist != null){
ListIterator<ResBean> iterator = reslist.listIterator(reslist.size());
while(iterator.hasPrevious()){
ResBean res = iterator.previous();
 %>
 <p>No：<%=res.getNo() %></p>
 <p><a href="/keijiban/replyContents_Controller?No=<%=res.getNo() %>&reply_id=<%=res.getReply_id() %>&name=<%=res.getName() %>&contents=<%=res.getContents() %>&time=<%=res.getTime() %>"><%=res.getReply_id() %></a></p>
 <p>名前:<%=res.getName() %></p>
 <p>内容:<%=res.getContents() %></p>
 <p>日付:<%=res.getTime() %></p>
 <%
 if(res.getContents().equals("※コメントは削除されました。")){
 %>
 <p class="Dbutton"  style="font-size:12px; width:50px;" >返信</p>
 <hr>
 <%}else{ %>
 <p><a href="/keijiban/keijiban_Controller?No=<%=res.getNo() %>&reply_id=<%=res.getReply_id() %>&name=<%=res.getName() %>&contents=<%=res.getContents() %>&time=<%=res.getTime() %>" class="button" style="font-size:10px;">返信</a></p>
 <hr>
 <%} %>
 <%}
}%>
</form>
</div>
</body>
</html>