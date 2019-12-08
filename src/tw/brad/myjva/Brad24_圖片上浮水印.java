package tw.brad.myjva;
//javax.imageio.ImageIO.read(File input)://影像讀取(回傳BufferedImage)
//java.awt.Font.Font(String name, int style, int size)://設定字形的物件(檔案,字形的效果,字形的大小)(建構式)
//java.awt.geom.AffineTransform.AffineTransform()://變形物件(建構式)
//java.awt.geom.AffineTransform.rotate(double theta, double anchorx, double anchory)://旋轉角度(經度,起始位址,偏移位置)(void方法)
//java.awt.Font.deriveFont(AffineTransform trans):// 變形字形(變形物件)(回傳Font)
//javax.imageio.ImageIO.write(RenderedImage im, String formatName, OutputStream output)://把影像輸出在畫面(影像讀取的檔案,格式,跟輸出串流)(回傳boolean)
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
//圖片一上來就有浮水印,事後端坐處理
//目的從既有的檔案目錄取得影像作出浮水印效果
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Brad24_圖片上浮水印")
public class Brad24_圖片上浮水印 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.輸出影像格式為圖片影像
		response.setContentType("image/jpeg");
		//2.取得檔案的影像位置
		String uploadPath = request.getServletContext().getInitParameter("uploadPath"); //連接到web.xml的指定資料夾
		//3.把影像串流放進來
		BufferedImage bimg = ImageIO.read(new File(uploadPath,"coffee.jpg"));//影像讀取從哪個檔案位置而來
		
		//5.畫畫處理浮水印
		Graphics2D g2d = bimg.createGraphics(); //取得畫筆物件實體
		Font myfont = new Font(null, Font.BOLD + Font.ITALIC,50); //設定字形的物件(檔案,字形的效果,字形的大小)
		AffineTransform tran = new AffineTransform(); //變形物件
		tran.rotate(Math.toRadians(-45),0, 0);//旋轉角度(經度,起始位址,偏移位置)
		Font myfont2 = myfont.deriveFont(tran); // 變形字形(變形物件)
		g2d.setFont(myfont2);
		g2d.setColor(Color.YELLOW); //設置顏色
		g2d.drawString("hello brad", 120, 160); //在圖片上寫字("要寫的字",要寫的座標x,y)
		
		//4.把影像輸出在畫面
		OutputStream out = response.getOutputStream();
		ImageIO.write(bimg,"jpeg", out); //把影像輸出在畫面(影像讀取的檔案,格式,跟輸出串流)
		
		//6.把改過好的圖片寫入資料夾
		File outFile = new File(uploadPath, "kid.jpg");
		ImageIO.write(bimg, "jpeg", outFile);
		out.flush();
		out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
