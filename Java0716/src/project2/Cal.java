package project2;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Cal extends JFrame {
	
	JTextField num1, num2;
	JButton plus, minus, multiply, divide;
	JLabel label02;
	
	public Cal() {
		this.setTitle("계산기 화면");
		this.setSize(300, 250);	

		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();		
		JPanel jp3 = new JPanel();
		num1 = new JTextField(5);
		num2 = new JTextField(5);
		
		plus = new JButton("+");
		minus = new JButton("-");
		multiply = new JButton("*");
		divide = new JButton("/");
		
		label02 = new JLabel("계산 결과");
		
		Container con = this.getContentPane();
		con.setLayout(new BorderLayout());
		con.add(jp1, BorderLayout.NORTH);
		con.add(jp2, BorderLayout.CENTER);
		con.add(jp3, BorderLayout.SOUTH);
		
		
		jp1.setLayout(new FlowLayout());
		jp3.setLayout(new FlowLayout());
		jp2.setLayout(new GridLayout(2,2,20,20));
		
		jp1.add(num1); jp1.add(num2);
		
		jp2.add(plus); jp2.add(minus); jp2.add(multiply); jp2.add(divide);
		
		jp3.add(label02);
		
		
	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		plus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				double no1 = Double.parseDouble(num1.getText());
				double no2 = Double.parseDouble(num2.getText());
				label02.setText(String.valueOf(no1+no2));
			}
		});
		minus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				double no1 = Double.parseDouble(num1.getText());
				double no2 = Double.parseDouble(num2.getText());
				label02.setText(String.valueOf(no1-no2));
				
			}
		});
		multiply.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				double no1 = Double.parseDouble(num1.getText());
				double no2 = Double.parseDouble(num2.getText());
				label02.setText(String.valueOf(no1*no2));
				
			}
		});
		divide.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				double no1 = Double.parseDouble(num1.getText());
				double no2 = Double.parseDouble(num2.getText());
				label02.setText(String.valueOf(no1/no2));
				
			}
		});

	}
	
	public static void main(String[] args) {  
		new Cal();
	}

}