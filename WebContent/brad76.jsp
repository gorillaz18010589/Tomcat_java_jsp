<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
/*
<c:set var="var1" values="hello,world"></c:set> => pagecontext的掛參數
<c:if test='${fn:contains(var1,"r") }'>  //:fn:contains(參數,跟包含的字),效果等於字串的contains
var1有包含wor這些字,才會印出來
</c:if>

//等同於<c:if test='${fn:contains(var1,"r") }'> 
String var1 =(String) pageContext.getAttribute("var1");
if(var1.contains("r")){
	out.print("有包含用java方式");
}


*/
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="var1" value="hello,world"/>
<!--  -->
<c:if test='${fn:contains(var1,"r") }'>
var1有包含wor這些字,才會印出來
</c:if>
<br>
<%
	String var1 =(String) pageContext.getAttribute("var1");
	if(var1.contains("r")){
		out.print("有包含用java方式");
	}
%>
</body>
</html>