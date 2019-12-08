package tw.brad.myjva;
//連接資料庫
//寫一個登入頁面
//jsp自從把你的code轉為伺服器
//brad18.html是我的介面
//Brad19.java是我的後端
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Brad17_mysql")
public class Brad17_mysql extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 //1.啟動驅動程式
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("OK");//驅動程式載入成功會按OK
		}catch (Exception e) {
			System.out.println(e.toString());
		}
}

	

}
