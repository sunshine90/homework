package myproject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class books {
	
	//��ȡtb_books���е�����
	private int id;
	private String name;
	private String type;
	private String author;
	private String price;
	private String date;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	// get set ����
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String d) {
		this.price = d;
	}
//	public static String getDate() {
//		setDate(null);
//		return date;
//	}
//	public static void setDate(String date1) {
//		if(date1 != null){
//			date = date1;
//		}else{
//			Date da = new Date();
//			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//			String time = sdf.format(da);
//			date = time;
//		}
//	}
	
	
	
	//toString ��������д
	@Override
	public String toString() {
		return "id=" + id + ", name=" + name + ", type=" + type
				+ ", author=" + author + ", price=" + price + ";\n";
	}

	
}
