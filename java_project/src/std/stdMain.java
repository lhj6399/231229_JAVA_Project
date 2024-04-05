package std;

import java.util.Scanner;
// 2번
public class stdMain {

	public static void main(String[] args) {
		// 메뉴 구성
		/* 1. 학생 추가 | 2. 학생 출력 | 3. 학생 검색 |
		 * 4. 학생 수정 | 5. 학생 삭제 | 6. 점수 추가 |
		 * 7. 점수 수정 | 8. 점수 삭제 | 9. 종료     |
		 * 
		 */

		Scanner scan = new Scanner (System.in);
		
		stdManager sm = new stdManager();
		int menu = 0;
		sm.add();
		
		do {
			System.out.println("1. 학생 추가 | 2  학생 출력  | 3. 학생 검색 |");
			System.out.println("4. 학생 수정 | 5. 학생 삭제  | 6. 점수 추가 |");
			System.out.println("7. 점수 수정 | 8. 점수 삭제  | 9. 종료     |");
			System.out.println("메뉴를 입력하세요.");
			
			menu = scan.nextInt();
			
			switch(menu) {
			case 1: sm.addStd(scan); // 학생 추가
			break;
			case 2: sm.printStd(); // 학생 출력
			break;
			case 3: sm.searchStd(scan); // 학생 검색
			break;
			case 4: sm.modStd(scan); // 학생 수정
			break;
			case 5: sm.delStd(scan); // 학생 삭제
			break;
			case 6: sm.addSub(scan); // 점수 추가
			break;
			case 7: sm.modSub(scan); // 점수 수정
			break;
			case 8: sm.delSub(scan); // 점수 삭제
			break;
			case 9: 
			break;
			default: System.out.println("잘못된 메뉴입니다.");
			break;
			}
		} while (menu != 9); {
			System.out.println("프로그램 종료");
		}
		
		scan.close();
	}

}
