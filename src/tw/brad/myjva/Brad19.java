package tw.brad.myjva;
//目的是資料庫的後端接收
//連接brad18.html前端畫面
//引入外部檔案
//下載java Bcrypt aip加密密碼
//*找到git hub 按下row 又鍵另存新黨 附檔名改為java
//*在src新增packge跟他密名一樣,把外部黨放進去
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.berry.BCrypt;



@WebServlet("/Brad19")
public class Brad19 extends HttpServlet {
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 //1.輸出
		 response.setContentType("text/htm; charset=UTF-8");
		 PrintWriter out = response.getWriter();
		 
		//2.抓帳號,密碼,姓名參數
		 String account = request.getParameter("account");
		 String passwd = request.getParameter("passwd");
		 String realname = request.getParameter("realname");
		 
		//3.因為這會員表單缺一不可,沒有帳號就不讓你進來
		 if(account == null) return;//如果你沒有輸入使用者帳號,我就不讓你進來
//		 out.println(account +":" + passwd + ":" + realname);
		 
		 //4.加密演算法
		 String passwd2 = BCrypt.hashpw(passwd, BCrypt.gensalt()); //加密演算法(加密的密碼參數,加密的來源)
//		 out.println(passwd); //確認密碼
//		 out.println(passwd2);//確認加密密碼
//		 out.println(passwd2.length()); //看一下加密碼長度資料庫夠不夠放
		 String ret = toMySQL(account, passwd2, realname);
		 out.print(ret); //印出更新了幾筆資料
		 out.flush();
		 
		
	}
		//5.Mysql方法
	private String toMySQL(String account,String passwd,String realname ) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Properties prop = new Properties();
			prop.put("user", "root");
			prop.put("password","root");
			prop.put("serverTimezone","Asia/Taipei");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3307/ii",prop);
				
			//在資料庫新增三筆資料
			String sql = "INSERT INTO member (account,passwd,realname) VALUES(?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,account);
			pstmt.setString(2,passwd);
			pstmt.setString(3,realname);
			int count = pstmt.executeUpdate(); //更新了幾筆存在count
			return "上傳了: " + count +"次資料"; //傳完資料回傳有幾筆資料
			}catch (Exception e) {
				System.out.println(e.toString());
				return e.toString();
			}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response); //有訊息來post你還是轉到get去做
	}

}






