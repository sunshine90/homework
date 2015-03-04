package myproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class booksDAOImpl implements booksDAO {

	// 书籍的添加
	@Override
	public void add(books book) {
		
		// 数据库连接
		Connection conn = DBUtil.open();
		String sql = "insert into tb_books(b_name,b_type,b_author,b_price,b_date) values(?,?,?,?,?)";
		
		try {
			
			PreparedStatement pst = conn.prepareStatement(sql);
			
			pst.setString(1, book.getName());
			pst.setString(2, book.getType());
			pst.setString(3, book.getAuthor());
			pst.setString(4, book.getPrice());
			pst.setString(5, book.getDate());
			
			// 执行预编译sql语句
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		
	}

	// 书籍的删除
	@Override
	public void delete(int id) {
		
		Connection conn = DBUtil.open();
		String sql = "delete from tb_books where id=?";
	
		try {
			
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			
			// 执行预编译sql语句
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
	}

	// 书籍的更新
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
			
			// 执行预编译sql语句
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
	}

	// 通过id获取相应的书籍
	@Override
	public books getBookById(int id) {
		Connection conn = DBUtil.open();
		String sql = "select * from tb_books where id = ?";
		
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				//获取到结果集中的变量
				int Id = rs.getInt(1);
				String name = rs.getString(2);
				String type = rs.getString(3);
				String author = rs.getString(4);
				String price = rs.getString(5);
				String date = rs.getString(6);
				
				// 临时循环中创建一个对象，主要是储存临时对象
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

	// 遍历全部的书籍
	@Override
	public List<books> query() {
		Connection conn = DBUtil.open();
		String sql = "select * from tb_books";
		
		try {
			//创建一个sql语句处理对象，并执行
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			// 保存结果集中的对象
			List<books> list = new ArrayList<books>();
			
			while(rs.next()){
				
				//获取到结果集中的变量
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String type = rs.getString(3);
				String author = rs.getString(4);
				String price = rs.getString(5);
				String date = rs.getString(6);
				
				// 临时循环中创建一个对象，主要是储存临时对象
				books book = new books();
				book.setId(id);
				book.setName(name);
				book.setType(type);
				book.setAuthor(author);
				book.setPrice(price);
				book.setDate(date);
				
				list.add(book);
			}
			return list;		// 返回list对象集合
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		
		return null;
	}
	
	// 以类型返回相关的books类的list
	public List<books> typeSearch(String type1){
		Connection conn = DBUtil.open();
		String sql = "select * from tb_books where b_type = ?";
		
		try {
			PreparedStatement prt = conn.prepareStatement(sql);
			prt.setString(1, type1);
			ResultSet rs = prt.executeQuery();
			
			// 保存结果集中的对象
			List<books> list = new ArrayList<books>();
			
			while(rs.next()){
				
				//获取到结果集中的变量
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String type = rs.getString(3);
				String author = rs.getString(4);
				String price = rs.getString(5);
				String date = rs.getString(6);
				
				// 临时循环中创建一个对象，主要是储存临时对象
				books book = new books();
				book.setId(id);
				book.setName(name);
				book.setType(type);
				book.setAuthor(author);
				book.setPrice(price);
				book.setDate(date);
				
				list.add(book);
			}
			return list;		// 返回list对象集合
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
			
		return null;
	}
	
	// 按查找的值进行查找
	public List<books> textSearch(String text){
		Connection conn = DBUtil.open();
		String sql = "SELECT * FROM tb_books WHERE b_name LIKE '%"+text+"%' OR b_author LIKE '%"+text+"%'";
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			List<books> list = new ArrayList<books>();
			while(rs.next()){
				//获取到结果集中的变量
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String type = rs.getString(3);
				String author = rs.getString(4);
				String price = rs.getString(5);
				String date = rs.getString(6);
				
				// 临时循环中创建一个对象，主要是储存临时对象
				books book = new books();
				book.setId(id);
				book.setName(name);
				book.setType(type);
				book.setAuthor(author);
				book.setPrice(price);
				book.setDate(date);
				
				list.add(book);
			}
			return list;		// 返回list对象集合
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return null;
	}
	
	// 获取书籍类型数组
	public String[] distinctType(){
		Connection conn = DBUtil.open();
		String sql = "SELECT DISTINCT b_type from tb_books";
		
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			// 此处用到了结果集的定位，定位到最后一条记录，并记下记录数，作为记录的总数
			rs.last();
			int count = rs.getRow();	// 记录总数
			String[] str = new String[count];	// 创建一个为记录总数的字符串数组
			rs.beforeFirst();	// 再将结果集的浮动指针指向初始化位置
			
			int i = 0;
			while(rs.next()){
				str[i] = rs.getString(1);
				i++;
			}
			return str;		// 返回字符串数组
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		
		return null;
		
	}
	
	// 用书名判断该书是否存在
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
