package day08;

import java.util.Scanner;

public class Method03 {

	public static void main(String[] args) {
		
	int num = 0;	
		
	
	Scanner scan = new Scanner(System.in);
	
	System.out.println("정수(2~9중 하나)를 입력하세요.");
	num = scan.nextInt();
	
	for(int i=1; i<=9; i++) {
	if(num<=9) {
	System.out.println(num+"*"+i+"="+mul(num,i));
		}
	else {
		System.out.println("2~9를 입력하세요.");
		break;
	}
	}
	
	scan.close();	
	
	
	}
	
	// 정수 (2~9 중 하나)에 해당하는 구구단 출력 메서드
	// 매개변수 : 2
	public static int mul(int num1, int num2) {
		return num1 * num2;
	}
	
}
