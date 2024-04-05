package EzenToto;

import java.util.Scanner;

public class GameManager {
	
	
	public void gameList(Scanner scan) {
		int menu = 0;
		홀짝Manager SippingGame = new 홀짝Manager(); //홀짝게임
		경마 horseRacing = new 경마(); 
		EzenSoccerManager scoccerGame = new EzenSoccerManager();
		
		do {
			System.out.println("==========================================================");
			System.out.println("1.홀짝 | 2.경마 | 3.축구 | 4.게임목록 종료");
			System.out.println("메뉴를 선택해주세요 > ");
			menu = scan.nextInt();
			
			switch (menu) {
			case 1:
				SippingGame.hz(scan);
				break;
			case 2:
				horseRacing.add(scan);
				break;
			case 3:
				scoccerGame.Soccer(scan);
				break;
			case 4:
				
				break;

				
			default:
				System.out.println("잘못된 메뉴입니다!");
				break;
			}
			
			
		} while (menu != 4);
		
		
	}
	
	

}