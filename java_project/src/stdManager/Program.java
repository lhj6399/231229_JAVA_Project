package stdManager;

import java.util.Scanner;

public interface Program {
	/*
	 * - 학생 출력 기능 : void printStudent();
	 * - 학생 등록 기능 : void insertStudent(Scanner scan);
	 * - 학생 검색 기능 : void searchStudent(Scanner scan);
	 * - 수강 신청 기능 : void registerStudent(Scanner scan);
	 * - 수강 철회 기능 : void deleteStudent(Scanner scan);
	 */

	void printStudent();
	void insertStudent(Scanner scan);
	void searchStudent(Scanner scan);
	void registerStudent(Scanner scan);
	void deleteStudent(Scanner scan);
	
}