package day10;

public class Class03 {

	public static void main(String[] args) {
		Car1 c = new Car1(); //Car1 클래스를 통해 c객체를 생성. new 키워드를 통해 생성. Car1() 생성자에 의해 초기화된다.
		c.setName("붕붕이");
		c.setColor("노란색");
		c.setYear("2024");
		c.setdoor(2);
		c.printInfo();
		c.power();
		c.speedUp();
		c.speedUp();
		c.speedUp();
		c.speedUp();
		System.out.println("my Car Speed : "+c.getSpeed());
		c.speedDown();
		c.speedDown();
		c.speedDown();
		c.speedDown();
		System.out.println("my Car Speed : "+c.getSpeed());
		
	}
}
// 같은 패키지에서 같은 이름의 클래스를 사용하면 error
class Car1{
	// 멤버변수 : name, year, color, door(문짝 개수), power, speed,
	private String name;
	private String year;
	private String color;
	private int door;
	private boolean power;
	private int speed;
	
	// 생성자 위치
	public Car1() {
		// 기본 생성자
	}
	// 생성자는 여러개 만들 수 있음. (생성자 오버로딩)
	// 오버로딩 조건 : 매개변수의 개수가 달라야함. (개수가 같다면) 타입이 달라야함.
	public Car1(String name, String year, String color, int door) {
		this.name = name;
		this.year = year;
		this.color = color;
		this.door = door;
	}

	
	
	// 내 차량의 정보를 출력하는 메서드(name, year, color, door)
	public void printInfo() {
		System.out.println("myCar: "+name+" / "+color+" ("+year+") "+"문짝 "+door+"개");
	}
	
	// power()
	// 시동이 켜졌습니다. / 시동이 꺼졌습니다.
	public void power() {
		this.power = !power;
		if(this.power) {
			System.out.println("시동이 켜졌습니다.");
		} else if(power && speed >0) {
			System.out.println("주행중입니다.");
		} else if(!power && speed >0) {
			System.out.println("주행중에 시동을 끌 수 없습니다.");
		} else {
			System.out.println("시동을 끕니다.");
			this.power = false;
		}
	}
	
	// speedUP / speedDown의 기본조건은 power가 켜져야 가능.
	// 시동이 꺼져있는 상태라면, 시동이 꺼져있습니다. 시동을 켜주세요. 출력
	// speedUp
	// 300 이상이면 최고속도입니다. 라고 출력
	// 속도를 올릴때마다 현재 속도를 출력
	public void speedUp() {
		if (power) {
		if (speed>=300) {
			System.out.println("최고속도입니다.");
		} else {
			speed+=100;
			System.out.println("현재속도 : "+speed);
			}
		}
		if (!power) { //else만으로도 가능
			System.out.println("시동이 꺼져있습니다. 시동을 켜주세요.");
		}
	}
	
	// speedDown
	// 속도가 0이되면 더이상 내려가지 않음. (멈췄습니다.)
	// 속도를 내릴때마다, 현재속도가 얼마인지 출력
	public void speedDown() {
		if (speed<=0) {
			speed=0;
			System.out.println("멈췄습니다.");
		} else {
		speed-=100;
		System.out.println("현재속도 : "+speed);
		}
	}
	// getter / setter

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		public String getYear() {
			return year;
		}

		public void setYear(String year) {
			this.year = year;
		}

		public boolean isPower() {
			return power;
		}

		public void setPower(boolean power) {
			this.power = power;
		}

		public int getSpeed() {
			return speed;
		}

		public void setSpeed(int speed) {
			this.speed = speed;
		}
		
		public String getdoor() {
			return name;
		}

		public void setdoor(int door) {
			this.door = door;
		}
		
		
	}