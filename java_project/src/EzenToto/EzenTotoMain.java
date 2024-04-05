package EzenToto;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class EzenTotoMain {

	public static void main(String[] args) throws IOException {
		
		
		Scanner scan = new Scanner(System.in);
		int menu = 0;
		LoginManager log = new LoginManager();

		
		do {
			System.out.println("1.회원가입 | 2.로그인 | 3.종료");
			System.out.println("메뉴를 선택해주세요 > ");
			menu = scan.nextInt();
			
			switch (menu) {
			case 1: log.joingMembershipUser(scan);  break;
			 
			
			case 2: log.loginUser(scan); break;
			
			case 3: break;

			default:
				System.out.println("잘못된 메뉴입니다.");
				break;
			}
	
		}while(menu!=3);
		
		System.out.println("프로그램을 종료합니다!");
		

		scan.close();
		
		
		//파일에 저장
		PrintWriter pw = new PrintWriter("EzenTotoUserInformation.txt");
		int index = 0;
		for(int i = 0; i<LoginManager.userList.length;i++) {
			
			if(LoginManager.userList[i] != null) {
				
				if(index == i) {
					//String userList = log.ezenTotoUserInformation()+"\r\n";
					String userList = LoginManager.userList[i].toString()+"\r\n";
//					System.out.println(LoginManager.userList[i].toString());
					pw.write(userList);						
				}
				
				index++;
			}
		}
		pw.close();
		
		
		
		
		
	}
	
	
	
	
	

}