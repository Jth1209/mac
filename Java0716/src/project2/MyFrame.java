package project2;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyFrame extends JFrame{//윈도우 창 만들어주는 클래스 JFrame, 아래는 해당 클래스가 포함하고 있는 메소드들
	JLabel jL = new JLabel("아이디");//
	JTextField jt1 = new JTextField(5);
	JLabel jL2 = new JLabel("SSN");//
	JTextField jt2 = new JTextField(5);
	JLabel jL3 = new JLabel("전화번호");//
	JTextField jt3 = new JTextField(5);
	JLabel jL4 = new JLabel("금액입력");//
	JTextField jt4 = new JTextField(5);
	JButton jb = new JButton("로그인");
	JButton jb2 = new JButton("회원가입");
	JButton jb3 = new JButton("예금");
	JButton jb4 = new JButton("출금");
	JButton jb5 = new JButton("잔고");
	JTextArea ta = new JTextArea(100,50);
	List<Member> list = new ArrayList<>();
	Member member;//로그인된 현재 사용자
	
	public void msg(String msg) {
		ta.setText(msg);
	}
	
	class Login implements ActionListener {//로그인 이벤트

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
	public MyFrame(){
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		JPanel jp3_1 = new JPanel();//하단 판넬
		JPanel jp3_2 = new JPanel();
		JPanel jp3_3 = new JPanel();
		
		
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
		
		con.setLayout(new BorderLayout());//판넬 1번을 컨테이너의 위쪽에 배치하고 해당 판넬 내부도 border레이아웃으로 잡는다.
		con.add(jp1, BorderLayout.NORTH);
		jp1.setLayout(new FlowLayout());
		jp1.add(jL); jp1.add(jt1); jp1.add(jL2); jp1.add(jt2); jp1.add(jL3); jp1.add(jt3); 
		
		con.add(jp2, BorderLayout.CENTER);
		jp2.setLayout(new FlowLayout());
		jp2.add(ta);
		
		con.add(jp3, BorderLayout.SOUTH);
		jp3.setLayout(new GridLayout(1,3,10,10));
		jp3.add(jp3_1); jp3.add(jp3_2); jp3.add(jp3_3);
		jp3_1.setLayout(new FlowLayout());
		jp3_2.setLayout(new FlowLayout());
		jp3_3.setLayout(new FlowLayout());
		jp3_1.add(jb); jp3_1.add(jb2); jp3_2.add(jL4); jp3_2.add(jt4); jp3_2.add(jb3); jp3_2.add(jb4); jp3_3.add(jb5);
		
		jb.addActionListener(new Login());
		jb2.addActionListener(new SignIn());
		jb3.addActionListener(new Deposit());
		jb4.addActionListener(new Withdraw());
		jb5.addActionListener(new Balance());
		
		this.setBounds(1200,200,700,500);
		this.setSize(900, 500);//윈도우 창 크기 설정
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//윈도우 창의 x버튼을 누르면 프로세스 자체가 종료되게 설정
		this.setTitle("계좌 입출력 프로그램(SWING)");//윈도우의 타이틀 설정
		this.setLocation(700,300);//윈도우가 화면에 위치하는 좌표 설정
		this.setVisible(true);//윈도우를 화면에 띄우는 설정
		}
	
	class JFrameWindowClosingEventHandler extends WindowAdapter {

		@Override
		public void windowClosing(WindowEvent e) {
			Member[] list2 = list.toArray(new Member[list.size()]);//ArrayList를 배열로 바꿔서 저장
         	try (FileOutputStream fos = new FileOutputStream("/Users/taehojang/temp/members.dat");
    	             	ObjectOutputStream oos = new ObjectOutputStream(fos)) {
    			
         			oos.writeObject(list2);
//    	         	System.out.println("객체를 파일에 저장했습니다.");
         	} catch (IOException e2) {
         		e2.printStackTrace();
         	}
			JFrame frame = (JFrame)e.getWindow();
			frame.dispose();
			System.out.println("WindowClosing");
		}

	}
	public static void main(String[] args) {
		MyFrame mf = new MyFrame();
			
	}
}