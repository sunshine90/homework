package myproject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
	
	// ��̬����������
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	
	// ������ʼ��
	static {
		// �����ļ�������
		Properties prop = new Properties();
		// �ļ�����
		//Reader in;
		try {
		//	in = new FileReader("src//config.properties");
			prop.load(DBUtil.class.getClassLoader().getResourceAsStream("config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// �����ļ�����
		driver = prop.getProperty("driver");
		url = prop.getProperty("url");
		user = prop.getProperty("username");
		password = prop.getProperty("password");
		
	}
	
	// �����ݵĺ�������
	public static Connection open(){
		
		try {
			// �������ݿ�����
			Class.forName(driver);
			// ����һ�����Ӻ�����Ӷ���
			return DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	// �ر����ݿ������
	public static void close(Connection conn){
		// ����һ��connection������йر����ݿ�����
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
















