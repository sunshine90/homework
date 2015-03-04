package myproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Code {
	
	public String getCode(int id){
		Connection conn = DBUtil.open();
		String sql = "select * from tb_code where code_id = ?";
		
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){
				return rs.getString(2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// 测试code代码的获取
//	public static void main(String[] args) {
//		Code code = new Code();
//		String str = code.getCode(3);
//		System.out.println(str);
//	}
}
