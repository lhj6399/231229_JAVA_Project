package day13;
// Product 클래스 생성 : 상품을 등록하는 클래스
// 상품명, 가격을 멤버변수로 하는 클래스 생성
// 상품 추가 메서드
// 추가한 상품을 출력하는 메서드 (toString으로 생성 가능.)

import java.util.Scanner;

public class 과제 {

	public static void main(String[] args) {
		// 상품을 10개 등록 가능한 배열 생성
		// 스캐너를 이용하여 상품을 등록받기
		// 등록한 상품 출력
		Scanner scan = new Scanner(System.in);
		
		// product 클래스를 담을 수 있는 배열 10칸 준비
		Product menu [] = new Product[10];
		
		// 상품을 등록하시겠습니까(Y/N)? Y=>등록 / N=>그만
		// N을 누르면 등록한 상품 출력
		
		char c ='y'; // 반복 키워드
		int cnt = 0;
		
		
		while (c != 'n') { // !(c.equals("n") => String 일 경우 어려워 짐
			System.out.println("상품을 등록하시겠습니까? (y/n)");
			c=scan.next().charAt(0);
			if (c == 'y') {
				System.out.println("상품명: ");
				String name = scan.next();
				System.out.println("가격: ");
				int price = scan.nextInt();
				
				// 객체 생성
				Product p = new Product(name,price); // 배열에 들어가려면 스캔에서 생성 후 넣어야 함.
				menu[cnt] = p;
				cnt++;
			} else {
				if (c == 'n') {
					System.out.println("상품 등록 종료");
				} else {
					System.out.println("y/n만 가능합니다.");
				}
			}
		}
		System.out.println("등록된 상품 리스트 출력");
		
		Product p = new Product("pizza", 15000);
		menu[cnt] = p;
		cnt++;
		
		Product p1 = new Product();
		p1.insertProduct("juice", 2000);
		menu[cnt] = p1;
		cnt++;
		
		for(int i=0; i<cnt; i++) { // toString 사용할 경우
			System.out.println(menu[i]);
		}
		// 출력 메서드가 있는 경우
		// menu[i].print();
		
		scan.close();
		}
	
	}

class Product {
	private String name; // 상품명
	private int price; // 가격
	
	// 생성자
	public Product() { 
		
	}
	
	public Product (String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	// 메서드
	public void insertProduct(String name, int price) {
		this.name = name;
		this.price = price;
	}

	// getter / setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "name: " + name + ", price: " + price;
	}
	
}