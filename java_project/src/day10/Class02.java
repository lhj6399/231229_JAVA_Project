package day10;

public class Class02 {

	public static void main(String[] args) {
		Car c = new Car();
		c.setName("붕붕이");
		c.setColor("노란색");
		c.setYear("2024");
		c.print();
		c.power();
		System.out.println("my Car Power : "+(c.isPower()? "ON":"OFF"));
		c.power();
		System.out.println("my Car Power : "+(c.isPower()? "ON":"OFF"));
		c.speedUp();
		c.speedUp();
		c.speedUp();
		System.out.println("my Car Speed : "+c.getSpeed());
		c.speedDown();
		c.speedDown();
		c.speedDown();
		System.out.println("my Car Speed : "+c.getSpeed());
		
		
		Car c2 = new Car();
		c.setName("빵빵이");
		c.setColor("파란색");
		c.setYear("2020");
		c.print();
		c2.power();
		System.out.println("my Car2 Power : "+(c2.isPower()? "ON":"OFF"));
		c2.speedUp();
		c2.speedUp();
		c2.speedUp();
		c2.speedUp();
		c2.speedUp();
		System.out.println("my Car2 Speed : "+c2.getSpeed());
		c2.speedDown();
		c2.speedDown();
		c2.speedDown();
		c2.speedDown();
		c2.speedDown();
		c2.speedDown();
		System.out.println("my Car2 Speed : "+c2.getSpeed());
		
	}

}
class Car{ // 클래스명은 대문자로 시작 
	// 멤버변수 = private
	// 메서드 = public => getter/setter 메서드
	
	private String name;
	private String color;
	private String year;
	private boolean power;
	private int speed;
	
	// power()
	// 꺼져있을 경우 => 켜짐 (시동)
	// 켜져있을 경우 => 꺼짐
	public void power() {
		power = !power;
	}
	
	// speedUp()
	public void speedUp() {
		while(speed<300) {
			speed+=10;
			System.out.println("현재속도 : "+speed);
			
		break;
			}
	}
	
	// speedDown()
	public void speedDown() {
		if (speed<=0) {
			speed=0;
		} else {
		speed-=10;
		}
	}
	
	// print()
	public void print() {
		System.out.println("myCar: "+name+"/"+color+"("+year+")");
	}

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
	
	
}
