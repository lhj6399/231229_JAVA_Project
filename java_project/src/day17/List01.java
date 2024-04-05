package day17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class List01 {

	public static void main(String[] args) {
		/* 하루 일과를 저장하는 list를 생성
		 * 출력 for / 향상된 for / Iterator 출력
		 * import 단축키 : Ctrl + Shift + o
		 */
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("밥");
		list.add("운동");
		list.add("학원");
		list.add("잠");
		
		System.out.println(">> for문 출력");
		for (int i=0; i<list.size(); i++) {
			System.out.print(list.get(i)+" ");
		}

		System.out.println();
		System.out.println(">> 향상된 for문 출력");
		for (String s : list) {
			System.out.print(s+" ");
		}
		
		System.out.println();
		System.out.println(">> Iterator 출력");
		Iterator<String> it = list.iterator();
		while(it.hasNext()) { // hasNext() 다음 요소가 있는지 체크 true / false
			String tmp = it.next(); // next()는 다음요소 가져오기
			System.out.print(tmp+" ");
		}
		System.out.println();
		
		// 정렬
		Collections.sort(list);
		System.out.println(list);
		
		list.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// 숫자는(크다/작다를 이용) - / +의 값이 출력
				// 문자는 compareTo 메서드를 활용하여 정렬
				// o1.compareTo(o2); 오름차순
				return o2.compareTo(o1); // 내림차순
			}
			
		});
		System.out.println(list);
		

	}

}
