package day07;

public class StringEx01 {

	public static void main(String[] args) {
		/* file에 저장되어 있는 문자를 파일명과 확장자로 분리하여 출력
		 * 파일명 : 이것이자바다
		 * 확장자 : java
		 */
		
		String file = "이것이자바다.java";

		String fileName = file.substring(0,file.indexOf("."));
		System.out.println("파일명 : "+fileName);
		String suffix = file.substring(file.indexOf(".")+1);
		System.out.println("확장자 : "+suffix);
		
		
		String[] arr1 = file.split("\\.");
		//System.out.println(arr);
		for (String s : arr1) {
			System.out.println(s+" ");
		}
		
		if(file.contains("java")) {
			System.out.println("자바파일입니다.");
		}

	}

}
