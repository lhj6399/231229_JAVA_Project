package oop;
/* CardPack 클래스
 * - ♥1 ~ ♥K / ◆1 ~ ◆K /  ♣1 ~ ♣K / ♠1 ~ ♠K
 * - 총 카드 수 52장
 * - 52장의 카드 한 묶음 (배열)
 * 
 * - 카드 출력 기능 => Card Class. print()  사용
 * - 카드 초기화 기능 (CardPack 생성자)
 * - 카드 한 장을 빼내는 기능 => 출력. print() 사용
 * - 카드 섞는 기능
 */


public class CardPack2 {
	// int arr[] = new int[52]; // int 배열 안에 들어가는 자료의 형태
	// 카드 52장이 들어갈 수 있는 배열을 생성
	private Card2[] pack = new Card2[52];
	private int cnt = 0; // 카드 배열의 index위치를 체크하기 위한 변수
	
	public CardPack2() {
		// CardPack 클래스를 생성하면 52장의 카드가 생성되어야 함.
		// - 숫자 : 2 ~ 10, J(11), Q(12), K(13)
		// - 모양 : ♥, ◆, ♣, ♠
		char shape = '♥';
		for (int i=1; i<=4; i++) { // 4가지 모양을 넣기 위한 for문
				switch (i) {
				case 1 : shape = '♥'; break;
				case 2 : shape = '◆'; break;
				case 3 : shape = '♣'; break;
				case 4 : shape = '♠'; break;
				}
				for(int j=1; j<=13; j++) { // 13까지 숫자를 넣기 위한 for문
					Card2 c = new Card2(); // 새 카드 1장을 생성
					c.setShape(shape);
					c.setNum(j);
					pack[cnt] = c;
					cnt++; // 52
			}
		}
		
	}
	
	//초기화하는 기능
	public void init() {
		cnt = 52;
	}

	public Card2[] getPack() {
		return pack;
	}

	public void setPack(Card2[] pack) {
		this.pack = pack;
	}
	
}
