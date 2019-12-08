package tw.brad.myjva;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//javax.servlet.ServletRequest.getParameterValues(String name):多選題時可用,取得多個參數時(回傳String[])
//java.io.PrintWriter.write(String s):輸出串流檔案(void)
@WebServlet("/Brad05")
public class Brad05 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			String gender= request.getParameter("gender");
			
			//發現只抓第一個參數,設計多選題
//			String hobby = request.getParameter("hobby"); 
//			System.out.println(hobby); 
		
			
			//2.多選題,要抓多個參數用這招getParameterValues,選擇性去
			String[] hobbys = request.getParameterValues("hobby");
			for(String hobby: hobbys) {
				System.out.println(hobby);
			}
			
			//1.設計單選題二擇一,選擇性別
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			if(gender.equals("m")) {
				writer.append("男生");
			}else{
				writer.append("女生");
			}
			//3.郵遞區號抓到方式
			String zipcode = request.getParameter("zipcode");
			if(zipcode.equals("401")) {
				writer.append("北屯");
			}else if(zipcode.equals("402")) {
				writer.append("南屯");
			}else if(zipcode.equals("403")) {
				writer.append("西屯");
			}else {
				writer.append("東屯");
			}
			//4.抓文字區域,你打什麼就抓什麼
			String text = request.getParameter("text");
			writer.write(text);
			writer.flush();
	}

	
	
}
