package day07;

import java.util.Scanner;

public class 과제 {

	public static void main(String[] args) {
		/* 계산기 만들기
		 * --menu--
		 * 1. 덧셈 | 2. 뺄셈 | 3. 곱셈 | 4. 나눗셈 | 5. 나머지 | 6. 종료
		 * >> 메뉴선택 1
		 * >> 숫자1 5
		 * >> 숫자2 10
		 * 결과 : 5 + 10 = 15 
		 */
		Scanner scan = new Scanner(System.in);
		
		int num1 = 0;
		int num2 = 0;
		int menu = 0;
		
		do {
			System.out.println("--menu--");
			System.out.println("1. 덧셈 | 2. 뺄셈 | 3. 곱셈 | 4. 나눗셈 | 5. 나머지 | 6.종료");
			System.out.println(">> menu 선택 :  ");
			menu = scan.nextInt();
		
		if(menu<6) {
			System.out.println(">> 숫자1 :");
			num1 = scan.nextInt();

			System.out.println(">> 숫자2 :");
			num2 = scan.nextInt();
		}
			
			
			//실제 기능을 구현하는 처리문
		switch(menu) {
		case 1:
			//실제 기능 처리
			System.out.println("덧셈");
			System.out.println(num1+"+"+num2+"="+sum(num1,num2));
			break;
		case 2:
			System.out.println("뺄셈");
			System.out.println(num1+"-"+num2+"="+sub(num1,num2));
			break;
		case 3:
			System.out.println("곱셈");
			System.out.println(num1+"*"+num2+"="+mul(num1,num2));
			break;
		case 4:
			System.out.println("나눗셈");
			System.out.println(num1+"/"+num2+"="+div(num1,num2));
			break;
		case 5:
			System.out.println("나머지");
			System.out.println(num1+"%"+num2+"="+mod(num1,num2));
			break;
		case 6:
			System.out.println("종료");
			break;
		default:
			System.out.println("잘못된 메뉴입니다. 다시 선택하세요.");
		}
		} while(menu != 6); //메뉴가 6이 아니면 실행
			System.out.println("프로그램 종료");
		
		scan.close();
	}
		

	

	// 두 정수의 합을 알려주는 메서드 sum
			public static int sum(int num1, int num2) {
				return num1 + num2;
			}
			// 두 정수의 차를 알려주는 메서드 sub
			public static int sub(int num1, int num2) {
				return num1 - num2;
			}
			// 두 정수의 곱을 알려주는 메서드 mul
			public static int mul(int num1, int num2) {
				return num1 * num2;
			}
			// 두 정수의 몫을 알려주는 메서드 div
			public static double div(int num1, int num2) {
				return num1 / (double)num2;
			}
			// 두 정수의 나머지를 알려주는 메서드 mod
			public static int mod(int num1, int num2) {
				return num1 % num2;
			}
	
}

