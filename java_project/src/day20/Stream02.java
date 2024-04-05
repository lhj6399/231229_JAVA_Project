package day20;

import java.util.Arrays;

public class Stream02 {

	public static void main(String[] args) {
		/* 배열에서 홀수 / 짝수만 출력. 중복되는 값 제거 & 정렬
		 * 2가지 방법 이용
		 */
		int[] arr = {1,8,4,5,7,8,9,6,5,4,1,2,3,6,8,2,4};

		// 홀수 출력
		int[] s = Arrays.stream(arr).filter(n -> n%2==1).distinct().sorted().toArray();
		for (int i=0; i<s.length; i++) {
			System.out.print(s[i]+" ");
		}
		System.out.println();
		
		// 짝수 출력
		Arrays.stream(arr)
		.filter(a -> a%2==0)
		.distinct()
		.sorted()
		.forEach(n -> System.out.print(n+" "));
		System.out.println();
	}

}
