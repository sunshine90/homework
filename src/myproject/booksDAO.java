package myproject;

import java.util.List;

public interface booksDAO {
	
	// 接口中抽象函数的申明
	
	// 基本的增删改查
	
	// 以对象的形式添加书籍
	public void add(books book);
	
	// 以id的形式进行书籍的删除
	public void delete(int id);
	
	// 以对象的形式进行书籍的更新
	public void update(books book);
	
	// 按id的形式进行查询书籍，并返回书籍的对象
	public books getBookById(int id);
	
	// 遍历所有的书籍类
	public List<books> query();
	
	// 类型遍历查询
	public List<books> typeSearch(String type1);
	
	// 按文本查找
	public List<books> textSearch(String text);
	
	// 查找书籍的不同类型
	public String[] distinctType();
	
	// 书名判断该书是否存在
	public boolean isExist(String book);
	
	//  实现类 -----  booksDAOImpl.java
	
}
