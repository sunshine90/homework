package myproject;

import java.util.List;

public interface booksDAO {
	
	// �ӿ��г�����������
	
	// ��������ɾ�Ĳ�
	
	// �Զ������ʽ����鼮
	public void add(books book);
	
	// ��id����ʽ�����鼮��ɾ��
	public void delete(int id);
	
	// �Զ������ʽ�����鼮�ĸ���
	public void update(books book);
	
	// ��id����ʽ���в�ѯ�鼮���������鼮�Ķ���
	public books getBookById(int id);
	
	// �������е��鼮��
	public List<books> query();
	
	// ���ͱ�����ѯ
	public List<books> typeSearch(String type1);
	
	// ���ı�����
	public List<books> textSearch(String text);
	
	// �����鼮�Ĳ�ͬ����
	public String[] distinctType();
	
	// �����жϸ����Ƿ����
	public boolean isExist(String book);
	
	//  ʵ���� -----  booksDAOImpl.java
	
}
