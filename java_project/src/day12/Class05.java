package day12;

public class Class05 {
	
	/* - 객체를 생성할 때 값을 초기화하는 방법
	 * - 기본값, 명시적 초기값, 초기화 블럭, 생성자
	 * 1. 기본값 : 기본적으로 지정되는 값. int => 0, String => null
	 * 2. 명시적 초기값 : 멤버변수를 선언함과 동시에 값을 지정하는 방법
	 * 		private String name = "홍길동";
	 * 3. 초기화 블럭 : {		} 멤버변수를 초기화
	 * 4. 생성자 : 객체를 생성할 때 초기화 해서 생성
	 * 
	 * 초기값의 우선순위 
	 * 기본값 > 명시적 초기값 > 초기화 블럭 > 생성자(가장 우선순위가 높음)
	 */
	
	public static void main(String[] args) {
		
		
		EzenStudent ez = new EzenStudent("인천","철수","java","1111");
		// toString() 메서드가 없으면 객체의 주소가 출력
		// toString() 메서드가 있으면 toString()이 출력
		System.out.println(ez);
		//System.out.println(ez.toString()); // ez.toSting()도 가능
		
		EzenStudent ez1 = new EzenStudent("강남","영희","java","2222");
		System.out.println(ez1);
		
		EzenStudent ez2 = new EzenStudent();
		System.out.println(ez2);
		
		System.out.println();
		// 학생 5명 생성
		EzenStudent ez3 = new EzenStudent("인천","학생1","java","3333");
		System.out.println(ez3);
		EzenStudent ez4 = new EzenStudent("강북","학생2","java","4444");
		System.out.println(ez4);
		EzenStudent ez5 = new EzenStudent("인천","학생3","빅데이터","5555");
		System.out.println(ez5);
		EzenStudent ez6 = new EzenStudent("부천","학생4","빅데이터","6666");
		System.out.println(ez6);
		EzenStudent ez7 = new EzenStudent("부산","학생5","java","7777");
		System.out.println(ez7);
		
		// 학생 정보를 담을 배열을 생성
		// studentArr (변수명, 메서드명 소문자 / 클래스명 대문자 시작)
		EzenStudent[] StudentArr = new EzenStudent[7];
		StudentArr[0] = ez;
		StudentArr[1] = ez1;
		StudentArr[2] = ez3;
		StudentArr[3] = ez4;
		StudentArr[4] = ez5;
		StudentArr[5] = ez6;
		StudentArr[6] = ez7;
		
		//  학생4가 듣고 있는 과목을 출력
		String searchName = "학생4";
		System.out.println("--- "+searchName+"가 듣고 있는 과목 ---");
		for (int i=0; i<StudentArr.length; i++) {
			if (StudentArr[i].getName().equals(searchName)) { //StudentArr배열의 Name을 불러와서 searchName이 포함된다면
				System.out.println(StudentArr[i].getGroup());
			}
		}
		
		//학생2가 자바를 들으려고 했는데, 빅데이터로 변경
		String modify = "학생2";
		System.out.println("--- "+ modify+"의 그룹을 자바에서 빅데이터로 변경 ---");
		for (int i=0; i<StudentArr.length; i++) {
			if (StudentArr[i].getName().equals(modify)) {
				StudentArr[i].setGroup("빅데이터");
				System.out.println(StudentArr[i]);
			}
		}
		
		// 자바를 듣고있는 학생 명단을 출력. 학생이 없으면 명단이 없습니다. 출력
		String subject = "빅데이터";
		int count = 0;
		
		System.out.println("--- "+ subject+"을(를) 듣고있는 학생 명단 ---");
		
		for (int i=0; i<StudentArr.length; i++) {
			if (StudentArr[i].getGroup().equals(subject)) {
				System.out.println(StudentArr[i]);
				count++;
				}	
			} if (count ==0) {
				System.out.println(subject+"을(를) 듣고 있는 학생은 없습니다.");
			}
	}
}

class EzenStudent {
	private String gigum = "incheon"; // 명시적 초기값
	private String name; // 기본 초기값 : null
	private String group;
	private String phone;
	
	// 학생 정보를 생성하는 클래스
	public EzenStudent () { // 기본 생성자. source => generate constructor using field
		
	}


	public EzenStudent(String gigum, String name, String group, String phone) {
//		super(); // 내 부모 클래스의 생성자 호출 (아직은 사용X)
		this.gigum = gigum;
		this.name = name;
		this.group = group;
		this.phone = phone;
	}

	{
		//초기화 블럭 영역
		gigum = "인천";
		name = "미상";
		group = "미정";
		phone = "0000";
	}
	
	// toString. [source => generate toString()] : print 메서드와 비슷한 일을 함.
	@Override // 바꿔서 쓸때 사용
	public String toString() { // 클래스 내부에서 주는 출력 메서드
		return gigum + " > " + name + " (" + group + "/" + phone + ")"; // 수정 가능
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getGroup() {
		return group;
	}


	public void setGroup(String group) {
		this.group = group;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}