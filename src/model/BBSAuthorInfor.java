package model;

public class BBSAuthorInfor {
	private String id;
	private String username;
	private String nickname;
	private String password;
	private String email;
	private String idcard;
	private String sex;
	private String telephone;
	private String qq;
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	private String img;
	public BBSAuthorInfor() {
		// TODO Auto-generated constructor stub
	}
	
	public BBSAuthorInfor(String id, String username, String nickname, String password, String email, String idcard,
			String sex, String telephone, String qq,String img) {
		super();
		this.id = id;
		this.username = username;
		this.nickname = nickname;
		this.password = password;
		this.email = email;
		this.idcard = idcard;
		this.sex = sex;
		this.telephone = telephone;
		this.qq = qq;
		this.img = img;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	
}
