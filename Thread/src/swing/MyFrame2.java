package swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyFrame2 extends JFrame {//flag를 사용해서 경우의 수를 나눈 경우/ 항상 코딩할 떄 어느 부분을 고쳐야하고 어느 부분을 반복해야하는지 생각하고 코딩하기
	
	String[] walk = {"walk1.gif", "walk2.gif"};
	String[] stand = {"stand.gif"};
	String[] run = {"run1.gif", "run2.gif", "run3.gif"};
	int flag = 0;
	String[] path = stand;
	MyFrame2() {
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Field field = new Field();
		Control control = new Control();
		this.add(field, BorderLayout.CENTER);
		this.add(control, BorderLayout.SOUTH);
		this.setBounds(1200, 100, 500, 500);
		this.setVisible(true);
		
		//여기에 Thread를 객체 생성하여 start()메소드를 호출하세요.
		Thread thread = new Thread(field);
		thread.start();
	}
	
	private class Field extends JPanel implements Runnable {
		JLabel lbl;
		Field() {
			this.setLayout(new BorderLayout());
			lbl = new JLabel();
			lbl.setIcon(new ImageIcon("./src/stand.gif"));
			this.add(lbl, BorderLayout.CENTER);
		}
		@Override
		public void run() {
			while (true) {
				switch(flag) {
				case 1:
					path = stand;
					break;
				case 2:
					path = walk;
					break;
				case 3:
					path = run;
					break;
				default:
					path = stand;
				}
				
				for (int i = 0; i < path.length; i++) {
					lbl.setIcon(new ImageIcon("./src/" + path[i]));
//					System.out.println(i);
					try {
						Thread.sleep(300);  // 0.3초
					} catch (InterruptedException e) {}
				}
			}
			
		}
	}
	
	private class Control extends JPanel implements ActionListener {
		private JButton standingBtn, walkingBtn, runningBtn;
		public Control() {
			this.setLayout(new FlowLayout());

			standingBtn = new JButton("Standing");
			walkingBtn = new JButton("Walking");
			runningBtn = new JButton("Running");

			standingBtn.addActionListener(this);
			walkingBtn.addActionListener(this);
			runningBtn.addActionListener(this);
			this.add(standingBtn);
			this.add(walkingBtn);
			this.add(runningBtn);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == standingBtn) {
				flag = 1;
			} else if (e.getSource() == walkingBtn) {
				flag = 2;
			} else if (e.getSource() == runningBtn) {
				flag = 3;
			}
		}
	}
	
	public static void main(String[] args) {
		new MyFrame2();
	}
}