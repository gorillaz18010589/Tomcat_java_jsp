<%@page import="java.util.LinkedList"%>
<%@page import="java.util.HashMap"%>
<%@page import="org.json.JSONObject"%>
<%@page import="org.json.JSONArray"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:import var="x" url="http://data.coa.gov.tw/Service/OpenData/ODwsv/ODwsvTravelFood.aspx"></c:import>
	<%	
	//	pageContext.setAttribute(x, value); =>這段等同於<c:important
		String strData = (String)pageContext.getAttribute("x");
		//out.print(url);這邊顯示有抓到資料印出來
		
		//外面一個陣列觀念,裡面物件進行解析的動作,因為想用el方式去尋訪,所以用Link+hashma
		LinkedList<HashMap<String,String>> data = new LinkedList<>();
		JSONArray root = new JSONArray(strData);
		for(int i=0; i<root.length(); i++){
			JSONObject row = root.getJSONObject(i);
			HashMap<String,String> map = new HashMap<>();
			map.put("Name", row.getString("Name")); //把抓到的資料庫資料掛上去map
			map.put("Address", row.getString("Address"));
			map.put("Tel", row.getString("Tel"));
			data.add(map);//把map資料掛上去data
		
		}
		
		
		
	
		pageContext.setAttribute("pdata", data);//把屬性設置上去用餐束帶,方便El,因為用c:foreach去尋訪資料庫
		
	%>
	<!-- 畫面呈現 -->
	<table border="1" width="100%">
	<tr>
		<th>Name</th>
		<th>Address</th>
		<th>Tel</th>
	</tr>

	<c:forEach items="${pdata }" var="row">
		<tr>
			<td>${row.Name }</td>
			<td>${row.Address }</td>
			<td>${row.Tel }</td>
		</tr>
	</c:forEach>

</table>
</body>
</html>