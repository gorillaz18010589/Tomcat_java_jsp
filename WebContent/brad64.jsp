<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- 
<c:out value="Hello world"></c:out> //印出字串
<c:out value="${'Hello world' }"></c:out> //用El輸出字串
<c:out value="${x }" default="na value"></c:out>  //用el印出抓到的參數,如果沒參數default="no value"
<c:set var="x" value="1234" scope="page"/> // 設定一個參數掛上值,用什麼頁面方式(var:變數,value:值  scope:page)


${requestScope.var1 }<br> //顯示Request的參數

<!-- 把值寫在innerHtml裡 -->
<c:set var="var2">3</c:set>  設定值var(參數名)>值<
${var2 }<br> //印出值

<!-- member1已經被useBean物件實體,所以EL直接可以印出值 -->
${member1 }

<!-- 針對Bean來set -->
<c:set target="${member1 }" property="id" >001</c:set> :target(針對誰)的property(屬性) 改為001
${member1.id } //印出member1的id值

<!--直接砍掉物件的方法  -->
<c:remove var="member1"/>  砍掉物件(var=物件名)
${member1.id }: ${member1.name } //查詢物件裡面的屬性
 --%>
<%
	//pageContext.setAttribute("x",1234); //等同於下面
	//<c:set var="x" value="1234" scope="page"/>
%>

<jsp:useBean id="member1" class="tw.brad.beans.Member"></jsp:useBean>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:set var="x" value="1234" scope="page"/>				
<c:out value="Hello world"></c:out><br>
<c:out value="${'Hello world' }"></c:out><br>
<c:out value="${x }" default="na value"></c:out> <br>

<!-- 同一個name,比較request跟page誰會被叫 -->
<c:set var="var1" value="1" scope="page"/>
<c:set var="var1" value="2" scope="request"/>
${var1 }<br>
${requestScope.var1 }<br>

<!-- 把值寫在innerHtml裡 -->
<c:set var="var2">3</c:set>
${var2 }<br>

<!-- member1已經被useBean物件實體,所以EL直接可以印出值 -->
${member1 }<br>
<!-- 針對Bean來set -->
<c:set target="${member1 }" property="id" >001</c:set>
<c:set target="${member1 }" property="name" >Brad</c:set>
${member1.id } : ${member1.name }<br>

<!--直接砍掉物件的方法  -->
<c:remove var="member1"/>
${member1.id }: ${member1.name }



</body>
</html>