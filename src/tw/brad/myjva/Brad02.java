package tw.brad.myjva;
//看流程怎麼會叫近來這邊
//1.實際上是先叫super.service(req, resp),然後拉到doget去做
//2.因為省略這段沒寫,所以每次物件實體後都是doget被叫
//3.這是brad01.html的後端
//4.跟brad01.html連接,看出do get跟post差異
//*do get得到的資訊走url
//*do post 有機密資訊
//super.service(req, resp):叫爸爸的這招,看你是走do get還是post然後再指派處理
//5.自己件至一個doTesk方法做改寫
//6.後端要處理的就是參數
//javax.servlet.ServletRequest.getParameter(String arg0):取得參數的值(回傳值String )
//javax.servlet.ServletRequest.getParameterNames():取得參數名子的物件(回傳)
//java.util.Enumeration.nextElement(): //裡面還有元素嗎(回傳到String)
//javax.servlet.http.HttpServletRequest.getRequestURL()://抓取丟出請求息的網址(回傳值 StringBuffer)
//java.lang.String.getBytes(String charsetName)://把字串的原本是iso-8859-1改成byte UTF-8(回傳byte[]陣列)
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





@WebServlet("/Brad02")
public class Brad02 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service()被叫了");
//		super.service(req, resp);  //serverice在叫doget,註解掉的話就不會叫doget
		doTesk(req, resp); //呼叫改寫的方法
		
	}
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet被叫了");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost被叫了");	
	}
	//改寫一個sever方法,讓頁面執行時呼叫此方法
	private	void doTesk(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		 System.out.println("doTesk");
		 response.setContentType("text/html; charset=UTF-8");
		 PrintWriter writer = response.getWriter();//取得輸出串流物件
		
		 StringBuffer sb = request.getRequestURL(); //抓取丟出請求息的網指
		 writer.append(sb);
		 
		 Enumeration<String> names = request.getParameterNames();
		 while(names.hasMoreElements()) {
			 String name = names.nextElement(); //取得下參數裡的(看你定義)
			 String value = request.getParameter(name); //取得參數的值
			 String navalue = 
					 new String(value.getBytes("ISO-8859-1"),"UTF-8"); //把字串的原本是iso-8859-1改成byte UTF-8
			 System.out.println(name +":" +value);
			 writer.append(name +":" +value);
			 //執行brad01.html 輸入帳號密碼取得了帳號的值跟密碼
			
		 }
		 
		 writer.flush();
	}
		
}

