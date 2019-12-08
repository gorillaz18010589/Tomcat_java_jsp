package tw.brad.myjva;
//兩個sevelet結合,並且抓到參數
//我是分之10夾到09畫面
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Brad10")
public class Brad10 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		
				PrintWriter out = response.getWriter();
				out.println("開始Brad10");
				out.println("<div>我是分支10</div>");
				out.println(request.getParameter("name") +":"+
				request.getParameter("age")); //輸出你的回應抓到參數的mame
				
	
	}
}
