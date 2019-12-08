package tw.brad.myjva;
//31是看現在到底有沒有session我不會自己創
//page:單一頁面,大家都有getAttribute
//request:頁面跟頁面之間,大家都有getAttribute
//session:這段期間,這段行為,大家都有getAttribute
//session:永遠是從requset而來,不是new出來的
//*session的傳遞取得,會傳true或flase
//1.true:沒有我就會自動建,有我就會造原來的
//2.false:沒有我不會自動建,所以現在有就有沒有就有
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Brad31")
public class Brad31 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
			
		
		HttpSession session = request.getSession(false); //如果一開始有就有沒有就沒有
		if (session == null) { //如果沒有session我去30號
			// get out here
			response.sendRedirect("Brad30_session");
		}else {//拿到session後印出來,可以去32登出,這樣又重複沒有session動作
			// got it
			Member member = (Member)session.getAttribute("member");
			out.println("Account:" + member.getAccount() + "<br>");
			out.println("Realname:" + member.getRealname() + "<br>");
			out.println("age: " + member.getAge());
	}

	
	}

}
