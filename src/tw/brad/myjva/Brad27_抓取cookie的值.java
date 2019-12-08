package tw.brad.myjva;
//目的抓cookie26的值
//畫面在25呈現
//javax.servlet.http.HttpServletRequest.getCookies()://取得使用者的cookie(回傳值Cookie[])
//javax.servlet.http.Cookie.getValue()://抓到cookie的值(回傳值String)
//javax.servlet.http.Cookie.getName()://抓到cookie的name(回傳值String)
//java.util.HashMap.HashMap<String, String>()://陣列不好使用用hashMap存放(建構是)
//java.util.HashMap.containsKey(Object key)://這個hashmap有沒有包含哪個值(帳號參數)(回傳值boolean)
//java.util.HashMap.get(Object key)://抓取物件參數的值(回傳值String )
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Brad27")
public class Brad27_抓取cookie的值 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			request.setCharacterEncoding("UTF-8");//通常你傳來的回應,字串設置為UTF-格式
			
			//取得cookie
			HashMap<String, String> cookieMap = new HashMap<>();//陣列不好使用用hashMap存放
			Cookie[] cookies = request.getCookies(); //取得使用者的cookie
			if(cookies!= null) { //如果cookie不是空的
				for(Cookie cookie : cookies) {
					String value = cookie.getValue(); //抓到cookie的值
					String name = cookie.getName(); //抓到cookie的name
					
					//把name跟value掛上 hashmap方便查詢
					cookieMap.put(name, value); 
				}
				
			}
			//用hashmap方式來問
			if(cookieMap.containsKey("account")) {//這個hashmap有沒有包含哪個值 ,去抓了26號的帳號有沒有Cookie
				out.print(cookieMap.get("account"));//抓取參數
			}else {
				System.out.println("沒有Cookie");
			}
	}

	

}
