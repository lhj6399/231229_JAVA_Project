package day18;

import java.util.HashMap;

public class MapEx01 {

	public static void main(String[] args) {
		/* map을 이용하여 상품과 가격을 추가하여 합계를 구하시오.
		 * 상품을 map에 추가하는 작업은 메서드를 활용
		 * 
		 * 1. map을 main에 생성해놓고, 매개변수로 받아 map의 데이터를 채우는 메서드
		 * 2. map을 메서드 내부에서 생성하여, main으로 리턴하는 메서드
		 * 
		 * 가위 3000
		 * 크레파스 4000
		 * 물감 5000
		 * 합계 ?
		 * 
		 */
		HashMap<String, Integer>map = new HashMap<>();
		int sum = 0;
		MapEx01 m = new MapEx01();
		
		System.out.println("--- map을 매개변수로 받은 메서드 실행 ---");
//		m.makeMap(map);
		m.printMap(map);
//		for (String s : map.keySet()) { // key만 별도로 set구성
//			sum += map.get(s);
//			System.out.println(s+":"+map.get(s));
//		}
//		System.out.println("총합: "+sum);
		
		// 메서드를 실행하면 map을 주는 케이스
		sum = 0;
		HashMap<String, Integer> map1 = m.makeMap2();
		System.out.println("--- map을 리턴타입으로 받은 메서드 실행 ---");
		m.printMap(map1);
//		for (String s : map1.keySet()) {
//			sum += map1.get(s);
//			System.out.println(s+":"+map1.get(s));
//		}
//		System.out.println("총합: "+sum);
		
		// map을 받아서 출력하는 메서드
		System.out.println("--- map을 받아서 출력하는 메서드 ---");
		m.printMap(map);
//		m.printMap(m.makeMap2());
		
		
	}

	// map을 매개변수로 받는 케이스
	public void makeMap(HashMap<String, Integer>map) {
		map.put("가위", 3000);
		map.put("크레파스", 4000);
		map.put("물감", 5000);
	}
	
	// map을 내부에서 생성하여 리턴하는 케이스
	public HashMap<String, Integer> makeMap2() {
		HashMap<String, Integer>map = new HashMap<>();
		map.put("가위",4000);
		map.put("크레파스", 5000);
		map.put("물감", 6000);
		return map;
	}
	
	// map을 받아서 출력하는 메서드
	public void printMap(HashMap<String, Integer>map2) {
		map2.put("가위", 5000);
		map2.put("크레파스", 6000);
		map2.put("물감", 7000);
		int sum = 0;
		for (String s : map2.keySet()) {
			sum += map2.get(s);
			System.out.println(s+":"+map2.get(s));
		}
		System.out.println("총합: "+sum);
	}
}
