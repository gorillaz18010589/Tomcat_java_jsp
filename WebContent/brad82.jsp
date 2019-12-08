<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 
    	1.request.fowrad,這頁forwad到brad83
    	*一開始有看到亂數,如果下了forwrad就直接跳頁面,但url還是在82.jsp
    	*結論:forwrad讓頁面移轉出去給下個分頁去做,但還在同一頁,request移交forwad給他繼續做,直接看不到82頁面的內容
    	
    	2.request.inclide:
    	*request要求先做,把其他頁面include進來後,才做out輸出的動作請求先做
    	*結論:request的Include,把指定頁面的內容加進來後,才跑自己頁面的out輸出
    	
    	3.//response.sendRedirect("brad83.jsp");
    	//直接在輸出時response,把頁面丟給別的分頁處理,會直接跳到83頁面
    	
    	//javax.servlet.ServletRequest.getRequestDispatcher(String path):取得調度員物件實體("分頁名")(回傳值RequestDispatcher)
//javax.servlet.RequestDispatcher.forward(ServletRequest request, ServletResponse response) :頁面移轉出去但還在同一頁("要求","回應")(void方法)
//javax.servlet.RequestDispatcher.include(request, response);//因為是rquest請求所以會先做include把頁面加進來,在座自己out的輸出,活在同一頁面
//javax.servlet.http.HttpServletResponse.sendRedirect(String location)://直接在輸出時response,把頁面丟給別的分頁處理,會直接跳到83頁面(void方法)    	
     -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>這頁是brad82.jsp</h1>
<%
	//1.準備亂數看看在參數傳遞中的影響
	int ran = (int)(Math.random()*46 +1);
	out.print(ran + "<br>");
	
	//3.參數的傳遞
	request.setAttribute("ran",ran); //從要求上面設上屬性("自訂名",屬性名)
	
	//2.三種方式的介紹
	//response.sendRedirect("brad83.jsp");
	request.getRequestDispatcher("brad83.jsp").forward(request, response);//叫出Reqdispather調度員物件實體,用他的招數forwad出去
	//request.getRequestDispatcher("brad83.jsp").include(request, response);//叫出Reqdispather調度員物件實體,用他的招數include近來
%>
</body>
</html>