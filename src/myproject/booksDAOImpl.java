package myproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class booksDAOImpl implements booksDAO {

	// �鼮�����
	@Override
	public void add(books book) {
		
		// ���ݿ�����
		Connection conn = DBUtil.open();
		String sql = "insert into tb_books(b_name,b_type,b_author,b_price,b_date) values(?,?,?,?,?)";
		
		try {
			
			PreparedStatement pst = conn.prepareStatement(sql);
			
			pst.setString(1, book.getName());
			pst.setString(2, book.getType());
			pst.setString(3, book.getAuthor());
			pst.setString(4, book.getPrice());
			pst.setString(5, book.getDate());
			
			// ִ��Ԥ����sql���
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		
	}

	// �鼮��ɾ��
	@Override
	public void delete(int id) {
		
		Connection conn = DBUtil.open();
		String sql = "delete from tb_books where id=?";
	
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

	// �鼮�ĸ���
	@Override
	public void update(books book) {
		Connection conn = DBUtil.open();
		String sql = "UPDATE tb_books SET b_name = ?,b_type = ?,b_author = ?,b_price = ?,b_date = ? WHERE id = ?";
	
		try {
			
			PreparedStatement pst = conn.prepareStatement(sql);
			
			pst.setString(1, book.getName());
			pst.setString(2, book.getType());
			pst.setString(3, book.getAuthor());
			pst.setString(4, book.getPrice());
			pst.setString(5, book.getDate());
			pst.setInt(6, book.getId());
			
			// ִ��Ԥ����sql���
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
	}

	// ͨ��id��ȡ��Ӧ���鼮
	@Override
	public books getBookById(int id) {
		Connection conn = DBUtil.open();
		String sql = "select * from tb_books where id = ?";
		
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				//��ȡ��������еı���
				int Id = rs.getInt(1);
				String name = rs.getString(2);
				String type = rs.getString(3);
				String author = rs.getString(4);
				String price = rs.getString(5);
				String date = rs.getString(6);
				
				// ��ʱѭ���д���һ��������Ҫ�Ǵ�����ʱ����
				books book = new books();
				book.setId(Id);
				book.setName(name);
				book.setType(type);
				book.setAuthor(author);
				book.setPrice(price);
				book.setDate(date);
				
				return book;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		
		return null;
	}

	// ����ȫ�����鼮
	@Override
	public List<books> query() {
		Connection conn = DBUtil.open();
		String sql = "select * from tb_books";
		
		try {
			//����һ��sql��䴦����󣬲�ִ��
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			// ���������еĶ���
			List<books> list = new ArrayList<books>();
			
			while(rs.next()){
				
				//��ȡ��������еı���
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String type = rs.getString(3);
				String author = rs.getString(4);
				String price = rs.getString(5);
				String date = rs.getString(6);
				
				// ��ʱѭ���д���һ��������Ҫ�Ǵ�����ʱ����
				books book = new books();
				book.setId(id);
				book.setName(name);
				book.setType(type);
				book.setAuthor(author);
				book.setPrice(price);
				book.setDate(date);
				
				list.add(book);
			}
			return list;		// ����list���󼯺�
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		
		return null;
	}
	
	// �����ͷ�����ص�books���list
	public List<books> typeSearch(String type1){
		Connection conn = DBUtil.open();
		String sql = "select * from tb_books where b_type = ?";
		
		try {
			PreparedStatement prt = conn.prepareStatement(sql);
			prt.setString(1, type1);
			ResultSet rs = prt.executeQuery();
			
			// ���������еĶ���
			List<books> list = new ArrayList<books>();
			
			while(rs.next()){
				
				//��ȡ��������еı���
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String type = rs.getString(3);
				String author = rs.getString(4);
				String price = rs.getString(5);
				String date = rs.getString(6);
				
				// ��ʱѭ���д���һ��������Ҫ�Ǵ�����ʱ����
				books book = new books();
				book.setId(id);
				book.setName(name);
				book.setType(type);
				book.setAuthor(author);
				book.setPrice(price);
				book.setDate(date);
				
				list.add(book);
			}
			return list;		// ����list���󼯺�
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
			
		return null;
	}
	
	// �����ҵ�ֵ���в���
	public List<books> textSearch(String text){
		Connection conn = DBUtil.open();
		String sql = "SELECT * FROM tb_books WHERE b_name LIKE '%"+text+"%' OR b_author LIKE '%"+text+"%'";
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			List<books> list = new ArrayList<books>();
			while(rs.next()){
				//��ȡ��������еı���
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String type = rs.getString(3);
				String author = rs.getString(4);
				String price = rs.getString(5);
				String date = rs.getString(6);
				
				// ��ʱѭ���д���һ��������Ҫ�Ǵ�����ʱ����
				books book = new books();
				book.setId(id);
				book.setName(name);
				book.setType(type);
				book.setAuthor(author);
				book.setPrice(price);
				book.setDate(date);
				
				list.add(book);
			}
			return list;		// ����list���󼯺�
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return null;
	}
	
	// ��ȡ�鼮��������
	public String[] distinctType(){
		Connection conn = DBUtil.open();
		String sql = "SELECT DISTINCT b_type from tb_books";
		
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			// �˴��õ��˽�����Ķ�λ����λ�����һ����¼�������¼�¼������Ϊ��¼������
			rs.last();
			int count = rs.getRow();	// ��¼����
			String[] str = new String[count];	// ����һ��Ϊ��¼�������ַ�������
			rs.beforeFirst();	// �ٽ�������ĸ���ָ��ָ���ʼ��λ��
			
			int i = 0;
			while(rs.next()){
				str[i] = rs.getString(1);
				i++;
			}
			return str;		// �����ַ�������
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		
		return null;
		
	}
	
	// �������жϸ����Ƿ����
	public boolean isExist(String book){
		Connection conn = DBUtil.open();
		String sql = "select * from tb_books where b_name=?";
		
		try {
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, book);
			ResultSet rs = pre.executeQuery();
			
			if(rs.next()){
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return false;
	}
	
	
	
}
