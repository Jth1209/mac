package project2;

import java.io.Serializable;

public class Member implements Serializable {
	private String name; 
	private String ssn;//주민번호 6자리
	private String tel;	
	private int balance=0;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Member [name=" + name + ", ssn=" + ssn + ", tel=" + tel + ", balance=" + balance + "]";
	}
	public Member(String name, String ssn, String tel) {
		super();
		this.name = name;
		this.ssn = ssn;
		this.tel = tel;
	}
	public Member(int balance) {//생성자는 특이한 메소드일 뿐.
		super();
		this.balance = balance;
	}
	public Member() {
		
	}
	
	public void deposit(int deposit) {
		if(deposit <0) {
			System.out.println("금액을 다시 입력해주세요");
			return;
		}
		this.balance += deposit;
	}
	public void withdraw(int withdraw) {
		if(withdraw>balance) {
			System.out.println("잔액이 부족합니다.");
			return;
		}
		if(withdraw <= 0) {
			System.out.println("0원 및 마이너스 단위는 출력할 수 없습니다.");
		}
		this.balance -= withdraw;
	}

	
}