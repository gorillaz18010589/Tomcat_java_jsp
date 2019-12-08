package tw.brad.beans;

public class BradAPIs {
	//產生樂透
	public static String creatLottert() {
		int rand =(int)(Math.random()*49+1);
		return rand +"";
	}
	//跟某人說ya
	public static String sayYa (String name) {
		return "Ya!" +name;
	}
		//拿到double轉成字串
	public static String toIntString(double v) {
		Double d = v; //先轉乘Double物件再用它方法
		return d.intValue() + "";
		
	}
}
