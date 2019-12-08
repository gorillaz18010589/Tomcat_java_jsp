package tw.brad.myjva;
//目標印出你使用的瀏覽器的header
//request是隱含物件
//boolean	hasMoreElements():裡面還有元素嗎?
//E	nextElement():有元素就拿出來
//完後端的東西,是執行後的結果送出
//圖片等比例縮方是伺服器在做的

//javax.servlet.ServletResponse.getWriter()://得到輸出串流(回傳到PrintWriter)
//javax.servlet.http.HttpServletRequest.getHeaderNames()://人家提出要求的header為什麼(回傳到Enumeration<String>)
//java.util.Enumeration.nextElement(): //裡面還有元素嗎(回傳到String)
//javax.servlet.http.HttpServletRequest.getHeader(String name)://取得標頭檔的值(回傳String)
//void java.io.PrintWriter.write(String s)://輸出物件(方法)
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Brad01")
public class Brad01 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8"); //設定網頁輸出類型
		PrintWriter write = response.getWriter(); //輸出
		Enumeration<String> headerNames = request.getHeaderNames(); //人家提出要求的header為什麼(回傳到Enumeration<String>)
		while(headerNames.hasMoreElements()) { //裡面還有元素嗎,當有的話座以下的事情
			String headerName = headerNames.nextElement(); //裡面元素的下一個元素存放在String裡
			String value = request.getHeader(headerName); //取得標頭檔的值(回傳String)
			write.write(headerName +":"+value + "<br>"); //輸出物件,印出標頭檔:值 換列
		}
		write.flush(); //有輸出前一定要衝出來,不然檔案可能看不到全部
		
	}

	

}
