package myproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class usersDAOImpl implements usersDAO {

	@Override
	public void u_add(users user) {
		Connection conn = DBUtil.open();
	 	String sql = "insert into tb_user(u_user,u_pwd,u_rel_name,u_s_id,u_sex,u_depart,u_tel) values(?,?,?,?,?,?,?)";
	 	
	 	try {
			PreparedStatement pst = conn.prepareStatement(sql);
			
			pst.setString(1, user.getUser());
			pst.setString(2, user.getPwd());
			pst.setString(3, user.getRel_name());
			pst.setString(4, user.getS_id());
			pst.setString(5, user.getSex());
			pst.setString(6, user.getDepart());
			pst.setString(7, user.getTel());
			
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
	}

	@Override
	public void u_update(users user) {
		Connection conn = DBUtil.open();
	 	String sql = "UPDATE tb_user SET u_user = ?,u_pwd = ?,u_rel_name = ?,u_s_id = ?,u_sex = ?,u_depart = ?,u_tel = ? WHERE u_id = ?";
	 	
	 	try {
			PreparedStatement pst = conn.prepareStatement(sql);
			
			pst.setString(1, user.getUser());
			pst.setString(2, user.getPwd());
			pst.setString(3, user.getRel_name());
			pst.setString(4, user.getS_id());
			pst.setString(5, user.getSex());
			pst.setString(6, user.getDepart());
			pst.setString(7, user.getTel());
			pst.setInt(8, user.getId());

			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
	}

	@Override
	public void u_delete(int id) {
		Connection conn = DBUtil.open();
	 	String sql = "delete from tb_user where u_id = ?";
	 	
	 	try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			
			// ÷¥––‘§±‡“Îsql”Ôæ‰
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
	}

	@Override
	public users u_getUserById(int id) {
		Connection conn = DBUtil.open();
	 	String sql = "select * from tb_user where u_id = ?";
	 	
	 	try {
			PreparedStatement pst = conn.prepareStatement(sql);
			
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();

			if(rs.next()){
				
				int Id = rs.getInt(1);
				String user = rs.getString(2);
				String pwd = rs.getString(3);
				String rel_name = rs.getString(4);
				String s_id = rs.getString(5);
				String sex = rs.getString(6);
				String depart = rs.getString(7);
				String tel = rs.getString(8);
				
				users user1 = new users();
				user1.setId(Id);
				user1.setUser(user);
				user1.setPwd(pwd);
				user1.setRel_name(rel_name);
				user1.setS_id(s_id);
				user1.setSex(sex);
				user1.setDepart(depart);
				user1.setTel(tel);
				
				return user1;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return null;
	}

	@Override
	public List<users> u_query() {
		Connection conn = DBUtil.open();
	 	String sql = "select * from tb_user";
	 	List<users> list = new ArrayList<users>();
	 	
	 	try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()){
				
				int Id = rs.getInt(1);
				String user = rs.getString(2);
				String pwd = rs.getString(3);
				String rel_name = rs.getString(4);
				String s_id = rs.getString(5);
				String sex = rs.getString(6);
				String depart = rs.getString(7);
				String tel = rs.getString(8);
				
				users user1 = new users();
				user1.setId(Id);
				user1.setUser(user);
				user1.setPwd(pwd);
				user1.setRel_name(rel_name);
				user1.setS_id(s_id);
				user1.setSex(sex);
				user1.setDepart(depart);
				user1.setTel(tel);
				
				
				list.add(user1);
			}
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return null;
	}

	@Override
	public boolean u_existUser(String name) {
		Connection conn = DBUtil.open();
	 	String sql = "select * from tb_user where u_user = ?";
	 	
	 	try {
			PreparedStatement prt = conn.prepareStatement(sql);
			prt.setString(1, name);
			
			ResultSet rs = prt.executeQuery();
			if(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return false;
	}

	@Override
	public users u_login(String username, String password) {
		Connection conn = DBUtil.open();
	 	String sql = "select * from tb_user where u_user = ? and u_pwd = ?";
	 	
		try {
			PreparedStatement prs = conn.prepareStatement(sql);
			prs.setString(1, username);
			prs.setString(2, password);
			
			ResultSet rs = prs.executeQuery();
			
			if(rs.next()){
				int id = rs.getInt(1);
				
				users u = new users();
				u.setUser(username);
				u.setId(id);
				u.setPwd(password);
				
				return u;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		
		return null;
	}
	
}
