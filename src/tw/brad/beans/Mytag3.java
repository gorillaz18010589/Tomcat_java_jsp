package tw.brad.beans;
//要玩這塊原上都要封裝
//1.要玩屬性要封裝
//2.如何讓你的屬性能讓外部叫到,要設置方法
import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Mytag3 extends SimpleTagSupport {
	private String name;
	private int price;
	
	//設置方法,讓屬性可以去玩到
	public void setName(String name) {this.name = name;}
	public void setPrice(int price) {this.price = price;}
	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		super.doTag();
		
		//先看看有沒有掌握到name跟price
		JspWriter out = getJspContext().getOut();
//		out.print(name + ":" + price );
		
		//玩body的方式
		StringWriter sw = new StringWriter();
		getJspBody().invoke(sw); //玩身體,把sw字串玩得加進來
		
		String x = sw.toString(); //本來是物件轉字串
		
		//輸出你想要的呈現方式
		out.print(sw + "=>" + name + ":" + price);
		
		
	}
}
