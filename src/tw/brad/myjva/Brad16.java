package tw.brad.myjva;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
//畫面的呈現,連接主畫面Brad14
//寫出一個方法連接新的myview1畫面
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Brad16")
public class Brad16 extends HttpServlet {
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html; charset=UTF-8"); 
		 PrintWriter out =  response.getWriter();
		 
		 //收到x,y,result的參數,就跟演算結果就呈現出來
		 String x = request.getParameter("x");
		 String y = request.getParameter("y");
		 String op = request.getParameter("op");
		 String result = request.getParameter("result");
		 
		 
//		 out.print(x +"+" + y +"=" + result);//畫面輸出x+y=結果
//		 	out.print(loadView("myview1.html"));
		 
		 //連接myview1.html去做畫面
		 String html =loadView("myview2.html");//把載入好的畫面塞入字串html
		 String op1,op2,op3,op4; op1=op2=op3=op4="";
		 switch(op) {
		 case "1": op1="selected" ; break;
		 case "2": op1="selected" ; break;
		 case "3": op1="selected" ; break;
		 case "4": op1="selected" ; break;
		 }
//		 String outhtml = String.format(html, x ,y ,result); //把x,y,html畫面跟結果用format方式取得參數輸出出來
		 String outhtml = String.format(html,x,op1,op2,op3,op4,y,result);//把x,y,op,html畫面跟結果用format方式取得參數輸出出來
		 out.print(outhtml);//輸出畫面
	}
	//載入寫好的前端畫面
	private String loadView(String viewfile) throws IOException {
		ServletContext context = getServletContext();//抓到伺服器全文物件
		String viewPath = context.getInitParameter("viewPath"); //取得載入頁面
	
	//讀入views畫面,html化面是字串
		BufferedReader reader = 
				new BufferedReader(new FileReader(new File(viewPath, viewfile)));
			StringBuffer sb = new StringBuffer(); String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
			reader.close();
			return sb.toString(); //把bufferread轉String
	}
}