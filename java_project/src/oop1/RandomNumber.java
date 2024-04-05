package oop1;

import java.util.Scanner;

public class RandomNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int sum = 0;
		System.out.print("난수의 개수를 입력하세요. :");
		int num = scan.nextInt();
		for (int i=1; i<=num; i++) {
			int random = (int)(Math.random()*99);
			sum += random;
//			System.out.println(random);
		}
		
		System.out.println("난수 "+num+"개의 합은 "+sum);
		scan.close();
		
	}

}
