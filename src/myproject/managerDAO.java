package myproject;

import java.util.List;

public interface managerDAO {
	// ����Ա���dao�ӿ�
	
	// �Զ������ʽ������ӹ���Ա���
	public void m_add(manager m);
	
	// �Զ������ʽ���й���Ա�ĸ���
	public void m_update(manager m);
	
	// ��ID����ʽ���й�����ݵ�ɾ���޸�
	public void m_delete(int id);
	
	// ��ID ��ʽ���в�ѯ����Ա���
	public manager m_getManagerById(int id);
	
	// �Լ��ϵ���ʽ���б������е��鼮��
	public List<manager> m_query();

	public boolean idExist(int id);
	
	// ���ҹ���Ա�����֤
	public manager m_login(String name,String tel,String pwd);
	// ʵ����------ --  managerDAOImpl.java

}









