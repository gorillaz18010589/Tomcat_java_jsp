//用url =>rate改寫量大小
////畫畫
//畫面在brad23_百分比圖.html
//java.awt.image.BufferedImage.BufferedImage(int width, int height, int imageType)://創造一個畫布(寬,高,屬性)(建構式)
//java.awt.image.BufferedImage.createGraphics():(回傳Graphics2D)://創造一個畫筆物件(建構式)
//java.awt.Graphics.setColor(Color c)://設置顏色 (VOID方法)
//java.awt.Graphics.fillRect(int x, int y, int width, int height)://把矩形填滿(VOID方法) 
//java.awt.image.BufferedImage.getHeight():(回傳int):取得畫布的寬
//java.awt.image.BufferedImage.getWidth():(回傳int)取得畫布的高
//javax.servlet.ServletResponse.getOutputStream() ://取得輸出串流,影像的用getOutputStream();(回傳ServletOutputStream )
//javax.imageio.ImageIO.write(RenderedImage im, String formatName, OutputStream output)://影像輸出(影像檔,格式名,輸出串流) (回傳boolean)
package tw.brad.myjva;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Brad22")
public class Brad22 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/jpeg"); //設定畫圖輸出格式
		
		//1.創一個畫布
		BufferedImage bimg = new BufferedImage(400, 20,BufferedImage.TYPE_INT_RGB);//創造一個畫布(寬,高,屬性)
		Graphics2D g2d = bimg.createGraphics();  //創造一個畫筆
		
		
		float rate =Float.parseFloat(request.getParameter("rate")) ;
		//2.填滿顏色
		g2d.setColor(Color.YELLOW);//設置顏色(Color.YELLOW)
		g2d.fillRect(0,0 , bimg.getWidth(), bimg.getHeight()); //把矩形填滿,取得畫布的高,跟畫布的寬
		g2d.setColor(Color.RED);//設置顏色(Color.YELLOW)
		g2d.fillRect(0,0 ,(int)( bimg.getWidth()*rate/100), bimg.getHeight()); //把矩形填滿,取得畫布的高,跟畫布的寬
		
		//3.影像畫面輸出
		OutputStream out = response.getOutputStream();//取得輸出串流,影像的用getOutputStream();
		ImageIO.write(bimg, "jpeg", out); //影像輸出(影像檔,格式名,輸出串流)
		out.flush();
		out.close();
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
