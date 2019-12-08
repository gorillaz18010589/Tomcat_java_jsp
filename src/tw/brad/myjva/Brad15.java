package tw.brad.myjva;
//我是model演算,連接14號的主程式
//目的:取得你的參數,做演算法
public class Brad15 {
	private int x, y;
	String op;
	 public Brad15(String x ,String y,String op) {
			this.x = Integer.parseInt(x); //拿到參數是字串轉成Int才能演算
			this.y = Integer.parseInt(y);
			this.op = op;
	}

	 public int add() { //演算法加法
		 return x + y;
	 }
	 
	 public double operation() {
		 double ret = 0;
		 switch(op) {
		 case "1" : ret = x + y; break;
		 case "2" : ret = x - y; break;
		 case "3" : ret = x * y; break;
		 case "4" : ret = x*1.0 / y; break;
		 }
		 
		 return ret;
	 }
	 
}
