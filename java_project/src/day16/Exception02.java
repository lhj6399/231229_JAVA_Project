package day16;

import java.util.Scanner;

import javax.management.RuntimeErrorException;

public class Exception02 {

	public static void main(String[] args) {
		// ArithmeticException : 0으로 나누었을 때 발생하는 Exception
		// 하단에서 만든 메서드 실행.
		// 예외처리
		try {
			// 예외가 발생할 수 있는 구문 작성
			System.out.println(calc(4,0,'+'));
			System.out.println(calc(4,0,'-')); // 산술연자가 바꾸면 default 값 나옴
			System.out.println(calc(4,0,'*'));
			System.out.println(calc(4,0,'/'));
			System.out.println(calc(4,0,'%'));
		} catch (Exception e) {
			// 예외 처리 작성
			System.out.println(e.getMessage()); // 메시지 String을 출력
//			System.out.println("0으로 나누었습니다.");
			e.printStackTrace();
		}
			System.out.println(calc(4,0,'+'));
			System.out.println(calc(4,0,'-'));
			System.out.println(calc(4,0,'*'));
			
	
	}
	// 예외 발생시키기 : throw new로 발생시킬 수 있음.
	// throw : 예외 떠넘기기
	// 예외를 발생시키게 되면 메서드 선언부 끝 부분에 throws를 적고, 발생할 수 있는 예외를 반드시 적어줘야 함.
	// throws는 RuntimeException만 예외적으로 생략가능.
	
	// 기능 : 두 수를 입력받고 연산자를 입력받아 사칙연산의 결과를 리턴하는 메서드
	// 매개변수 : int num1, int num2, char op
	
	public static double calc(int num1, int num2, char op) throws RuntimeException { // 런타임 생략 가능
		double res = 0;
		// 연산자가 /, % 인 경우 num2가 0이면 예외발생
		if ((op=='/' || op == '%') && num2==0) {
			// 예외 미리 발생시키기.
				throw new RuntimeException("num2는 0이 될 수 없습니다.");
		}
		switch(op) {
		case '+': res=(num1+num2);
		break;
		case '-': res=(num1-num2);
		break;
		case '*': res=(num1*num2);
		break;
		case '/': res=(num1/num2);
		break;
		case '%': res=(num1%num2);
		break;
		default:
			throw new RuntimeException(op+"는 산술연산자가 아닙니다.");
		}
		return res;
		}
}
