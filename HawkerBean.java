package Hawker_tableview;

public class HawkerBean {

		String name;
		String address;
		String aadhar;
		String contact;
		String selected;
		
			
		public HawkerBean(String hname, String haddress, String haadhar, String hcontact, String hselected) {
			super();
			this.name = hname;
			this.address = haddress;
			this.aadhar = haadhar;
			this.contact = hcontact;
			this.selected = hselected;
		}

		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getAadhar() {
			return aadhar;
		}
		public void setAadhar(String aadhar) {
			this.aadhar = aadhar;
		}
		public String getContact() {
			return contact;
		}
		public void setContact(String contact) {
			this.contact = contact;
		}
		public String getSelected() {
			return selected;
		}
		public void setSelected(String selected) {
			this.selected = selected;
		}
		
		

	}
