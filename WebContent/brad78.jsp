<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/mytag.tld" prefix="iii" %>
<!-- 自訂的tag方式,這種方式比較有物件導向概念,MYtag系列 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>HelloBrad對應到Mytag</h1>
<iii:HelloBrad/>
<hr>
<h2>tag2</h2>對應到Mytag2
<hr>
<iii:tag2>
aaaa
bbbb
cccccc
ddddd
123234
</iii:tag2>
<hr>
<iii:tag3 name="Apple" price="100">
偉大的
</iii:tag3>
<hr>
<iii:tag3 name="htc" price="1000">
品項:
</iii:tag3>
</body>
</html>