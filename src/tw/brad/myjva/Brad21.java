package tw.brad.myjva;
//連接brad20.html的登入畫面
//建構式,發現只有第一次叫伺服器時有來建構式,之後產生了物件實體,由request跟response來服務大眾
//1.所以登入的驅動程式做一次就好,在建構式去做處理就好
//2.寫一個檢查帳密的方法
//3.先檢查帳號,帳號有在,把加密後的密碼抽出來,如果帳號不在連挖都不用挖
//4.常用的api另外寫類別BradAPis,專門寫工具
//如果驅動程式味登入成功導入自訂錯誤訊息
//如果登陸成功導入到main.html畫面
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Brad21")
public class Brad21 extends HttpServlet {
	private boolean isOk;
	private Connection conn;
	private PreparedStatement pstmt;
	private String sql ="SELECT * FROM member WHERE account = ?"; //資料庫的帳號是否等於你輸入的帳號
	//5.建構式,發現只有第一次叫伺服器時有來建構式,之後產生了物件實體,由request跟response來服務大眾
	public Brad21() {
//		System.out.println("Brad21()有來");
		//5.驅動程式有連線成功,就TRUE繼續跑,沒有的話flase都別做了
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Properties prop = new Properties();
		prop.put("user","root");
		prop.put("password","root");
		prop.put("serverTimezone","Asia/Taipei");
		//因為conn後面的程式碼要用到,我拉到全域變數去
//		Connection comm = DriverManager.getConnection("jdbc:mysql://localhost:3307/ii", prop);
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/ii", prop);
		//準備一個敘述句在建構式處理
		pstmt = conn.prepareStatement(sql);
			isOk=true; //驅動程式載入成功就做
		}catch (Exception e) {
			System.out.println(e.toString());
			isOk=false;
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/htm; charset=UTF-8");
		 PrintWriter out = response.getWriter();
		 
		 //如果驅動程式沒載入的錯誤isok=false,自己定義錯誤訊息
		 if(!isOk) {
			 response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,"驅動程式沒有載入成功");
		 }
		 
		//2.抓帳號,密碼,參數
		 String account = request.getParameter("account");
		 String passwd = request.getParameter("passwd");
		 
		 //3.因為這會員表單缺一不可,沒有帳號就不讓你進來
		 if(account == null) {return;}//如果你沒有輸入使用者帳號,我就不讓你進來
		 	//帳號沒為空的化跑以下
		 out.println("有帳號\n");
		 	boolean ismember = checkAccount(account,passwd); //是否式我們的會員,式的話傳進ismember
		 	if(ismember) { //如果是會員的話,輸出到到我指定的頁面
		 		response.sendRedirect("main.html");
		 	}else {//不是會員的話,繼續導向會員登入畫面
//		 		response.sendRedirect("brad20_登入帳號"); 因為導向的頁面不能含中文字改英文後才可用
		 		out.print("不好意思帳號密罵登入錯誤");
		 	}
	}

		//4.檢常帳號密碼,把加密帳號挖出來方法
		private boolean checkAccount(String account,String passwd) {
			boolean ret = false;
			//查詢資料庫是否有你註冊好的這個帳號
			try {
				pstmt.setString(1, account);
				ResultSet rs = pstmt.executeQuery(); //ResultSet指標觀念
				if(rs.next()) { //如果指標還有下一個,代表有撈到帳號,那就下一步撈出密碼
					String hashPasswd = rs.getString("passwd"); //從密碼的欄位撈出你的資料庫密碼
						ret = BradAPis.ckPasswd(passwd, hashPasswd); //檢查你輸入的密碼(來源密碼,資料庫密碼),是否跟資料庫密碼一樣
						System.out.println("有撈到帳號");
				}else {
					System.out.println("沒勞到帳號");
				}	
			}catch (Exception e) {
				System.out.println(e.toString());
			}
			return ret ; //回傳
		}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	//如果有再連線,要關掉
	@Override 
	public void destroy() {
		System.out.println("close");
		if (conn!=null) {
			try {
			conn.close();
			}catch(Exception e) {}
		}
		super.destroy();
	}
}
