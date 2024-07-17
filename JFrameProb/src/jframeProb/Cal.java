package jframeProb;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Cal extends JFrame implements ActionListener {
	
	JTextField jt1 = new JTextField(10);
	JTextField jt2 = new JTextField(10);
	JTextField jt3 = new JTextField(10);
	
	JButton jb1 = new JButton("+");
	JButton jb2 = new JButton("-");
	JButton jb3 = new JButton("/");
	JButton jb4 = new JButton("*");
	
	JLabel la1 = new JLabel("계산기");
	JLabel la2 = new JLabel("계산결과");
	
	
	Cal(){
		Container con = this.getContentPane();
		
		JPanel jp1 = new JPanel();
		JPanel jp2= new JPanel();
		JPanel jp3 = new JPanel();
		
		jp3.setLayout(new GridBagLayout());
//		jp3.setLayout(new FlowLayout());
		con.setLayout(new BorderLayout());
		
		con.add(jp1,BorderLayout.NORTH);
		con.add(jp2,BorderLayout.SOUTH);
		con.add(jp3,BorderLayout.CENTER);
		
		jp1.add(la1);
		jp2.add(la2);
		jp2.add(jt3);
		
		jp3.add(jt1); jp3.add(jt2); jp3.add(jb1); jp3.add(jb2); jp3.add(jb3); jp3.add(jb4);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(700,500);
		this.setTitle("계산기 프로그램");
		
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);
	}

	public static void main(String[] args) {
		new Cal();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jb1) {
			int sum = Integer.parseInt(jt1.getText()) + Integer.parseInt(jt2.getText());
			jt3.setText(sum+"");
		}else if(e.getSource() == jb2) {
			int sub = Integer.parseInt(jt1.getText()) - Integer.parseInt(jt2.getText());
			jt3.setText(sub+"");
		}else if(e.getSource() == jb3) {
			int div = Integer.parseInt(jt1.getText()) / Integer.parseInt(jt2.getText());
			jt3.setText(div+"");
		}else if(e.getSource() == jb4) {
			int mul = Integer.parseInt(jt1.getText()) * Integer.parseInt(jt2.getText());
			jt3.setText(mul+"");
		}
		
	}

}
