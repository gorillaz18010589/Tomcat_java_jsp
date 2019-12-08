<%@page import="java.util.HashMap"%>
<%@page import="java.util.LinkedList"%>
<%@page import="tw.brad.beans.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%/*
//(第一層pageContext)=>(第二層)request=>(第三層)session(第四層)appication
x = ${x [0] } = //顯示x[0]陣列的值在畫面上,request等級的
//EL方法因為,我設的陣列他看不到所以要給他掛上參數,讓el去抓
	//當你的pageContext設的物件名跟rquest一樣,他會找離他最近的,所以印出pagecontext的
	//el裡面的物件很多都時做好了,你就拿來用
	//網頁所有東西都是字串
	//特徵是表現其值,但code可少寫
*/%>
<%
String[] var1 = {"value1","value2","value3","value4","value5","value6",};
pageContext.setAttribute("usernames", var1);
String[] names = {"brad", "kevin","peter","eric","andy","jeff"};
request.setAttribute("usernames", names);

LinkedList<String> list = new LinkedList<>();
list.add("AAA"); list.add("BBB"); list.add("CCC");
request.setAttribute("list", list);

HashMap<String,String> map = new HashMap<>();
map.put("key1", "value1");
map.put("key2", "value2");
map.put("key3", "value3");
request.setAttribute("map", map);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Username1: ${usernames[0] }<br>
Username2: ${usernames[4] }<br>
List1: ${list[param.i] }<br>
Map1: ${map.key2 }<br>
Map2: ${map[param.key] }<br>
Username:page: ${pageScope.usernames[0] }<br>
Username:request: ${requestScope.usernames[0] }<br>
樂透號瑪:<%=BradAPIs.creatLottert() %> 一般呼叫方法
樂透號瑪:${BradAPIs.creatLottert() }<br>

<!-- $裡面可以做運算,但其實是字串相加 -->
${10 + 3}<br>
${param.x } > ${param.y } = ${param.x > param.y }<br>

<!-- 輸入的參數是否等於10,是的話yes,不是的話no -->
${(param.x =="10") ?"yes":"no"}<br>

</body>
</html>