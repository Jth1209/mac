package Java0712;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Projetc11 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	    List<Member> list = null;	//Member[] = ArrayList<Member> list	
	    try (FileInputStream fis = new FileInputStream("/users/taehojang/temp/user.dat");
				ObjectInputStream ois = new ObjectInputStream(fis)) {
			Member[] list2 = (Member[]) ois.readObject();//파일에 기본적으로 값을 받지 않고 LinkedList령으로 강제변환하여 값을 받음
//			Member[] list2 = (Member[]) ois.readObject(); 
			list = new ArrayList<>(Arrays.asList(list2));
			System.out.println("파일에서 객체를 가져왔습니다.");
		}catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	    for(Member member: list) {
	    		System.out.println(member);
	    }
		/*
		 * String ex = scanner.nextLine(); if(list.get(3).name.equals(ex)){
		 * System.out.println(1); }
		 */	    
	    Member member = null;//로그인된 현재 사용자
		boolean run = true;
		while (run) {
			System.out.println("-------------------------------------");
			System.out.println("1.로그인 | 2.회원가입 | 3.예금/출금 | 4.회원삭제 | 5.종료");
			System.out.println("-------------------------------------");
			System.out.print("선택> ");
			int menuNum = Integer.parseInt(scanner.nextLine());
			switch (menuNum) {
			
			case 1:
				// 로그인 처리
				System.out.println("로그인 처리");
				System.out.print("아이디:");  //출력문
				String name = scanner.nextLine(); // name 변수의 값 입력
				System.out.print("패스워드:");
				String strPassword = scanner.nextLine();//패스워드입력
				int find = -1;
				
				for(Member m: list) {
					if(m.getName().equals(name) && m.getSsn().equals(strPassword)) {//이건 제대로 인식
						member = m;
						break;
					}
				}
				System.out.println("인덱스 : "+find);
				System.out.println(member);
				
				break;
				
 	            case 2:
				// 회원 가입
 	            int same = 1;
				System.out.println("회원 가입");
				System.out.println("[필수 정보 입력]"); 
				System.out.print("1. 이름: ");
				String name2 = scanner.nextLine(); 
				System.out.print("2. 주민번호 앞 6자리: ");
				String ssn = scanner.nextLine(); 
				System.out.print("3. 전화번호: "); 
				String tel = scanner.nextLine();
				System.out.println("아이디 중복 검사");//중복된 아이디(이름)생성 불가
				
				for(Member m: list) {
				    if(m.getName().equals(name2)) {//LinkedList 사용하여 해결
						System.out.println("같은 아이디 존재. 다른 아이디를 사용해주세요");
						same = -1;
						break;
					}else {
					    System.out.println("사용 가능한 아이디입니다.");
					}

				}
				if(same == 1) {
					System.out.println();
					System.out.println("[입력된 내용]");
					System.out.println("1. 이름: " + name2);
					System.out.println("2. 주민번호 앞 6자리: " + ssn); 
					System.out.println("3. 전화번호: " + tel);
					// 객체 생성
					list.add(new Member(name2, ssn, tel));//ArrayList에 멤버 클래스의 생성자로 값 넣기(add)
				}else {
					break;
				}
				break;
			
 	            case 3:
				// 예금 출금
				if(member == null) {//로그인 미진행 시 예금/출금 기능 사용 불가
					System.out.println("로그인을 진행해 주세요");
					break;
				}
				System.out.println("예금 출금");
				boolean run2 = true;
				
				while (run2) {
					System.out.println("-------------------------------------");
					System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
					System.out.println("-------------------------------------");
					System.out.print("선택> ");
					int menuNum2 = Integer.parseInt(scanner.nextLine());
					switch (menuNum2) {
					case 1:
						System.out.print("예금액> ");
						member.deposit(Integer.parseInt(scanner.nextLine()));
						break;
					case 2:
						System.out.print("출금액> ");
						member.withdraw(Integer.parseInt(scanner.nextLine()));
						break;
					case 3:
						System.out.print("잔고> ");
						System.out.println(member.getBalance());
						break;
					case 4:
						run2 = false;
						break;
					}
					System.out.println();
				}
				System.out.println("예금/출금 프로그램 종료");
				break;
			
 	            case 4://삭제 기능
				System.out.print("삭제할 계정의 아이디: ");
				String dname = scanner.nextLine(); 
				for(Member m : list) {
					if(m.getName().equals(dname)) {
						list.remove(m);
					    break;
					}
				}
				System.out.println("삭제 완료");
				break;
			
 	            case 5:
 	            	   Member[] list2 = list.toArray(new Member[list.size()]);//list.size()만큼 새로운 Member 배열을 만들어 list2에 데이터 전달
 	       		       try (FileOutputStream fos = new FileOutputStream("/users/taehojang/temp/user.dat");
 	       	                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
 	       			            oos.writeObject(list);
 	       	            System.out.println("객체를 파일에 저장했습니다.");
 	       			
 	       			
 	       		        } catch (IOException e) {
 	       			            e.printStackTrace();
 	       		        }

				run = false;
				break;
			}
		}System.out.println("프로그램 전체 종료");

	}
}