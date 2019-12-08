<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
//onsubmit="return false">//再送出時false連送出都不會送
%>
<html>
<%
	String x = request.getParameter("x"); //抓到x的參數
	String y = request.getParameter("y");
	int result = 0;
	String newresult = ""; //一開始讓結果不顯示,放入空字串
	String StrX,StrY;  StrX = StrY ="";
	if(x != null && y != null){ //如果x跟y沒有空的話
		 try{
		 int intX  = Integer.parseInt(x); //字串x轉成int才能被加法
		 int intY  = Integer.parseInt(y); 
		 result = intX + intY; 
		 newresult =  result +""; //最後成功後才把值丟進去顯示
		 StrX = intX+""; 
		 StrY = intX+"";
		 }catch(Exception e){
			 newresult="";
		 }
	}

%>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="brad45.jsp" onsubmit="return false">
<input type="text" name="x" value =<%= StrX %>> 
<select name="select">
	<option>+</option>
	<option>-</option>
	<option>x</option>
	<option>/</option>
</select>
<input type="text" name="y" value =<%= StrY %>> 
<input type="submit"  value= "=">
 <%= newresult %>
</form>
</body>
</html>