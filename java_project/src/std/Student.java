package std;

import java.util.HashMap;
import java.util.Objects;

import javax.security.auth.Subject;

public class Student {
	/* 멤버 변수 : 이름, 나이, 전화번호, map (과목/점수), 힙계, 평균
	 * 생성자, 메서드, getter/setter, 출력메서드 (toString)
	 * 
	 * 메서드
	 * 	- 출력 메서드(학생정보, 과목점수(성적표), 합계, 평균 )
	 * 	- map (과목,점수) 데이터를 '추가'하는 메서드
	 *  - map (과목,점수) 데이터를 '삭제'하는 메서드
	 */
	
	// 멤버변수는 private 설정 / 메서드는 public
	// 클래스명은 대문자로 시작.
	// 변수명, 메서드명은 소문자로 시작.
	//  - 변수명, 메서드명에 단어가 많아지면 다음 시작단어 대문자 (카멜케이스 기법)
	// indent : 들여쓰기 잘 맞추기
	
	private String name;
	private int age;
	private String phone;
	private HashMap<String, Integer> subject = new HashMap<>();	
	private int sum;
	private double avg;

	
	// 기본 생성자
	public Student() {
		
	}

	// 생성자
	public Student(String name) {
		this.name = name;
		this.age = 15;
	}
	
	public Student(String name, int age, String phone) {
		this.name = name;
		this.age = age;
		this.phone = phone;
	}
	// 출력 메서드
	// 학생 1명의 정보 출력
	public void printOne() {
		System.out.println(name+"("+age+") / ");
		if (phone != null) {
			System.out.println(phone);
		}
		if(subject.size()<=0) {
			System.out.println("점수가 없습니다.");
			System.out.println("------------");
			return;
		}
		printSub();
		calc();
		System.out.println("result: "+sum+"["+avg+"]");
		System.out.println("------------");
	 }
	
	// 학생의 성적표 출력 - map 출력
	public void printSub() {
		System.out.println("------------");
		for(String sub:subject.keySet() ) {
			System.out.println(sub+":"+subject.get(sub));
		}
		System.out.println("------------");
	}
	
	// 합계 평균 계산 
	public void calc() {
		this.sum = 0;
		this.avg = 0;
		for(String sub : subject.keySet()) {
			sum += subject.get(sub);
		}
		avg = (double) sum / subject.size();
	}
	
	// 과목 추가
	public void addSubject(String sub, int score) {
		subject.put(sub,score);
		System.out.println("점수 추가");
	}
	
	// 과목 삭제
	public void delSubject(String sub) {
		
		if(subject.remove(sub) == null) {
			System.out.println("해당 과목이 없습니다.");
			return;
		}
	}

	
	// getter / setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", phone=" + phone + ", sum=" + sum
				+ ", avg=" + avg + "]";
	}

	// source => Generate hashCode() and equals()
	@Override
	public int hashCode() {
		return Objects.hash(age, avg, name, phone, subject, sum);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) // 주소가 내 객체의 주소와 같다면 ture
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass()) // 클래스 정보가 다르다면 false
			return false;
		Student other = (Student) obj;
		return Objects.equals(name, other.name); // 이름만 같다면 true
	}
	
	
	
}


