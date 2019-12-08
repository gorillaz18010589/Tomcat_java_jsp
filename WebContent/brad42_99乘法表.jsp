<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1" width="100%">
	
		
			<%	for(int k=0; k<2; k++){
					out.print("<tr>");
					for(int j=2; j<=5; j++){
						int newj = j + 4*k;
						out.print("<td bgcolor='"+((k+j)%2==0?"yellow":"pink")+"'>");
						for(int i=1; i<=9; i++){
							int r = newj* i;
							out.print(newj +"x" +i + "=" + r+"<br>");
						}
						out.print("</td>");
					}
					out.print("</tr>");
				}
			%>
		
		
			
		
		
</table>
</body>
</html>