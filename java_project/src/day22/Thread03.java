package day22;

class JoinTest extends Thread{

	int start;
	int end;
	int total;
	
	public JoinTest(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	public void run() {
		for(int i=start; i<=end; i++) {
			this.total += i;	
		}
	}
	
}

class JoinTest2 extends Thread{

	int start;
	int end;
	int total;
	
	public JoinTest2(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	
	
	@Override
	public void run() {
		for(int i=start; i<=end; i++) {
			this.total += i;	
		}
	}
	
}



public class Thread03 {

	public static void main(String[] args) {
		// 1 ~ 50, 51 ~ 100 까지의 합을 구하는 두 개의 Thread를 생성
		// 그 결과를 확인
		
		// 두 개의 Thread가 실행되고 난 후,
		// Thread1 1 ~ 50 까지의 합계 출력
		// Thread2 51 ~ 100 까지의 합계 출력
		// Thread1 + Thread2의 합계 출력

		
		JoinTest jt1 = new JoinTest(1, 50);
		JoinTest jt2 = new JoinTest(51, 100);
		jt1.start();
		jt2.start();
	
		try {
			jt1.join();
			Thread.sleep(1000); // 1초 기다렸다가 실행. 0.5초 = 500
			jt2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("jt1 total = "+jt1.total);
		System.out.println("jt2 total = "+jt2.total);
		
		try {
			Thread.sleep(1000); // 1초 기다렸다가 실행. 0.5초 = 500
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("jt1 + jt2"+" = "+ (jt1.total + jt2.total));
	}

}
