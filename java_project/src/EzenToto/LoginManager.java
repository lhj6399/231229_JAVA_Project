package EzenToto;

import java.util.Scanner;

public class LoginManager {
	
	public JoinMembership[] getUserList() {
		return userList;
	}
	


	public static JoinMembership[] userList = new JoinMembership[10];
	private int userCnt;
	public static JoinMembership loginUser; //로그인한 유저 고정값
	
	AccountManager am = new AccountManager();
	
	
	
	//회원가입 정보를 입력받아서 객체를 생성후 유저리스트에 추가.
	public void joingMembershipUser(Scanner scan) {
		System.out.println("사용하실 ID를 입력해주세요!");
		String userId = scan.next();
		for(int i =0; i<userList.length;i++) {
			if(userList[i]!=null&&userList[i].getUserID().equals(userId)) {
				System.out.println("----------error중복된 ID입니다!----------");
				return;
			}
		}
		System.out.println("사용하실 PassWord를 입력해주세요!");
		String userPassWord = scan.next();
		System.out.println("사용하실 닉네임을 입력해주세요!");
		String userName = scan.next();
		
		
		if(userCnt >= 1) {		
			for(int i =0;i<userCnt;i++) {
				
				if((userList[i].getUserName().equals(userName))) {
					while((userList[i].getUserName().equals(userName))) {
						
						System.out.println("--------중복된 닉네임입니다!--------");
						System.out.println("사용하실 닉네임을 다시 입력해주세요!");
						userName = scan.next();	
					}
					break;
				}
				
			}
		}
		
		
		//입력받은 값을 객체로 생성
		JoinMembership user = new JoinMembership(userId, userPassWord, userName);
		
		//배열이 다 찼을 경우 배열복사
		if(userCnt == userList.length) {
			JoinMembership[] tmp = new JoinMembership[userList.length+10];
			System.arraycopy(userList, 0, tmp, 0, userCnt);
			userList = tmp;
		}
		userList[userCnt] = user;
		userCnt++;
		System.out.println("회원가입이 완료되었습니다!");
//		System.out.println(user);
	}
	
	
	//유저 로그인 메서드
	public void loginUser(Scanner scan) {
		
		
		System.out.println("ID를 입력해주세요!");
		String userId = scan.next();
		for(int i =0; i<userList.length;i++) {
			
			if(userList[i] == null) {
				System.out.println("=====존재하지 않는 ID입니다!=====");
				System.out.println("회원가입을 해주세요!");
				return;
			}
			
			if(userList[i].getUserID().equals(userId)) {
				while(!(userList[i].getUserID().equals(userId))) {
					System.out.println("존재하지 않는 ID입니다!!");
					userId = scan.next();
				}
			}
			
			if(userList[i].getUserID().equals(userId)) { //입력한 id가 유저리스트에 있으면
				
				System.out.println("PassWord를 입력해주세요!");
				String userPassWord = scan.next();
				if(userList[i].getUserPassWord().equals(userPassWord)) {
					System.out.println("환영합니다! "+userList[i].getUserName()+"님!");
					
				//-------------로그인하면 메뉴에 들어감------------------------
					loginUser = userList[i]; //로그인한 유저 고정
					
						int logingMenu = 0;
						GameManager gm = new GameManager();
						AccountManager am = new AccountManager();
						
						do {
						System.out.println("1.BANK(입출금 포인트) | 2.게임목록 | 3.로그아웃");
						System.out.println("메뉴를 선택해주세요 > ");
						logingMenu = scan.nextInt();
						
						switch (logingMenu) {
						case 1:
							am.AccountMenu(scan);
							
							break;
						case 2:
							gm.gameList(scan);
							
							break;
							
						case 3:
							
							
							break;

						default:
							System.out.println("잘못된 메뉴입니다!");
							break;
						}
						
						} while (logingMenu != 3);
						
					System.out.println("로그아웃합니다!");
						return;
						
				}else {
					System.out.println("----------존재하지 않는 PassWord입니다!----------");
					return;
				}
				
			}
		}
		
	}
	
}