<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
//<% jsp寫在這裡面,java程式 >%
//java輸出要PrintWrite out,但jsp是隱含物件直接out.就可以用
//因為這些語言設定早就設定好了.而printwrite是隱含物件所以用out就可以
//可以讓code不會被抄襲s
//<%= lottery%> :用=號代替out.
//java.util.Calendar:(建構式)
//java.util.Calendar.getInstance():(回傳Calendar)
//java.util.Calendar.get(int field):(回傳int)
int java.util.Calendar.get(int field):
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>brad40.jsp</h1>
<%
	int a= 10,b=3;
	out.println(a/b +"<br>");
	int lottery = (int)(Math.random()*46+1);
	int year = Calendar.getInstance().get(Calendar.YEAR); //取得年分
	int month =Calendar.getInstance().get(Calendar.MONTH)+1; //取得月分是從0開始算所以+1
	int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH); //日
	String newDate = year +"-" + month + "-" + day;
%>
這期樂透號碼是:<% out.println(lottery);%><br>
這期樂透號碼是:<%= lottery%> <br>
今年的時間是:<%= newDate %>

</body>
</html>