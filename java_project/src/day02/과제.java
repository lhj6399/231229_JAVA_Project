package day02;

import java.util.Scanner;

public class 과제 {

	public static void main(String[] args) {
		/*카페에 제출
		 * 정수 2개와 연산자 1개를 입력받아 두 정수의 연산을 출력
		 * ex) 2 3 + => 2 + 3 => 5
		 * ex) 5 1 - => 5 - 1 => 4
		 * 연산자는 + - x / % 가능
		 * 다른 종류의 연산자는 들어오면 잘몬된 연산자로 출력
		 */
		
		//연산자 = char(기본 자료형) == 비교가능 / String(객체) == 비교불가능
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("숫자(정수)를 입력해주세요.");
		int num1 = scan.nextInt();
		
		System.out.println("다음 숫자(정수)를 입력해주세요.");
		int num2 = scan.nextInt();
		
		System.out.println("연산자를 입력해주세요.");
		char op = scan.next().charAt(0); //한글자 받기
		
		
		// /, %일 경우 num2가 0이 되면 안내문구 띄우기
		if ((op == '/' || op == '%')&&num2==0)  {	
			System.out.println("잘못된 입력값입니다.");
		} else {
			int a = num1 - num2;
			int b = num1 * num2;
			
			switch (op) {
			case '+':
				System.out.println(""+num1+op+num2+"="+(num1+num2));
				break;
			case '-':
				System.out.println(""+num1+op+num2+"="+a);
				break;
			case '*':
				System.out.println(""+num1+op+num2+"="+b);
				break;
			case '/':
				System.out.println(""+num1+op+num2+"="+num1 / (double)num2);
				break;
			case '%':
				System.out.println(""+num1+op+num2+"="+num1 % num2);
				break;
			default:
				System.out.println("잘못 입력된 값입니다.");
			
			}
		}

		scan.close();
		
	}

}
