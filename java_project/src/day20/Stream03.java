package day20;

import java.util.ArrayList;
import java.util.Arrays;

public class Stream03 {

	public static void main(String[] args) {
		// Student 클래스로 리스트 구성
		// add로 5명 추가
		ArrayList<Student> list = new ArrayList<>();
		
		list.add(new Student("홍길동",89));
		list.add(new Student("김길동",95));
		list.add(new Student("이길동",77));
		list.add(new Student("박길동",85));
		list.add(new Student("고길동",92));
		
		// 스트림을 이용하여 콘솔에 출력 ex) 홍길동 : 98
		list.stream().forEach(n -> System.out.println(n));
		
		System.out.println("---------------");
		list.stream().forEach(n -> {
			String name = n.getName();
			int score = n.getScore();
			System.out.println(name +" : "+score);
		});
		
		// list의 점수 합계 / 전체 인원수 출력
		System.out.println("----- 점수 합계 -----");
		int sum = list.stream()
				.mapToInt(n -> n.getScore())
				.sum();
		System.out.println("점수 합계: "+sum);
		
		// 인원수
		System.out.println("----- 인원수 -----");
		long count = list.stream().count();
		System.out.println(count+"명");
	}
	
}
