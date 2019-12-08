package tw.brad.myjva;
//目的自己種cookie給25.html抓
//然後27號負責看種cookie的值
//javax.servlet.http.Cookie.Cookie(String name, String value)://創建cookie物件實體(帳號,hank)(建構是)
//void javax.servlet.http.Cookie.setMaxAge(int expiry)://設置最大存活時間(1*60)(void方法)
//void javax.servlet.http.HttpServletResponse.addCookie(Cookie cookie)://輸出回應,新增一個cookie(void方法)
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Brad26_種cookie")
public class Brad26_種cookie extends HttpServlet {
	
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie rememberMe = new Cookie("remember", "true"); //創建cookie物件實體(name,value)
		rememberMe.setMaxAge(1*60); //設置最大存活時間
		response.addCookie(rememberMe);//輸出回應,新增一個cookie
		
		Cookie account = new Cookie("account", "brad");
		account.setMaxAge(1*60); 
		response.addCookie(account);
		
		Cookie passwd = new Cookie("passwd", "123"); //創建cookie物件實體(name,value)
		passwd.setMaxAge(1*60); //設置最大存活時間
		response.addCookie(passwd);//輸出回應,新增一個cookie
		
	}

	
	

}
