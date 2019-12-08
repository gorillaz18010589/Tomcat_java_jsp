<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 純粹處理79號帳密的檢查,如果登入成功轉到81號 -->
<!-- session處理 -->
<%
//1.如果登入是新的或這帳號為空,或者密碼為空繼續轉到79登陸頁面
	if(session.isNew()||
		request.getParameter("account") == null ||
		request.getParameter("passwd") == null){
		response.sendRedirect("brad79.jsp");
		return;
	}
		//2.這邊就是有登入的情況取得,帳號密碼參數
			String account = request.getParameter("account");
			String passwd  = request.getParameter("passwd");
			System.out.print("跑到第二段");
		//3.如果帳號密碼是brad,123456才燈入成功到brad81.jsp
				if(account.equals("brad") && passwd.equals("123456")){ //帳號密碼正確走以下
					session.setAttribute("account",account); //把帳號的資訊參數掛上去,並且帶到brad818oo
					response.sendRedirect("brad81.jsp");
					System.out.print("跑到第三段");
				}else{//沒有登入成功走以下
					response.sendRedirect("brad79.jsp");
					System.out.print("跑到第四段");
				}
		
%>