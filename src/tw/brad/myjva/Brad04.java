package tw.brad.myjva;
//連接brad03.html前端
//加法取得參數
//網頁來的東西永遠是字串
//因為一開始抓來的3+5其實是參數,所以要先字串轉成Int
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Brad04")
public class Brad04 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
			
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String x = request.getParameter("x");
		String y = request.getParameter("y");
		
		//抓到的是字串轉成,int,怕對方亂輸入所以用try/cauth/
		int intX , intY; //
		try { //因為怕有人亂輸入不是整數的字
		 intX =Integer.parseInt(x); //字串轉int
		 intY =Integer.parseInt(y);
		}catch (Exception e) { //如果輸入了不是整數的狀況
			intX = intY = 0; //把這兩個值預設為0
		}
		int  result = intX + intY;
		String r = "" + result;
		String xx = "" + intX;
		String yy = "" + intY;
		response.setContentType("text/html; charset=UTF-8"); 
		PrintWriter writer = response.getWriter();
		writer.write(result);
		writer.write(xx + "+" + yy +"=" + r);
		writer.print(xx + "+" + yy +"=" + r);
		writer.flush();
	}
	

}
