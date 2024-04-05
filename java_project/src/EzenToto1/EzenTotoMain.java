package EzenToto1;

import java.util.Scanner;

public class EzenTotoMain {

	public static void main(String[] args) {
		
		
		Scanner scan = new Scanner(System.in);
		int menu = 0;
//		LoginManager log = new LoginManager();
//		VolleyballManager vm = new VolleyballManager();
//		홀짝Manager h = new 홀짝Manager();
		경마 h = new 경마();
		
		do {
			System.out.println("1.회원가입 | 2.로그인 | 3.종료");
			System.out.println("메뉴를 선택해주세요 > ");
			menu = scan.nextInt();
			
			switch (menu) {
//			case 1: log.joingMembershipUser(scan);  break;
			 
			
			case 2: h.add(scan); break;
			
			case 3: break;

			default:
				System.out.println("잘못된 메뉴입니다.");
				break;
			}
	
		}while(menu!=3);
		

		scan.close();
	}

}