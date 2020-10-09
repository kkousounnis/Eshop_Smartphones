package model;

public class User {
	private String Phonenumber;
	private String username;
	private String password;
	private String name;
    private String surname;
    private String address;
    private String idnumber;
    
    public String getPhonenumber() {
		return Phonenumber;
	}
	public void setPhonenumber(String d) {
		Phonenumber = d;
	} 
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
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
	 @Override
	    public String toString() {
	        return "User [Username="+username+",Password"+password +",Idnumber="+idnumber+", Name=" + name
	                + ", SurName=" + surname +", Phonenumber=" + Phonenumber + ", Address"+address+  " ]";
	 }
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getIdnumber() {
		return idnumber;
	}
	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}
	
	
}
