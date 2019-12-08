<%@page import="java.util.Properties"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.berry.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--資料庫連線,上傳,包在catch裡抓錯誤例外  -->
<c:catch var="errMesg">
	<%
		String passwd = BCrypt.hashpw("123456", BCrypt.gensalt());
		Class.forName("com.mysql.cj.jdbc.Driver");
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password","root");
		prop.put("serverTimezone", "Asia/Taipei");
	
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/ii", prop);
		String sql =
				"INSERT INTO member (account,passwd,realname) VALUES(?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, "Carter");
		stmt.setString(2, passwd);
		stmt.setString(3, "wen");
		stmt.executeUpdate();
		out.print("OK");
	%>

<!-- 如果出現錯誤,顯示錯誤訊息 -->
</c:catch>
<c:if test="${errMesg != null }">
	${errMesg }<br>
</c:if>
</body>
</html>