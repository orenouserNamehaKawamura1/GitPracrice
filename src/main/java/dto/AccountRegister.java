package dto;

public class AccountRegister {
	private int id;
	private int age;
	private String name;
	private String mail;
	private String gender;
	private String tel;
	private String pw;
	private String salt;
	private String hashpw;
	public AccountRegister(int id, String name,int age, String gender,  String tel, String mail,String pw, String salt,
			String hashpw) {
		super();
		this.id = id;
		this.age = age;
		this.name = name;
		this.mail = mail;
		this.gender = gender;
		this.tel = tel;
		this.pw = pw;
		this.salt = salt;
		this.hashpw = hashpw;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getHashpw() {
		return hashpw;
	}
	public void setHashpw(String hashpw) {
		this.hashpw = hashpw;
	}
	
	
}
