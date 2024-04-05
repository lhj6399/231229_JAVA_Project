package day16;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Date02 {

	public static void main(String[] args) {
		LocalDateTime today = LocalDateTime.now();
		System.out.println(today);
		System.out.println(today.getYear());
		String t = today.toString(); // toString() 스트링으로 객체를 변환
		System.out.println(t);
		// 날짜 2024-01-26 / 시간 17:03:45 추출
		String date = t.substring(0,t.indexOf("T")) ; // 0부터 T전까지 // subString(앞,뒤) = 앞 포함 뒤 미포함 
		System.out.println(date);
		String time = t.substring(t.indexOf("T")+1,t.indexOf(".")); // T+1부터 .전까지
		System.out.println(time);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss"); // 패턴을 만들 수 있음.
		System.out.println(dtf.format(today)); 
		
		LocalDateTime sDate = LocalDateTime.of(1998, 1, 05, 8,30); // 날짜 생성
		System.out.println(sDate.format(dtf));
	}
}
