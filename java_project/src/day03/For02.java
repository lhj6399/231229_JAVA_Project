package day03;

public class For02 {

	public static void main(String[] args) {
		
		//1~10까지 출력
		for(int i=1;i<=10;i++) {
			System.out.print(i+" ");
		}
		
		System.out.println();
		
		
		//1부터 10까지 짝수만 출력
		for (int i=1; i<=5;i++) {
			System.out.print(2*i+" ");
		}
		
		System.out.println();
		
		
		//1부터 10까지 합계 출력
		int sum = 0; //지역변수는 반드시 초기화 해야함. 초기화 기본값 0 / null
		for (int i=1; i<=10; i++) {
			sum +=i; // sum = sum+i;
		}
		System.out.println(sum);
		
		//1부터 10까지의 짝수합과 홀수합을 출력
		int sum1 = 0;
		int sum2 = 0;
		
		for(int i=1; i<=10; i++) {
			if(i % 2 ==0) {
				sum1 = sum1+i; //sum1+=i;
			} else {
				sum2 = sum2+i; //sum2+=i;
			}
		}
		System.out.println("짝수의 합: "+sum1);
		System.out.println("홀수의 합: "+sum2);
		
	}

}
