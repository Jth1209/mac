package Java0710;

import java.util.Scanner;
public class MacProb1 {
    public static int getNum(String msg,Scanner scan) {
    	System.out.println(msg);
		String input1 = scan.nextLine();
		return Integer.parseInt(input1);
    }

	public static void main(String[] args) {
		boolean run1 = true;
		int balance = 0;
		String ID = "";
		String PW = "";
		Scanner sc = new Scanner(System.in);
		
        while(run1) {
			System.out.println("---------------------------");
			System.out.println("1.회원 가입 |2.로그인 |3.종료 ");
			System.out.println("---------------------------");
			int select = getNum("선택> ",sc);
			if(select == 1) {//아이디 ,비밀번호 생성 
				System.out.println("아이디 생성: ");
			    String ip1 = sc.nextLine();
			    System.out.println("비밀번호 생성: ");
		        String ip2= sc.nextLine();
		    
		        ID = ip1;
		        PW = ip2;
			}
			if(select == 2) {//아아디 , 비밀번호 대치 
				System.out.println("아이디: ");
			    String UID = sc.nextLine();
			    System.out.println("비밀번호: ");
			    String UPW = sc.nextLine();
			    if((ID.equals(UID)) && (PW.equals(UPW))) {
			        System.out.println("로그인 성공... 다음 화면으로 진입힙니다... ");
			        System.out.println();
			        System.out.println();
			        System.out.println();
			        boolean run2 = true;
			        while(run2) {
						System.out.println("-----------------------------");
						System.out.println("1.예금 | 2.출금 |3.잔고 | 4.종료 ");
						System.out.println("-----------------------------");
						int select1 = getNum("선택>",sc);
						
						if(select1 == 1) {
							int money = getNum("예금액>",sc);
							balance += money;
						}
						if(select1 == 2) {
							int money = getNum("출금액>",sc);
							balance -= money;
						}
						if(select1 == 3) {
							System.out.println("잔고> ");
							System.out.println(balance);
						}
						if(select1 == 4) {
							run2 = false;
						}
						
						}
					System.out.println("프로그램 종료");
					}else {
						System.out.println("아이디나 비밀번호를 틀렸습니다. 다시 입력 해주세요.");
			    }
			}if(select == 3) {
				run1 = false;
			}
		}
        System.out.println("프로그램 완전 종료");

	}
}