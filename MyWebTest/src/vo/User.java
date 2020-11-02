package vo;

public class User {
	private String userName;
	private String password;
	private String chrName;	
	private String role;
	private String mail;
	private String povi;
	private String city;	
	private String povicode;
	private String citycode;

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getChrName() {
		return chrName;
	}
	public void setChrName(String chrName) {
		this.chrName = chrName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPovi() {
		return povi;
	}
	public void setPovi(String povi) {
		this.povi = povi;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getPoviCode() {
		return povicode;
	}
	public void setPoviCode(String poviCode) {
		this.povicode = povicode;
	}
	public String getCityCode() {
		return citycode;
	}
	public void setCityCode(String cityCode) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", chrName=" + chrName + ", role=" + role
				+ ", mail=" + mail + ", povi=" + povi + ", city=" + city + "]";
	}

	
 
	
}
