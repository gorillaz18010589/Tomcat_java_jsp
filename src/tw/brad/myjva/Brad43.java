package tw.brad.myjva;
//java.util.concurrent.ExecutorService://執行者伺服器的物件實體
//java.util.concurrent.Executors://可以產生很多執行序的人
//java.util.concurrent.Executors.newFixedThreadPool(int nThreads):放固定的線程執行序(幾個執行序)(回傳ExecutorService)
//javax.servlet.AsyncContext://一個非同步的執行序物件畫面由request.getAsyncContext();
//javax.servlet.ServletRequest.getAsyncContext():由request.取得非同步的執行序物件(回傳AsyncContext)
//void javax.servlet.AsyncContext.complete()://非同步頁面,關閉
//void java.util.concurrent.ExecutorService.shutdown()://伺服器關避
//另外寫了MyAsyncListener方法,來監聽
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.AsyncContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//urlPatterns = "/brad_async" ://執行檔案名
//asyncSupported = true ://非同步權限要打開
@WebServlet(
		urlPatterns = "/Brad43",
		asyncSupported = true
		)
public class Brad43 extends HttpServlet {
	ExecutorService executorService = Executors.newFixedThreadPool(10);
	//AsyncContext asContext;
	
	//初始化時產生由init館裡去request還是response那邊
	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("init");
		
		ServletContext servletContext =  getServletContext();//取得整個伺服器全文
		List<AsyncContext> asyncContexts = new LinkedList<>();//把她用犯行非不同步物件處理
		servletContext.setAttribute("asyncs", asyncContexts);//把他設定參數上去
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");


	}

		//保留下面的方法
	private class AsyncRequest implements Runnable {
		private AsyncContext asyncContext;
		AsyncRequest(AsyncContext asyncContext){
			this.asyncContext = asyncContext;
		}
		
		//當主序結束時,背景非同步執行
		@Override
		public void run() {
			try {
				Thread.sleep(10*1000); //睡久一點
				
				PrintWriter out = asyncContext.getResponse().getWriter();//從非同步的頁面,取得輸出
				out.print("Lottery:" + (int)(Math.random()*49+1));//顯示出樂透號碼
				asyncContext.complete();//非同步頁面,關閉
			}catch(Exception e) {
				
			}
		}
	}
	//當伺服器結束時
	@Override
	public void destroy() {
		System.out.println("die");
		executorService.shutdown();//伺服器關避
		super.destroy();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}