package std;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class stdManager implements stdProgram{

	// 학생 리스트 생성 후 stdProgram 메서드 구현
	private ArrayList<Student> list = new ArrayList<>();
	
	public void add() {
		list.add(new Student("홍길동"));
		list.add(new Student("김영이"));
		list.add(new Student("이순신"));
		list.add(new Student("강감찬"));
		list.add(new Student("박순이"));
	}

	@Override
	public void printStd() {
		for(int i=0; i<list.size(); i++) {
			list.get(i).printOne();
		}
	}

	@Override
	public void addStd(Scanner scan) {
		System.out.println("학생명 >");
		String name = scan.next();
		System.out.println("나이 >");
		int age = scan.nextInt();
		System.out.println("전화번호 >");
		String phone = scan.next();
		
		Student s = new Student(name, age, phone);
		
		list.add(s);
		System.out.println("학생 추가 완료");
	}

	@Override
	public void searchStd(Scanner scan) {
		System.out.println("학생명 >");
		String name = scan.next();
		if (list.contains(new Student(name)));{
			for(Student s : list) {
				if(s.getName().equals(name)) {
					s.printOne();
					return;
				}
			}
			System.out.println("검색된 학생이 없습니다.");
		}
	}
	
	@Override
	public void modStd(Scanner scan) {
		System.out.println("학생명 >");
		String name = scan.next();
		for (int i=0; i<list.size(); i++) {
			if (list.get(i).getName().equals(name)) {
				System.out.println("수정할 정보 (이름, 나이, 전화번호 중 하나 입력) > ");
				String op = scan.next();
				System.out.println("수정할 값 입력 >");
				switch (op) {
				case "이름":
					String modName = scan.next();
					list.get(i).setName(modName);
					break;
				case "나이":
					int modAge = scan.nextInt();
					list.get(i).setAge(modAge);
					break;
				case "전화번호":
					String modPhone = scan.next();
					list.get(i).setPhone(modPhone);
					break;
				default: System.out.println("정보가 존재하지 않습니다.");
					break;
				}
				System.out.println("수정 완료");
				return;
			}
		}
		System.out.println("학생이 존재하지 않습니다.");
	}

	@Override
	public void delStd(Scanner scan) {
		System.out.println("학생명 >");
		String name = scan.next();
		boolean result = list.remove(new Student(name));
		if (!result) {
			System.out.println("학생이 없습니다.");
			return;
		}
		System.out.println("학생 삭제 완료");
	}


	@Override
	public void addSub(Scanner scan) {
		System.out.println("학생명 >");
		String name = scan.next();
		System.out.println("과목 >");
		String sub = scan.next();
		System.out.println("점수 >");
		int score = scan.nextInt();
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getName().equals(name)){
				list.get(i).addSubject(sub, score);
				return;
			}
		}
		System.out.println("학생이 없습니다.");
	}

	@Override
	public void modSub(Scanner scan) {
		System.out.println("학생명 >");
		String name = scan.next();
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getName().equals(name)){
				System.out.println("수정할 과목 >");
				String sub = scan.next();
				System.out.println("수정할 점수 >");
				int score = scan.nextInt();
				
				list.get(i).delSubject(sub); // 삭제 후
				
				// map 중복 불가능. 그냥 add해도 덮어씀.
				list.get(i).addSubject(sub, score); // 추가
				return;
			}
		}
		System.out.println("학생이 없습니다.");
	}

	@Override
	public void delSub(Scanner scan) {
		System.out.println("학생명 >");
		String name = scan.next();
		System.out.println("과목 >");
		String sub = scan.next();
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getName().equals(name)){
				list.get(i).delSubject(sub);
				return;
			}
		}
		System.out.println("학생이 없습니다.");
	}


}
