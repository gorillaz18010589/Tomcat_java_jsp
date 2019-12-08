<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

   <%
   	session.invalidate();//清楚session
   	response.sendRedirect("brad79.jsp");//轉回登陸頁面
   %>