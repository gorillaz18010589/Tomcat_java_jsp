package tw.brad.beans;
//隨便寫當然不會變成標籤,所以他是繼承SimpleTagSupport
//並且override doTag()方法
//我本身就是一個jsp黨,因為你的標籤本來就是會活在jsp當中所以用get而來
import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;


public class Mytag extends SimpleTagSupport{ //繼承這個代表現在是標籤

	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		super.doTag();
		
		JspContext jsp = getJspContext(); //因為這就是標籤直接從jsp全文裡取得
		JspWriter out = jsp.getOut(); //在取得輸出串流
		out.print("hello Brad");
	}
}
