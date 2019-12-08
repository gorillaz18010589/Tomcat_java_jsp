package tw.brad.myjva;

import com.berry.BCrypt;

//目的:此類別專門寫工具方法,不寫物件實體
public class BradAPis {
	public static boolean ckPasswd (String src, String cpasswd) { //檢查密碼(你輸入的密碼來源,跟加密的密碼)
		boolean isRight = false; //是否正確預設flase
		
		if (cpasswd.startsWith("$2a$10$")) { //如果加密的密碼,開頭不是這些數字,就不用近來,如果是進來做檢查
			isRight = BCrypt.checkpw(src, cpasswd);//檢查你輸入的密碼來源,跟加密的密碼
		}
		return isRight;
	}
}

