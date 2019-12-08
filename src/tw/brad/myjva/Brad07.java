//目的:抓到使用者上傳的檔案,及寫入檔案,連接brad06.html
//正常上傳檔案會有規劃,設置在web-inf底下
//1.搜尋tomcat web.xml web app =>到官網下載 xml
//2.把附檔名改成web.xml其他後面要去掉
//3.放在web-inf底下
//4.處理web檔案,在web.xml
//5.url到這網址看https://www.ibm.com/support/knowledgecenter/zh-tw/SSEQTP_liberty/com.ibm.websphere.wlp.doc/ae/cwlp_cdi_behavior.html
//6改好後設定要存檔的資料夾跟目錄位置
//7.web的祖態黨
//javax.servlet.http.Part.getSize()://取得大小(回傳long)
//javax.servlet.http.Part.getName()://取得你前端參數的設定的name值(回傳String)
//javax.servlet.http.Part.getSubmittedFileName()://取得你送出的檔案名稱(回傳String)
//javax.servlet.GenericServlet.getServletContext()://取得一個掌管伺服器全局的物件(回傳ServletContext)
//javax.servlet.ServletContext.getInitParameter(String arg0)://取得web.xml的上傳路徑(回傳String)

package tw.brad.myjva;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;




@WebServlet("/Brad07")
@MultipartConfig  //前端用Multipart,這邊也要宣告才行
public class Brad07 extends HttpServlet {
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//設定好組態黨後,拿到這個要存放的資料夾路徑
		ServletContext context = getServletContext();//取得一個掌管伺服器全局的物件
		String uploadPath = context.getInitParameter("uploadPath");//取得web.xml的上傳路徑
		
		//取得使用者上傳的檔案,明子跟值
		Part upload = request.getPart("upload"); //取得檔案的部分,因為是檔案切割所以用part
		Collection<String> names = upload.getHeaderNames(); //取得參數的名子
		for(String name: names) {
			String value = upload.getHeader(name); //取得參數的值
			System.out.println(name +":" + value);
		}
		long  getsize = upload.getSize(); //取得大小
		String getname = upload.getName(); //取得你前端參數的name值
		String getfilename = upload.getSubmittedFileName(); //取得你送出的檔案名稱
		System.out.println(  getname+":" + getfilename +";" + getsize);
		
		//把用戶上船的檔案串流抓到,準備一個跟他大小一樣的蓬子讀取
		BufferedInputStream bin = 
				new BufferedInputStream(upload.getInputStream());
		byte [] buf = new byte [(int)getsize];
		bin.read(buf);;
		bin.close();
		
		//把抓到的輸出串流檔案寫到資料夾
//		FileOutputStream fout = new FileOutputStream("c:/hank/hank.jpg");
		File uploadfile = new File(uploadPath, getfilename); //我設定的檔案位置,跟使用者上傳的檔案名稱
		FileOutputStream fout = new FileOutputStream(uploadfile);//上傳檔案指定到此資料夾

		fout.write(buf);
		fout.flush();
		fout.close();
	}

}
