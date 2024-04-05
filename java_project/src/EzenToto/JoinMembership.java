package EzenToto;



public class JoinMembership { //회원가입
	private String userID;
	private String userPassWord;
	private String userName;
	private int account = 0;
	
	
	public int getAccount() {
		return account;
	}

	public void setAccount(int account) {
		this.account = account;
	}

	public JoinMembership() {}

	public JoinMembership(String userID, String userPassWord, String userName) {
		
		this.userID = userID;
		this.userPassWord = userPassWord;
		this.userName = userName;
		
	}
	
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserPassWord() {
		return userPassWord;
	}

	public void setUserPassWord(String userPassWord) {
		this.userPassWord = userPassWord;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "유저ID = "+ userID +" | "+ "유저 닉네임 = " + 
				userName +" | "+ "계좌 잔액 = "+ account+"원";  
	}
	
	
}