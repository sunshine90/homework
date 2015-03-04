package myproject;

public class manager {
	
	private int id;
	private String name;
	private String pwd;
	private String sex;
	private String tel;
	
	// 无参构造器
	public manager(){
		super();
		this.name = null;
		this.pwd = null;
		this.sex = null;
		this.tel = null;
	}
	
	// 有参构造器 
	public manager(String name, String pwd, String sex, String tel) {
		super();
		this.name = name;
		this.pwd = pwd;
		this.sex = sex;
		this.tel = tel;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	@Override
	public String toString() {
		return "manager [id=" + id + ", name=" + name + ", pwd=" + pwd
				+ ", sex=" + sex + ", tel=" + tel + "]";
	}
	
	
	
}
















