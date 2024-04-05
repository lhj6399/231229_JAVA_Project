package day01;

public class 과제 {

	public static void main(String[] args) {
		//카페에 제출
		/* 국어, 영어, 수학의 점수 합계와 평균을 출력
		 * 평균은 소수점을 살려서 출력
		 * 조건선택연산자를 이용하여 평균이 80이상이면 합격, 아니면 불합격으로 출력
		 */
		int kor = 100; //국어 점수
		int eng = 80; //영어 점수
		int math = 90; //수학 점수
		
		int sum = kor+eng+math; 
		double avr = sum/3.0; 
		System.out.println("국영수 합계:"+sum);
		System.out.println("국영수 평균:"+(avr));
		
		System.out.println(avr>=80?"합격":"불합격");
		
		//조건선택 연산자 => if문으로 변경
		/*	if(조건식){
				처리문;
			}else{
				처리문;
				}
			}
		*/
		if(avr>=80){
			System.out.println("결과:합격");
		}else{
			System.out.println("결과:불합격");
		}
	}

}
