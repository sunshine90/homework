package myproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class managerDAOImpl implements managerDAO {

	// ����Ա��ݵ����
	@Override
	public void m_add(manager m) {
		
	 	Connection conn = DBUtil.open();
	 	String sql = "insert into tb_manager(m_name,m_pwd,m_sex,m_tel) values(?,?,?,?)";
	 	
	 	try {
			PreparedStatement pst = conn.prepareStatement(sql);
			
			pst.setString(1, m.getName());
			pst.setString(2, m.getPwd());
			pst.setString(3, m.getSex());
			pst.setString(4, m.getTel());
			
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
	}

	// ���¹���Ա���
	@Override
	public void m_update(manager m) {
		Connection conn = DBUtil.open();
	 	String sql = "UPDATE tb_manager SET m_name = ?,m_pwd = ?,m_sex = ?,m_tel = ? WHERE m_id = ?";
	 	
	 	try {
			PreparedStatement pst = conn.prepareStatement(sql);
			
			pst.setString(1, m.getName());
			pst.setString(2, m.getPwd());
			pst.setString(3, m.getSex());
			pst.setString(4, m.getTel());
			pst.setInt(5, m.getId());

			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
	 	
	}

	// ͨ��IDɾ������Ա���
	@Override
	public void m_delete(int id) {
		if(id == 1){
			try {
				throw new Exception("ȷ������Ա��ݵ���Ҫ�ԣ��ù���Ա����ɾ����");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(!idExist(id)){
			try {
				throw new Exception("��Ҫɾ���� id �����ڣ�������ѡ��");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			Connection conn = DBUtil.open();
		 	String sql = "delete from tb_manager where m_id = ?";
		 	
		 	try {
				PreparedStatement pst = conn.prepareStatement(sql);
				pst.setInt(1, id);
				
				// ִ��Ԥ����sql���
				pst.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				DBUtil.close(conn);
			}
		}
	}


	// ͨ��ID ��ѯ����Ա���
	@Override
	public manager m_getManagerById(int id) {
		if(!idExist(id)){
			try {
				throw new Exception("û���ҵ�������ѯ ID ��ƥ�����Ϣ��������ȷ����");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}else{
			Connection conn = DBUtil.open();
		 	String sql = "select * from tb_manager where m_id = ?";
		 	
		 	try {
				PreparedStatement pst = conn.prepareStatement(sql);
				
				pst.setInt(1, id);
				ResultSet rs = pst.executeQuery();
	
				if(rs.next()){
					
					int Id = rs.getInt(1);
					String name = rs.getString(2);
					String pwd = rs.getString(3);
					String sex = rs.getString(4);
					String tel = rs.getString(5);
					
					manager m = new manager();
					m.setId(Id);
					m.setName(name);
					m.setPwd(pwd);
					m.setSex(sex);
					m.setTel(tel);
					
					return m;
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				DBUtil.close(conn);
			}
			return null;
		}
	}

	// �������еĹ���Ա
	@Override
	public List<manager> m_query() {
		Connection conn = DBUtil.open();
	 	String sql = "select * from tb_manager";
	 	List<manager> list = new ArrayList<manager>();
	 	
	 	try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()){
				
				int Id = rs.getInt(1);
				String name = rs.getString(2);
				String pwd = rs.getString(3);
				String sex = rs.getString(4);
				String tel = rs.getString(5);
				
				manager m = new manager();
				m.setId(Id);
				m.setName(name);
				m.setPwd(pwd);
				m.setSex(sex);
				m.setTel(tel);
				
				list.add(m);
			}
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		
		return null;
	}

	// �жϲ�ѯ��id�Ƿ����
	public boolean idExist(int id){
		Connection conn = DBUtil.open();
		String sql = "select m_id from tb_manager where m_id = ?";
		
		try {
			PreparedStatement prs = conn.prepareStatement(sql);
			prs.setInt(1, id);
			ResultSet rs = prs.executeQuery();
			
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

	// ���ֻ�绰������в���
	@Override
	public manager m_login(String name, String tel, String pwd) {
		Connection conn = DBUtil.open();
	 	String sql = "select * from tb_manager where m_pwd = ? and (m_name = ? or m_tel = ?)";
	 	
	 	try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(2, name);
			pst.setString(3, tel);
			pst.setString(1, pwd);
			
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				manager man = new manager();
				man.setId(rs.getInt(1));
				man.setName(rs.getString(2));
				man.setPwd(rs.getString(3));
				man.setSex(rs.getString(4));
				man.setTel(rs.getString(5));
				
				return man;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return null;
	}

}
