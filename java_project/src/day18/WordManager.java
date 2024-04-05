package day18;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class WordManager {
	
	
	private HashMap<String, String>map = new HashMap<>();
	
	
	// 기본값
	public void addWord() {
		map.put("apple", "사과");
		map.put("banana", "바나나");
		map.put("kiwi", "키위");
		map.put("orange", "오렌지");
	}
	
	// 단어 등록
	public void insertWord(Scanner scan) {
			System.out.println("단어: ");
			String word = scan.next(); 
			System.out.println("의미: ");
			String mean = scan.next(); 
			System.out.println("단어가 등록되었습니다.");
			map.put(word,mean);
		
	}
	
	// 단어 검색 
	public void searchWord(Scanner scan) {
		System.out.println("검색할 단어: ");
		String word = scan.next();
		if (map.containsKey(word)) {
			System.out.println("-- 검색 결과 --");
			System.out.println(word+":"+map.get(word));
			return;
		}
		System.out.println("검색 결과가 없습니다.");
	}
	
	// 단어 수정
	public void modifyWord(Scanner scan) {
		// map은 set이 없음. remove => put
		// key 중복 불가능. put => 덮어쓰기
		System.out.println("수정할 단어: ");
		String word = scan.next();
		if (map.containsKey(word)) {
			System.out.println("의미: ");
			String mean = scan.next();
			System.out.println("수정 완료");
			map.remove(word);
			map.put(word, mean);
			return;
		}
		System.out.println("수정할 단어가 없습니다.");
	}
	
	// 단어 출력 
	public void printWord() {
		System.out.println("-- 단어장 --");
		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()) {
			for (int i=1; i<=map.size(); i++) {
			String word = it.next();
			String mean = map.get(word);
			System.out.println(i+"."+word+" : "+mean);
			}
		}
	}
	
	// 단어 삭제
	public void removeWord(Scanner scan) {
		System.out.println("삭제할 단어: ");
		String word = scan.next();
		String result = map.remove(word);
		if (result == null) {
			System.out.println("삭제할 단어가 없습니다.");
			return;
		}
		System.out.println("삭제 완료.");
	}

	public void filePrint() throws IOException {
		// StringBuffer 객체
		// .append : 기존 String에 데이터 추가 가능.
		// 파일 출력
		FileWriter fw = new FileWriter("text.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		
		StringBuffer sb = new StringBuffer();
		// sb.append : 기존 String에 데이터 추가
		String data  = null;
		sb.append("-- 단어장 --");
		sb.append("\r\n"); // 줄바꿈
		
		for(String key : map.keySet()) {
			sb.append(key+" : "+map.get(key));
			sb.append("\r\n"); // 줄바꿈
		}
		
		data = sb.toString(); // StringBuffer 객체여서 String 객체로 변환
		System.out.println(data);
		bw.write(data);
		if(bw != null) {
			bw.close();
		}
		if (fw != null) {
			fw.close();
		}
	}


}
