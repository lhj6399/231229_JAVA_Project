package day09;

import java.util.Scanner;

public class 가위바위보 {

	public static void main(String[] args) {
		/* 컴퓨터가 가위바위보를 랜덤으로 선택 (0=가위, 1=바위, 2=보)
		 * 내가 가위바위보 중 하나를 선택하여 입력
		 * 승/패/무 의 결과를 출력
		 * ex)
		 * com = 0 (가위) 
		 * user = 가위 => 무승부입니다.
		 */
		String rsp = null;
		int random = (int)(Math.random()*3);
		
		System.out.println("가위바위보 중 하나 입력");
		
		Scanner scan = new Scanner(System.in);
		
		rsp = scan.next();
		
		while (rsp.equals("가위")) { // user가 가위
			if (random == 0) {
				System.out.println("com = 가위. 무승부입니다.");
			} else if (random == 1) {
				System.out.println("com = 바위. 졌습니다.");
			} else if (random == 2) {
				System.out.println("com = 보. 이겼습니다.");
			}
			break;
			
	
	}
		while (rsp.equals("바위")) { //user가 바위
			if (random == 0) {
				System.out.println("com = 가위. 이겼습니다.");
			} else if (random == 1) {
				System.out.println("com = 바위. 무승부입니다.");
			} else if (random == 2) {
				System.out.println("com = 보. 졌습니다.");
			}
			break;
			
	
	}
		
		while (rsp.equals("보")) { //user가 보
			if (random == 0) {
				System.out.println("com = 가위. 졌습니다.");
			} else if (random == 1) {
				System.out.println("com = 바위. 이겼습니다.");
			} else if (random == 2) {
				System.out.println("com = 보. 비겼습니다.");
			}
			break;
			
	
	}
		scan.close();
	
	}
}
