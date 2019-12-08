package tw.brad.myjva;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//結論1.Thread.sleep(1*1000);畫面是一次輸出,因為你只是讓主序去睡覺而已
//所以這個程式你想讓他有執行一次再繼續坐視無法達到這樣的效果,請看41

@WebServlet("/brad40")
public class Brad40 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");

		
		int a = 0;
		while (true) {
			a = (int)(Math.random()*6+1);	// 1 - 6
			out.print(a + "<br>");
			System.out.println(a);
			if (a == 6) {
				out.println("game over");
				break;
			}else {
				try {
					Thread.sleep(1*1000);//只有這個主序去睡覺,沒有執行序
				}catch(Exception e) {
					
				}
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}