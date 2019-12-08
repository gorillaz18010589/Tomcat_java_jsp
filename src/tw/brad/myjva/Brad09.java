package tw.brad.myjva;
//這支是主程式,創造分支讓10號跟11號連過來
//9號分支動作,分到Brad10,跟brad11用include方式較近來
//輸出最單純比較複查再request
//以為是同一頁其實是兩頁做出來,看不到程式碼
//如果你有重複以問號為優先,如果沒有重複疊加上去的
//java.io.PrintWriter.println(String x)://畫面輸出(void方法)
//javax.servlet.ServletRequest.getRequestDispatcher(String path)://進行分支動作連接到(另一隻程式碼)(回傳RequestDispatcher)
//javax.servlet.RequestDispatcher.include(ServletRequest request, ServletResponse response)://把相同的rquest跟response傳進來,把指定頁面夾近來(void方法)
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Brad09")
public class Brad09 extends HttpServlet {
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name"); //抓到name的參數
		
		RequestDispatcher dispatcher1 = request.getRequestDispatcher("Brad10?age=18");//進行分支動作連接到(另一隻程式碼),以你這支講得為主
		RequestDispatcher dispatcher2 = request.getRequestDispatcher("brad11.html");//進行分支連接到brad11
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<h1>布萊德大公司</h1>");//畫面輸出
		out.println("<hr>");
		out.println("i am " + name);
		out.println("<hr>");
		
		//發現有include才做,可以做一些判斷是,很彈性
		dispatcher1.include(request, response); //把相同的rquest跟response傳進來,把指定頁面夾近來
		out.println("<hr>");
		dispatcher2.include(request, response); //把brad11.html較近來
		
	}

	
	

}
