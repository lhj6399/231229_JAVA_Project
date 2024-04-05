package day16;

import java.util.Calendar;
import java.util.Date;

public class Date01 {

	public static void main(String[] args) {
		/* 날짜 / 시간 클래스
		 * Date 클래스 => Deprecated (비권장) / Calendar 클래스
		 * Calendar : 추상클래스 // 추상클래스는 객체를 생성할 수 없음.
		 * 추상클래스를 구현한 객체를 이용하여 사용
		 * new로 객체 생성 불가능.
		 * getIncstance()메서드를 이용하여 객체를 얻어옴
		 * static 메서드. 클래스명.메서드명() 
		 */
		
//		Date d = new Date();
		Calendar c = Calendar.getInstance(); // 오늘 날짜 리턴
		int year = c.get(Calendar.YEAR);
		System.out.println(year);
		
		// 월 0~11까지 +1표현
		int month = c.get(Calendar.MONTH)+1;
		System.out.println(month);
		int day = c.get(Calendar.DAY_OF_MONTH);
		System.out.println(day);
		int week = c.get(Calendar.DAY_OF_WEEK); // 일~토
		System.out.println(week);
		System.out.println(year+"-"+month+"-"+day);
		
		System.out.println();
		// hour, minute, second, ap_pm
		int hour = c.get(Calendar.HOUR);
		int minute = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);
		int am_pm = c.get(Calendar.AM_PM);
		
		String weekStr = null;
		switch(week) {
		case 1: weekStr="일";break;
		case 2: weekStr="월";break;
		case 3: weekStr="화";break;
		case 4: weekStr="수";break;
		case 5: weekStr="목";break;
		case 6: weekStr="금";break;
		case 7: weekStr="토";break;
		default: break;
		} 
		System.out.println(year+"-"+month+"-"+day+" ("+weekStr+")");
		
		
		
		// 2024-1-26 (금)
		System.out.print(year+"-"+month+"-"+day+" ");
		System.out.print("(");
		switch(week) {
		case 1: System.out.print("일");break;
		case 2: System.out.print("월");break;
		case 3: System.out.print("화");break;
		case 4: System.out.print("수");break;
		case 5: System.out.print("목");break;
		case 6: System.out.print("금");break;
		case 7: System.out.print("토");break;
		default: break;
		}
		System.out.print(")");
		System.out.println();
		// 오후 4:30
		if (am_pm == 1) {
			System.out.print("오후 ");
		} else {
			System.out.print("오전 ");
		}
		System.out.println(hour+":"+minute);
	}

}
