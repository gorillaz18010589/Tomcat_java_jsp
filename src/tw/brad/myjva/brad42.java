package tw.brad.myjva;
//背景執行序的取消及應用
//可以發推波報價靠這招
//比較偏重在資料庫有關
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/brad42")
public class brad42 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		brad41.Mytest1 test1 = (brad41.Mytest1)session.getAttribute("t1"); //取得寫的執行序方法,而且娶她的屬性
		brad41.Mytest2 test2 = (brad41.Mytest2)session.getAttribute("t2");
		
		if(test2 != null) { //2.啟動42後有session先跑這個if所以取消2任務
			test2.cancel();
			test2 = null;
			session.removeAttribute("t2");
		}else if(test1 != null) {//3.在啟動一次42跑這個任務兩個任務都結束
			test1.cancel();
			test1 = null;
			session.removeAttribute("t1");
		}else {//1.一開始執行42因為沒有啟動session所以出現沒有任務
			out.print("沒有任務");
			session.invalidate();//4.第四次啟動都沒有任務了摧毀掉跑出沒有任務
		}
		
	}

}
