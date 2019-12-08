<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 會員成功登入畫面,登出畫面的話接Logout.jsp -->
    <% 
    	//這邊登入如果帳號還是為空的話,轉到79燈入畫面
    	if(session.getAttribute("account") == null){
    		response.sendRedirect("brad79.jsp");
    	}
    	//下面代表有登入成功,直接el顯示
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
歡迎光臨我們的會員~ ${account }<br>
<hr>
<a href="logout.jsp">登出</a>
</body>
</html>