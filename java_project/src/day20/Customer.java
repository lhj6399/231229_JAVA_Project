package day20;

import java.util.ArrayList;

public class Customer implements Comparable<Customer>{
	
	// 멤버변수 이름, 나이, 가격
	private String name;
	private int age;
	private int price;
	
	// 생성자, getter / setter, toString
	
	// 생성자
	public Customer () {}
	
	public Customer (String name, int age) {
		this.name = name;
		this.age = age;
		this.price = (age >= 15 )? 100 : 50;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "이름: " + name + ", 나이: " + age + ", 비용: " + price;
	}

	@Override
	public int compareTo(Customer o) {
		// TODO Auto-generated method stub
		return this.name.compareTo(o.name);
	}

	
}
