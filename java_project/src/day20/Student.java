package day20;

public class Student {

	// name, score만 가지는 클래스 생성
	// 생성자, getter / setter, toString
	private String name;
	private int score;
	
	// 생성자
	public Student() {
		
	}
	
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	// getter / setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}

	// toString
	@Override
	public String toString() {
		return  name + " : " + score;
	}
	
	
}
