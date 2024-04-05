package day13;

class Animal {
	private String name; // 이름
	private String caterogy; // 종
	
	public Animal() {}
	
	// 출력 메서드
	public void printInfo() {
		System.out.println("이름: "+name);
		System.out.println("종류: "+caterogy);
		}
		
	// 울음소리 메서드
	public void howl() {
		System.out.println(name+"의 울음소리 : ");
		}
	
	public Animal(String name, String caterogy) {
		this.name = name;
		this.caterogy = caterogy;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCaterogy() {
		return caterogy;
	}

	public void setCaterogy(String caterogy) {
		this.caterogy = caterogy;
	}

	
}
// Dog Cat Animal 클래스
// printInfo()
// howl() 오버라이드 후 출력
class Dog extends Animal{
	public Dog() {
		// 자식의 생성자에서 상속받은 멤버변수를 setting
		setName("뽀삐");
		setCaterogy("개과");
	}
	@Override
	public void howl() {
		super.howl();
		System.out.println("멍멍");
	}
}


class Cat extends Animal{
	public Cat(String name, String Caterogy) {
		super.setName(name);
		super.setCaterogy(Caterogy);
	}
	
	public void howl() {
		super.howl();
		System.out.println("야옹");
	}
	
}

class Tiger extends Animal{
	public Tiger(String name, String caterogy) {
		// super 생성자 호출
		super(name,caterogy);
	}
	
	public void howl() {
		super.howl();
		System.out.println("어흥");
	}
}
public class 상속02 {

	public static void main(String[] args) {
		/* 오버라이딩 : 부모 클래스에게서 물려받은 메서드를 재정의하는 것.
		 * - 부모 클래스의 메서드와 선언부가 일치해야 한다.
		 * - 접근제한자도 더 넓은 범위는 가능하지만, 축소는 안됨.
		 * 
		 */
		Dog d = new Dog();
		d.printInfo();
		d.howl();
		
		System.out.println();
		
		Cat c = new Cat("나비","고양이과");
		c.printInfo();
		c.howl();
		
		System.out.println();
		
		Tiger t = new Tiger("호랭이","고양이과");
		t.printInfo();
		t.howl();
	}

}

