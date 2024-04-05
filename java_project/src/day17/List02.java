package day17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class List02 {

	public static void main(String[] args) {
		/* 두 배열을 입력받아서 하나로 합치는 ArrayList 생성
		 * 정렬하여 출력
		 */
		String arr1[] = new String[] {"a", "c", "f", "b"};
		String arr2[] = new String[] {"d", "g", "h", "e"};
		
		// 합치기 => 정렬
		ArrayList<String> list = new ArrayList<String>();
		
		int cnt = arr1.length + arr2.length;
		int i = 0;
		int j = 0;
		
		while (cnt>list.size()) {
			if (i<arr1.length) {
				list.add(arr1[i]);
				i++;
			} if (j<arr2.length) {
				list.add(arr2[j]);
				j++;
			}
		}
	System.out.println(list);
	Collections.sort(list);
	System.out.println("--- 오름차순 정렬 후 ---");
	System.out.println(list);
	
	list.sort(new Comparator<String>() {

		@Override
		public int compare(String o1, String o2) {
			
			return o2.compareTo(o1);
		}
	});
	System.out.println("--- 내림차순 정렬 후 ---");
	System.out.println(list);
	}

}
