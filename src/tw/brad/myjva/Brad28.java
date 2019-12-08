package tw.brad.myjva;
//錯誤例外處理
//*500代表內部伺服器錯誤
//10/0是runtime,所以try catch可另外處理
//有時錯誤是@WebServlet("/Brad28")名字不對
//javax.servlet.http.HttpServletResponse.sendError(int sc, String msg)://顯示錯誤(http回應代碼,跟自訂名義錯誤名)(vodi方法)
//javax.servlet.http.HttpServletResponse:伺服器回應物件(建構是)
//javax.servlet.http.HttpServletResponse.sendRedirect(String location):response的輸出轉向到指定頁面("指定頁面")(void方法)
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Brad28")
public class Brad28 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		int a = 10, b = 0;
		try {
			out.print(a / b);
			out.flush();
		}catch(Exception e) {//出現錯誤輸出到brad29
			response.sendRedirect("Brad29"); //response的輸出轉向到("Brad29")
//		
			response.sendError(HttpServletResponse.SC_BAD_GATEWAY,"Server Busy");//顯示錯誤(http回應代碼,跟自訂名義錯誤名)
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}