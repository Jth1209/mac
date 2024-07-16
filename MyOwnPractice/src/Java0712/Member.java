package Java0712;

import java.io.Serializable;

public class Member implements Serializable{
	private String name;
	private String ssn;
	private String tel;
	private int balance;
	

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
	public void deposit(int deposit) {
		if(deposit < 0) {
			System.out.println("입력단위가 잘못됐습니다.");
			return;
		}
		balance += deposit;
	}
	public void withdraw(int withdraw) {
		if(withdraw > balance) {
			System.out.println("잔액이 부족합니다.");
			return;
		}
		if(withdraw <= 0) {
			System.out.println("0원이나 마이너스는 출금할 수 없습니다.");
			return;
		}
		balance -= withdraw;
	}
	public Member(String name, String ssn, String tel) {
		super();
		this.name = name;
		this.ssn = ssn;
		this.tel = tel;
	}	

}


