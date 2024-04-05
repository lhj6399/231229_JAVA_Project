package EzenToto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class 경마 {
	
	
	JoinMembership user = LoginManager.loginUser;	//로그인유저 데이터 값 사용
	
	private int horse; // 말
	private int price; // 금액
	private double dividend; // 배당
	public int money = 0; // 돈
	public double money1 = 0; // 투입금액에 배당을 곱하고 투입금액을 뺀 값. 실질적으로 얻는 이득
	
	// 말 리스트
	private ArrayList<경마> list = new ArrayList<경마>();
	
	//date
			LocalDateTime today = LocalDateTime.now();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd  hh:mm:ss");
		
			
	// 생성자
	public 경마() { // 기본 생성자
		
	}
	
	public 경마(int horse, int price, double dividend) {
		this.horse = horse;
		this.price = price;
		this.dividend = dividend;
	}
	
	// 말 선택 메서드
	public void add(Scanner scan) {
		int menu = 0;
		do {
			System.out.println("\r\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⠀⠀⠀⣠⣤⣄⢀⣠⣤⣶⣶⣶⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣿⣿⣿⣷⣤⠀⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⠀⠀⣀⣤⣶⣾⣿⣿⣿⣿⣿⣿⣿⣷⡌⠉⠉⠉⢿⣿⣿⣿⣿⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⠀⠀⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠿⠿⠿⣿⣿⣿⠏⣀⣀⣀⣀⣀⡀⢀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⠀⠀⠈⠉⠁⠀⠀⠀⠀⢹⣿⣿⣿⣿⣿⣿⡄⠀⠀⠹⣿⣷⡀⢻⣿⡿⠿⣿⣿⡌⢿⣿⣿⣆⣠⣤⣤⣤⣤⣤⣀⣀⣀⣀⣀⡄⠀⠀\r\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⡿⠿⠛⣉⣉⣉⣁⣀⣀⣀⣹⣿⣷⠈⢿⣷⡄⠘⣿⣷⡈⣿⣿⣿⡏⠉⠉⠛⠻⠿⣿⣿⡿⠟⠋⠀⠀⠀\r\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣇⠈⣿⣿⡀⠸⣿⣧⠘⣿⣿⣿⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣆⠸⣿⣿⣿⣿⣿⠇⠸⣿⣿⣷⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢿⣿⣿⡿⠛⠋⠉⠉⠉⠉⠉⠉⠉⠉⠉⠀⠉⠉⠉⠀⠀⠀⠀⠈⠙⠛⢿⣷⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠻⣿⣷⣄⠀⠀⠀⠀⠀⠀⠀⢀⣤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢿⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⠻⠿⢷⣶⣤⣤⣶⡾⠿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠿⠿⠷⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(" ★★★★★ 경마 게임 ★★★★★");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("메뉴를 선택하세요.");
			System.out.println("1. 게임 규칙 설명 | 2. 배당표 확인 | 3. 게임 시작 (배팅) | 4.종료");
			menu = scan.nextInt();
			
		switch(menu) {
		
		case 1: {
			System.out.println(" ★★★★★★★ 게임 규칙 ★★★★★★★");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("☞ 배당표를 보고 말을 선택한 후 금액을 배팅한다.");
			try {
				Thread.sleep(700);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("☞ 경마가 끝난 후 본인이 배팅한 말이 우승을 차지하면");
			try {
				Thread.sleep(700);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("☞ 정해진 배당 비율에 따라 배팅비를 획득할 수 있다. ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		}
		case 2:
			System.out.println("배당표 확인");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("     ★★★★★"+dtf.format(today)+" 출전마 능력평가 ★★★★★");
			System.out.println("========마번===마   명=====습 성===우승 확률=== 배 당=======");
			System.out.println("	 ①  [스페셜 위크] [ 도주 ]   [30%]   [X1.5]"); 
			System.out.println("	 ②  [키타산 블랙] [ 선행 ]   [20%]   [X2.0]");
			System.out.println(" 	 ③  [큐피드 보이] [ 추입 ]   [ 7%]   [X3.0]");
			System.out.println(" 	 ④  [하루 우라라] [ 도주 ]   [ 3%]   [X4.0]"); 
			System.out.println("  	 ⑤  [블랙 포인트] [ 선입 ]   [15%]   [X2.5]");
			System.out.println(" 	 ⑥  [매지로 맥퀸] [ 후행 ]   [25%]   [X1.8]"); 
			System.out.println("===================================================");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		
		case 3: 
		if(user.getAccount()<=0) {
				System.out.println(user.getUserName() + " 님 배팅할 금액이 부족합니다. (잔액 : " + user.getAccount() + " 원)");
				System.out.println("*충전 후 이용해주세요.");
			}
		
		if (user.getAccount()>0){
		
			System.out.println("선택마 (1~6번마 숫자만 입력) >");
			horse = scan.nextInt();
			if (horse>=1 && horse<=6) {
				System.out.println("투입 금액 >");
				price = scan.nextInt();

				switch(horse) {
				case 1: dividend = 1.5;
				break;
				case 2: dividend = 2;
				break;
				case 3: dividend = 3;
				break;
				case 4: dividend = 4;
				break;
				case 5: dividend = 2.5;
				break;
				case 6: dividend = 1.8;
				break;
				}
				경마 s = new 경마(horse, price, dividend);
				list.add(s);
				System.out.println("말 선택 완료");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("-------------- 마표 --------------");
				for (int i=0; i<list.size(); i++) {
					System.out.println(list.get(i)+" ");
					
				}
				System.out.println("---------------------------------");
		
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			System.out.println("게임 시작");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("경마가 시작되었습니다! 말들이 달립니다!!");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("\r\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠁⠀⠇⠀⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⡅⠀⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⡇⠀⢸⠀⠀⠀⠀⠀⠀⢀⠀⠀⣀⣾⡧⡤⠀⠀⢠⣄⢠⣦⠀⠀⠀⢠⡀⠀⠀⠀⠀⣄⢀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⡇⠀⢸⠀⠀⠀⠀⠀⠘⢥⡄⠀⣴⣿⠂⠀⠀⣼⡿⣫⣿⣓⣅⠀⠀⣬⣥⣴⣶⢾⣷⣿⠷⡎⠀⠀⣤⣴⣾⣷⡦⣀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⡇⠀⢸⠀⠀⠀⠀⠀⠀⠀⢱⠐⠁⠧⠀⢤⣽⢏⣼⣿⣿⣷⣫⣀⠀⠀⠉⠒⠶⢿⣿⡏⢨⡤⣷⣿⣿⣛⣿⣯⣾⣿⣷⣤⠀⠀⠀⠀\r\n"
					+ "⠁⠀⡇⠀⣸⣤⣌⣴⣶⣿⣿⣦⣀⣵⣭⣭⣿⡿⢟⣶⣿⣿⣿⣯⣾⣻⢹⡀⠀⡠⣴⣬⣿⣿⣾⣦⣾⣟⣛⣻⣿⣿⣿⣿⡯⣾⣷⡄⠀⠀\r\n"
					+ "⣀⣀⣷⣺⣹⣠⣿⣿⡿⣿⣿⣿⣿⡟⣾⣿⡿⣷⣾⢟⣿⣿⣿⣿⡅⣽⣟⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠋⠀⠁⠉⠉⠙⠛⠃⠀⠀\r\n"
					+ "⣿⣿⣿⣿⣽⣀⣀⣀⡇⠩⢻⣿⣿⣼⢿⣬⣷⡿⣯⣿⣿⣿⣿⣿⣽⣿⣿⣿⠿⣾⣿⣟⣿⣿⣿⣿⣿⣿⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⣽⣽⣿⣿⣿⣿⣿⢟⣥⣶⣾⣿⣷⡟⡰⣿⣭⣿⣿⣿⣿⣿⣿⣿⣟⣿⣿⣿⡇⢸⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡞⣨⣿⣻⣿⢿⢟⣿⣿⣿⣿⣿⣿⣿⡷⢸⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠿⠿⣿⣿⣿⣏⣈⣿⣿⠻⣿⣿⠿⠿⣾⢯⣬⠻⣿⣿⣿⠿⢿⣄⣉⠛⠻⠿⣧⣼⣿⣿⣿⠙⢿⣿⣿⣿⣶⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⣿⣿⣿⣿⣟⣿⣿⣷⣶⣄⠻⣿⡀⠀⠉⠛⠿⢿⣷⣽⢻⣿⣟⠙⢿⣧⠀⠀⠀⠉⠙⠻⣿⣾⣅⡌⠉⠉⠉⠙⡷⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⠛⠳⢄⡄⠀⠀⠀⠀⠀⣸⡿⠸⢿⣏⣢⢠⠋⠃⣀⡀⠀⠀⠀⡀⠈⠉⣳⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠉⠀⠀⠀⠈⢣⠀⠀⠦⢂⢾⠋⠀⠀⠀⠀⠄⠀⠀⠀⠉⢿⠂⠉⠻⠧⠀⠈⠈⠀⠀⠀⠀⡗⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢴⡂⠀⠀⠀⠀⠀⠀⠀⠀⠐⢢⣄⠀⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠠⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠁⠒⠀⠀⠀⠀⠀⠀⠀⠈⠐⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "");
			System.out.println("말들의 자리 싸움이 치열합니다!!");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println(".");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println(".");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println(".");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("\r\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⠈⣰⠄⡤⠀⢀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⢀⡀⠀⠀⢀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⡞⠧⢴⡑⢞⡻⠆⢲⣄⠀⢂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⠀⠀⠀⣀⣤⣀⡀⢰⠀⡆⡹⣆⠂⢋⠄⢀⠀⠀⠀⠀⠀⢀⡞⠟⢁⠛⡌⢳⡄⡘⠱⠞⠛⠓⡀⢡⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⢠⣾⣯⣛⠓⠻⠿⢧⣞⡑⠓⠎⠡⢀⠀⠈⠀⠀⠀⠀⠰⡟⢠⡿⢋⣴⡋⠀⠳⣦⣄⣆⣀⣠⣲⠸⠀⠐⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⢠⣿⣭⡼⢿⣧⣀⠤⣂⡞⢭⣿⣷⣤⣴⣂⢀⢀⠀⣀⡀⠀⠈⠁⠀⠀⢻⣷⡄⠀⠈⡟⢭⣠⡙⢿⢸⣷⡉⠀⠁⠀⠀⣀⢀⠀⠀⠀⠀\r\n"
					+ "⢠⠿⣿⣻⡡⠟⠻⣿⣷⣤⣙⠛⠿⣮⣿⣾⣿⣟⣬⢻⣿⣿⣿⣶⡕⣤⣀⡌⣿⣷⣀⠂⠄⠘⠻⠧⣙⢾⣧⠇⢸⡁⠀⠐⠘⠿⣿⣦⣄⠀\r\n"
					+ "⠻⢧⠓⠀⠀⠀⠀⢈⣿⣿⣿⣿⣶⣿⣿⣼⠟⡉⣾⣿⡯⣿⣿⣿⣿⣿⠙⠻⠛⣿⣿⣮⠀⠀⠀⠀⢁⠃⠀⣰⣿⣷⡀⢀⠂⠀⠈⠉⠉⠀\r\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠸⣿⣿⣿⣿⣿⣻⣿⡟⣠⣿⣿⣶⣷⣿⣿⣿⣿⡏⠀⠀⠀⢹⣯⣿⣆⠀⠀⠐⣬⣤⡾⠟⢏⢹⣇⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⢀⡿⠟⢋⢿⣿⣿⣯⣰⡿⠿⠋⠁⠙⠿⣿⣿⣿⠁⠀⠀⠀⠀⠻⣿⣟⣿⠀⠠⠀⠈⠓⠤⢬⡙⣿⠘⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⠀⠀⠀⠀⢀⠈⢱⠞⠋⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠻⣿⣿⣧⡄⠀⠀⠀⠀⠈⢿⡽⢀⠀⠀⠀⠀⠀⢀⠛⡈⠃⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⠀⠀⠀⢀⢈⣷⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⣿⣿⣷⠀⠀⠀⠀⠀⢀⣏⠾⠦⠸⠤⠀⢀⠶⠈⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⠀⢀⡐⠣⢰⡿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⠇⠘⣷⣀⠀⠀⠀⠀⠉⠀⠚⣇⠀⠀⠰⣆⣧⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⠀⠘⠒⠁⠿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⠏⠀⠀⠈⠙⠛⠉⠀⠀⠀⠀⠀⠈⣦⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⠀⠀⠠⡞⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣴⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⠁⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
			System.out.println();
			System.out.println("반환점을 돌아 보이는 두마리의 선두말이 1등을 다툽니다!!");
			System.out.println(".");
			try {
				Thread.sleep(700);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println(".");
			try {
				Thread.sleep(700);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println(".");
			System.out.println();
			try {
				Thread.sleep(700);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("\r\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣾⣿⣿⡄⠀⠄⠠⢀⠀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⠀⠀⠀⠠⣘⣄⣀⠀⠀⠀⠉⠄⡟⢄⠃⢊⠔⡀⢂⠤⠓⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⠀⠀⠘⠢⡜⠀⠠⠙⠦⣀⠀⠀⠀⠈⡄⠉⠂⠑⠊⠌⡐⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⠀⣌⠉⢰⠃⠌⠠⢁⠆⣏⠳⣀⣂⠡⠈⠁⠠⠁⡜⠀⠀⠀⢀⣀⣀⣀⣤⣀⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⡠⢈⠤⢈⠯⠐⠈⠑⡁⢂⠠⠐⡨⢈⠙⠓⡖⠳⣐⣲⠒⠒⠋⠍⣭⠉⢉⠈⢉⠉⡉⠻⢶⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠐⠉⠈⠀⠀⠀⠀⠀⠈⠄⢂⢡⠃⠄⡈⠐⢨⠡⢈⢻⣧⡈⠐⡠⠘⡆⠠⠈⠄⠂⠄⠡⢀⢹⣄⣀⣠⣄⣤⣤⣤⣤⣄⣀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢘⡠⠃⡐⠠⠐⡉⠀⡇⢂⠞⡡⢠⢡⣄⣣⠕⠠⠁⠌⡐⢈⠐⡀⢂⠛⠻⠿⠿⣿⢿⣿⣿⡿⠿⣷⣆⡀⠀⠀\r\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢆⠐⠠⢁⠂⠄⠡⢈⠉⣿⡏⢁⠂⣀⣿⠂⡅⢈⡐⢀⠂⠰⢀⠃⠀⠀⠀⠀⠀⠀⠀⠀⠉⠐⠀⠉⠢⠀⠀\r\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢑⠀⡂⠌⡀⢣⠀⢺⣿⠁⠄⢂⡼⠗⠨⠐⠠⢐⣠⣼⣆⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⠔⡀⢂⡐⠤⢴⣷⣿⠁⠁⠈⠉⠀⠀⠀⠰⢁⠢⠁⢀⣿⣿⠆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢐⠠⠆⠁⠁⠀⠀⠘⣿⣽⠀⠀⠀⠀⠀⠀⠀⠘⡀⢲⠿⠛⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠁⢌⠐⢠⠀⠀⠀⠙⠿⠷⠾⠿⠶⣶⣶⡄⠂⡔⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠂⠤⢋⡄⠀⠀⠀⠀⠀⠀⠀⠌⢠⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⢊⠌⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
					+ "");
			System.out.println("골인!!!");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println(".");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println(".");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println(".");
			
			
			double random = (double)(Math.random()*10)+0;
//			System.out.println("랜덤값: "+random);
			
			if (random>0 && random<=3) {
				System.out.println("1번마 1등!! 스페셜 위크가 1등입니다!!!");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣾⣿⣿⣡⠀⢸⣿⢸⠀⠀⠀⠀⡇⣿⠀⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣥⣿⣿⣿⣿⣿⠀⠸⡿⣸⠀⠀⠀⠀⡄⡿⠀⣼⣿⣿⣿⣿⣿⣿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⢹⣿⠀⠀⡇⢸⠀ ⠀⢸⠁⡇⠀⣸⣿⣛⣛⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣏⣾⣿⠁⠀⠃⣘⠀⠀⠀⢰⠀⠃⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⡇⢻⠀⠀⠀⢸⠀⡇⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠇⠺⠀⢰⡆⢸⠀⠇⠀⣾⣿⣿⣿⣿⣿⣿⣿⠋⡉⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
						+ "⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠿⠿⠿⠿⠀⠀⠆⠻⠀⠸⡇⠸⠀⠄⠀⠻⠿⠿⠿⢯⣤⡆⠀⠿⠿⠿⠿⠿⣿⣿⠿⠿⠿⠿⠿⠿\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⣄⠀⠀⠀⠀⠀⠀⢠⡆⠀⠂⠀⠀⠀⠐⠂⢀⡇⠀⢀⣠⣤⣄⣀⣀⣀⠀⢀⣀⡀⣀⣠⣷⣾⣿⣿⣿⣷⣆⠀⠂⠀⠴\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡆⣘⣷⣾⣿⣿⣿⣿⣿⣿⣿1⣿⡵⢟⣻⣿⣿⣿⡿⠟⠻⠿⣿⣧⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⠀⠀⠀⠀⠀⣴⣿⣿⡿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠋⠀⠀⠀⠀⠀⠁⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣾⡿⠋⠁⠀⣈⣿⣿⣿⠛⠉⠛⠿⣿⣿⣿⣿⣿⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠀⠀⠀⠐⠻⣟⣽⡿⠁⠀⠀⠀⠀⠈⣹⣿⣿⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⣀⡀⠀⣀⠀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⣮⠻⣦⡀⠀⠀⢀⣼⠟⢀⣹⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠝⠀⠈⠋⢀⡤⠊⠉⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "");
			}
			if(random>3 && random<=5) {
				System.out.println("2번마 1등!! 키타산 블랙이 1등입니다!!!");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣾⣿⣿⣡⠀⢸⣿⢸⠀⠀⠀⠀⡇⣿⠀⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣥⣿⣿⣿⣿⣿⠀⠸⡿⣸⠀⠀⠀⠀⡄⡿⠀⣼⣿⣿⣿⣿⣿⣿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⢹⣿⠀⠀⡇⢸⠀ ⠀⢸⠁⡇⠀⣸⣿⣛⣛⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣏⣾⣿⠁⠀⠃⣘⠀⠀⠀⢰⠀⠃⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⡇⢻⠀⠀⠀⢸⠀⡇⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠇⠺⠀⢰⡆⢸⠀⠇⠀⣾⣿⣿⣿⣿⣿⣿⣿⠋⡉⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
						+ "⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠿⠿⠿⠿⠀⠀⠆⠻⠀⠸⡇⠸⠀⠄⠀⠻⠿⠿⠿⢯⣤⡆⠀⠿⠿⠿⠿⠿⣿⣿⠿⠿⠿⠿⠿⠿\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⣄⠀⠀⠀⠀⠀⠀⢠⡆⠀⠂⠀⠀⠀⠐⠂⢀⡇⠀⢀⣠⣤⣄⣀⣀⣀⠀⢀⣀⡀⣀⣠⣷⣾⣿⣿⣿⣷⣆⠀⠂⠀⠴\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡆⣘⣷⣾⣿⣿⣿⣿⣿⣿⣿2⣿⡵⢟⣻⣿⣿⣿⡿⠟⠻⠿⣿⣧⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⠀⠀⠀⠀⠀⣴⣿⣿⡿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠋⠀⠀⠀⠀⠀⠁⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣾⡿⠋⠁⠀⣈⣿⣿⣿⠛⠉⠛⠿⣿⣿⣿⣿⣿⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠀⠀⠀⠐⠻⣟⣽⡿⠁⠀⠀⠀⠀⠈⣹⣿⣿⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⣀⡀⠀⣀⠀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⣮⠻⣦⡀⠀⠀⢀⣼⠟⢀⣹⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠝⠀⠈⠋⢀⡤⠊⠉⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "");
				
			}
			
			if (random>5 && random<=5.7) {
				System.out.println("3번마 1등!! 큐피드 보이가 1등입니다!!!");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣾⣿⣿⣡⠀⢸⣿⢸⠀⠀⠀⠀⡇⣿⠀⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣥⣿⣿⣿⣿⣿⠀⠸⡿⣸⠀⠀⠀⠀⡄⡿⠀⣼⣿⣿⣿⣿⣿⣿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⢹⣿⠀⠀⡇⢸⠀ ⠀⢸⠁⡇⠀⣸⣿⣛⣛⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣏⣾⣿⠁⠀⠃⣘⠀⠀⠀⢰⠀⠃⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⡇⢻⠀⠀⠀⢸⠀⡇⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠇⠺⠀⢰⡆⢸⠀⠇⠀⣾⣿⣿⣿⣿⣿⣿⣿⠋⡉⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
						+ "⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠿⠿⠿⠿⠀⠀⠆⠻⠀⠸⡇⠸⠀⠄⠀⠻⠿⠿⠿⢯⣤⡆⠀⠿⠿⠿⠿⠿⣿⣿⠿⠿⠿⠿⠿⠿\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⣄⠀⠀⠀⠀⠀⠀⢠⡆⠀⠂⠀⠀⠀⠐⠂⢀⡇⠀⢀⣠⣤⣄⣀⣀⣀⠀⢀⣀⡀⣀⣠⣷⣾⣿⣿⣿⣷⣆⠀⠂⠀⠴\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡆⣘⣷⣾⣿⣿⣿⣿⣿⣿⣿3⣿⡵⢟⣻⣿⣿⣿⡿⠟⠻⠿⣿⣧⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⠀⠀⠀⠀⠀⣴⣿⣿⡿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠋⠀⠀⠀⠀⠀⠁⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣾⡿⠋⠁⠀⣈⣿⣿⣿⠛⠉⠛⠿⣿⣿⣿⣿⣿⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠀⠀⠀⠐⠻⣟⣽⡿⠁⠀⠀⠀⠀⠈⣹⣿⣿⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⣀⡀⠀⣀⠀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⣮⠻⣦⡀⠀⠀⢀⣼⠟⢀⣹⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠝⠀⠈⠋⢀⡤⠊⠉⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "");
			}
			
			if (random>5.7 && random<=6) {
				System.out.println("4번마 1등!! 하루 우라라가 1등입니다!!!");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣾⣿⣿⣡⠀⢸⣿⢸⠀⠀⠀⠀⡇⣿⠀⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣥⣿⣿⣿⣿⣿⠀⠸⡿⣸⠀⠀⠀⠀⡄⡿⠀⣼⣿⣿⣿⣿⣿⣿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⢹⣿⠀⠀⡇⢸⠀ ⠀⢸⠁⡇⠀⣸⣿⣛⣛⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣏⣾⣿⠁⠀⠃⣘⠀⠀⠀⢰⠀⠃⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⡇⢻⠀⠀⠀⢸⠀⡇⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠇⠺⠀⢰⡆⢸⠀⠇⠀⣾⣿⣿⣿⣿⣿⣿⣿⠋⡉⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
						+ "⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠿⠿⠿⠿⠀⠀⠆⠻⠀⠸⡇⠸⠀⠄⠀⠻⠿⠿⠿⢯⣤⡆⠀⠿⠿⠿⠿⠿⣿⣿⠿⠿⠿⠿⠿⠿\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⣄⠀⠀⠀⠀⠀⠀⢠⡆⠀⠂⠀⠀⠀⠐⠂⢀⡇⠀⢀⣠⣤⣄⣀⣀⣀⠀⢀⣀⡀⣀⣠⣷⣾⣿⣿⣿⣷⣆⠀⠂⠀⠴\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡆⣘⣷⣾⣿⣿⣿⣿⣿⣿⣿4⣿⡵⢟⣻⣿⣿⣿⡿⠟⠻⠿⣿⣧⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⠀⠀⠀⠀⠀⣴⣿⣿⡿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠋⠀⠀⠀⠀⠀⠁⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣾⡿⠋⠁⠀⣈⣿⣿⣿⠛⠉⠛⠿⣿⣿⣿⣿⣿⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠀⠀⠀⠐⠻⣟⣽⡿⠁⠀⠀⠀⠀⠈⣹⣿⣿⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⣀⡀⠀⣀⠀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⣮⠻⣦⡀⠀⠀⢀⣼⠟⢀⣹⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠝⠀⠈⠋⢀⡤⠊⠉⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "");
			}
			
			if (random>6 && random<=7.5) {
				System.out.println("5번마 1등!! 블랙 포인트가 1등입니다!!!");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣾⣿⣿⣡⠀⢸⣿⢸⠀⠀⠀⠀⡇⣿⠀⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣥⣿⣿⣿⣿⣿⠀⠸⡿⣸⠀⠀⠀⠀⡄⡿⠀⣼⣿⣿⣿⣿⣿⣿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⢹⣿⠀⠀⡇⢸⠀ ⠀⢸⠁⡇⠀⣸⣿⣛⣛⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣏⣾⣿⠁⠀⠃⣘⠀⠀⠀⢰⠀⠃⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⡇⢻⠀⠀⠀⢸⠀⡇⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠇⠺⠀⢰⡆⢸⠀⠇⠀⣾⣿⣿⣿⣿⣿⣿⣿⠋⡉⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
						+ "⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠿⠿⠿⠿⠀⠀⠆⠻⠀⠸⡇⠸⠀⠄⠀⠻⠿⠿⠿⢯⣤⡆⠀⠿⠿⠿⠿⠿⣿⣿⠿⠿⠿⠿⠿⠿\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⣄⠀⠀⠀⠀⠀⠀⢠⡆⠀⠂⠀⠀⠀⠐⠂⢀⡇⠀⢀⣠⣤⣄⣀⣀⣀⠀⢀⣀⡀⣀⣠⣷⣾⣿⣿⣿⣷⣆⠀⠂⠀⠴\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡆⣘⣷⣾⣿⣿⣿⣿⣿⣿⣿5⣿⡵⢟⣻⣿⣿⣿⡿⠟⠻⠿⣿⣧⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⠀⠀⠀⠀⠀⣴⣿⣿⡿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠋⠀⠀⠀⠀⠀⠁⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣾⡿⠋⠁⠀⣈⣿⣿⣿⠛⠉⠛⠿⣿⣿⣿⣿⣿⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠀⠀⠀⠐⠻⣟⣽⡿⠁⠀⠀⠀⠀⠈⣹⣿⣿⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⣀⡀⠀⣀⠀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⣮⠻⣦⡀⠀⠀⢀⣼⠟⢀⣹⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠝⠀⠈⠋⢀⡤⠊⠉⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "");
			}
			
			if (random>7.5 && random<=10) {
				System.out.println("6번마 1등!! 매지로 맥퀸이 1등입니다!!!");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣾⣿⣿⣡⠀⢸⣿⢸⠀⠀⠀⠀⡇⣿⠀⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣥⣿⣿⣿⣿⣿⠀⠸⡿⣸⠀⠀⠀⠀⡄⡿⠀⣼⣿⣿⣿⣿⣿⣿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⢹⣿⠀⠀⡇⢸⠀ ⠀⢸⠁⡇⠀⣸⣿⣛⣛⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣏⣾⣿⠁⠀⠃⣘⠀⠀⠀⢰⠀⠃⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⡇⢻⠀⠀⠀⢸⠀⡇⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
						+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠇⠺⠀⢰⡆⢸⠀⠇⠀⣾⣿⣿⣿⣿⣿⣿⣿⠋⡉⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
						+ "⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠿⠿⠿⠿⠀⠀⠆⠻⠀⠸⡇⠸⠀⠄⠀⠻⠿⠿⠿⢯⣤⡆⠀⠿⠿⠿⠿⠿⣿⣿⠿⠿⠿⠿⠿⠿\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⣄⠀⠀⠀⠀⠀⠀⢠⡆⠀⠂⠀⠀⠀⠐⠂⢀⡇⠀⢀⣠⣤⣄⣀⣀⣀⠀⢀⣀⡀⣀⣠⣷⣾⣿⣿⣿⣷⣆⠀⠂⠀⠴\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡆⣘⣷⣾⣿⣿⣿⣿⣿⣿⣿6⣿⡵⢟⣻⣿⣿⣿⡿⠟⠻⠿⣿⣧⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⠀⠀⠀⠀⠀⣴⣿⣿⡿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠋⠀⠀⠀⠀⠀⠁⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣾⡿⠋⠁⠀⣈⣿⣿⣿⠛⠉⠛⠿⣿⣿⣿⣿⣿⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠀⠀⠀⠐⠻⣟⣽⡿⠁⠀⠀⠀⠀⠈⣹⣿⣿⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⣀⡀⠀⣀⠀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⣮⠻⣦⡀⠀⠀⢀⣼⠟⢀⣹⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠝⠀⠈⠋⢀⡤⠊⠉⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "");
			}
			
			for (int i=0; i<list.size(); i++) {
			
				money1 = 
				((int)list.get(i).getPrice() * list.get(i).getDividend()-list.get(i).getPrice());
				// 투입금액에 배당을 곱하고 투입금액을 뺀 값. 실질적으로 얻는 이득
			
				if (random>0 && random<=3) {
				if (list.get(i).getHorse() == 1) {
					System.out.println("투입 금액: "+list.get(i).getPrice());
					System.out.println("수령액: "+(int)(list.get(i).getPrice() * list.get(i).getDividend()));
					money = (int) (user.getAccount() + money1);
				}
				else {
					System.out.println("선택하신 "+list.get(i).getHorse()+"번 말은 1등이 아닙니다.");
					System.out.println("잃은 금액: "+ list.get(i).getPrice());
					money = user.getAccount() - list.get(i).getPrice();
					
				}
			} else if(random>3 && random<=5) {
				if (list.get(i).getHorse() == 2) {
					System.out.println("투입 금액: "+list.get(i).getPrice());
					System.out.println("수령액: "+(int)(list.get(i).getPrice() * list.get(i).getDividend()));
					money = (int) (user.getAccount() + money1);
					
				}
				else {
					System.out.println("선택하신 "+list.get(i).getHorse()+"번 말은 1등이 아닙니다.");
					System.out.println("잃은 금액: "+ list.get(i).getPrice());
					money = user.getAccount() - list.get(i).getPrice();
				}
				
			} else if (random>5 && random<=5.7) {
				if (list.get(i).getHorse() == 3) {
					System.out.println("투입 금액: "+list.get(i).getPrice());
					System.out.println("수령액: "+(int)(list.get(i).getPrice() * list.get(i).getDividend()));
					money = (int) (user.getAccount() + money1);
					
				}
				else {
					System.out.println("선택하신 "+list.get(i).getHorse()+"번 말은 1등이 아닙니다.");
					System.out.println("잃은 금액: "+ list.get(i).getPrice());
					money = user.getAccount() - list.get(i).getPrice();
					
				}
				
			} else if (random>5.7 && random<=6) {
				if (list.get(i).getHorse() == 4) {
					System.out.println("투입 금액: "+list.get(i).getPrice());
					System.out.println("수령액: "+(int)(list.get(i).getPrice() * list.get(i).getDividend()));
					money = (int) (user.getAccount() + money1);
					
				}
				else {
					System.out.println("선택하신 "+list.get(i).getHorse()+"번 말은 1등이 아닙니다.");
					System.out.println("잃은 금액: "+ list.get(i).getPrice());
					money = user.getAccount() - list.get(i).getPrice();
					
				}
			
			} 
			else if (random>6 && random<=7.5) {
				if (list.get(i).getHorse() == 5) {
					System.out.println("투입 금액: "+list.get(i).getPrice());
					System.out.println("수령액: "+(int)(list.get(i).getPrice() * list.get(i).getDividend()));
					money = (int) (user.getAccount() + money1);
					
				}
				else {
					System.out.println("선택하신 "+list.get(i).getHorse()+"번 말은 1등이 아닙니다.");
					System.out.println("잃은 금액: "+ list.get(i).getPrice());
					money = user.getAccount() - list.get(i).getPrice();
					
				}
				
			} else if (random>7.5 &&random<10) {
				if (list.get(i).getHorse() == 6) {
					System.out.println("투입 금액: "+list.get(i).getPrice());
					System.out.println("수령액: "+(int)(list.get(i).getPrice() * list.get(i).getDividend()));
					money = (int) (user.getAccount() + money1);
				}
				else {
					System.out.println("선택하신 "+list.get(i).getHorse()+"번 말은 1등이 아닙니다.");
					System.out.println("잃은 금액: "+ list.get(i).getPrice());
					money = user.getAccount() - list.get(i).getPrice();
				}
				
			}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				list.get(i).setMoney(money);
				user.setAccount(money);
				System.out.println("총 금액: " + user.getAccount());
				list.remove(i).getHorse();
		}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	} 
			else System.out.println("1~6번마만 존재합니다.");
			break;
	}else System.out.println("파산!"); // case2 끝.
		
		case 4:
			System.out.println("이전 메뉴");
			break;
		default :
			System.out.println("1~3만 입력");
			break;
		}
		
		} while (menu != 4);
		
	}
	
	@Override
	public String toString() {
		System.out.println("선택마: "+horse+"번마");
		System.out.println("투입 금액: "+price+" (배당: X"+dividend+")");
		return "수령액: " + (int)(price*dividend);
	}

	// getter / setter
	public int getHorse() {
		return horse;
	}

	public void setHorse(int horse) {
		this.horse = horse;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public double getDividend() {
		return dividend;
	}

	public void setDividend(double dividend) {
		this.dividend = dividend;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public ArrayList<경마> getList() {
		return list;
	}

	public void setList(ArrayList<경마> list) {
		this.list = list;
	}

	
}