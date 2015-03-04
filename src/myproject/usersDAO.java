package myproject;

import java.util.List;

public interface usersDAO {
	
	// 管理员身份dao接口
	
		public void u_add(users user);
		public void u_update(users user);
		public void u_delete(int id);
		public users u_getUserById(int id);
		public List<users> u_query();
		
		// 按用户名查找
		public boolean u_existUser(String name);
		
		// 用户登录查询用户名与密码
		public users u_login(String username,String password);
	// 实现类到  usersDAOImpl.java -----
}
