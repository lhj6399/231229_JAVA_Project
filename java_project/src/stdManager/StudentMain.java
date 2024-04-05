package stdManager;

import java.util.Scanner;

public class StudentMain {

	public static void main(String[] args) {
		// 메뉴 처리
		/*
		 * 1. 학생등록 | 2. 학생리스트 출력 | 3. 학생검색(학생정보,수강정보) |
		 * 4. 수강신청 | 5. 수강철회 | 6. 종료 |
		 */
		// 객체를 생성하는 것은 항상 미리 해놓고 메서드 호출
		Scanner scan = new Scanner(System.in);
		// Manager를 호출하기 위한 객체
		StudentManager sm = new StudentManager();
		int menu = 0;
		do {
			// 메뉴 넣기
			System.out.println("--menu--");
			System.out.println("1. 학생등록 | 2. 학생리스트 출력 | 3. 학생검색(학생정보,수강정보) |");
			System.out.println("4. 수강신청 | 5. 수강철회 | 6. 종료");
			System.out.println(">> 메뉴선택 >");
			
			menu = scan.nextInt();
			
			// 메뉴에 따른 분기 구현
			switch(menu) {
			case 1 : sm.insertStudent(scan); break;
			case 2 : sm.printStudent(); break;
			case 3 : sm.searchStudent(scan); break;
			case 4 : sm.registerStudent(scan); break;
			case 5 : sm.deleteStudent(scan); break;
			case 6 : break;
			default:
				System.out.println("잘못된 메뉴입니다.");
			}
			
		} while(menu != 6);
		
		System.out.println("종료");
		
		scan.close();
	}

}
