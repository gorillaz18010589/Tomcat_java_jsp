<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <!-- 目的:抓48號的參數,因為include方式所以抓的到 
 	//1.抓name是透過getParameter("name");參數來抓
 	//2.抓who是透過//抓到rquset,設置的屬性物件
 	//3.抓value1是透過 pageContext.getAttribute("value1");//抓到pageContext.設置的屬性物件
 
 -->
 
 <%  
 	String name = request.getParameter("name");  //抓48號的參數,他會自動帶進來
	if(name != null){ //如果你在48頁沒有參數我就不做,如果偶參數就顯示以下的name
	 	out.print(name + "<br>");
	
		String who = (String) request.getAttribute("who"); //抓到rquset,設置的屬性物件
		out.print(who +"<br>");
		
		String value1 = (String) pageContext.getAttribute("value1");//抓到pageContext.設置的屬性物件
		out.print(value1);
		
	}
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>我是49號程式被include夾近來</h1>



</body>
</html>
