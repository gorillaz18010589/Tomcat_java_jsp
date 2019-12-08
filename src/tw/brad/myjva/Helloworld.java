package tw.brad.myjva;
//do Get =>你的用戶端url從do GET做出請求
//*request:對方回應的請求物件 =>對方的請求跟訊息回傳給我
//*response:你會回應的
//response傳回自己.append.append=>一值補東西上去

//do Post =>兩種特性:1.資訊隱藏 2.檔案上傳
//response把請求訊息跑給網頁看

//*一開始啟動伺服器跑件購式, 之後物件實體化後跑do get服務大眾
//*只有一個物件所以你有做static跟沒做都看的到
//*server的建構式沒有意義,因為建構式初始話就是做出屬性不同地方,但server只有一個物件實體屬性都一樣所以意義不大
//google java servelet api:
//java.io.PrintWriter.append(CharSequence):增加CharSequence有實作的都可以,因為STRING有實作CharSequence,所以放進去也OK
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Helloworld") //對外營業的名稱
public class Helloworld extends HttpServlet { //永遠是繼承HttpServlet
	private static final long serialVersionUID = 1L; //只是宣告一個版本序號
		private int a; //寫這邊的屬性,因為只有一個物件在服務所以全世界都看的到
		static int b;
       public Helloworld() { //一開始啟動伺服器跑件購式, 之後物件實體化後跑do get服務大眾
    	   super();
    	   System.out.println("Hello world");
       }

	protected void doGet(HttpServletRequest request, //拿人家的請求(request),做出回應(response)
			HttpServletResponse response) throws ServletException, IOException {
		a++;
		b++;
		System.out.println(a + ":" + b); //照理來說a式看不到不會+1只有static 方法看的到,但因為物件實體只有一個服務所已都看的到
		 System.out.println("do Get"); //伺服器物件實體只有一個,網頁重新整理doget都顯示
		response.setContentType("text/html; charset=UTF-8"); //設定網頁輸出類型
		response.getWriter().append("Served at: ").
			append(request.getContextPath())
			.append("<h1>hello hank<h1>"); //新增一段話回應在,網頁上,但在瀏覽器上卻沒有變大,因為他你沒有轉成html物件她看待你還是依般字串
			
	}
	

}
