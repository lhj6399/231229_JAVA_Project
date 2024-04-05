package day21;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class File05 {

	public static void main(String[] args) throws IOException {
		// test.txt 파일을 읽어들여 map에 저장하여 명단, 합계, 평균을 출력
		// txt에서 읽어들이는 값은 모두 String
		// 계산을 하기 위해서는 int 자료형으로 변환이 필요
		// Integer.parseInt();를 통해 String -> int로 변환
		
		BufferedReader br = new BufferedReader(new FileReader("test.txt"));
		HashMap<String, Integer>map = new HashMap<>();
		int sum = 0;
		
		while(true) {
			String line = br.readLine(); 
			if (line == null) {
				break;
			}
			// line이 null이 아니라면...
			String name = line.substring(0, line.indexOf(" "));
			int score = Integer.parseInt(line.substring(line.indexOf(" ")+1));
			sum += score;
			map.put(name,score);
		}	
		System.out.println(map);
		System.out.println("----------------------------");
		for (String key : map.keySet()) {
			System.out.println(key + " : " + map.get(key));
		}
		System.out.println("합계: "+sum +" / 평균: "+(double)sum / map.size());
		
		// br 끊기
		if (br != null) { // 객체가 생성되었다면 끊기
		br.close();
		}
	}

}
