
package myproject;

import java.util.ArrayList;
import java.util.List;

 public class test {

	 
/*
 * ======================  ���û�������ʽ�ж��û��Ƿ���� =========================
 *	

	 public static void main(String[] args) {	
		usersDAO udao = new usersDAOImpl();
		boolean bool = udao.u_existUser("�ʺ�");
		System.out.println(bool);
//		users user = udao.u_login("�ʺ�", "123456");
//		System.out.println(user.getId() + ":" + user.getUser());
//		 managerDAO mdao = new managerDAOImpl();
//		 manager man = mdao.m_login("18523892937", "185292937", "123456");
//		 System.out.println(man);
//		 System.out.println("������"+man.getName() + "�绰���룺"+man.getTel() + "���룺" +man.getPwd());
	}
*/ 

	/*
	 * ============================= usersDAOʵ����Ĳ��� ====================================
	public static void main(String[] args) {
	
		usersDAO udao = new usersDAOImpl();
		//1. ����û�
//		users user = new users("���֮��1", "123456", "����", "2013214567", "��", "�������ѧԺ", "18538335254");
//		udao.u_add(user);
		//2.�����û�
//		users user = new users("sky", "123456", "����", "2013211542", "Ů", "�������ѧԺ", "18852465823");
//		user.setId(2013214241); //-------->>>>>��һ��Ϊȷ�����µ�id����Ӧ��
//		udao.u_update(user);
		//3.��ID�Ž���ɾ��
//		udao.u_delete(2013214241);
		//4.��ID�����û�
//		users user = udao.u_getUserById(1);
//		System.out.println(user);
		//5.����ȫ���û�
//		List<users> list = udao.u_query();
//		System.out.println(list);
		
	}
	*/
	
	/*
	 * ================= managerDAOʵ�����---���� ======================
	// test
	public static void main(String[] args) {
		
		managerDAO mdao = new managerDAOImpl();
		
		//1.��ӹ���Ա
//		manager m = new manager("������", "123456", "��", "18523892937");
//		mdao.m_add(m);
		
		//2.���¹���Ա��Ϣ
//		manager m = new manager("������", "123", "��", "18811112222");
//		m.setId(2);
//		mdao.m_update(m);
		
		//3.��IDɾ������Ա���
//		mdao.m_delete(1);	//idΪ 1 �Ĺ���Ա�̶���׼ɾ��
//		mdao.m_delete(2);	// ��id�����ڣ�ɾ���ᱨ��
		
		//4.��ID����
//		manager m = mdao.m_getManagerById(1);
//		System.out.println(m);
		
		//5.�жϸ� id �Ƿ���ڣ�
//		System.out.println(mdao.idExist(1));
		
		//6.�Լ��ϵ���ʽ���б�������Ԫ��
//		List<manager> list = mdao.m_query();
//		System.out.println(list);
	}
	*/

	/*
	 * =================== booksDAOʵ����Ĳ��� =========================
	public static void main(String[] args) {
		
		// ���ýӿڴ���һ��ʵ�����dao����
		booksDAO dao = new booksDAOImpl();
		
		// 9.�����������鼮�Ƿ����
//		boolean bool = dao.isExist("�ߵ���ѧ1");
//		System.out.println(bool);
		
		// 8.���Ҳ�ͬ����
//		String[] str = dao.distinctType();
//		
//		for(int i=0;i<str.length;i++){
//			System.out.println(str[i]);
//		}
		
//		// 1.����
//		books book = new books();
//		book.setName("�������ձ���̳�1");
//		book.setType("�����γ�");
//		book.setAuthor("ˮ������");
//		book.setPrice("39.90");
//		book.setDate(null);
//		dao.add(book);
		
		// 2.����
//		books book = new books();		
//		book.setName("�������ձ���̳�");
//		book.setType("�����γ�");
//		book.setAuthor("ˮ������");
//		book.setPrice("39.90");
//		book.setDate(null);
//		book.setId(5);
//		dao.update(book);
		
		// 3.ɾ��
//		dao.delete(7);	
		
		// 4.����
//		List<books> list = dao.query();
//		System.out.println(list);   //�˴�������ڿ���̨�Ͻ������������Ϊ��books���н�����tostring��������д
		
		
		// 5.��id���в�ѯ
//		books book = dao.getBookById(2);	
//		System.out.println(book);
		
		// 6.�����ͽ��в�ѯ
//		List<books> list = dao.typeSearch("������ѧ");
//		System.out.println(list);
		
		// 7.���ı������в���
//		List<books> list = dao.textSearch("��ѧ");
//		System.out.println(list);
		
	}
	*/
	
	

}
