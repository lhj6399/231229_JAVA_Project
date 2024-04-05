package day05;

import java.util.Scanner;

public class Array02 {

	public static void main(String[] args) {
		/* 5명의 점수를 입력할 수 있는 배열을 생성
		 * 5명의 점수를 입력받아서 배열에 저장
		 * 점수를 출력 => 점수의 합계
		 */
		
		Scanner scan = new Scanner(System.in);
		int arr1[] = new int[10];
		int sum = 0;
		
		
		System.out.println("학생의 점수 입력: ");
		for(int i=0; i<arr1.length; i++) {
			arr1[i] = scan.nextInt();
			System.out.print(arr1[i]+" ");
			System.out.println();
			sum = sum+arr1[i];
		}
		
		double avg = sum/(double)arr1.length;
		System.out.println();
		System.out.println("점수 합계: "+sum);
		System.out.println("점수 평균: "+avg);
		
		
		scan.close();
		
		
	}

}
