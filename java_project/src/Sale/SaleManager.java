package Sale;

import java.util.ArrayList;
import java.util.Scanner;

public class SaleManager {
	// 메뉴를 저장하기 위한 list
	private ArrayList<Sale<String, Integer>> menu = new ArrayList<>();
	// 주문을 저장하기 위한 list
	private ArrayList<Order> order = new ArrayList<>();

	// 기본 메뉴 구성
	public void addMenu() {
		menu.add(new Sale("사과", 2000));
		menu.add(new Sale("키위", 3000));
		menu.add(new Sale("자몽", 5000));
		menu.add(new Sale("딸기", 2500));
	}
	
	public void add(Scanner scan) {
		// 메뉴 추가
			System.out.println("메뉴명 >");
			String menu = scan.next();
			System.out.println("가격 >");
			int price = scan.nextInt();
			this.menu.add(new Sale<String, Integer>(menu,price));
			System.out.println("메뉴 추가 완료");
		
	}


	public void update(Scanner scan) {
		// 메뉴 수정
		// list.set(index,object) : 해당 번지의 객체를 변경
		System.out.println("수정할 메뉴 입력 >");
		String upMenu = scan.next();
		System.out.println("수정할 가격 입력 >");
		int upPrice = scan.nextInt();
		
		for (int i=0; i<menu.size(); i++) {
			if (menu.get(i).getMenu().equals(upMenu)) {
				menu.set(i,new Sale(upMenu, upPrice)); // 객체를 새로 만들어서 해당 번지에 set
//				menu.get(i).setPrice(upPrice); //해당 객체의 가격만 수정
				System.out.println("수정 완료");
			}
		}
	}

	public void delete(Scanner scan) {
		System.out.println("삭제할 메뉴 >");
		String delMenu = scan.next();
		for (int i=0; i<menu.size(); i++) {
			if(menu.get(i).getMenu().equals(delMenu)) {
				// list.remove(index) => 번지수 지우기 / list.remove(Object) => 객체 지우기
//				menu.remove(i); // i번지의 객체 삭제
				menu.remove(menu.get(i)); // Object로 객체 삭제  
				System.out.println("삭제 완료.");
				return;
			}
		}
		System.out.println("삭제할 메뉴가 없습니다.");
		
//			int cnt = 0;
//			boolean result = menu.remove(new Sale<String, Integer>(menu1));
//			for (int i=0; i<menu.size(); i++) {
//				cnt++;
//			if (!result || cnt ==0 ) {
//				System.out.println("삭제할 메뉴가 없습니다.");
//				return;
//			}
//			}
//			System.out.println("메뉴 삭제 완료"); // 안됨..
	}
	
	
	public void printSale() {
		// 메뉴 출력
		System.out.println("------ menu ------");
		for(Sale s : menu) {
			System.out.println(s);
		}
		System.out.println("------------------");
	}

	public void orderPick(String name, int count) {
		for (int i=0; i<menu.size(); i++) {
			if (menu.get(i).getMenu().equals(name)) {
				// 내가 주문한 메뉴의 가격
				int price = menu.get(i).getPrice();
				// order의 데이터가 없다면 비교 자체가 불가
//				if(order.size()>0) {
//					for(int j=0; j<order.size(); j++) {
//						if()
//					}
//				}
				// 주문한 같은 메뉴가 없으면 -1 있으면 해당 번지
				int index = orderSearch(name);
				if (index != -1) { // 해당 메뉴가 있다면
					// 기존 값에서 count + / total +
					int cnt = order.get(index).getCount(); // 기존 주문 수량
					int tot = order.get(index).getTotal(); // 기존 주문 금액
					order.get(index).setCount(count+cnt); // 주문수량 + 기존수량
					order.get(index).setTotal(tot+(price*count)); // 주문수량 + 기존수량
					System.out.println("주문 추가 완료");
				}
				Order o = new Order(name,price,count);
				order.add(o);
				System.out.println("주문 추가 완료");
				return;
			}
		}
		
	}
	
	public int orderSearch(String name) {
		int index = -1;
		for(int i=0; i<order.size(); i++) {
			if (order.get(i).getMenu().equals(name)) {
				index = i;
				return index;
			}
		}
		return index; // 해당 메뉴가 없다면 -1리턴
	}

	public void orderPrint() {
		// 주문 출력
		int sum = 0;
		System.out.println("-------------- 영수증 ----------------");
		for (Order o : order) {
			sum += o.getTotal();
			o.print();
			}
		System.out.println("-------------------------------------");
		System.out.println("총 지불금액: "+sum);
		
	}
	

}
