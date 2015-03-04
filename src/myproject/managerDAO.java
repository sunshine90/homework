package myproject;

import java.util.List;

public interface managerDAO {
	// 管理员身份dao接口
	
	// 以对象的形式进行添加管理员身份
	public void m_add(manager m);
	
	// 以对象的形式进行管理员的更新
	public void m_update(manager m);
	
	// 以ID的形式进行管理身份的删除修改
	public void m_delete(int id);
	
	// 以ID 形式进行查询管理员身份
	public manager m_getManagerById(int id);
	
	// 以集合的形式进行遍历所有的书籍类
	public List<manager> m_query();

	public boolean idExist(int id);
	
	// 查找管理员身份验证
	public manager m_login(String name,String tel,String pwd);
	// 实现类------ --  managerDAOImpl.java

}









