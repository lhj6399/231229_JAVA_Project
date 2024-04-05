package day01;

public class 변수 {

	public static void main(String[] args) {
		/* 변수 선언
		 * 자료형(타입) 변수명;
		 * 
		 * 변수 선언 + 초기화;
		 * 자료형(타입) 변수명 = 값;
		 * 
		 */
		int num = 123; //선언 + 초기화
		System.out.println(num);
		
		//int num = 456; //변수는 중복선언 불가능.
		
		int num1 = 12, num2 = 34, num3 = 56; // 같은 자료형의 한줄 선언 가능.
		System.out.println(num1);
		
		num1 = 78; // =(대입연산자) 오른쪽의 값을 왼쪽의 변수에 저장(덮어쓰기)
		System.out.println(num1);
		
		//8개의 기본 자료형은 지역변수 범위(scope) { }


	int num4 = 12;
	{
		System.out.println(num4);
	}
	
		System.out.println(num3);
		
		//한글자만 저장가능한 char
		//"문자열", 숫자, char 'a'
		//string("문자열") / char('한글자만 가능')
		
		char ch = 'a';
		System.out.println(ch);
		
		double dou= 3.1;
		System.out.println(dou);
		
		byte b = 1;
		System.out.println(b);
		
		boolean boo = true; //true,false 로만 저장 가능
		System.out.println(boo);
		
		//float / long 자료형운 좁마서룰 붙여야 사용가능.
		//float (f F) long (l L);
		
		float f =1.2f;
		long l = 1L;
		System.out.println(f);
		System.out.println(l);
		
		num1 = 010; //8진수로 인식 (0~7 8=>10)
		//10진수 (0~9 10=>10) / 16진수 (0~15(ABCDEF) 10=>16)
		System.out.println(num1);
		
		num2 = 0x10; //16진수로 인식
		System.out.println(num2);
		
		// + - * / %(나머지)
		
		num1 = 10;
		num2 = 20;
		System.out.println(num1+num2);
		
		//국어점수(kor), 영어점수(eng), 수학점수(math)를 변수로 선언하고,
		//값을 입력하여, 세 점수의 합을 콘솔에 출력
		
		int kor = 100, eng = 85, math = 90;
		System.out.println(kor+eng+math);
		int sum = kor+eng+math;
		System.out.println("합계:"+sum); // + : 숫자 + 숫자 = 숫자 (더하기연산자)
										// + : 숫자 + 문지 = 문자 (연결연산자)
		System.out.println("평균:"+sum/3.0);
		
		int a= 10;
		a += 10; // a = a + 10; 
		System.out.println(a);
		System.out.println(a++);
		System.out.println(a);
	}
}
