package myproject;

public class users {

	private int id;
	private String user;
	private String pwd;
	private String rel_name;
	private String s_id;
	private String sex;
	private String depart;
	private String tel;
	
	// 空构造器
	public users(){
		super();
		this.user = null;
		this.pwd = null;
		this.s_id = null;
		this.rel_name = null;
		this.sex = null;
		this.depart = null;
		this.tel = null;
	}
	
	// 构造一个 users 构造器
	public users(String user, String pwd, String rel_name, String s_id,
			String sex, String depart, String tel) {
		super();
		this.user = user;
		this.pwd = pwd;
		this.s_id = s_id;
		this.rel_name = rel_name;
		this.sex = sex;
		this.depart = depart;
		this.tel = tel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getS_id() {
		return s_id;
	}

	public void setS_id(String s_id) {
		this.s_id = s_id;
	}

	public String getRel_name() {
		return rel_name;
	}

	public void setRel_name(String rel_name) {
		this.rel_name = rel_name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "users [id=" + id + ", user=" + user + ", pwd=" + pwd
				+ ", s_id=" + s_id + ", rel_name=" + rel_name + ", sex=" + sex
				+ ", depart=" + depart + ", tel=" + tel + "]";
	}
	
	
	
}
