<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%/*
 1.用${param.x}就算沒給參數也不會報錯,不給參數就ㄉ沒有
 2.但如果是10+brad還是會報錯,會出現例外
 3.出現例外的話,用errion page就好
 */%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${param.x} + ${param.y} = ${param.x + param.y }

</body>
</html>