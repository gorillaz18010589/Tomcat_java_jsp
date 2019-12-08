package tw.brad.myjva;
//我是主畫面,control
//x + y簡單事情搞很複雜處理MVC
//MVC架構
//model連接到Brad15=>class方法
//view連接到Brad16=>處理
//myview2.html處理畫面
//1.打算把前端畫面放在特定資料夾,在web context開一個views資料夾
//2.叫出web.xml再加一組參數,指定是views資料夾
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Brad14")
public class Brad14 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//0.用戶輸入參數,拿到x,y就算沒有,也給你0
		String x = request.getParameter("x");
		String y = request.getParameter("y");
		String op = request.getParameter("op"); //抓到下拉式選單的參數加減乘除
		if (x == null) x = "0"; //如果沒抓到參數給x=>0字串
		if (y == null) y = "0";
		if (op == null) op = "1";//如果沒抓到參數,就先1號加法為主
		
		
		//1.Model演算,將X+Y套入公式,model程式Brad15,呼叫方法
		Brad15 model = new Brad15(x, y,op); //帶入你輸入的x跟y
//		int result = model.add();  //用model寫好的add方法演算
		double result = model.operation();//叫出加減乘除方法,存進結果裡
		
		//2.畫面的呈現較給View,用Fowad方式直接提交出去,不然自己還要做處理=>Brad16
		//一般是用JSP的view區去做畫面,但目前這方式用secelte做
		String pline = String.format("Brad16?x=%s&y=%s&op=%s&result=%s",x,y,op,result);
		RequestDispatcher dispatcher1 = request.getRequestDispatcher(//連接到Brad16號做view,懶得寫畫面所以加這麼多
				pline); 
//				"Brad16?x=" +x + "&y=" + y +"&result=" +result//傳統帶字串方法,改用format帶參數
		dispatcher1.forward(request, response);
	}

	

}
