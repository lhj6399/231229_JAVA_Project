package EzenToto;

import java.util.Scanner;

public class EzenSoccerManager extends Thread {

	private int price; // 배팅금액
	JoinMembership user = LoginManager.loginUser;	//로그인유저 데이터 값 사용

	public EzenSoccerManager() {
	}

	public EzenSoccerManager(int price) {
		super();
		this.price = price;
	}

	public void Soccer(Scanner scan) {

		int menu1 = 0; // 내가 첫번째로 선택하는 메뉴

		int menu2 = 0; // 문자 메뉴
		int cnt = 0;

		String c1; // 컴퓨터 랜덤값
		String c2;
		String c3 = "무승부";
		int c1Score = 0;
		int c2Score = 0;
		String result; // 축구경기 결과

		do {
			int menu3 = 0;

			System.out.println("\n" + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠠⠀⢂⠠⠡⠃⠁⠁⠁⠉⠓⠲⣦⣤⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠠⢐⣈⣠⣤⠂⠁⠠⠀⠠⠈⠀⠁⠀⠂⠀⠀⠉⠛⠿⠷⡦⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣷⣿⣿⣿⣿⡏⠀⡀⠄⠀⠄⠀⠄⠂⠁⠀⠈⠀⠐⠈⡀⠄⠠⠀⠈⠄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⣿⣟⣯⣿⣾⢿⡇⠀⠀⠀⠀⡀⠀⢀⠀⠀⠄⠁⠀⠂⠀⠄⢀⠐⠀⢁⠀⢈⠠⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⣾⣿⣯⣷⣿⣿⣻⡽⠛⠁⠂⠢⢈⢀⠀⠀⠀⡀⠀⡀⠄⣐⣠⣠⡁⠀⡀⢈⠀⠠⠀⠄⠡⡀⠀⠀⠀⠀⠀⠀⠀\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠠⠡⣿⣷⣿⢿⡽⠞⠁⠀⠀⡀⠀⠀⠀⠀⠁⠂⢥⣤⣶⣶⣿⣿⣽⣿⣿⣦⡀⠄⠐⠀⠂⠐⢀⠐⡀⠀⠀⠀⠀⠀⠀\n"
					+ "⠀⠀⠀⠀⠀⠀⢀⠅⡁⢀⠉⠚⡋⠀⠀⡀⠄⠁⠀⠀⠁⠀⠐⠀⠀⢸⣿⣯⣿⣷⡿⣯⣷⣿⢿⣷⣔⠀⠁⡈⠠⠀⠄⢢⠀⠀⠀⠀⠀⠀\n"
					+ "⠀⠀⠀⠀⠀⠀⡌⠄⠠⠀⠠⠀⠂⠀⢀⠀⠀⠀⢀⠠⠐⠀⠠⠐⠀⠘⣿⣽⣷⣿⢿⣿⣻⡿⣟⣿⣽⣦⢀⠄⠂⠐⠠⢸⡇⠀⠀⠀⠀⠀\n"
					+ "⠀⠀⠀⠀⠀⢠⠠⠐⢀⠈⠠⠀⡁⠀⠀⢀⠠⠈⠀⠀⠀⠀⠀⠀⡀⠀⣿⣿⣻⣾⣿⣟⣿⡿⣿⣿⣻⠃⠀⠌⠈⡉⢈⢹⣿⠀⠀⠀⠀⠀\n"
					+ "⠀⠀⠀⠀⠀⠐⡀⠐⡀⠄⠁⠄⡆⠀⠁⠀⠀⠀⠀⡀⠄⠂⠁⠀⠀⠀⣿⣿⣻⣯⣷⣿⣿⣻⣿⡽⠁⡀⠁⠄⠁⠄⠂⡐⣿⠀⠀⠀⠀⠀\n"
					+ "⠀⠀⠀⠀⠀⢐⠀⡁⠠⠀⡁⠠⢁⠄⠁⠠⠐⠀⠁⠀⠀⠀⠀⡠⠌⠈⠀⠀⠉⠙⠛⠽⠾⠿⠏⠀⠂⠠⠈⡀⠡⠀⠅⠄⢽⠁⠀⠀⠀⠀\n"
					+ "⠀⠀⠀⠀⠀⠐⠄⠐⡀⠂⡀⢢⣿⣶⣮⣤⣀⠄⠠⠀⢐⠠⠃⠀⠀⠠⠐⠈⠀⠐⠀⠄⠠⠀⠇⠈⡀⢁⠐⠠⠈⠄⠅⡊⠼⠀⠀⠀⠀⠀\n"
					+ "⠀⠀⠀⠀⠀⠀⡅⡁⠄⠂⣠⣿⣿⣾⢿⣽⡿⣿⣶⡎⠠⠀⠄⠂⠈⡀⠄⠂⠁⡈⠀⠂⡀⠂⠡⠂⡀⢂⠈⠄⠡⡈⡂⡂⠍⠀⠀⠀⠀⠀\n"
					+ "⠀⠀⠀⠀⠀⠀⢐⠁⠆⡢⣿⣟⣷⣿⣿⢿⣿⣻⣽⣷⠀⠂⠐⢀⠁⡀⠄⠂⠁⡀⢈⠠⠀⠌⢨⠀⡂⠄⢂⠡⢁⢂⠢⢨⠁⠀⠀⠀⠀⠀\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠡⢂⠐⠹⣿⣿⣽⣾⣿⣿⣻⣿⣻⠄⡈⠐⡀⠄⠠⠀⠂⢁⠠⢀⠐⠠⠈⠄⡢⠐⡈⠄⡊⠔⡐⡱⠁⠀⠀⠀⠀⠀⠀\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠡⡨⠐⡈⢿⣽⡿⣷⡿⣿⣽⣿⡇⢀⠁⠠⠐⢀⠡⠈⡀⠄⡀⢂⠁⢌⣴⣷⣾⣦⣵⣤⠕⡡⠊⠀⠀⠀⠀⠀⠀⠀\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⢅⢐⠠⠙⢿⣿⣻⠿⠯⠛⠓⠠⢌⠠⢈⠠⠀⡂⠄⢂⢐⢠⣞⣿⣽⣾⣷⣿⣯⢏⠂⠁⠀⠀⠀⠀⠀⠀⠀⠀\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠑⢨⢐⠨⡠⢀⢂⢐⠈⠄⡡⠐⡈⠌⡐⡑⠰⠨⣴⣾⣿⢿⣟⣿⣯⣿⣾⠏⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⠡⡃⡂⡂⡢⠡⡁⡂⠅⡂⠅⡂⡂⠅⠅⢿⣷⣿⡿⣿⣻⡽⠛⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠁⠒⠔⣁⠢⡈⡂⡢⢑⢐⠨⠨⡨⡸⢻⠾⠛⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠈⠀⠐⠀⠁⠉⠁⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
					+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" + "");

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("★★★★★ 축구 배팅 게임 ★★★★★");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("메뉴를 선택하세요.");
			System.out.println("1. 게임 규칙 설명 | 2. 게임 시작(배팅) | 3.종료");
			menu1 = scan.nextInt();

			switch (menu1) {
			case 1:
				System.out.println("     ★★★★★★★게임 규칙★★★★★★★");
				System.out.println("☞ 원하는 나라의 승,무,패를 맞추는 게임이다. ");
				System.out.println("☞ 실제 월드컵 경기가 끝난 후 본인이 배팅한 팀의 승,무,패를 맞추면 ");
				System.out.println("☞ 정해진 배당 비율에 따라 배팅비를 획득할 수 있다.  ");
				System.out.println("☞ 배당 비율은 FIFA랭킹에 따라 정해진다.  ");
				break; 

			case 2:

				System.out.println("\n" + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠠⠀⢂⠠⠡⠃⠁⠁⠁⠉⠓⠲⣦⣤⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠠⢐⣈⣠⣤⠂⠁⠠⠀⠠⠈⠀⠁⠀⠂⠀⠀⠉⠛⠿⠷⡦⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣷⣿⣿⣿⣿⡏⠀⡀⠄⠀⠄⠀⠄⠂⠁⠀⠈⠀⠐⠈⡀⠄⠠⠀⠈⠄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⣿⣟⣯⣿⣾⢿⡇⠀⠀⠀⠀⡀⠀⢀⠀⠀⠄⠁⠀⠂⠀⠄⢀⠐⠀⢁⠀⢈⠠⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⣾⣿⣯⣷⣿⣿⣻⡽⠛⠁⠂⠢⢈⢀⠀⠀⠀⡀⠀⡀⠄⣐⣠⣠⡁⠀⡀⢈⠀⠠⠀⠄⠡⡀⠀⠀⠀⠀⠀⠀⠀\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠠⠡⣿⣷⣿⢿⡽⠞⠁⠀⠀⡀⠀⠀⠀⠀⠁⠂⢥⣤⣶⣶⣿⣿⣽⣿⣿⣦⡀⠄⠐⠀⠂⠐⢀⠐⡀⠀⠀⠀⠀⠀⠀\n"
						+ "⠀⠀⠀⠀⠀⠀⢀⠅⡁⢀⠉⠚⡋⠀⠀⡀⠄⠁⠀⠀⠁⠀⠐⠀⠀⢸⣿⣯⣿⣷⡿⣯⣷⣿⢿⣷⣔⠀⠁⡈⠠⠀⠄⢢⠀⠀⠀⠀⠀⠀\n"
						+ "⠀⠀⠀⠀⠀⠀⡌⠄⠠⠀⠠⠀⠂⠀⢀⠀⠀⠀⢀⠠⠐⠀⠠⠐⠀⠘⣿⣽⣷⣿⢿⣿⣻⡿⣟⣿⣽⣦⢀⠄⠂⠐⠠⢸⡇⠀⠀⠀⠀⠀\n"
						+ "⠀⠀⠀⠀⠀⢠⠠⠐⢀⠈⠠⠀⡁⠀⠀⢀⠠⠈⠀⠀⠀⠀⠀⠀⡀⠀⣿⣿⣻⣾⣿⣟⣿⡿⣿⣿⣻⠃⠀⠌⠈⡉⢈⢹⣿⠀⠀⠀⠀⠀\n"
						+ "⠀⠀⠀⠀⠀⠐⡀⠐⡀⠄⠁⠄⡆⠀⠁⠀⠀⠀⠀⡀⠄⠂⠁⠀⠀⠀⣿⣿⣻⣯⣷⣿⣿⣻⣿⡽⠁⡀⠁⠄⠁⠄⠂⡐⣿⠀⠀⠀⠀⠀\n"
						+ "⠀⠀⠀⠀⠀⢐⠀⡁⠠⠀⡁⠠⢁⠄⠁⠠⠐⠀⠁⠀⠀⠀⠀⡠⠌⠈⠀⠀⠉⠙⠛⠽⠾⠿⠏⠀⠂⠠⠈⡀⠡⠀⠅⠄⢽⠁⠀⠀⠀⠀\n"
						+ "⠀⠀⠀⠀⠀⠐⠄⠐⡀⠂⡀⢢⣿⣶⣮⣤⣀⠄⠠⠀⢐⠠⠃⠀⠀⠠⠐⠈⠀⠐⠀⠄⠠⠀⠇⠈⡀⢁⠐⠠⠈⠄⠅⡊⠼⠀⠀⠀⠀⠀\n"
						+ "⠀⠀⠀⠀⠀⠀⡅⡁⠄⠂⣠⣿⣿⣾⢿⣽⡿⣿⣶⡎⠠⠀⠄⠂⠈⡀⠄⠂⠁⡈⠀⠂⡀⠂⠡⠂⡀⢂⠈⠄⠡⡈⡂⡂⠍⠀⠀⠀⠀⠀\n"
						+ "⠀⠀⠀⠀⠀⠀⢐⠁⠆⡢⣿⣟⣷⣿⣿⢿⣿⣻⣽⣷⠀⠂⠐⢀⠁⡀⠄⠂⠁⡀⢈⠠⠀⠌⢨⠀⡂⠄⢂⠡⢁⢂⠢⢨⠁⠀⠀⠀⠀⠀\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠡⢂⠐⠹⣿⣿⣽⣾⣿⣿⣻⣿⣻⠄⡈⠐⡀⠄⠠⠀⠂⢁⠠⢀⠐⠠⠈⠄⡢⠐⡈⠄⡊⠔⡐⡱⠁⠀⠀⠀⠀⠀⠀\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠡⡨⠐⡈⢿⣽⡿⣷⡿⣿⣽⣿⡇⢀⠁⠠⠐⢀⠡⠈⡀⠄⡀⢂⠁⢌⣴⣷⣾⣦⣵⣤⠕⡡⠊⠀⠀⠀⠀⠀⠀⠀\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⢅⢐⠠⠙⢿⣿⣻⠿⠯⠛⠓⠠⢌⠠⢈⠠⠀⡂⠄⢂⢐⢠⣞⣿⣽⣾⣷⣿⣯⢏⠂⠁⠀⠀⠀⠀⠀⠀⠀⠀\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠑⢨⢐⠨⡠⢀⢂⢐⠈⠄⡡⠐⡈⠌⡐⡑⠰⠨⣴⣾⣿⢿⣟⣿⣯⣿⣾⠏⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⠡⡃⡂⡂⡢⠡⡁⡂⠅⡂⠅⡂⡂⠅⠅⢿⣷⣿⡿⣿⣻⡽⠛⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠁⠒⠔⣁⠢⡈⡂⡢⢑⢐⠨⠨⡨⡸⢻⠾⠛⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠈⠀⠐⠀⠁⠉⠁⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" + "");

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				System.out.println("             ★★★★★ 2024 EZEN WORLDCUP ★★★★★");
				System.out.println("==========================================================");
				System.out.println("	 ① [2/27 08:00] [대한민국 VS 일본]"); // 대한민국23 일본17
				System.out.println("	 ② [2/27 21:00] [호주 VS 프랑스] "); // 호주 24 프랑스2
				System.out.println(" 	 ③ [2/28 13:00] [노르웨이 VS 칠레 ]");// 노르웨이 44 칠레 40
				System.out.println(" 	 ④ [2/29 00:00] [요르단 VS 캐나다]"); // 요르단87 캐나다 48
				System.out.println("  	 ⑤ [2/29 17:30] [대한민국 VS 아르헨티나] "); // 대한민국 23 아르헨티나 1
				System.out.println(" 	 ⑥ [3/1 22:00]  [이탈리아 VS 포르투갈] "); // 이 9 포 7
				System.out.println(" 	 ⑦ [3/1 23:00]  [러시아 VS 가나] "); // 러 38 가 61
				System.out.println("	 ⑧ [3/2 04:00]  [페루 VS 스코틀랜드] ");// 페35 스 36
				System.out.println("	 ⑨ [3/3 14:00]  [대한민국 VS 브라질] "); // 대23 브5
				System.out.println("	 ⑩ [3/4 21:00]  [스페인 VS 모로코] "); // 스8 모13
				System.out.println("==========================================================");

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("배팅을 희망하는 경기 번호(1~10)를 입력하세요.");
				menu2 = scan.nextInt();

				switch (menu2) {
				case 1:

					while (menu2 != 9) {
						System.out.println("[2/27 08:00] [대한민국 VS 일본] 을 선택하셨습니다.");
						System.out.println("진행하시려면 1을 입력하세요. 다시 선택하시려면 9를 눌러주세요. ");

						menu2 = scan.nextInt();
						if (menu2 == 1) {
							System.out.println("===============배당 비율===============");
							System.out.println("대한민국 승 (X1.8) | 무승부 (X2) | 일본 승 (X1.5) ");
							System.out.println("대한민국을 선택하시려면 1, 일본을 선택하시려면 2를 눌러주세요.");
							System.out.println("무승부를 선택하시려면 3을 눌러주세요.");

							menu3 = scan.nextInt();

							System.out.println("배팅할 금액을 입력하세요.");
							price = scan.nextInt();
							
							if(user.getAccount()<price || user.getAccount()<=0) {
								System.out.println(user.getUserName() + " 님 배팅할 금액이 부족합니다. (잔액 : " + user.getAccount() + " 원)");
								System.out.println("*충전 후 이용해주세요.");
								return;
							}
							
							System.out.println("베팅 전 잔액 : "+user.getAccount());
							user.setAccount(user.getAccount()-price);
							System.out.println("*배팅완료");
							System.out.println("베팅 후 잔액 : "+user.getAccount());
							
							c1 = "대한민국";
							c2 = "일본";
							if (menu3 == 1) {
								System.out.println(c1 + "을 선택하셨습니다.");
							} else if (menu3 == 2) {
								System.out.println(c2 + "을 선택하셨습니다.");
							} else if (menu3 == 3) {
								System.out.println(c3 + "를 선택하셨습니다.");
							} else {
								System.out.println("잘못된 입력입니다.");
							}

							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							System.out.println("=======게임 결과=======");
							c1Score = (int) (Math.random() * 5);
							c2Score = (int) (Math.random() * 5);
							if (c1Score == c2Score) {
//								System.out.println(c1 + c1Score + " : " + c2 + c2Score);
								System.out.println(c1 +" "+ c1Score + " : " + c2Score+" " + c2 );
								System.out.println("무승부입니다.");
								result = "무승부";
								//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
								// 
								if (result.equals("무승부") && menu3 == 3) {
									
									
									price = (int) (price * 2);
									System.out.println("축하합니다! " + price + "원이 지급됩니다.");
									
									user.setAccount((int) (user.getAccount()+(price)));	// 게임성공 금액 지급
									System.out.println(user.getUserName() + " 님. (잔액 : " + user.getAccount() + " 원)");
									System.out.println();

								}else {
									System.out.println("베팅에 실패하였습니다!ㅠㅠ");
									System.out.println(user.getUserName() + " 님. (잔액 : " + user.getAccount() + " 원)");
									System.out.println();
								}
								return;
								//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

							} else if (c1Score > c2Score) {
//								System.out.println(c1 + c1Score + " : " + c2 + c2Score);
								System.out.println(c1 +" "+ c1Score + " : " + c2Score+" " + c2 );
								System.out.println(c1 + " 승입니다.");
								result = "대한민국";
								if (result.equals("대한민국") && menu3 == 1) {
									price = (int) (price * 1.8);
									System.out.println("축하합니다! " + price + "원이 지급됩니다.");
									
									user.setAccount((int) (user.getAccount()+(price)));	// 게임성공 금액 지급
									System.out.println(user.getUserName() + " 님. (잔액 : " + user.getAccount() + " 원)");
									System.out.println();
									

								}else {
									System.out.println("베팅에 실패하였습니다!ㅠㅠ");
									System.out.println(user.getUserName() + " 님. (잔액 : " + user.getAccount() + " 원)");
									System.out.println();
								}
								return;

							} else {
//								System.out.println(c1 + c1Score + " : " + c2 + c2Score);
								System.out.println(c1 +" "+ c1Score + " : " + c2Score+" " + c2 );
								System.out.println(c2 + " 승입니다.");
								result = "일본";
								if (result.equals("일본") && menu3 == 2) {
									price = (int) (price * 1.5);
									System.out.println("축하합니다! " + price + " 원이 지급됩니다.");
									
									user.setAccount((int) (user.getAccount()+(price)));	// 게임성공 금액 지급
									System.out.println(user.getUserName() + " 님. (잔액 : " + user.getAccount() + " 원)");
									System.out.println();

								}else {
									System.out.println("베팅에 실패하였습니다!ㅠㅠ");
									System.out.println(user.getUserName() + " 님. (잔액 : " + user.getAccount() + " 원)");
									System.out.println();
								}
								return;

							}
						}

					}
					break;
				case 2:
					while (menu2 != 9) {
						System.out.println("[2/27 21:00] [호주 VS 프랑스] 을 선택하셨습니다.");
						System.out.println("진행하시려면 1을 입력하세요. 다시 선택하시려면 9를 눌러주세요. ");

						menu2 = scan.nextInt();
						if (menu2 == 1) {

							System.out.println("===============배당 비율===============");
							System.out.println("호주 승 (X4) | 무승부 (X3) | 프랑스 승 (X1.3) ");
							System.out.println("호주를 선택하시려면 1, 프랑스를 선택하시려면 2를 눌러주세요.");
							System.out.println("무승부를 선택하시려면 3을 눌러주세요.");
							menu3 = scan.nextInt();
							System.out.println("배팅할 금액을 입력하세요.");
							price = scan.nextInt();
							
							if(user.getAccount()<price || user.getAccount()<=0) {
								System.out.println(user.getUserName() + " 님 배팅할 금액이 부족합니다. (잔액 : " + user.getAccount() + " 원)");
								System.out.println("*충전 후 이용해주세요.");
								return;
							}
							
							System.out.println("베팅 전 잔액 : "+user.getAccount());
							user.setAccount(user.getAccount()-price);
							System.out.println("*배팅완료");
							System.out.println("베팅 후 잔액 : "+user.getAccount());
							
							c1 = "호주";
							c2 = "프랑스";
							if (menu3 == 1) {
								System.out.println(c1 + "를 선택하셨습니다.");
							} else if (menu3 == 2) {
								System.out.println(c2 + "를 선택하셨습니다.");
							} else if (menu3 == 3) {
								System.out.println("무승부를 선택하셨습니다.");
							} else {
								System.out.println("잘못된 입력입니다.");
							}

							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							System.out.println("=======게임 결과=======");
							c1Score = (int) (Math.random() * 5);
							c2Score = (int) (Math.random() * 5);
							if (c1Score == c2Score) {
//								System.out.println(c1 + c1Score + " : " + c2 + c2Score);
								System.out.println(c1 +" "+ c1Score + " : " + c2Score+" " + c2 );
								System.out.println("무승부입니다.");
								result = "무승부";
								if (result.equals("무승부") && menu3 == 3) {
									price = (int) (price * 3);
									System.out.println("축하합니다! " + price + "원이 지급됩니다.");
									
									user.setAccount((int) (user.getAccount()+(price)));	// 게임성공 금액 지급
									System.out.println(user.getUserName() + " 님. (잔액 : " + user.getAccount() + " 원)");
									System.out.println();


								}else {
									System.out.println("베팅에 실패하였습니다!ㅠㅠ");
									System.out.println(user.getUserName() + " 님. (잔액 : " + user.getAccount() + " 원)");
									System.out.println();
								}
								return;
							} else if (c1Score > c2Score) {
//								System.out.println(c1 + c1Score + " : " + c2 + c2Score);
								System.out.println(c1 +" "+ c1Score + " : " + c2Score+" " + c2 );
								System.out.println(c1 + " 승입니다.");
								result = "호주";
								if (result.equals("호주") && menu3 == 1) {
									price = (int) (price * 4);
									System.out.println("축하합니다! " + price + "원이 지급됩니다.");
									
									user.setAccount((int) (user.getAccount()+(price)));	// 게임성공 금액 지급
									System.out.println(user.getUserName() + " 님. (잔액 : " + user.getAccount() + " 원)");
									System.out.println();


								}else {
									System.out.println("베팅에 실패하였습니다!ㅠㅠ");
									System.out.println(user.getUserName() + " 님. (잔액 : " + user.getAccount() + " 원)");
									System.out.println();
								}
								return;
							} else {
//								System.out.println(c1 + c1Score + " : " + c2 + c2Score);
								System.out.println(c1 +" "+ c1Score + " : " + c2Score+" " + c2 );
								System.out.println(c2 + " 승입니다.");
								result = "프랑스";
								if (result.equals("프랑스") && menu3 == 2) {
									price = (int) (price * 1.3);
									System.out.println("축하합니다! " + price + "원이 지급됩니다.");
									
									user.setAccount((int) (user.getAccount()+(price)));	// 게임성공 금액 지급
									System.out.println(user.getUserName() + " 님. (잔액 : " + user.getAccount() + " 원)");
									System.out.println();


								}else {
									System.out.println("베팅에 실패하였습니다!ㅠㅠ");
									System.out.println(user.getUserName() + " 님. (잔액 : " + user.getAccount() + " 원)");
									System.out.println();
								}
								return;
							}
						}

					}
					break;
				case 3:
					while (menu2 != 9) {

						System.out.println("[2/28 13:00] [노르웨이 VS 칠레 ] 을 선택하셨습니다.");
						System.out.println("진행하시려면 1을 입력하세요. 다시 선택하시려면 9를 눌러주세요. ");

						menu2 = scan.nextInt();
						if (menu2 == 1) {

							System.out.println("===============배당 비율===============");
							System.out.println("노르웨이 승 (X1.3) | 무승부 (X1.5) | 칠레 승 (X1.2) ");
							System.out.println("노르웨이를 선택하시려면 1, 칠레를 선택하시려면 2를 눌러주세요.");
							System.out.println("무승부를 선택하시려면 3을 눌러주세요.");

							menu3 = scan.nextInt();
							System.out.println("배팅할 금액을 입력하세요.");
							price = scan.nextInt();
							
							if(user.getAccount()<price || user.getAccount()<=0) {
								System.out.println(user.getUserName() + " 님 배팅할 금액이 부족합니다. (잔액 : " + user.getAccount() + " 원)");
								System.out.println("*충전 후 이용해주세요.");
								return;
							}
							
							System.out.println("베팅 전 잔액 : "+user.getAccount());
							user.setAccount(user.getAccount()-price);
							System.out.println("*배팅완료");
							System.out.println("베팅 후 잔액 : "+user.getAccount());
							
							c1 = "노르웨이";
							c2 = "칠레";
							if (menu3 == 1) {
								System.out.println(c1 + "를 선택하셨습니다.");
							} else if (menu3 == 2) {
								System.out.println(c2 + "를 선택하셨습니다.");
							} else if (menu3 == 3) {
								System.out.println("무승부를 선택하셨습니다.");
							} else {
								System.out.println("잘못된 입력입니다.");
							}

							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							System.out.println("=======게임 결과=======");
							c1Score = (int) (Math.random() * 5);
							c2Score = (int) (Math.random() * 5);
							if (c1Score == c2Score) {
//								System.out.println(c1 + c1Score + " : " + c2 + c2Score);
								System.out.println(c1 +" "+ c1Score + " : " + c2Score+" " + c2 );
								System.out.println("무승부입니다.");
								result = "무승부";
								if (result.equals("무승부") && menu3 == 3) {
									price = (int) (price * 1.5);
									System.out.println("축하합니다! " + price + "원이 지급됩니다.");
									
									user.setAccount((int) (user.getAccount()+(price)));	// 게임성공 금액 지급
									System.out.println(user.getUserName() + " 님. (잔액 : " + user.getAccount() + " 원)");
									System.out.println();

								}else {
									System.out.println("베팅에 실패하였습니다!ㅠㅠ");
									System.out.println(user.getUserName() + " 님. (잔액 : " + user.getAccount() + " 원)");
									System.out.println();
								}
								return;
							} else if (c1Score > c2Score) {
//								System.out.println(c1 + c1Score + " : " + c2 + c2Score);
								System.out.println(c1 +" "+ c1Score + " : " + c2Score+" " + c2 );
								System.out.println(c1 + " 승입니다.");
								result = "노르웨이";
								if (result.equals("노르웨이") && menu3 == 1) {
									price = (int) (price * 1.3);
									System.out.println("축하합니다! " + price + "원이 지급됩니다.");
									
									user.setAccount((int) (user.getAccount()+(price)));	// 게임성공 금액 지급
									System.out.println(user.getUserName() + " 님. (잔액 : " + user.getAccount() + " 원)");
									System.out.println();

								}else {
									System.out.println("베팅에 실패하였습니다!ㅠㅠ");
									System.out.println(user.getUserName() + " 님. (잔액 : " + user.getAccount() + " 원)");
									System.out.println();
								}
								return;
							} else {
//								System.out.println(c1 + c1Score + " : " + c2 + c2Score);
								System.out.println(c1 +" "+ c1Score + " : " + c2Score+" " + c2 );
								System.out.println(c2 + " 승입니다.");
								result = "칠레";
								if (result.equals("칠레") && menu3 == 2) {
									price = (int) (price * 1.3);
									System.out.println("축하합니다! " + price + "원이 지급됩니다.");
									
									user.setAccount((int) (user.getAccount()+(price)));	// 게임성공 금액 지급
									System.out.println(user.getUserName() + " 님. (잔액 : " + user.getAccount() + " 원)");
									System.out.println();

								}else {
									System.out.println("베팅에 실패하였습니다!ㅠㅠ");
									System.out.println(user.getUserName() + " 님. (잔액 : " + user.getAccount() + " 원)");
									System.out.println();
								}
								return;

							}
						}

					}

					break;
				case 4:
					while (menu2 != 9) {

						System.out.println("[2/29 00:00] [요르단 VS 캐나다] 을 선택하셨습니다.");
						System.out.println("진행하시려면 1을 입력하세요. 다시 선택하시려면 9를 눌러주세요. ");

						menu2 = scan.nextInt();
						if (menu2 == 1) {

							System.out.println("===============배당 비율===============");
							System.out.println("요르단 승 (X2.7) | 무승부 (X1.7) | 캐나다 승 (X1.4) ");
							System.out.println("요르단을 선택하시려면 1, 캐나다를 선택하시려면 2를 눌러주세요.");
							System.out.println("무승부를 선택하시려면 3을 눌러주세요.");

							menu3 = scan.nextInt();
							System.out.println("배팅할 금액을 입력하세요.");
							price = scan.nextInt();
							
							if(user.getAccount()<price || user.getAccount()<=0) {
								System.out.println(user.getUserName() + " 님 배팅할 금액이 부족합니다. (잔액 : " + user.getAccount() + " 원)");
								System.out.println("*충전 후 이용해주세요.");
								return;
							}
							
							System.out.println("베팅 전 잔액 : "+user.getAccount());
							user.setAccount(user.getAccount()-price);
							System.out.println("*배팅완료");
							System.out.println("베팅 후 잔액 : "+user.getAccount());
							
							c1 = "요르단";
							c2 = "캐나다";
							if (menu3 == 1) {
								System.out.println(c1 + "을 선택하셨습니다.");
							} else if (menu3 == 2) {
								System.out.println(c2 + "를 선택하셨습니다.");
							} else if (menu3 == 3) {
								System.out.println("무승부를 선택하셨습니다.");
							} else {
								System.out.println("잘못된 입력입니다.");
							}

							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							System.out.println("=======게임 결과=======");
							c1Score = (int) (Math.random() * 5);
							c2Score = (int) (Math.random() * 5);
							if (c1Score == c2Score) {
//								System.out.println(c1 + c1Score + " : " + c2 + c2Score);
								System.out.println(c1 +" "+ c1Score + " : " + c2Score+" " + c2 );
								System.out.println("무승부입니다.");
								result = "무승부";
								if (result.equals("무승부") && menu3 == 3) {
									price = (int) (price * 1.7);
									System.out.println("축하합니다! " + price + "원이 지급됩니다.");
									
									user.setAccount((int) (user.getAccount()+(price)));	// 게임성공 금액 지급
									System.out.println(user.getUserName() + " 님. (잔액 : " + user.getAccount() + " 원)");
									System.out.println();

								}else {
									System.out.println("베팅에 실패하였습니다!ㅠㅠ");
									System.out.println(user.getUserName() + " 님. (잔액 : " + user.getAccount() + " 원)");
									System.out.println();
								}
								return;
							} else if (c1Score > c2Score) {
//								System.out.println(c1 + c1Score + " : " + c2 + c2Score);
								System.out.println(c1 +" "+ c1Score + " : " + c2Score+" " + c2 );
								System.out.println(c1 + " 승입니다.");
								result = "요르단";
								if (result.equals("요르단") && menu3 == 1) {
									price = (int) (price * 2.7);
									System.out.println("축하합니다! " + price + "원이 지급됩니다.");
									
									user.setAccount((int) (user.getAccount()+(price)));	// 게임성공 금액 지급
									System.out.println(user.getUserName() + " 님. (잔액 : " + user.getAccount() + " 원)");
									System.out.println();

								}else {
									System.out.println("베팅에 실패하였습니다!ㅠㅠ");
									System.out.println(user.getUserName() + " 님. (잔액 : " + user.getAccount() + " 원)");
									System.out.println();
								}
								return;
							} else {
//								System.out.println(c1 + c1Score + " : " + c2 + c2Score);
								System.out.println(c1 +" "+ c1Score + " : " + c2Score+" " + c2 );
								System.out.println(c2 + " 승입니다.");
								result = "캐나다";
								if (result.equals("캐나다") && menu3 == 2) {
									price = (int) (price * 1.4);
									System.out.println("축하합니다! " + price + "원이 지급됩니다.");
									
									user.setAccount((int) (user.getAccount()+(price)));	// 게임성공 금액 지급
									System.out.println(user.getUserName() + " 님. (잔액 : " + user.getAccount() + " 원)");
									System.out.println();

								}else {
									System.out.println("베팅에 실패하였습니다!ㅠㅠ");
									System.out.println(user.getUserName() + " 님. (잔액 : " + user.getAccount() + " 원)");
									System.out.println();
								}
								return;

							}
						}

					}
					break;
				case 5:
					while (menu2 != 9) {

						System.out.println("⑤ [2/29 17:30] [대한민국 VS 아르헨티나] 을 선택하셨습니다.");
						System.out.println("진행하시려면 1을 입력하세요. 다시 선택하시려면 9를 눌러주세요. ");

						menu2 = scan.nextInt();
						if (menu2 == 1) {

							System.out.println("===============배당 비율===============");
							System.out.println("대한민국 승 (X7.8) | 무승부 (X5) | 아르헨티나 승 (X1.3) ");
							System.out.println("대한민국을 선택하시려면 1, 아르헨티나를 선택하시려면 2를 눌러주세요.");
							System.out.println("무승부를 선택하시려면 3을 눌러주세요.");

							menu3 = scan.nextInt();
							System.out.println("배팅할 금액을 입력하세요.");
							price = scan.nextInt();
							
							if(user.getAccount()<price || user.getAccount()<=0) {
								System.out.println(user.getUserName() + " 님 배팅할 금액이 부족합니다. (잔액 : " + user.getAccount() + " 원)");
								System.out.println("*충전 후 이용해주세요.");
								return;
							}
							
							System.out.println("베팅 전 잔액 : "+user.getAccount());
							user.setAccount(user.getAccount()-price);
							System.out.println("*배팅완료");
							System.out.println("베팅 후 잔액 : "+user.getAccount());
							
							c1 = "대한민국";
							c2 = "아르헨티나";
							if (menu3 == 1) {
								System.out.println(c1 + "을 선택하셨습니다.");
							} else if (menu3 == 2) {
								System.out.println(c2 + "를 선택하셨습니다.");
							} else {
								System.out.println("잘못된 입력입니다.");
							}

							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							System.out.println("=======게임 결과=======");
							c1Score = (int) (Math.random() * 5);
							c2Score = (int) (Math.random() * 5);
							if (c1Score == c2Score) {
//								System.out.println(c1 + c1Score + " : " + c2 + c2Score);
								System.out.println(c1 +" "+ c1Score + " : " + c2Score+" " + c2 );
								System.out.println("무승부입니다.");
								result = "무승부";
								if (result.equals("무승부") && menu3 == 3) {
									price = (int) (price * 5);
									System.out.println("축하합니다! " + price + "원이 지급됩니다.");
									
									user.setAccount((int) (user.getAccount()+(price)));	// 게임성공 금액 지급
									System.out.println(user.getUserName() + " 님. (잔액 : " + user.getAccount() + " 원)");
									System.out.println();


								}else {
									System.out.println("베팅에 실패하였습니다!ㅠㅠ");
									System.out.println(user.getUserName() + " 님. (잔액 : " + user.getAccount() + " 원)");
									System.out.println();
								}
								return;
							} else if (c1Score > c2Score) {
//								System.out.println(c1 + c1Score + " : " + c2 + c2Score);
								System.out.println(c1 +" "+ c1Score + " : " + c2Score+" " + c2 );
								System.out.println(c1 + " 승입니다.");
								result = "대한민국";
								if (result.equals("대한민국") && menu3 == 1) {
									price = (int) (price * 7.8);
									System.out.println("축하합니다! " + price + "원이 지급됩니다.");
									
									user.setAccount((int) (user.getAccount()+(price)));	// 게임성공 금액 지급
									System.out.println(user.getUserName() + " 님. (잔액 : " + user.getAccount() + " 원)");
									System.out.println();


								}else {
									System.out.println("베팅에 실패하였습니다!ㅠㅠ");
									System.out.println(user.getUserName() + " 님. (잔액 : " + user.getAccount() + " 원)");
									System.out.println();
								}
								return;
							} else {
//								System.out.println(c1 + c1Score + " : " + c2 + c2Score);
								System.out.println(c1 +" "+ c1Score + " : " + c2Score+" " + c2 );
								System.out.println(c2 + " 승입니다.");
								result = "아르헨티나";
								if (result.equals("아르헨티나") && menu3 == 2) {
									price = (int) (price * 1.3);
									System.out.println("축하합니다! " + price + "원이 지급됩니다.");
									
									user.setAccount((int) (user.getAccount()+(price)));	// 게임성공 금액 지급
									System.out.println(user.getUserName() + " 님. (잔액 : " + user.getAccount() + " 원)");
									System.out.println();


								}else {
									System.out.println("베팅에 실패하였습니다!ㅠㅠ");
									System.out.println(user.getUserName() + " 님. (잔액 : " + user.getAccount() + " 원)");
									System.out.println();
								}
								return;

							}
						}

					}
					break;
				case 6:
					while (menu2 != 9) {

						System.out.println("⑥ [3/1 22:00]  [이탈리아 VS 포르투갈] 을 선택하셨습니다.");
						System.out.println("진행하시려면 1을 입력하세요. 다시 선택하시려면 9를 눌러주세요. ");

						menu2 = scan.nextInt();
						if (menu2 == 1) {

							System.out.println("===============배당 비율===============");
							System.out.println("이탈리아 승 (X1.7) | 무승부 (X3) | 포르투갈 승 (X1.6) ");
							System.out.println("이탈리아를 선택하시려면 1, 포르투갈을 선택하시려면 2를 눌러주세요.");
							System.out.println("무승부를 선택하시려면 3을 눌러주세요.");

							menu3 = scan.nextInt();
							System.out.println("배팅할 금액을 입력하세요.");
							price = scan.nextInt();
							
							if(user.getAccount()<price || user.getAccount()<=0) {
								System.out.println(user.getUserName() + " 님 배팅할 금액이 부족합니다. (잔액 : " + user.getAccount() + " 원)");
								System.out.println("*충전 후 이용해주세요.");
								return;
							}
							
							System.out.println("베팅 전 잔액 : "+user.getAccount());
							user.setAccount(user.getAccount()-price);
							System.out.println("*배팅완료");
							System.out.println("베팅 후 잔액 : "+user.getAccount());
							
							c1 = "이탈리아";
							c2 = "포르투갈";
							if (menu3 == 1) {
								System.out.println(c1 + "를 선택하셨습니다.");
							} else if (menu3 == 2) {
								System.out.println(c2 + "을 선택하셨습니다.");
							} else if (menu3 == 3) {
								System.out.println("무승부를 선택하셨습니다.");
							} else {
								System.out.println("잘못된 입력입니다.");
							}

							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							System.out.println("=======게임 결과=======");
							c1Score = (int) (Math.random() * 5);
							c2Score = (int) (Math.random() * 5);
							if (c1Score == c2Score) {
//								System.out.println(c1 + c1Score + " : " + c2 + c2Score);
								System.out.println(c1 +" "+ c1Score + " : " + c2Score+" " + c2 );
								System.out.println("무승부입니다.");
								result = "무승부";
								if (result.equals("무승부") && menu3 == 3) {
									price = (int) (price * 3);
									System.out.println("축하합니다! " + price + "원이 지급됩니다.");
									
									user.setAccount((int) (user.getAccount()+(price)));	// 게임성공 금액 지급
									System.out.println(user.getUserName() + " 님. (잔액 : " + user.getAccount() + " 원)");
									System.out.println();

								}else {
									System.out.println("베팅에 실패하였습니다!ㅠㅠ");
									System.out.println(user.getUserName() + " 님. (잔액 : " + user.getAccount() + " 원)");
									System.out.println();
								}
								return;
							} else if (c1Score > c2Score) {
//								System.out.println(c1 + c1Score + " : " + c2 + c2Score);
								System.out.println(c1 +" "+ c1Score + " : " + c2Score+" " + c2 );
								System.out.println(c1 + " 승입니다.");
								result = "이탈리아";
								if (result.equals("이탈리아") && menu3 == 1) {
									price = (int) (price * 1.7);
									System.out.println("축하합니다! " + price + "원이 지급됩니다.");
									
									user.setAccount((int) (user.getAccount()+(price)));	// 게임성공 금액 지급
									System.out.println(user.getUserName() + " 님. (잔액 : " + user.getAccount() + " 원)");
									System.out.println();

								}else {
									System.out.println("베팅에 실패하였습니다!ㅠㅠ");
									System.out.println(user.getUserName() + " 님. (잔액 : " + user.getAccount() + " 원)");
									System.out.println();
								}
								return;
							} else {
//								System.out.println(c1 + c1Score + " : " + c2 + c2Score);
								System.out.println(c1 +" "+ c1Score + " : " + c2Score+" " + c2 );
								System.out.println(c2 + " 승입니다.");
								result = "포르투갈";
								if (result.equals("포르투갈") && menu3 == 2) {
									price = (int) (price * 1.6);
									System.out.println("축하합니다! " + price + "원이 지급됩니다.");
									
									user.setAccount((int) (user.getAccount()+(price)));	// 게임성공 금액 지급
									System.out.println(user.getUserName() + " 님. (잔액 : " + user.getAccount() + " 원)");
									System.out.println();

								}else {
									System.out.println("베팅에 실패하였습니다!ㅠㅠ");
									System.out.println(user.getUserName() + " 님. (잔액 : " + user.getAccount() + " 원)");
									System.out.println();
								}
								return;

							}
						}

					}
					break;
				case 7:
					while (menu2 != 9) {

						System.out.println("⑦ [3/1 23:00]  [러시아 VS 가나] 을 선택하셨습니다.");
						System.out.println("진행하시려면 1을 입력하세요. 다시 선택하시려면 9를 눌러주세요. ");

						menu2 = scan.nextInt();
						if (menu2 == 1) {

							System.out.println("===============배당 비율===============");
							System.out.println("러시아 승 (X1.8) | 무승부 (X3) | 가나 승 (X3.1) ");
							System.out.println("러시아를 선택하시려면 1, 가나를 선택하시려면 2를 눌러주세요.");
							System.out.println("무승부를 선택하시려면 3을 눌러주세요.");

							menu3 = scan.nextInt();
							System.out.println("배팅할 금액을 입력하세요.");
							price = scan.nextInt();
							
							if(user.getAccount()<price || user.getAccount()<=0) {
								System.out.println(user.getUserName() + " 님 배팅할 금액이 부족합니다. (잔액 : " + user.getAccount() + " 원)");
								System.out.println("*충전 후 이용해주세요.");
								return;
							}
							
							System.out.println("베팅 전 잔액 : "+user.getAccount());
							user.setAccount(user.getAccount()-price);
							System.out.println("*배팅완료");
							System.out.println("베팅 후 잔액 : "+user.getAccount());
							
							c1 = "러시아";
							c2 = "가나";
							if (menu3 == 1) {
								System.out.println(c1 + "를 선택하셨습니다.");
							} else if (menu3 == 2) {
								System.out.println(c2 + "를 선택하셨습니다.");
							} else if (menu3 == 3) {
								System.out.println("무승부를 선택하셨습니다.");
							} else {
								System.out.println("잘못된 입력입니다.");
							}
							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							System.out.println("=======게임 결과=======");
							c1Score = (int) (Math.random() * 5);
							c2Score = (int) (Math.random() * 5);
							if (c1Score == c2Score) {
//								System.out.println(c1 + c1Score + " : " + c2 + c2Score);
								System.out.println(c1 +" "+ c1Score + " : " + c2Score+" " + c2 );
								System.out.println("무승부입니다.");
								result = "무승부";
								if (result.equals("무승부") && menu3 == 3) {
									price = (int) (price * 3);
									System.out.println("축하합니다! " + price + "원이 지급됩니다.");
									
									user.setAccount((int) (user.getAccount()+(price)));	// 게임성공 금액 지급
									System.out.println(user.getUserName() + " 님. (잔액 : " + user.getAccount() + " 원)");
									System.out.println();

								}else {
									System.out.println("베팅에 실패하였습니다!ㅠㅠ");
									System.out.println(user.getUserName() + " 님. (잔액 : " + user.getAccount() + " 원)");
									System.out.println();
								}
								return;
							} else if (c1Score > c2Score) {
//								System.out.println(c1 + c1Score + " : " + c2 + c2Score);
								System.out.println(c1 +" "+ c1Score + " : " + c2Score+" " + c2 );
								System.out.println(c1 + " 승입니다.");
								result = "러시아";
								if (result.equals("러시아") && menu3 == 1) {
									price = (int) (price * 1.8);
									System.out.println("축하합니다! " + price + "원이 지급됩니다.");
									
									user.setAccount((int) (user.getAccount()+(price)));	// 게임성공 금액 지급
									System.out.println(user.getUserName() + " 님. (잔액 : " + user.getAccount() + " 원)");
									System.out.println();

								}else {
									System.out.println("베팅에 실패하였습니다!ㅠㅠ");
									System.out.println(user.getUserName() + " 님. (잔액 : " + user.getAccount() + " 원)");
									System.out.println();
								}
								return;
							} else {
//								System.out.println(c1 + c1Score + " : " + c2 + c2Score);
								System.out.println(c1 +" "+ c1Score + " : " + c2Score+" " + c2 );
								System.out.println(c2 + " 승입니다.");
								result = "가나";
								if (result.equals("가나") && menu3 == 2) {
									price = (int) (price * 3.1);
									System.out.println("축하합니다! " + price + "원이 지급됩니다.");
									
									user.setAccount((int) (user.getAccount()+(price)));	// 게임성공 금액 지급
									System.out.println(user.getUserName() + " 님. (잔액 : " + user.getAccount() + " 원)");
									System.out.println();

								}else {
									System.out.println("베팅에 실패하였습니다!ㅠㅠ");
									System.out.println(user.getUserName() + " 님. (잔액 : " + user.getAccount() + " 원)");
									System.out.println();
								}
								return;

							}
						}

					}
					break;
				case 8:
					while (menu2 != 9) {
						System.out.println("⑧ [3/2 04:00]  [페루 VS 스코틀랜드] 을 선택하셨습니다.");
						System.out.println("진행하시려면 1을 입력하세요. 다시 선택하시려면 9를 눌러주세요. ");

						menu2 = scan.nextInt();
						if (menu2 == 1) {

							System.out.println("===============배당 비율===============");
							System.out.println("페루 승 (X1.4) | 무승부 (X3.4) | 스코틀랜드 승 (X1.5) ");
							System.out.println("페루를 선택하시려면 1, 스코틀랜드를 선택하시려면 2를 눌러주세요.");
							System.out.println("무승부를 선택하시려면 3을 눌러주세요.");

							menu3 = scan.nextInt();
							System.out.println("배팅할 금액을 입력하세요.");
							price = scan.nextInt();
							
							if(user.getAccount()<price || user.getAccount()<=0) {
								System.out.println(user.getUserName() + " 님 배팅할 금액이 부족합니다. (잔액 : " + user.getAccount() + " 원)");
								System.out.println("*충전 후 이용해주세요.");
								return;
							}
							
							System.out.println("베팅 전 잔액 : "+user.getAccount());
							user.setAccount(user.getAccount()-price);
							System.out.println("*배팅완료");
							System.out.println("베팅 후 잔액 : "+user.getAccount());
							
							c1 = "페루";
							c2 = "스코틀랜드";
							if (menu3 == 1) {
								System.out.println(c1 + "를 선택하셨습니다.");
							} else if (menu3 == 2) {
								System.out.println(c2 + "를 선택하셨습니다.");
							} else if (menu3 == 3) {
								System.out.println("무승부를 선택하셨습니다.");
							} else {
								System.out.println("잘못된 입력입니다.");
							}
							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							System.out.println("=======게임 결과=======");
							c1Score = (int) (Math.random() * 5);
							c2Score = (int) (Math.random() * 5);
							if (c1Score == c2Score) {
//								System.out.println(c1 + c1Score + " : " + c2 + c2Score);
								System.out.println(c1 +" "+ c1Score + " : " + c2Score+" " + c2 );
								System.out.println("무승부입니다.");
								result = "무승부";
								if (result.equals("무승부") && menu3 == 3) {
									price = (int) (price * 3.4);
									System.out.println("축하합니다! " + price + "원이 지급됩니다.");
									
									user.setAccount((int) (user.getAccount()+(price)));	// 게임성공 금액 지급
									System.out.println(user.getUserName() + " 님. (잔액 : " + user.getAccount() + " 원)");
									System.out.println();

								}else {
									System.out.println("베팅에 실패하였습니다!ㅠㅠ");
									System.out.println(user.getUserName() + " 님. (잔액 : " + user.getAccount() + " 원)");
									System.out.println();
								}
								return;
							} else if (c1Score > c2Score) {
//								System.out.println(c1 + c1Score + " : " + c2 + c2Score);
								System.out.println(c1 +" "+ c1Score + " : " + c2Score+" " + c2 );
								System.out.println(c1 + " 승입니다.");
								result = "페루";
								if (result.equals("페루") && menu3 == 1) {
									price = (int) (price * 1.4);
									System.out.println("축하합니다! " + price + "원이 지급됩니다.");
									
									user.setAccount((int) (user.getAccount()+(price)));	// 게임성공 금액 지급
									System.out.println(user.getUserName() + " 님. (잔액 : " + user.getAccount() + " 원)");
									System.out.println();

								}else {
									System.out.println("베팅에 실패하였습니다!ㅠㅠ");
									System.out.println(user.getUserName() + " 님. (잔액 : " + user.getAccount() + " 원)");
									System.out.println();
								}
								return;
							} else {
//								System.out.println(c1 + c1Score + " : " + c2 + c2Score);
								System.out.println(c1 +" "+ c1Score + " : " + c2Score+" " + c2 );
								System.out.println(c2 + " 승입니다.");
								result = "스코틀랜드";
								if (result.equals("스코틀랜드") && menu3 == 2) {
									price = (int) (price * 1.5);
									System.out.println("축하합니다! " + price + "원이 지급됩니다.");
									
									user.setAccount((int) (user.getAccount()+(price)));	// 게임성공 금액 지급
									System.out.println(user.getUserName() + " 님. (잔액 : " + user.getAccount() + " 원)");
									System.out.println();

								}else {
									System.out.println("베팅에 실패하였습니다!ㅠㅠ");
									System.out.println(user.getUserName() + " 님. (잔액 : " + user.getAccount() + " 원)");
									System.out.println();
								}
								return;

							}
						}

					}
					break;
				case 9:
					while (menu2 != 9) {
						System.out.println("⑨ [3/3 14:00]  [대한민국 VS 브라질] 을 선택하셨습니다.");
						System.out.println("진행하시려면 1을 입력하세요. 다시 선택하시려면 9를 눌러주세요. ");

						menu2 = scan.nextInt();
						if (menu2 == 1) {

							System.out.println("===============배당 비율===============");
							System.out.println("대한민국 승 (X10) | 무승부 (X7.3) | 브라질 승 (X1.2) ");
							System.out.println("대한민국을 선택하시려면 1, 브라질을 선택하시려면 2를 눌러주세요.");
							System.out.println("무승부를 선택하시려면 3을 눌러주세요.");

							menu3 = scan.nextInt();
							System.out.println("배팅할 금액을 입력하세요.");
							price = scan.nextInt();
							
							if(user.getAccount()<price || user.getAccount()<=0) {
								System.out.println(user.getUserName() + " 님 배팅할 금액이 부족합니다. (잔액 : " + user.getAccount() + " 원)");
								System.out.println("*충전 후 이용해주세요.");
								return;
							}
							
							System.out.println("베팅 전 잔액 : "+user.getAccount());
							user.setAccount(user.getAccount()-price);
							System.out.println("*배팅완료");
							System.out.println("베팅 후 잔액 : "+user.getAccount());

							
							c1 = "대한민국";
							c2 = "브라질";
							if (menu3 == 1) {
								System.out.println(c1 + "을 선택하셨습니다.");
							} else if (menu3 == 2) {
								System.out.println(c2 + "을 선택하셨습니다.");
							} else if (menu3 == 3) {
								System.out.println("무승부를 선택하셨습니다.");
							} else {
								System.out.println("잘못된 입력입니다.");

							}
							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							System.out.println("=======게임 결과=======");
							c1Score = (int) (Math.random() * 5);
							c2Score = (int) (Math.random() * 5);
							if (c1Score == c2Score) {
//								System.out.println(c1 + c1Score + " : " + c2 + c2Score);
								System.out.println(c1 +" "+ c1Score + " : " + c2Score+" " + c2 );
								System.out.println("무승부입니다.");
								result = "무승부";
								if (result.equals("무승부") && menu3 == 3) {
									price = (int) (price * 7.3);
									System.out.println("축하합니다! " + price + "원이 지급됩니다.");
									
									user.setAccount((int) (user.getAccount()+(price)));	// 게임성공 금액 지급
									System.out.println(user.getUserName() + " 님. (잔액 : " + user.getAccount() + " 원)");
									System.out.println();


								}else {
									System.out.println("베팅에 실패하였습니다!ㅠㅠ");
									System.out.println(user.getUserName() + " 님. (잔액 : " + user.getAccount() + " 원)");
									System.out.println();
								}
								return;
							} else if (c1Score > c2Score) {
//								System.out.println(c1 + c1Score + " : " + c2 + c2Score);
								System.out.println(c1 +" "+ c1Score + " : " + c2Score+" " + c2 );
								System.out.println(c1 + " 승입니다.");
								result = "대한민국";
								if (result.equals("대한민국") && menu3 == 1) {
									price = (int) (price * 10);
									System.out.println("축하합니다! " + price + "원이 지급됩니다.");
									
									user.setAccount((int) (user.getAccount()+(price)));	// 게임성공 금액 지급
									System.out.println(user.getUserName() + " 님. (잔액 : " + user.getAccount() + " 원)");
									System.out.println();


								}else {
									System.out.println("베팅에 실패하였습니다!ㅠㅠ");
									System.out.println(user.getUserName() + " 님. (잔액 : " + user.getAccount() + " 원)");
									System.out.println();
								}
								return;
							} else {
//								System.out.println(c1 + c1Score + " : " + c2 + c2Score);
								System.out.println(c1 +" "+ c1Score + " : " + c2Score+" " + c2 );
								System.out.println(c2 + " 승입니다.");
								result = "브라질";
								if (result.equals("브라질") && menu3 == 2) {
									price = (int) (price * 1.2);
									System.out.println("축하합니다! " + price + "원이 지급됩니다.");
									
									user.setAccount((int) (user.getAccount()+(price)));	// 게임성공 금액 지급
									System.out.println(user.getUserName() + " 님. (잔액 : " + user.getAccount() + " 원)");
									System.out.println();


								}else {
									System.out.println("베팅에 실패하였습니다!ㅠㅠ");
									System.out.println(user.getUserName() + " 님. (잔액 : " + user.getAccount() + " 원)");
									System.out.println();
								}
								return;

							}
						}

					}
					break;
				case 10:
					while (menu2 != 9) {
						System.out.println("⑩ [3/4 21:00][스페인 VS 모로코] 경기를 선택하셨습니다.");
						System.out.println("진행하시려면 1을 입력하세요. 다시 선택하시려면 9를 눌러주세요. ");

						menu2 = scan.nextInt();
						if (menu2 == 1) {

							System.out.println("===============배당 비율===============");
							System.out.println("스페인 승 (X1.7) | 무승부 (X2.8) | 모로코 승 (X2.2) ");
							System.out.println("스페인을 선택하시려면 1, 모로코를 선택하시려면 2를 눌러주세요.");
							System.out.println("무승부를 선택하시려면 3을 눌러주세요.");

							menu3 = scan.nextInt();
							System.out.println("배팅할 금액을 입력하세요.");
							price = scan.nextInt();
							
							if(user.getAccount()<price || user.getAccount()<=0) {
								System.out.println(user.getUserName() + " 님 배팅할 금액이 부족합니다. (잔액 : " + user.getAccount() + " 원)");
								System.out.println("*충전 후 이용해주세요.");
								return;
							}
							
							System.out.println("베팅 전 잔액 : "+user.getAccount());
							user.setAccount(user.getAccount()-price);
							System.out.println("*배팅완료");
							System.out.println("베팅 후 잔액 : "+user.getAccount());
							
							c1 = "스페인";
							c2 = "모로코";
							if (menu3 == 1) {
								System.out.println(c1 + "을 선택하셨습니다.");
							} else if (menu3 == 2) {
								System.out.println(c2 + "를 선택하셨습니다.");
							} else if (menu3 == 3) {
								System.out.println("무승부를 선택하셨습니다.");
							} else {
								System.out.println("잘못된 입력입니다.");
							}
							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							System.out.println("=======게임 결과=======");
							c1Score = (int) (Math.random() * 5);
							c2Score = (int) (Math.random() * 5);
							if (c1Score == c2Score) {
//								System.out.println(c1 + c1Score + " : " + c2 + c2Score);
								System.out.println(c1 +" "+ c1Score + " : " + c2Score+" " + c2 );
								System.out.println("무승부입니다.");
								result = "무승부";
								if (result.equals("무승부") && menu3 == 3) {
									price = (int) (price * 2.8);
									System.out.println("축하합니다! " + price + "원이 지급됩니다.");
									
									user.setAccount((int) (user.getAccount()+(price)));	// 게임성공 금액 지급
									System.out.println(user.getUserName() + " 님. (잔액 : " + user.getAccount() + " 원)");
									System.out.println();


								}else {
									System.out.println("베팅에 실패하였습니다!ㅠㅠ");
									System.out.println(user.getUserName() + " 님. (잔액 : " + user.getAccount() + " 원)");
									System.out.println();
								}
								return;
							} else if (c1Score > c2Score) {
//								System.out.println(c1 + c1Score + " : " + c2 + c2Score);
								System.out.println(c1 +" "+ c1Score + " : " + c2Score+" " + c2 );
								System.out.println(c1 + " 승입니다.");
								result = "스페인";
								if (result.equals("스페인") && menu3 == 1) {
									price = (int) (price * 1.7);
									System.out.println("축하합니다! " + price + "원이 지급됩니다.");
									
									user.setAccount((int) (user.getAccount()+(price)));	// 게임성공 금액 지급
									System.out.println(user.getUserName() + " 님. (잔액 : " + user.getAccount() + " 원)");
									System.out.println();


								}else {
									System.out.println("베팅에 실패하였습니다!ㅠㅠ");
									System.out.println(user.getUserName() + " 님. (잔액 : " + user.getAccount() + " 원)");
									System.out.println();
								}
								return;
							} else {
//								System.out.println(c1 + c1Score + " : " + c2 + c2Score);
								System.out.println(c1 +" "+ c1Score + " : " + c2Score+" " + c2 );
								System.out.println(c2 + " 승입니다.");
								result = "모로코";
								if (result.equals("모로코") && menu3 == 2) {
									price = (int) (price * 2.2);
									System.out.println("축하합니다 " + price + "원이 지급됩니다.");
									
									user.setAccount((int) (user.getAccount()+(price)));	// 게임성공 금액 지급
									System.out.println(user.getUserName() + " 님. (잔액 : " + user.getAccount() + " 원)");
									System.out.println();


								}else {
									System.out.println("베팅에 실패하였습니다!ㅠㅠ");
									System.out.println(user.getUserName() + " 님. (잔액 : " + user.getAccount() + " 원)");
									System.out.println();
								}
								return;

							}
						}

					}
					break;
				}

				break;
			case 3:
				System.out.println("종료합니다.");
				break;
			default:
				System.out.println("잘못된 입력입니다.");
				break;
			}

		} while (menu1 != 3);

	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "EzenSoccerManager [price=" + price + "]";
	}

}