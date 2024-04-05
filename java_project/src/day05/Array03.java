package day05;

public class Array03 {

	public static void main(String[] args) {
		//과제 => 카페에 제출
		int arr[] = new int[] {10,56,78,89,48,62,93,50};
		/* arr배열의 합계와 평균을 출력
		 * 최대값 / 최소값 출력
		 */
		
		int i = 0;
		int sum = 0;
		double avg = 0;
		//성적 데이터(0 ~ 100점)
		int max = arr[0]; //가장 큰 값을 넣기 위한 변수
		int min = arr[0]; //가장 작은 값을 넣기 위한 변수
		
		for (i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
			sum = sum+arr[i];
		}
		avg = sum / (double)arr.length;
		System.out.println();
		System.out.println("합계:"+sum);
		System.out.println("평균:"+sum/(double)arr.length);
		
		for(i=0;i<arr.length;i++) {
		    if(max<arr[i]) {
			max = arr[i];
		    }
		    if(min>arr[i]) {
			min = arr[i];
		    }
		    
		    max = Math.max(max, arr[i]);
		    min = Math.min(min, arr[i]);
		}
		System.out.print("최대값:"+max+" ");
		System.out.print("최소값:"+min+" ");
	
		System.out.println();
		System.out.println("Math.max를 사용한 최대값: "+max);
		System.out.println("Math.min을 사용한 최소값: "+min);
	}
}
