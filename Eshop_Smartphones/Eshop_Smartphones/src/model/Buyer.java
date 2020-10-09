package model;

public class Buyer {
	
	 
	private String name;
    private String surname;
    private String Phonenumber;
    private String address;
    private String Status="";
    private String model="";
    private String price="";
    private String date="";
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPhonenumber() {
		return Phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		Phonenumber = phonenumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
    public String toString() {
        return "Buyer name=" + name + ", SurName=" + surname +", Phonenumber=" + Phonenumber + ", Address"+address+",Status "+Status+",Model "+model+",Date"+date+",Price"+price+"";
 }
	 
 
}
