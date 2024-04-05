package day19;

import java.util.ArrayList;
import java.util.Scanner;

public class SaleManager {
	// 제네릭 클래스 처리
	private ArrayList<Sale<String, Integer>> menu = new ArrayList<>();
	private ArrayList<Sale<String, Integer>> order = new ArrayList<>();
	
	public void add(Scanner scan) {
		// 제품 추가
		System.out.println("제품명 >");
		String menu = scan.next();
		System.out.println("가격 >");
		int price = scan.nextInt();
		Sale<String, Integer> s = new Sale<String, Integer>(menu,price);
		this.menu.add(s);
		System.out.println("제품 추가 완료");
	}

	public void menuPrint() {
		// 제품 리스트 보기
		for (Sale<String, Integer> tmp: menu)
		System.out.println(tmp);
	}

	public void orderPick(String name, int count) {
		// 입력받는 값은 제품명, 수량
		// 제품명 가격*수량(지불금액)을 order에 추가
		// 햄버거 5 => 햄버거 25000
		// name = 주문 음식, count = 수량
		for(int i=0; i<menu.size(); i++) {
			String ProductMenu = menu.get(i).getMenu();
			int ProductPrice = menu.get(i).getPrice();
			if(ProductMenu.equals(name)) {
				int index = orderSearch(name);
				if(index != -1) { // order에 같은 제품이 있다면...
					int price = order.get(index).getPrice();
					order.get(index).setPrice(price+(ProductPrice*count));
					return;
				}
				// 한번도 주문한적 없는 메뉴인 경우
				Sale p = new Sale(ProductMenu,(ProductPrice*count));
				order.add(p);
			}
		}
	}
	
	public int orderSearch(String name) {
		// name = 주문 메뉴
		int index = -1;
		for(int i=0; i<order.size(); i++) {
			if (order.get(i).getMenu().equals(name)) {
				index = i;
				System.out.println(index);
				return index;
			}
		}
		return index;
	}
	
	public void orderPrint() {
		// 주문내역 출력
		// 총 지불금액 출력
		int sum = 0;
		for(Sale<String, Integer>tmp : order) {
			System.out.println(tmp);
			sum +=tmp.getPrice();
		}
		System.out.println("총 지불금액"+sum);
			
	}
	
}
