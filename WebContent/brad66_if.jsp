<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="tw.brad.beans.BradAPIs" %>
 
 <%--
 <c:if test='${param.num =="100" }' var="x"> :test="你要測試的邏輯" var="你測完的true,false存放在此變數"
 	Hello world   //如果抓到num值==100是true,執行這段hello world
 </c:if>
 
 <!-- 引用方法,把輸入的亂數轉成int -->
 <c:set var="score">${BradAPIs.toIntString(Math.random()*101)}</c:set> //引用寫好的類別產生亂數,存到var裡
 Score:${score}<br>
 
<!-- 製造出成績大於60及格,小於60顯示被當 -->
<c:choose>括弧內放多重選擇</c:choose>
	<c:when test="${score >= 60 }">及格</c:when>://當test="邏輯判斷" 如果成立,印出及格
	<c:otherwise>被當</c:otherwise>//否則印出什麼

  --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 如果條件成立會被顯示 -->
<c:if test='${param.num =="100" }' var="x">
Hello world
</c:if>
${x }<br>

<!-- 引用方法,把輸入的亂數轉成int -->
<c:set var="score">${BradAPIs.toIntString(Math.random()*101)}</c:set>
Score:${score}<br>

<!-- 製造出成績大於60及格,小於60顯示被當 -->
<c:choose>
	<c:when test="${score >= 90 }">A</c:when>
	<c:when test="${score >= 80 }">B</c:when>
	<c:when test="${score >= 70 }">C</c:when>
	<c:when test="${score >= 60 }">D</c:when>
	<c:otherwise>被當</c:otherwise>
</c:choose>


</body>
</html>