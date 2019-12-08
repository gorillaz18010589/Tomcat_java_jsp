package tw.brad.myjva;


	public class Member {
		private String acount,realname; //會員帳號,姓名
		private int age; //會員年齡
		
		//建構式
		public Member(String account , String realname,int age) {
			this.acount = account;
			this.realname = realname;
			this.age =age;
		}
		
		//取回帳號方法
		public String getAccount() {
			return acount;
		}
		//取回姓名方法
		public String getRealname() {
			return realname;
		}
		//取回年齡方法
		public int getAge() {
			return age;
		}
		
	}
