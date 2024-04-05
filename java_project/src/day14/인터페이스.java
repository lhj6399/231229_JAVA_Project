package day14;

public class 인터페이스 {

	public static void main(String[] args) {
		/* 인터페이스 : 추상메서드와 상수(final)로만 이루어진 것
		 * 추상 메서드 : 메서드의 선언부만 있고, 구현부가 없는 메서드
		 * 
		 * 추상 클래스 / 인터페이스 => 반드시 구현을 해야 객체를 생성할 수 있음.
		 * 
		 * 인터페이스 키워드 : interface
		 * - 기능 요약서 : 메뉴얼 화
		 * - 자체적으로 사용할 수 없고, 인터페이스를 구현한 클래스로 활용
		 * - 구현 키워드 : implements
		 * - 인터페이스는 멤버변수가 없음. 이 부분을 염두에 두고 메서드 정리가 필요함.
		 * 
		 * - 상속 : 다중 상속 불가능.
		 * - 구현 : 다중 구현 가능.
		 * - 상속 + 구현은 동시에 가능.
		 */
		TV t = new TV();
		t.turnOn();
		t.chUp();
		t.chUp();
		t.chUp();
		t.chUp();
		t.chDown();
		t.turnOff();
		t.chUp();
		t.turnOn();
		t.volUp();
		t.volUp();
		t.volDown();
	}

}

interface Power {
	void turnOn();
	void turnOff();
}

interface Remocon {
	void volUp();
	void volDown();
}

// 인터페이스 구현
class TV implements Power, Remocon{ // 인터페이스를 구현한 클래스 / 다중 구현
// class Tv extends A implements B {  } // 부모 클래스가 있으면 이런 식으로도 가능 (상속과 구현을 하는 케이스)
	
	private boolean power;
	private int ch;
	private int vol;
	
	@Override
	public void turnOn() { // 전원 켜기
		power = true;
		System.out.println("전원이 켜졌습니다.");
		
	}

	@Override
	public void turnOff() { // 전원 끄기
		power = false;
		System.out.println("전원이 꺼졌습니다.");
	}

	public void chUp() {
		if (power) {
			ch++;
			System.out.println("ch: "+ch);
		}
	}
	
	public void chDown() {
		if (power) {
			ch--;
			System.out.println("ch: "+ch);
		}
	}

	@Override
	public void volUp() {
		if(power) {
			vol++;
			System.out.println("vol: "+vol);
		}
	}

	@Override
	public void volDown() {
		if(power) {
			vol--;
			System.out.println("vol: "+vol);
		}
		
	}
	
}


