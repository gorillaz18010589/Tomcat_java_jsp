package tw.brad.beans;
//搭配brad56_bean
//1.類別public
//2..因為要做傳遞工作所以我們要宣告可序列化
//3.屬性要封裝
//4.要傭有無傳參數建構式
public class Member  {
	


	
	private String id, name;  //id,跟姓名封裝起來
	//getter & setter
	//對於一個封裝的屬性進行取值的動作	
	
	public Member() {
		this("0000","no name");
		
	}
	
	private Member(String id, String name) { //建構式也可以用這種方式初始話
		this.id = id;
		this.name = name;
	}
	public String getId() {return id;} //getter動作取得封裝的id屬性
	public String getName() {return name;} //getter 動作取得封裝的name屬性
	public void setId(String id) {this.id =id;}//sette動作設置id屬性
	public void setName(String name) {this.name = name;}//sette動作設置name屬性
}

