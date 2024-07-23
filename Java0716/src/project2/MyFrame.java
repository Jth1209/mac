package project2;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	JButton jb6 = new JButton("회원삭제");
	JButton jb7 = new JButton("로그아웃");
	JTextArea ta = new JTextArea(100,50);
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs;
	ResultSetMetaData rsmd;
	JFrame jf;
	
	String URL = "jdbc:mysql://localhost:3306/spring5fs";
	String id = "root";
	String pw = "k1030112233!@#";
	
	String username = null;
	
	public void msg(String msg) {
		ta.setText(msg+"\n");
	}
	public void apd(String msg) {
		ta.append(msg+"\n");
	}
	public void apdt(String msg) {
		ta.append(msg+"\t");
	}

	public MyFrame(){
		JPanel jp1 = new JPanel();
		JPanel jp1_1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		JPanel jp3_1 = new JPanel();//하단 판넬
		JPanel jp3_2 = new JPanel();
		JPanel jp3_3 = new JPanel();
		JPanel logout = new JPanel();
		jf = this;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL,id,pw);
			stmt = conn.createStatement();
			msg("접속 성공");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    Member member = null;//로그인된 현재 사용자
		Container con = this.getContentPane();//패널 만들어주는 Container class
		
		WinTime time = new WinTime();//현재 시간 출력
		Thread th = new Thread(time);
		th.start();
		
		con.setLayout(new BorderLayout());//판넬 1번을 컨테이너의 위쪽에 배치하고 해당 판넬 내부도 border레이아웃으로 잡는다.
		con.add(jp1, BorderLayout.NORTH);
		
		jp1.setLayout(new GridLayout(1,2,10,10));
		jp1.add(jp1_1);
		jp1.add(time);
		jp1_1.setLayout(new FlowLayout());
		jp1_1.add(jL); jp1_1.add(jt1); jp1_1.add(jL2); jp1_1.add(jt2); jp1_1.add(jL3); jp1_1.add(jt3); 
		
		con.add(jp2, BorderLayout.CENTER);
		jp2.setLayout(new FlowLayout());
		jp2.add(ta);
		
		con.add(jp3, BorderLayout.SOUTH);
		jp3.setLayout(new GridLayout(1,3,10,10));
		jp3.add(jp3_1); jp3.add(jp3_2); jp3.add(jp3_3);
		jp3_1.setLayout(new FlowLayout());
		jp3_2.setLayout(new FlowLayout());
		jp3_3.setLayout(new FlowLayout());
		jp3_1.add(jb); jp3_1.add(jb2); jp3_2.add(jL4); jp3_2.add(jt4); jp3_2.add(jb3); jp3_2.add(jb4); jp3_3.add(jb5); jp3_3.add(jb6);
		
		con.add(logout,BorderLayout.EAST);
		logout.setLayout(new FlowLayout());
		logout.add(jb7);
		
		jb.addActionListener((e)->{//--------------------------로그인 이벤트 SUC
			String name = jt1.getText(); // name 변수의 값 입력
			String strPassword = jt2.getText();//패스워드 입력
			String select = String.format("select * from user where Uname =  '%s' and pw = '%s';", name,strPassword);
			boolean flag = true;
			try {
				rs = stmt.executeQuery(select);
				while(rs.next()) {
					flag = false;
					username = rs.getString(1);
					msg(String.format("로그인 성공. 안녕하세요 %s 님",rs.getString(1)));
				}
				if(flag) {
					JOptionPane.showMessageDialog(jf,"일치하는 유저 정보가 없습니다.","!!경고!!",JOptionPane.ERROR_MESSAGE);
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
				msg("오류입니다.");
			}		
		});
		
		jb2.addActionListener((e)->{//-------------------------회원가입 이벤트 SUC
			String name2 = jt1.getText(); 
			String ssn = jt2.getText(); 
			String tel = jt3.getText();
			if(!(name2.isEmpty()) && !(ssn.isEmpty()) && !(tel.isEmpty())) {
				try {
					String insert = String.format("insert into user(Uname,pw,tel) values ('%s','%s','%s');",name2,ssn,tel);
					stmt.executeUpdate(insert);
					msg("사용가능한 아이디 입니다.");
					apd("[입력된 내용] "+"1. 사용자 이름(아이디) : " + name2+" | 2. 비밀번호 : " + ssn+" | 3. 전화번호 : " + tel);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(jf,"해당 아이디가 존재합니다.","알림",JOptionPane.INFORMATION_MESSAGE);
				}	
			}else {
				JOptionPane.showMessageDialog(jf,"모든 유저 정보를 입력해주세요.","알림",JOptionPane.INFORMATION_MESSAGE);

			}
		});
		
		jb3.addActionListener((e)->{//-------------------------입금 이벤트 SUC
			int plus = Integer.parseInt(jt4.getText());
			if(plus <= 0) {
				apd("해당 금액은 예금할 수 없는 금액입니다.");
			}
			String deposit = String.format("update user set balance = balance + %d  where Uname = '%s'",plus,username);
			if(username == null) {
				JOptionPane.showMessageDialog(jf,"로그인을 진행해 주십시오.","알림",JOptionPane.ERROR_MESSAGE);
			}
			try {
				stmt.executeUpdate(deposit);
				
			} catch (SQLException e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(jf,"일치하는 유저 정보가 없습니다.","!!경고!!",JOptionPane.ERROR_MESSAGE);
			}
			apd("계좌에 "+jt4.getText()+"원을 예금하셨습니다.");

		});
		
		jb4.addActionListener((e)->{//--------------------------출금 이벤트 SUC
			int minus = Integer.parseInt(jt4.getText());
			if(minus <= 0) {
				apd("해당 금액은 출금할 수 없는 금액입니다.");
			}
			String withdraw = String.format("update user set balance = balance - %d where Uname = '%s'",minus,username);
			if(username == null) {
				JOptionPane.showMessageDialog(jf,"로그인을 진행해 주십시오.","알림",JOptionPane.ERROR_MESSAGE);
			}
			try {
				stmt.executeUpdate(withdraw);
				
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(jf,"일치하는 유저 정보가 없습니다.","!!경고!!",JOptionPane.ERROR_MESSAGE);
			}
			apd("계좌에서 "+jt4.getText()+"원을 출금하셨습니다.");

		});
		
		jb5.addActionListener((e)->{//------------------------계좌 상태 확인 이벤트 SUC
			String balance = String.format("select balance from user where Uname = '%s'", username);
			if(username == null) {
				JOptionPane.showMessageDialog(jf,"로그인을 진행해 주십시오.","알림",JOptionPane.ERROR_MESSAGE);}
			try {
				rs = stmt.executeQuery(balance);
				rs.next();
				apd("현재 계좌 잔액: "+ rs.getString(1));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		});
		
		jb6.addActionListener((e)->{//-------------------------삭제버튼 이벤트 SUC
			String dname = jt1.getText();
			String delete = String.format("delete from user where Uname = '%s';", dname);
			try {
				stmt.executeUpdate(delete);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(jf,"입력하신 유저는 없는 유저입니다.","경고",JOptionPane.WARNING_MESSAGE);
			}	
			msg("삭제 완료");

		});
		
		jb7.addActionListener((e)->{
			msg(" ");
			username = null;
			JOptionPane.showMessageDialog(jf,"로그아웃 성공.","알림",JOptionPane.INFORMATION_MESSAGE);
		});
		
		this.setBounds(1200,200,700,500);
		this.setSize(900, 500);//윈도우 창 크기 설정
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//윈도우 창의 x버튼을 누르면 프로세스 자체가 종료되게 설정
		this.setTitle("계좌 입출력 프로그램(SWING)");//윈도우의 타이틀 설정
		this.setLocation(700,300);//윈도우가 화면에 위치하는 좌표 설정
		this.setVisible(true);//윈도우를 화면에 띄우는 설정
		}

	public static void main(String[] args) {
		MyFrame mf = new MyFrame();
			
	}
	class WinTime extends JPanel implements Runnable{//현재 시간 반환해주는 class
		JLabel jL;
		WinTime(){
			this.setLayout(new FlowLayout());
			jL = new JLabel();
			this.add(jL);
		}
		@Override
		public void run() {
			for(;;) {
				LocalTime lt = LocalTime.now();
				String str = String.format("현재 시각| %d : %d : %d ",lt.getHour(),lt.getMinute(),lt.getSecond());
				this.jL.setText(str);
			}
		}
				
	}
}