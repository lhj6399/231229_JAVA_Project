package day09;

import java.util.Scanner;

public class 과제 {

	public static void main(String[] args) {
		/* 야구게임
		 * 컴퓨터가 3자리의 숫자를 생성 (각 자리수는 1~9까지의 수) => 배열로 랜덤 저장 (중복 불가능)
		 * 유저는 3자리의 숫자를 맞추는 게임 => 직접 입력 (중복되지 않게...)
		 * 자리와 숫자가 일치하면 strike
		 * 숫자만 맞으면 ball
		 * 아무것도 안맞으면 out
		 * ex) 컴퓨터 번호 : 1 2 3
		 * 	   사용자 번호 : 1 7 8 => 1s
		 *     사용자 번호 : 1 3 2 => 1s 2b
		 *     사용자 번호 : 7 8 9 => out
		 *     사용자 번호 : 1 2 3 => 3s 정답.
		 */
		
		int com[] = new int[3]; //컴퓨터 생성 번호
		int user[] = new int[3]; //사용자 번호
		
		int i = 0;
		int num = 0;
		randomArray(com);
		printArray(com);
		
		Scanner scan = new Scanner(System.in);
		System.out.println();
		System.out.println("사용자 번호 :");
		for(i=0; i<user.length; i++) {
				user[i] = scan.nextInt();
				System.out.print(user[i]+" ");
			}
		
		
		scan.close();
		
		
	}

	
	public static void randomArray(int arr[]) { 
		
		int cnt = 0;
		while (cnt < arr.length) {
			int r = (int)(Math.random()*10);
			if(!isContain(arr,r)) {
				arr[cnt] = r;
				cnt++;
			}
		}
		
	}

	public static void printArray (int arr[]) {
		System.out.println("컴퓨터 생성 번호 : ");
		for (int i=0; i<arr.length; i++){	
		System.out.print(arr[i]+" ");
		}
	}

	private static boolean isContain(int[] arr, int r) {
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == r) {
				return true;
			}
		}
		return false;
	}
}
