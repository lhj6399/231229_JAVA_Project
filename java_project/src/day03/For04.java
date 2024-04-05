package day03;

import java.util.Scanner;

public class For04 {

	public static void main(String[] args) {
		/* 단을 입력받아서 입력받은 단을 출력 (구구단)
		 * 2 =>2*1 = 2 2*2 = 4 ... 2*9 = 18
		 * 
		 */

		Scanner scan = new Scanner(System.in);
		System.out.println("단을 입력하세요");
		int num1 = scan.nextInt();
		
		for(int i=1; i<=9; i++) {
			System.out.println(num1+"*"+i+"="+num1*i);
		}
		
		scan.close();
		
		
		
	}

}
