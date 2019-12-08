package tw.brad.myjva;
//把session =>invaldate(廢止調)
//類似登出行為
//會有任何寫到跟session有關的就是要取出來
//1.先去31馬上被趕走
//javax.servlet.http.HttpSession.invalidate()://把session廢止掉(void方法)
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Brad32_invaldate")
public class Brad32_invaldate extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession(false);//預設false有session就有沒有就沒有
		if(session != null) {
			session.invalidate(); //把session廢止掉
		}
		out.println("登出");
	}

	
	

}
