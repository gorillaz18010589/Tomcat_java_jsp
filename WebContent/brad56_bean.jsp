<%@page import="java.io.Serializable"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="tw.brad.beans.Member" %>
<%/*
	搭配Member_bean
	//Member member = new Member(,,,) //一般創物件方法在<%%裡
	//<jsp:useBean id=""></jsp:useBean> //宣告物件實體 (id="變數名稱" class="tw.brad.myjva.Member")
	//<jsp:setProperty property="id" value="007" name="member" /> //把你寫的物件加上值(proprtty="類別屬性", value="其值為何"name="物件名稱member"))
	//<jsp:getProperty property="id" value="Brad" name="member"/>:取得這個物件的屬性的值
	//boolean isSerial = member instanceof Serializable; //這個(member物件)instanceof(是否是)Ser(可序列化)
*/%>
  <!-- 物件1 -->
<jsp:useBean id="member" class="tw.brad.beans.Member"></jsp:useBean>
<jsp:setProperty property="id" value="brad" name="member"/>
<jsp:setProperty property="name" value="007" name="member"/>

  <!-- 物件2 -->
<jsp:useBean id="member2" class="tw.brad.beans.Member"></jsp:useBean>
<jsp:setProperty property="id" value="008" name="member2"/>
<jsp:setProperty property="name" value="Hank" name="member2"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Hello,

<%
	//用用看bean創出的物件,發現可以用%玩
	member.setName("kidd"); 
	out.print(member.getName()+"<br>");
	
	//查一下bean是否需要可序列話,他說不用
	boolean isSerial = member instanceof Serializable; //這個(member物件)instanceof(是否是)Ser(可序列化)
	out.print(isSerial +"<br>");//flase =>不用序列化
	
%>

<jsp:getProperty property="id" name="member"/>:
<jsp:getProperty property="name" name="member"/>
<hr>
<jsp:getProperty property="id" name="member2"/>:
<jsp:getProperty property="name" name="member2"/>

</body>
</html>