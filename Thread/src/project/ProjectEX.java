package project;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ProjectEX extends JFrame{
	
	JLabel jL1 = new JLabel("select 문 작성: ");
	JLabel jL2 = new JLabel("부서 번호: ");
	JLabel jL3 = new JLabel("부서 이름: ");
	JLabel jL4 = new JLabel("부서 지점: ");
	
	JTextField jt1 = new JTextField(15);
	JTextField jt2 = new JTextField(7);
	JTextField jt3 = new JTextField(7);
	JTextField jt4 = new JTextField(7);
	
	JButton jb1 = new JButton("정보 출력");
	JButton jb2 = new JButton("정보 입력");
	
	JTextArea ta1 = new JTextArea(100,70);
	
	Connection con;
	Statement stmt;
	ResultSet rs;
	ResultSetMetaData rsmd;
		
	String URL = "jdbc:mysql://localhost:3306/spring5fs";
	String id = "root";
	String pw = "k1030112233!@#";
	
	JFrame jf;
	ProjectEX(){
		Time time = new Time();
		Thread th = new Thread(time);
		th.start();
		jf = this;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL,id,pw);
			stmt = con.createStatement();			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		Container con = this.getContentPane();
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		
		con.setLayout(new BorderLayout());
		
		con.add(jp1,BorderLayout.NORTH);
		con.add(jp2,BorderLayout.CENTER);
		con.add(jp3,BorderLayout.SOUTH);
		con.add(time,BorderLayout.WEST);
		
		jp1.setLayout(new FlowLayout());
		jp2.setLayout(new FlowLayout());
		jp3.setLayout(new FlowLayout());
		
		jp1.add(jL1);
		jp1.add(jt1);
		jp1.add(jb1);
		
		jp2.add(ta1);
		
		jp3.add(jL2);
		jp3.add(jt2);
		jp3.add(jL3);
		jp3.add(jt3);
		jp3.add(jL4);
		jp3.add(jt4);
		jp3.add(jb2);
		
		jb1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String select = jt1.getText();
				
				try {
					rs = stmt.executeQuery(select);
					rsmd = rs.getMetaData();
					int length = rsmd.getColumnCount();
					
					boolean flag = true;//rs.next()가 존재할 시, false로 전환 후 내용 출력 rs.next()가 null일 경우 true 상태로 내려가 경고문 출력
					ta1.setText("");
					while(rs.next()) {
						flag = false;
						ta1.append("[ ");
						for(int i = 1; i< length; i++) {
							ta1.append(rs.getString(i)+", ");
						}
						ta1.append(rs.getString(length)+" ]\n");
					}
					if(flag) {
						JOptionPane.showMessageDialog(jf,"해당 자료를 찾을 수 없습니다.","**경고**",JOptionPane.ERROR_MESSAGE);//다시 보기 하나도 이해 못하고 있음
					}
				}catch(SQLException e1) {
					e1.printStackTrace();
				}
			}
			
		});
		
		jb2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int dID = Integer.parseInt(jt2.getText());
				
				String dName = jt3.getText();
				
				String dLoc = jt4.getText();
				
				String insert = String.format("insert into dept(deptno,dname,loc) values (%d,'%s','%s');",dID,dName,dLoc);
				
				try {
					stmt.executeUpdate(insert);
					ta1.setText("테이블 데이터 입력 완료");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			
		});
		
		this.setVisible(true);
		this.setBounds(700,500,1000,700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("데이터 베이스 정보 입력 프로그램");
	}
	

	public static void main(String[] args) {
		new ProjectEX();
	}

	class Time extends JPanel implements Runnable{
		JLabel jL1;
		Time(){
			jL1 = new JLabel("test");
			this.add(jL1);
		}
		
		@Override
		public void run() {
			for(;;) {
				LocalTime localtime = LocalTime.now();
				String str = String.format("%d : %d : %d ", localtime.getHour(),localtime.getMinute(),localtime.getSecond());
				this.jL1.setText(str);
//				ProjectEX.this.setTitle(str);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
