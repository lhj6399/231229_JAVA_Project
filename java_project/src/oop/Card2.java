package oop;

public class Card2 {
	private int num;
	private char shape;
	
	// print
	public void print() {
		System.out.print(shape);
		switch (num) {
		case 1:
			System.out.print("A ");
			break;
		case 11:
			System.out.print("J ");
			break;
		case 12:
			System.out.print("Q ");
			break;
		case 13:
			System.out.print("K ");
			break;
		default :
			System.out.print(num+" ");
			break;
			
		}
	}
	
	//생성자
	public Card2() {
		this.num = 1;
		this.shape = '♥';
	}
	
	// getter / setter
	public int getNum() {
		return num;
	}
	
	//외부의 값(매개 변수)으로 내부 변수(멤버 변수)를 변경할 때 사용하는 메서드
	public void setNum(int num) {
		// 1 ~ 13까지만 내 숫자, 그 외는 1로 설정
		if (num<1 || num >13) {
			this.num = 1;
		} else {
		this.num = num;
		}
	}
	
	public char getShape() {
		return shape;
	}
	
	public void setShape(char shape) {
		// ♥, ◆, ♣, ♠ 아닌 나머지 모양은 ♥
		switch(shape) {
		case '♥': case '◆' : case '♣' : case '♠' :
			this.shape = shape;
			break;
			default:
				this.shape = '♥';
		}
	}
	public static void main(String[] args) {
		
		CardPack2 cp = new CardPack2(); // 52장의 카드가 모두 생성됨.
		
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
	}

}
