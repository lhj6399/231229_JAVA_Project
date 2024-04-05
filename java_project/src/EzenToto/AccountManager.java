package EzenToto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AccountManager {
	
	
	JoinMembership user = LoginManager.loginUser;
	
	//date
	LocalDateTime today = LocalDateTime.now();
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd  hh:mm:ss");
	
	//금액메뉴 출력
	public void AccountMenu(Scanner scan) {
		
		int accountmenu = -1;
				
		do {
		System.out.println("1.포인트 충전 | 2.포인트 출금 | 3. 잔액 확인 | 4. 돌아가기");
		System.out.println("메뉴를 선택해주세요 > ");
		accountmenu = scan.nextInt();
		
		switch (accountmenu) {
		
			case 1:		InMoney(scan);							break;
			
			case 2:		OutMoney(scan);							break;
			
			case 3:		PrintMoney();							break;
			
			case 4:												break;
			
			default:	System.out.println("*잘못된 메뉴입니다!");		break;
			
			}	
		
		} while(accountmenu !=4);
			return;
	}
	
	

	//입금
	public void InMoney(Scanner scan) {
		
		
		
				System.out.println("금액 입력 >");
				int b = scan.nextInt();

				
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
				System.out.println("*충전완료");
				try {
					Thread.sleep(700);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
				System.out.println();
				System.out.println(" " + dtf.format(today));
				System.out.println();
				System.out.println(" :: " + user.getUserName() + " 님");
				System.out.println(" :: 충전금액 : " + b + " 원");
				user.setAccount(user.getAccount() + b);
				System.out.println(" :: 잔액 : " + user.getAccount() + " 원");
				System.out.println();
				System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

				return;
	}
		
		
	
	
	//출금
	public void OutMoney(Scanner scan) {


			System.out.println("금액 입력 >");
			int b = scan.nextInt();	
			if(user.getAccount() < 0 || user.getAccount() < b) {
				System.out.println(" :: " + user.getUserName() + " 님의 총 잔액은 " + user.getAccount() + " 원 입니다.");
				System.out.println("*잔액이 부족합니다!");
				return;
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
			System.out.println(".");
			try {
				Thread.sleep(700);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("*출금완료");
			try {
				Thread.sleep(700);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
			System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
			System.out.println();
			System.out.println(" " + dtf.format(today));
			System.out.println();
			System.out.println(" :: " + user.getUserName() + " 님");
			System.out.println(" :: 출금금액 : " + b + " 원");
			user.setAccount(user.getAccount() - b);
			System.out.println(" :: 잔액 : " + user.getAccount() + " 원");
			System.out.println();
			System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
			
			return;
		}


	
	//잔액확인
	public void PrintMoney() {

		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println();
		System.out.println(" " + dtf.format(today));
		System.out.println();
		System.out.println(" :: " + user.getUserName() + " 님 잔액은 " + user.getAccount() + " 원 입니다.");
		System.out.println();
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		return;
		
	}

	

}