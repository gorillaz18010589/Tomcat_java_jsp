package tw.brad.myjva;
//只要有非同步的事情他都會聽到
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;

public class MyAsyncListener  implements AsyncListener{

	//沒有逾時的化完成
	@Override
	public void onComplete(AsyncEvent event) throws IOException {
		AsyncContext asyncContext = event.getAsyncContext();
		PrintWriter out = asyncContext.getResponse().getWriter();

		try {
			Thread.sleep(10*1000); //睡久一點
			out.print("Lottery:" + (int)(Math.random()*49+1));//顯示出樂透號碼
			asyncContext.complete();//非同步頁面,關閉
			out.print("我已抓到你的非同步請求,同步已結束");
		}catch(Exception e) {
	
		}
		
	}
	//錯誤
	@Override
	public void onError(AsyncEvent event) throws IOException {
		// TODO Auto-generated method stub
		
	}
	//開始
	@Override
	public void onStartAsync(AsyncEvent event) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.print("Start");
	}
	//逾時的化取消
	@Override
	public void onTimeout(AsyncEvent event) throws IOException {
		System.out.println("Time out");
		AsyncContext asyncContext = event.getAsyncContext(); //先從逾時拿到非同步的全文
		List<AsyncContext> asyncContexts =(List<AsyncContext>)
			asyncContext.//從全文底下
			getRequest().//取得請求
			getServletContext().//在取得43頁設置的全文伺服器底下的
			getAttribute("asyncs");//取得設置的屬性
		asyncContexts.remove(asyncContext);//取得後移除這個全文非同步指令
	}

}
