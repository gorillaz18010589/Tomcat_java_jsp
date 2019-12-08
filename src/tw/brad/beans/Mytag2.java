package tw.brad.beans;
//讓78號程式的body區域輸入的小寫字串變成大寫
import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Mytag2  extends SimpleTagSupport{
	@Override
	public void doTag() throws JspException, IOException {
		super.doTag();
		
		//1.輸出物件取得
		JspContext jsp = getJspContext();
		JspWriter out = jsp.getOut();
		//2..要玩有身體的body,我們是標籤所以直接拿
		JspFragment body = getJspBody(); //直接拿取身體,拿到一個jspFragemnt片段
		//2.我們要玩輸出要用,Fragment的invoke,把你要玩的東西invoke近來
		StringWriter sw = new StringWriter(); //得到一個StringWriter的物件實體準備放入invoke裡,也是我們等下標籤要做到身體的部分
		body.invoke(sw);
		
		out.print("hello" + sw.toString().toUpperCase()); //我們輸出這個body內容,因為本來是物件把它轉型字串,再把字變大
	}

}
