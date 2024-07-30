package CustomerView;

import java.time.LocalDate;

public class CustomerBean {
	
	String cname;
	String mobile;
	String address;
	String sel_papers;
	String sel_price;
	LocalDate dos;
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSel_papers() {
		return sel_papers;
	}
	public void setSel_papers(String sel_papers) {
		this.sel_papers = sel_papers;
	}
	public String getSel_price() {
		return sel_price;
	}
	public void setSel_price(String sel_price) {
		this.sel_price = sel_price;
	}
	public LocalDate getDos() {
		return dos;
	}
	public void setDos(LocalDate dos) {
		this.dos = dos;
	}
	public CustomerBean(String cname, String mobile, String address, String sel_papers, String sel_price,
			LocalDate dos) {
		super();
		this.cname = cname;
		this.mobile = mobile;
		this.address = address;
		this.sel_papers = sel_papers;
		this.sel_price = sel_price;
		this.dos = dos;
	}
	
}
