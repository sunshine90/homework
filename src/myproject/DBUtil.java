package myproject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
	
	// 静态变量的申明
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	
	// 块语句初始化
	static {
		// 配置文件的引入
		Properties prop = new Properties();
		// 文件读入
		//Reader in;
		try {
		//	in = new FileReader("src//config.properties");
			prop.load(DBUtil.class.getClassLoader().getResourceAsStream("config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 加载文件内容
		driver = prop.getProperty("driver");
		url = prop.getProperty("url");
		user = prop.getProperty("username");
		password = prop.getProperty("password");
		
	}
	
	// 打开数据的函数调用
	public static Connection open(){
		
		try {
			// 链接数据库驱动
			Class.forName(driver);
			// 返回一个链接后的链接对象
			return DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	// 关闭数据库的链接
	public static void close(Connection conn){
		// 传入一个connection对象进行关闭数据库连接
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
















