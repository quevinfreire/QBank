package model.entities;

import model.exceptions.DomainException;

public class Account {
	
	private Integer number;
	private String holder;
	private Double balance = 0.0;
	private Double withdrawLimit;

	public Account(Integer number, String holder, Double withdrawLimit ) {
		this.holder = holder;
		this.number = number;
		this.withdrawLimit = withdrawLimit;
	}
	
	public Account(Integer number, String holder,Double withdrawLimit, Double initialDeposit) {
		this.number = number;
		this.holder = holder;
		this.withdrawLimit = withdrawLimit;
		deposit(initialDeposit);
	}

	public String getAccountHolder() {
		return holder;
	}

	public void setAccountHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}
	
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
	
	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}

	public void deposit(Double amount) {
		this.balance += amount ;
	}
	
	public void withdraw(Double withdrawValue) {
		if (withdrawValue > getWithdrawLimit()) {
			throw new DomainException("The amount exceeds withdraw limit.");
		}
		if (getBalance() < withdrawValue) {
			throw new DomainException("Not enough balance.");
		}
		balance -= withdrawValue;
	}
	
	public String toString() {
		return "Account: "
				+ number
				+ ", Holder: "
				+ holder
				+ ", Balance: "
				+ String.format("$%.2f", balance);
	}
	
	
	
}
