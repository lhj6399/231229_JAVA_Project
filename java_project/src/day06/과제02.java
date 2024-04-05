package day06;

import java.util.Scanner;

public class 과제02 {

	public static void main(String[] args) {
		/* 숫자를 입력받아서 입력받은 숫자를 거꾸로 출력. 각 자리의 합계 출력
		 * ex) 1 1 4 5 6 => 6 5 4 1 1 => 6+5+4+1+1 => 결과값 출력
		 * ex) 1 9 8 7 4 => 4 7 8 9 1 => 4+7+8+9+1 => 결과값 출력
		 * /, % 연산자를 이용
		 */
		
		Scanner scan = new Scanner(System.in);
		System.out.println("숫자를 입력하세요.");
		int num = scan.nextInt();
		//System.out.println();
		int sum = 0;
		
		// num % 10 = 나머지값을 저장 => 마지막 자리 (출력)
		// num / 10 = 몫 (int)다시 나누는 값으로 사용
		while(num > 0) {
			int b = num % 10; // 마지막 자리 추출
			System.out.print(b+" ");
			
			sum += b;
			num = num/10; // 정수/정수 => 정수 소수점
		}
		System.out.println("합계 : "+sum);
		
		scan.close();

	}

}
