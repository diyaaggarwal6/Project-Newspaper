package BillStatusChecker;

import java.time.LocalDate;

public class BillBean {
	String mobile;
	LocalDate dos;
	LocalDate dupto;
	float bill;
	int status;
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public LocalDate getDos() {
		return dos;
	}
	public void setDos(LocalDate dos) {
		this.dos = dos;
	}
	public LocalDate getDupto() {
		return dupto;
	}
	public void setDupto(LocalDate dupto) {
		this.dupto = dupto;
	}
	public float getBill() {
		return bill;
	}
	public void setBill(float bill) {
		this.bill = bill;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public BillBean(String mobile, LocalDate dos, LocalDate dupto, float bill, int status) {
		super();
		this.mobile = mobile;
		this.dos = dos;
		this.dupto = dupto;
		this.bill = bill;
		this.status = status;
	}
		
}
