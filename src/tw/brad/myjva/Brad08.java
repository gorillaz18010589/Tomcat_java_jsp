package tw.brad.myjva;
//目標:看看設定的組態黨是否正確
//正常上傳檔案會有規劃,設置在web-inf底下
//手工調整組態黨,程式不用改
//javax.servlet.GenericServlet.getServletContext()://取得一個掌管伺服器全局的物件(回傳ServletContext)
//javax.servlet.ServletContext.getInitParameter(String name)://取得web.xml的上傳路徑(回傳String)
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Brad08")
public class Brad08 extends HttpServlet {
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		//讀參數
		ServletContext context = getServletContext();//取得一個掌管伺服器全局的物件
		String uploadPath = context.getInitParameter("uploadPath");//取得web.xml的上傳路徑
		System.out.println(uploadPath);//查看你剛設定的組態檔有沒有生效
		
	}
}


