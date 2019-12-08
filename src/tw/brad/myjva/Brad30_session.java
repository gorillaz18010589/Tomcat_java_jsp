//session會記得用戶觀的資訊
//因為我沒有在getSession():輸入true,false,所以他預設是true會自動建立session
//連接member class =>會員類別
//你們去登錄人家的網站,沒有登出
//要關閉瀏覽器才會登出,你關閉分頁則不會
//是這個連線記得這個頁面留下的資訊,session事由伺服器端存放資訊
//你自己決定什麼時候建立session
//31.先連線,沒有拿到惠來30拿到session在看31就有東西了

//page:單一頁面,大家都有getAttribute
//request:頁面跟頁面之間,大家都有getAttribute
//session:這段期間,這段行為,大家都有getAttribute
//session:永遠是從requset而來,不是new出來的
//*session的傳遞取得,會傳true或flase
//1.true:沒有我就會自動建,有我就會造原來的
//2.false:沒有我不會自動建,所以現在有就有沒有就有
//void javax.servlet.http.HttpSession.setAttribute(String name, Object value)://把屬性丟入session裡("自己定義名稱",物件)(void方法)
//javax.servlet.http.HttpServletRequest.getSession()://從request中取得一個Session物件,存放到httpsession(回傳HttpSession)
package tw.brad.myjva;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Brad30_session")
public class Brad30_session extends HttpServlet {

       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");	
		
		//session這邊沒有傳預設就是true,如果有就照原來的,沒有就自動產生
		HttpSession session = request.getSession(); //從request中取得一個Session物件,存放到httpsession
		
		Member member = new Member("user1234", "Hank", 28);//呼叫自己的會員類別
		session.setAttribute("member", member); //把屬性丟入session裡("自己定義名稱",物件)
		
		out.print("從31被趕到30拿到session");
		
		
		
	}

	

}
