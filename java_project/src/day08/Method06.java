package day08;

public class Method06 {

	public static void main(String[] args) {
		
		int arr[] = new int[] {1, 3, 2, 4, 5, 8, 7, 6, 9, 11, 10, 13, 12 };
		printArray(arr);
		System.out.println();
		System.out.println("---정렬 후---");
		sortArray(arr);
		printArray(arr);
		System.out.println();
		System.out.println("--배열 리턴 후 출력--");
//		int arr1[] = sortArray1(arr);
		printArray(sortArray1(arr));
		System.out.println();
		System.out.println("--randomArray 출력--");
		printArray(sortArray1(randomArray()));
		
		
	}

	/* 주어진 정수 배열을 콘솔에 출력하는 메서드 
	 * 매개변수 : 배열
	 * 리턴타입 : 출력 => void
	 * 메서드명 : printArray
	 * 5개씩 한줄에 나열
	 */
	
	public static void printArray(int arr[]) {
		
		for(int i=0; i<arr.length; i++) { 
			if(i%5==0 && i!=0) {
				System.out.println();
			}
			System.out.print(arr[i]+" ");
		}
		
	}
	
	/* 배열이 주어지면 배열을 오름차순 정렬하는 기능
	 * 매개변수 : 배열
	 * 리턴타입 : 없음. => void
	 * 매서드명 : sortArray
	 */
	
	public static void sortArray(int arr[]) {
		for(int i=0; i<arr.length-1; i++) { 
			for(int j=i+1; j<arr.length; j++) {
				if(arr[i] > arr[j]) { 
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
	}
	
	//정렬 후 배열을 리턴
	public static int[] sortArray1(int arr[]) { //배열을 받아서 배열을 리턴
		for(int i=0; i<arr.length-1; i++) { 
			for(int j=i+1; j<arr.length; j++) {
				if(arr[i] > arr[j]) { 
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
		return arr;
	}
	
	/* randomArray
	 * 배열을 생성하여 (10개) 랜덤값(1~50까지)을 채우고 해당 배열을 리턴
	 * 매개변수 : X
	 * 리턴타입 : 배열
	 */
	public static int[] randomArray() {
		int arr[] = new int[10];
		for (int i=0; i<arr.length; i++) {
			arr[i] = (int)(Math.random()*50)+1;
		}
		return arr;
	}

		
}

