package day08;

public class Method07 {

	public static void main(String[] args) {
		/* 로또 번호 생성
		 */
		int lotto[] = new int[7]; //당첨번호
		int user[] = new int[6]; //사용자 로또 번호
		
		randomArray(lotto); //로또번호 채우기
		randomArray(user); //사용자 번호 채우기
		System.out.println("--당첨번호--");
		printArray(lotto);
		System.out.println("--사용자 번호--");
		printArray(user);
		System.out.println();
		int rank = lottoRank(lotto, user);
		if (rank == -1) {
			System.out.println("꽝입니다.");
		} else {
			System.out.println(rank+"등 당첨입니다.");
		}
	}
	
	/* 배열을 매개변수로 받아 1 ~ 45까지 랜덤수를 채워서 생성. (중복 불가능)
	 * 매개변수 : 배열 => int arr[]
	 * random == arr[i] false면 추가
	 */
	
	public static void randomArray(int arr[]) { 
		// 배열을 받아서 배열에 랜덤 값 중복없이 채우기
		int cnt = 0; //while에서 i 역할을 할 변수
		while (cnt < arr.length) {
			int r = (int)(Math.random()*9)+1;
			if(!isContain(arr,r)) {
				arr[cnt] = r;
				cnt++;
			}
		}
		
	}
	
	
	/* 배열을 매개변수로 받아 배열을 출력하는 메서드
	 * 마지막(보너스) 번호에는 [ ] 넣기
	 */
	
	public static void printArray (int arr[]) {
		for (int i=0; i<arr.length; i++){
			if(arr.length == 7) { //lotto배열
				for(i=0; i<=6; i++) {
					if (i != 6) {
						System.out.print(arr[i]+" ");
					}
					else if(i == 6) {
						System.out.print("["+arr[i]+"]");
					}
				}
			}
			else if (arr.length != 7) {
				System.out.print(arr[i]+" ");
			}
		}
		System.out.println();
	}
	
	/* 중복 확인 메서드
	 * 매개변수 : 배열, 값
	 * 있으면 true, 없으면 false
	 * 리턴 타입 : boolean
	 * 메서드명 : inContain
	 */
	
	public static boolean isContain (int arr[], int random) {
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == random) {
				return true;
			}
		}
		
		return false;
	}
	
	/* 등수 확인 메서드
	 * 매개변수 : lotto[] / user[]
	 * 리턴타입 : int
	 * 메서드명 : lottoRank
	 * --당첨 기준--
	 * user 번호 기준으로
	 * 6개 일치 : 1등
	 * 5개 일치 + 보너스 번호 : 2등
	 * 5개 일치 : 3등
	 * 4개 일치 : 4등
	 * 3개 일치 : 5등
	 * 나머지는 꽝
	 * 
	 */
	
	public static int lottoRank(int lotto[],int user[]) {
		// lotto = 7개 / user = 6개
		// lotto / user 개수가 다르기 때문에 배열이 바뀌어서 들어온다면...
		if(lotto.length <= user.length) {
			return -1;
		
		}
	
		int cnt = 0; // 일치하는 개수를 세기 위한 변수 (보너스는 제외)
		for(int i=0; i<user.length; i++) { // 보너스를 제외시키기 위해
			if(isContain(user, lotto[i])) {
				cnt++;
			}
		}
		
		switch(cnt) {
		case 6: return 1;
		case 5: 
			if(isContain(user, lotto[lotto.length-1])) {
				return 2;
			} else {
				return 3;
			}
		case 4: return 4;
		case 3: return 5;
		default:
			return -1;
				
		
		}	
	}
}
