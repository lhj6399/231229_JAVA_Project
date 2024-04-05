package EzenToto;

import java.util.Scanner;

public class 홀짝Manager {
	
	
	JoinMembership user = LoginManager.loginUser;	//로그인유저 데이터 값 사용
	
	public 홀짝Manager() {}
	

	public void hz(Scanner scan) {
		int menu1 = 0;
		String menu2 = null;
		int a ; //컴퓨터 랜덤값
		String result; //랜덤값으로 홀짝을 도출
		
		
		do {
			
			System.out.println("\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⡀⠀⠀⠀⠀⠀⠀⠀\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢀⠜⠀⠀⠀⠀⠀⠀⠀\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡄⠀⠀⠀⠀⠀⠀⠀⢰⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⠛⢢⠀⠨⠀⠀⠀⠀⠀⠀⠀⠀\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⡄⠀⠀⠀⠀⠀⠀⣸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡖⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢳⠀⠀⠀⠀⠀⠀⡏⠀⠀⠀⠀⠀⠀⢀⠞⠁⠀⠐⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⢦⣀⠀⠀⠀⠀⠀⠀⠀⠃⠀⠀⠀⠀⠀⠁⠀⠀⠀⠀⠀⡴⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠳⣄⠀⠀⠀⠀⠀⠀⠀⣠⣤⣄⠀⠀⠀⠀⠀⠀⠘⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠁⠀⠀⠀⠀⢀⡾⠃⠀⣸⠗⠳⣆⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⠟⠀⢀⡾⠋⠀⣰⣟⣉⢻⣄⡀⠀⠀⠀⠤⠖⠋⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠤⠤⣤⣄⣀⣀⠀⠀⠀⠀⢠⡾⠛⠷⢴⡟⠀⢀⣾⡟⠉⠙⠻⣍⣹⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠀⠀⠀⣰⠏⠀⠀⠀⠈⠳⢶⡟⠀⢻⣦⡀⠀⠈⢻⡅⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣟⠀⠀⠀⣀⣤⡴⢦⣿⣷⣿⡿⠁⠀⣠⡞⠁⠀⠀⠠⣤⣀⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⠟⠀⠀⠾⠉⠀⠀⠀⠀⠙⠋⠀⢀⣴⠋⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⡾⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⡞⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣴⠏⠀⠀⠀⠀⠀⠀⠀⠀⣀⠀⢀⣠⡴⠋⠀⠀⠀⠀⠀⠠⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⡾⠁⠀⠀⠀⠀⠀⠀⠀⢀⡼⠋⠙⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠈⠳⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⠋⠀⠀⠀⠀⠀⠀⠀⠀⣠⠟⠀⠀⠀⠀⠀⠀⠀⠰⡄⠀⠀⠀⠀⠀⠀⠀⠙⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⣠⠞⠁⠀⠀⠀⠀⠀⠀⠀⢀⡾⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⢳⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
					+ "⠀⠀⠀⠀⠀⠀⠼⠋⠀⠀⠀⠀⠀⠀⠀⠀⣰⠟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⡾⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣴⠟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
					+ "");
			
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("메뉴를 선택하세요.");
			System.out.println("1. 게임 규칙 설명 | 2. 게임 시작(배팅) | 3.종료");
			menu1 = scan.nextInt();
			
			switch(menu1) {
			case 1: 
				
				System.out.println("  ==========================게임 규칙===============================");
				System.out.println(" // 홀짝은 상대 손에 쥔 구슬 개수가 홀수인지 짝수인지 맞히면 따는 간단한 게임이다.//");
				System.out.println("//                '홀' 또는 '짝'을 선택하면 된다.                    //");
				System.out.println("================================================================");
				break;
				
			case 2:
				
				System.out.println("배팅 금액을 입력하세요.");
				int price = scan.nextInt();

				
				if(user.getAccount()<price || user.getAccount()<=0) {
					System.out.println(user.getUserName() + " 님 배팅할 금액이 부족합니다. (잔액 : " + user.getAccount() + " 원)");
					System.out.println("*충전 후 이용해주세요.");
					return;
				}
				
				user.setAccount(user.getAccount()-price);
				System.out.println("*배팅완료");
				
				
				
				
				System.out.println("'홀' 또는 '짝'을 입력하세요.");
				System.out.println("'종료'를 입력하면 종료합니다.");
				menu2 = scan.next();
				while(!(menu2.equals("홀") || menu2.equals("짝")|| menu2.equals("종료"))) {
					System.out.println("잘못 입력하셨습니다.");
					System.out.println("다시 입력해주세요.");
					menu2 = scan.next();
				}
				
				String asd = menu2;
				
				switch(asd) {
				
				case "홀" : 
					
					System.out.println(".");
					try {
						Thread.sleep(700);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.out.println(".");
					try {
						Thread.sleep(700);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.out.println(".");
					try {
						Thread.sleep(700);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					a = (int)(Math.random()*2)+1;
					result = ((a == 1)? "홀": "짝");
					System.out.println(result);
					
					if(asd.equals(result)) {
						System.out.println("축하합니다! 맞추셨습니다.");
						System.out.println("2배! 당첨금이 지급됩니다.");
						
						user.setAccount(user.getAccount()+(price*2));	// 게임성공 금액 지급
						System.out.println();
						
					}else {
						System.out.println("꽝!");
					}	
					
					break;
				
				case "짝" : 
					
					System.out.println(".");
					try {
						Thread.sleep(700);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.out.println(".");
					try {
						Thread.sleep(700);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.out.println(".");
					try {
						Thread.sleep(700);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					a = (int)(Math.random()*2)+1;
					result = ((a == 1)? "홀": "짝");
					System.out.println(result);
					
					if(asd.equals(result)) {
						System.out.println("축하합니다! 맞추셨습니다.");
						System.out.println("2배! 당첨금이 지급됩니다.");
						
						user.setAccount(user.getAccount()+(price*2));	// 게임성공 금액 지급
						System.out.println();
						
					}else {
						System.out.println("꽝!");
					}	
					
					break;
								
				case "종료" : 
					break;
				


				}				
						
			}

				
		
		}while(menu1 != 3);
		
	

	}
	

}