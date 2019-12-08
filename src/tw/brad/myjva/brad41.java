package tw.brad.myjva;
//目的是讓主要畫面序結束,但背景仍然活著偷偷看事情
//發現TimerTask仍然,在背景執行序偷偷值行
//把參數帶給42去玩
//也可以做預約任務,時間到他就去做
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Out;




@WebServlet("/brad41")
public class brad41 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		//2.叫出兩個執行序在背景值行
		Timer time = new Timer();
		Mytest1 t1 = new Mytest1();
		Mytest2 t2 = new Mytest2();
		time.schedule(t1, 0,1000*1); //(1.任務2.哪時開始做3.幾秒間格)
		time.schedule(t2, 0, 1000*1);
		out.print("畫面主序結束");
		
		//3.把這三個區域變數設定在session上面帶到其他頁去玩
		HttpSession session =  request.getSession();
		session.setAttribute("timer", time);
		session.setAttribute("t1", t1);
		session.setAttribute("t2", t2);
	}
	
	//1.背景序物件實體,run方法裡面做產生亂數的事情
	class Mytest1 extends TimerTask{
		@Override
		public void run() {
		System.out.print("Mytest1=>" + (int)(Math.random()*36+1) +"<br>");
		}
	}
	class Mytest2 extends TimerTask{
			@Override
			public void run() {
			System.out.print("Mytest2=>" + (int)(Math.random()*36+1)+"<br>");
			}
	}

}