package tw.brad.myjva;
//foward是直接移轉交給被移轉者處理
//當用戶沒輸入參數時,可以做處理
//參數沒有就是null
//如果遇到使用者沒填入參數時的做法
//javax.servlet.RequestDispatcher.forward(ServletRequest request, ServletResponse response)://forward移轉出去交給他被移轉的全權處理(void方法)

//java EE MVC
//因為牽一髮動全身,如果你一個網頁太多語言在裡面,這樣太複雜所以分出來用MVC
//*Controller:最中心,有reqest跟response做控制  
//*Model:model去做演算邏輯,演算完交給View來處理
//*View:我最後負責畫面呈現

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Brad12")
public class Brad12 extends HttpServlet {
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		RequestDispatcher dispatcher1 = request.getRequestDispatcher("Brad13");//連接到Brad13
		out.println("<h1>Brad12大公司</h1>");
	
		//如果沒有輸入參數時
		String name = request.getParameter("name");
		if(name == null) { 
			out.println("null");
			dispatcher1.forward(request, response); //forward移轉出去交給他被移轉的全權處理
		}else {
			out.print(name);
		}
	}

	


}
