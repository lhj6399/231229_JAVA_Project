package Sale;

import java.util.Scanner;


public class SaleMain {

	public static void main(String[] args) {
		/* menu
		 * 1. 메뉴 추가 | 2. 메뉴 삭제 | 3. 메뉴 수정 (가격 수정)
		 * 4. 메뉴 보기(전체 메뉴 출력) | 5. 주문 | 6. 주문 내역 출력 (영수증) | 7. 종료 |
		 * 7. 종료 |
		 */
		
		SaleManager sm = new SaleManager();
		Scanner scan = new Scanner(System.in);
		sm.addMenu();
		
		int menu = 0;
		
		do {
			System.out.println("1. 메뉴 추가 | 2. 메뉴 수정 (가격 수정) | 3. 메뉴 삭제 ");
			System.out.println("4. 메뉴 보기 (전체 메뉴 출력) | 5. 주문 | 6. 주문 내역 출력 (영수증) | 7. 종료 |");
			System.out.println("선택 > ");
			menu = scan.nextInt();
			switch(menu) {
			case 1: sm.add(scan); break;
			case 2: sm.update(scan); break;
			case 3: sm.delete(scan); break;
			case 4: sm.printSale(); break;
			case 5: System.out.println("주문 메뉴 >");
					String menu3 = scan.next();
					System.out.println("수량 >");
					int count = scan.nextInt(); 
					sm.orderPick(menu3, count); break;
			case 6: sm.orderPrint(); ; break;
			case 7: break;
			default:
				System.out.println("잘못된 메뉴 입니다.");
			}
		} while(menu != 7);
		System.out.println("프로그램 종료");

		scan.close();
		
	}

}
