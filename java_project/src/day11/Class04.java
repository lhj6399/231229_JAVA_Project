package day11;

public class Class04 {

	public static void main(String[] args) {
		/* Tv 클래스 생성
		 * 멤버변수 : brand, power, ch, vol
		 * 
		 * 메서드 -
		 * power()
		 * power가 켜지면 "Tv가 켜졌습니다." 꺼지면 "Tv가 꺼졌습니다."
		 * 
		 * chUp() : 1씩 증가. ch은 20까지 있음. 20이 넘어가면 다시 1번으로 순환구조
		 * chDown() : 1씩 감소. Up처럼 순환구조
		 * 
		 * volUp() / volDown() : 1씩 증가 / 1씩 감소
		 * vol은 10까지 있음. 10이 넘어가면 10, 0이면 음소거라고 출력 
		 * 
		 * 
		 * getter / setter		 
		 * 
		 */
		Tv c = new Tv();
		c.setBrand("LG");
		c.print();
		c.power();
		c.power();
		c.power();
		c.chUp();
		c.chUp();
		c.chUp();
		c.chUp();
		c.chUp();
		c.chUp();
		c.chUp();
		c.chUp();
		c.chUp();
		c.chUp();
		c.chUp();
		c.chUp();
		c.chUp();
		c.chUp();
		c.chUp();
		c.chUp();
		c.chUp();
		c.chUp();
		c.chUp();
		c.chUp();
		c.chUp();
		c.chUp();
		c.chUp();
		c.power();
		c.power();
		c.chDown();
		c.chDown();
		c.chDown();
		c.chDown();
		c.chDown();
		c.chDown();
		c.chDown();
		c.volUp();
		c.volUp();
		c.volUp();
		c.volUp();
		c.volUp();
		c.volUp();
		c.volUp();
		c.volUp();
		c.volUp();
		c.volUp();
		c.volUp();
		c.volUp();
		c.volDown();
		c.volDown();
		c.volDown();
		c.volDown();
		c.volDown();
		c.volDown();
		c.volDown();
		c.volDown();
		c.volDown();
		c.volDown();
		c.volDown();
		c.volDown();
		c.volDown();
		c.volDown();
		
	}

}
class Tv{
	private String brand;
	private boolean power;
	private int ch;
	private int vol;
	
	public void power() {
		this.power = !power;
		if(this.power) {
			System.out.println("Tv가 켜졌습니다.");
		} else if(!power) {
			System.out.println("Tv가 꺼졌습니다. Tv를 켜주세요");
		}
	}
	
	// chUp
	public void chUp(){
		if (power) {
		if (ch>19) {
			ch = 1;
		} else {
			ch++;
		} System.out.println("현재 채널 번호는 : "+ch+"번 입니다.");
		}
		if(!power) {
			System.out.println("전원이 꺼져있습니다. 전원을 켜 주세요.");
		}
	}
	
	// chDown
	public void chDown(){
		if (power) {
		if (ch<=1) {
			ch = 20;
		} else {
			ch--;
		} System.out.println("현재 채널 번호는 : "+ch+"번 입니다.");
		} if (!power) {
			System.out.println("전원이 꺼져있습니다. 전원을 켜 주세요.");
		}
	}
	
	//volUp
	public void volUp() {
		if (power) {
		if (vol<10) {
			vol++;
		} System.out.println("현재 볼륨은 : "+vol+"입니다.");
		} if(!power) {
			System.out.println("전원이 꺼져있습니다. 전원을 켜 주세요.");
			}
		}

	
	//volDown
	public void volDown() {
		if (power) {
		if (vol>0) {
			vol--;
			System.out.println("현재 볼륨은 : "+vol+"입니다.");
		} else if (vol == 0) {
			System.out.println("음소거");
			}
		} if (!power) {
			System.out.println("전원이 꺼져있습니다. 전원을 켜 주세요.");
		}
	}
	
	// print
	public void print() {
		System.out.println("Tv 브랜드 : "+brand);
	}
	
	// getter, setter
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public boolean isPower() {
		return power;
	}

	public void setPower(boolean power) {
		this.power = power;
	}

	public int getCh() {
		return ch;
	}

	public void setCh(int ch) {
		this.ch = ch;
	}

	public int getVol() {
		return vol;
	}

	public void setVol(int vol) {
		this.vol = vol;
	}
}