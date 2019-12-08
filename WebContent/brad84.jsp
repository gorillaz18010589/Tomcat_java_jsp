<%@page import="java.util.Date"%>
<%@page import="java.util.Locale"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%/**
目的:多國語系第一個字i最後一個n有18個字代表區域化不同國家除了語言不一樣還有時間的表示,還有貨幣的符號差異
//1.在web-inf底下創folder夾叫classes:準備多國語系自訂黨
//2.創檔案慣例:res(資源)_en(語言)_US(地區).properties(屬性)
//3.hello=Hello => name:value的概念 =號要黏著
Locale javax.servlet.ServletRequest.getLocale():取得用戶的所在地語系物件實體,因為在網頁上用request取得
locale.getCountry()://取得國籍英文縮
locale.getDisplayCountry()://取得國家中文名
locale.getLanguage() ://取得語言縮寫

	<fmt:setLocale value="zh_TW"/>://取得你設定的語言檔案名
	<fmt:setBundle basename="res"/>//取得你設定的檔案來原處
	<h1><fmt:message key="companyName"/></h1>//取得你設定的key名,並顯示出值
	
type="time"> =>3:45:05 PM //顯示時間
type="date"> => Aug 20, 2019 //顯示日期
type="both"> =>Aug 20, 2019 3:45:05 PM //顯示日期時間
type="both"  dateStyle="short" timeStyle="short"> => 8/20/19 3:45 PM //顯示短短的時間日期
type="both"  dateStyle="medium" timeStyle="medium"> => Aug 20, 2019 3:45:05 PM //顯示中規格的時間日期
type="both" dateStyle="long" timeStyle="long"> =>August 20, 2019 3:45:05 PM JST //顯示複雜的時間日期
pattern="yyyy-MM-dd" >=> 2019-08-20 //照你的年月份去處理時間
**/%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>i18n</title>
</head>
<body>
<%
	//創一個區域化的東西物件實體
	Locale locale = request.getLocale(); //取得用戶的所在地語系,因為在網頁上用request取得
%>
 <!-- 取得我需要的語系資源 -->
國籍英文縮寫 :<%= locale.getCountry() %><br>
國家中文名 :<%= locale.getDisplayCountry() %><br>
語言縮寫:<%= locale.getLanguage() %><br>
<hr>

<!-- 套用多國語系 -->
<hr>
<fmt:setLocale value="zh_TW"/>
<fmt:setBundle basename="res"/>
<h1><fmt:message key="companyName"/></h1>
<fmt:message key="hello"/>, <fmt:message key="world"/> 
<hr>
<fmt:setLocale value="en_US"/>
<fmt:setBundle basename="ren"/>
<h1><fmt:message key="companyName"/></h1>
<fmt:message key="hello"/>, <fmt:message key="world"/> 
<hr>

<!-- 時間日期 -->
<%
	Date now = new Date();//顯示系統的時間
	out.print(now.toString());
	pageContext.setAttribute("now", now);
%>
<hr>
<!-- 顯示日本時間跟各種用法 -->
<fmt:setTimeZone value="Asia/Tokyo"/>
日期格式化 (1): <fmt:formatDate type="time"  value="${now}" /></p> 
<p>日期格式化 (2): <fmt:formatDate type="date" value="${now}" /></p>
<p>日期格式化 (3): <fmt:formatDate type="both"  value="${now}" /></p>
<p>日期格式化 (4): <fmt:formatDate type="both"  dateStyle="short" timeStyle="short"  value="${now}" /></p>
<p>日期格式化 (5): <fmt:formatDate type="both"  dateStyle="medium" timeStyle="medium"   value="${now}" /></p>
<p>日期格式化 (6): <fmt:formatDate type="both" dateStyle="long" timeStyle="long"  value="${now}" /></p>
<p>日期格式化 (7): <fmt:formatDate pattern="yyyy-MM-dd-hh:mm:ss" value="${now}" /></p>

<!-- 顯示柏林時間 -->
<br>
<fmt:setTimeZone value="Europe/Berlin"/>
<fmt:formatDate value="${now }" pattern="yyyy-MM-dd HH:mm:ss" 
	type="both" dateStyle="default" />
<hr>
<!-- 顯示歐元貨幣 -->
<fmt:setLocale value="de_de" />
<fmt:formatNumber value="12346789.123456789"
	type="currency" currencyCode="EUR" />	

</body>
</html>