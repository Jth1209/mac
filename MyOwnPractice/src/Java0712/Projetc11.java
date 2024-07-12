package Java0712;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Projetc11 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	    int count = 0;//회원의 수
		Member[] list = new Member[10];
		
		try (FileInputStream fis = new FileInputStream("/users/taehojang/temp/members.dat");
				ObjectInputStream ois = new ObjectInputStream(fis)) {
			
			Member[] list2 = (Member[]) ois.readObject();
			System.arraycopy(list2,0,list,0,list2.length);//1번 배열 0 번째 부터 두번째 배열의 0번 에 리스트2의 길이만큼 복사
			System.out.println("파일에서 객체를 가져왔습니다.");
		}catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	    for(Member member:list) {
	    	if(member != null) {
	    		System.out.println(member);
	    		++count;
	    	}
	    }
	    Member member = null;//로그인된 현재 사용자
		boolean run = true;
		while (run) {
			System.out.println("-------------------------------------");
			System.out.println("1.로그인 | 2.회원가입 | 3.예금/출금 | 4.삭제 | 5.종료");
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
				
				for(int i = 0; i<list.length; i++) {
					if(list[i].name.equals(name) && list[i].ssn.equals(strPassword)) {
						find = i;
						member = list[i];
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
				if(count == 10) {
					System.out.println("사용자 생성 가능 횟수 초과");//사용자 아이디 최대 개수 지정
					break;
				}
				System.out.println("아이디 중복 검사");//중복된 아이디(이름)생성 불가
				for(int i = 0; i<count; i ++) {
					if(list[i].name.equals(name2)) {
						System.out.println("같은 아이디 존재 다른 아이디를 사용해주세요");
						same = -1;
						break;
					}
				}
				if(same == 1) {
					System.out.println();
					System.out.println("[입력된 내용]");
					System.out.println("1. 이름: " + name2);
					System.out.println("2. 주민번호 앞 6자리: " + ssn); 
					System.out.println("3. 전화번호: " + tel);
					// 객체 생성
					list[count] = new Member(name2, ssn, tel);
					count++;
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
						member.balance += Integer.parseInt(scanner.nextLine());
						break;
					case 2:
						System.out.print("출금액> ");
						member.balance -= Integer.parseInt(scanner.nextLine());
						break;
					case 3:
						System.out.print("잔고> ");
						System.out.println(member.balance);
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
				for(int i = 0; i<count; i++) {
					if(list[i].name.equals(dname)) {
						list[i] = null;
						continue;
					}
				}
				for(int i = 0; i< list.length-1; i++) {
					if(list[i] == null) {
						list[i] = list[i+1];
						list[i+1] = null;
					}
				}
				System.out.println("삭제 완료");
				break;
			
 	            case 5:
				run = false;
				break;
			}
		}
		try (FileOutputStream fos = new FileOutputStream("/users/taehojang/temp/members.dat");
	             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			
			 oos.writeObject(list);
	         System.out.println("객체를 파일에 저장했습니다.");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("프로그램 전체 종료");

	}
}