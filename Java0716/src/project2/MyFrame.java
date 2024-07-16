package project2;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyFrame extends JFrame{//윈도우 창 만들어주는 클래스 JFrame, 아래는 해당 클래스가 포함하고 있는 메소드들
	JLabel jL = new JLabel("아이디");//
	JTextField jt1 = new JTextField();
	JLabel jL2 = new JLabel("SSN");//
	JTextField jt2 = new JTextField();
	JLabel jL3 = new JLabel("전화번호");//
	JTextField jt3 = new JTextField();
	JLabel jL4 = new JLabel("금액입력");//
	JTextField jt4 = new JTextField();
	JButton jb = new JButton("로그인");
	JButton jb2 = new JButton("회원가입");
	JButton jb3 = new JButton("예금");
	JButton jb4 = new JButton("출금");
	JButton jb5 = new JButton("잔고");
	JButton jb6 = new JButton("저장");
	JTextArea ta = new JTextArea();
	List<Member> list = new ArrayList<>();
	Member member;//로그인된 현재 사용자
	
	public void msg(String msg) {
		ta.setText(msg);
	}
	
	class MyListener implements ActionListener {//로그인 이벤트

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String name = jt1.getText(); // name 변수의 값 입력
			String strPassword = jt2.getText();//패스워드 입력
			
			for(Member m : list) {
				if(m.getName().equals(name) && m.getSsn().equals(strPassword)) {
					member = m;
//					System.out.println("로그인 성공");
					msg("로그인 성공");
					jL4.getCursor();
					break;
				}else if(!(m.getName().equals(name)) && (m.getSsn().equals(strPassword))) {
					msg("아이디를 다시 입력해주세요.");
					break;
			
				}else if((m.getName().equals(name)) && !(m.getSsn().equals(strPassword))) {
					msg("비밀번호를 다시 입력해주세요.");
					break;
					
				}else{
					msg("아이디와 비밀번호를 다시 입력해주세요.");
				}
			}
		}
	}
	class Deposit implements ActionListener {//예금 이벤트

		@Override
		public void actionPerformed(ActionEvent e) {
			if(member == null) {
				ta.setText("해당 기능을 사용하기 위해서는 로그인을 해야합니다.");
				return;
			}
			member.deposit(Integer.parseInt(jt4.getText()));
			msg("계좌에 "+jt4.getText()+"원을 예금하셨습니다.");
		}
	}
	class Withdraw implements ActionListener {//출금 이벤트
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(member == null) {
				ta.setText("해당 기능을 사용하기 위해서는 로그인을 해야합니다.");
				return;
			}
			member.withdraw(Integer.parseInt(jt4.getText()));
			msg("계좌에서 "+jt4.getText()+"원을 출금하셨습니다.");
		}
	}
	class Balance implements ActionListener {//계좌 확인 이벤트
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(member == null) {
				ta.setText("해당 기능을 사용하기 위해서는 로그인을 해야합니다.");
				return;
			}
			msg("현재 계좌: "+member.getBalance());
		}
	}
	
	class SignIn implements ActionListener{//회원가입 이벤트
		
		@Override
		public void actionPerformed(ActionEvent e) {
			int same = 1;
			msg("회원 가입");
			String name2 = jt1.getText(); 
			String ssn = jt2.getText(); 
			String tel = jt3.getText();
			if(!(name2.isEmpty()) && !(ssn.isEmpty()) && !(tel.isEmpty())) {
				for(Member id: list) {
					if(id.getName().equals(name2)) {
//						System.out.println("같은 아이디 존재");
						msg("같은 아이디가 존재합니다. 다른 아이디를 사용해주세요.");
						same = -1;
						return;
					}
				}
				msg("사용가능한 아이디 입니다.");
				if(same == 1) {
				msg("[입력된 내용] "+"1. 이름: " + name2+" 2. 주민번호 앞 6자리: " + ssn+" 3. 전화번호: " + tel);	// 객체 생성
				list.add(new Member(name2, ssn, tel));
					}
			}else {
				msg("모든 회원 정보를 입력해주세요.");
		}
	}

}
class Exit implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Member[] list2 = list.toArray(new Member[list.size()]);//ArrayList를 배열로 바꿔서 저장
         	try (FileOutputStream fos = new FileOutputStream("/Users/taehojang/temp/members.dat");
    	             	ObjectOutputStream oos = new ObjectOutputStream(fos)) {
    			
         			oos.writeObject(list2);
//    	         	System.out.println("객체를 파일에 저장했습니다.");
         			msg("사용자의 계좌 정보를 저장했습니다.");
         	} catch (IOException e2) {
         		e2.printStackTrace();
         	}
		}
	}
	public MyFrame(){
		
		try (FileInputStream fis = new FileInputStream("/Users/taehojang/temp/members.dat");
				ObjectInputStream ois = new ObjectInputStream(fis)) {
			
//			List<Member> list2 = (List<Member>) ois.readObject();
			Member[] list2 = (Member[]) ois.readObject();
			list = new ArrayList<>(Arrays.asList(list2));//위에서 선언했어도 무조건 선언하고 Arrays.asList()쓰자.*****
//			System.arraycopy(list2,0,list,0,list2.length);//1번 배열 0 번째 부터 두번째 배열의 0번 에 리스트2의 길이만큼 복사
			msg("사용자의 계좌 정보를 가져왔습니다.");
		}catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		for(Member member: list) {
			System.out.println(member);
		}
        msg("총 회원 수:"+ list.size());
	    Member member = null;//로그인된 현재 사용자
		Container con = this.getContentPane();//패널 만들어주는 Container class
		con.setLayout(null);//패널의 레이아웃 설정
		
		con.add(jL);//container
		jL.setLocation(20,50);
		jL.setSize(100,30);
		
		con.add(jt1);
		jt1.setLocation(60,50);
		jt1.setSize(100,30);
		
		con.add(jL2);//container
		jL2.setLocation(180,50);
		jL2.setSize(100,30);
		
		con.add(jt2);
		jt2.setLocation(210,50);
		jt2.setSize(100,30);

		con.add(jL3);//container
		jL3.setLocation(320,50);
		jL3.setSize(100,30);
		
		con.add(jt3);
		jt3.setLocation(380,50);
		jt3.setSize(100,30);
	
		con.add(jL4);//container
		jL4.setLocation(320,350);
		jL4.setSize(100,30);
		
		con.add(jt4);
		jt4.setLocation(380,350);
		jt4.setSize(100,30);
		
		con.add(ta);
		ta.setLocation(20,120);
		ta.setSize(830,200);
		
		con.add(jb);//패널에 버튼 삽입
		jb.setLocation(20,350);//버튼의 위치 설정
		jb.setSize(100,30);
		jb.addActionListener(new MyListener());
	
		con.add(jb2);//패널에 버튼 삽입
		jb2.setLocation(120,350);//버튼의 위치 설정
		jb2.setSize(100,30);
		jb2.addActionListener(new SignIn());
		
		con.add(jb3);//패널에 버튼 삽입
		jb3.setLocation(550,350);//버튼의 위치 설정
		jb3.setSize(100,30);
		jb3.addActionListener(new Deposit());
		
		con.add(jb4);//패널에 버튼 삽입
		jb4.setLocation(650,350);//버튼의 위치 설정
		jb4.setSize(100,30);
		jb4.addActionListener(new Withdraw());

		con.add(jb5);//패널에 버튼 삽입
		jb5.setLocation(750,350);//버튼의 위치 설정
		jb5.setSize(100,30);
		jb5.addActionListener(new Balance());
		
		con.add(jb6);//패널에 버튼 삽입
		jb6.setLocation(750,50);//버튼의 위치 설정
		jb6.setSize(100,30);
		jb6.addActionListener(new Exit());
		
		this.setSize(900, 500);//윈도우 창 크기 설정
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//윈도우 창의 x버튼을 누르면 프로세스 자체가 종료되게 설정
		this.setTitle("계좌 입출력 프로그램(SWING)");//윈도우의 타이틀 설정
		this.setLocation(700,300);//윈도우가 화면에 위치하는 좌표 설정
		this.setVisible(true);//윈도우를 화면에 띄우는 설정
		}
	public static void main(String[] args) {
		MyFrame mf = new MyFrame();
			
	}
}