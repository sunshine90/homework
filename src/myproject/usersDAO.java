package myproject;

import java.util.List;

public interface usersDAO {
	
	// ����Ա���dao�ӿ�
	
		public void u_add(users user);
		public void u_update(users user);
		public void u_delete(int id);
		public users u_getUserById(int id);
		public List<users> u_query();
		
		// ���û�������
		public boolean u_existUser(String name);
		
		// �û���¼��ѯ�û���������
		public users u_login(String username,String password);
	// ʵ���ൽ  usersDAOImpl.java -----
}
