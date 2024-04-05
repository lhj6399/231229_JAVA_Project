package day11;

public class Ex {

	public static void main(String[] args) {
//		Card c = new Card();
//		c.setNum(13);
//		c.setShape('@');
//		c.print();
		
		CardPack cp = new CardPack(); // 52장의 카드가 모두 생성됨.
		
		cp.shuffle(); // 셔플 없으면 순서대로 생성
		
		int cnt = 0;
		for (int i=0; i<4; i++) {
			for (int j=0; j<13; j++) {
				cp.getPack()[cnt].print(); {
					// cp.getPack() : CardPack 클래스 안에 있는 pack[]
					// cp.getPack()[cnt] : pack[0] => Card (멤버변수, 메서드)
					cnt++;
				}
			}
			System.out.println();
		}
		System.out.println("-----------------------------------");
		cp.pick().print();
		cp.pick().print();
		cp.pick().print();
		cp.pick().print();
	}

}
