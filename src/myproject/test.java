
package myproject;

import java.util.ArrayList;
import java.util.List;

 public class test {

	 
/*
 * ======================  以用户名的形式判断用户是否存在 =========================
 *	

	 public static void main(String[] args) {	
		usersDAO udao = new usersDAOImpl();
		boolean bool = udao.u_existUser("彩虹");
		System.out.println(bool);
//		users user = udao.u_login("彩虹", "123456");
//		System.out.println(user.getId() + ":" + user.getUser());
//		 managerDAO mdao = new managerDAOImpl();
//		 manager man = mdao.m_login("18523892937", "185292937", "123456");
//		 System.out.println(man);
//		 System.out.println("姓名："+man.getName() + "电话号码："+man.getTel() + "密码：" +man.getPwd());
	}
*/ 

	/*
	 * ============================= usersDAO实现类的测试 ====================================
	public static void main(String[] args) {
	
		usersDAO udao = new usersDAOImpl();
		//1. 添加用户
//		users user = new users("天空之城1", "123456", "王五", "2013214567", "男", "软件工程学院", "18538335254");
//		udao.u_add(user);
		//2.更新用户
//		users user = new users("sky", "123456", "赵六", "2013211542", "女", "软件工程学院", "18852465823");
//		user.setId(2013214241); //-------->>>>>这一步为确定更新的id所对应的
//		udao.u_update(user);
		//3.按ID号进行删除
//		udao.u_delete(2013214241);
		//4.按ID查找用户
//		users user = udao.u_getUserById(1);
//		System.out.println(user);
		//5.遍历全部用户
//		List<users> list = udao.u_query();
//		System.out.println(list);
		
	}
	*/
	
	/*
	 * ================= managerDAO实现类的---测试 ======================
	// test
	public static void main(String[] args) {
		
		managerDAO mdao = new managerDAOImpl();
		
		//1.添加管理员
//		manager m = new manager("李鑫其", "123456", "男", "18523892937");
//		mdao.m_add(m);
		
		//2.更新管理员信息
//		manager m = new manager("张三三", "123", "男", "18811112222");
//		m.setId(2);
//		mdao.m_update(m);
		
		//3.按ID删除管理员身份
//		mdao.m_delete(1);	//id为 1 的管理员固定不准删除
//		mdao.m_delete(2);	// 该id不存在，删除会报错
		
		//4.按ID查找
//		manager m = mdao.m_getManagerById(1);
//		System.out.println(m);
		
		//5.判断该 id 是否存在！
//		System.out.println(mdao.idExist(1));
		
		//6.以集合的形式进行遍历所有元素
//		List<manager> list = mdao.m_query();
//		System.out.println(list);
	}
	*/

	/*
	 * =================== booksDAO实现类的测试 =========================
	public static void main(String[] args) {
		
		// 利用接口创建一个实现类的dao对象
		booksDAO dao = new booksDAOImpl();
		
		// 9.按书名查找书籍是否存在
//		boolean bool = dao.isExist("高等数学1");
//		System.out.println(bool);
		
		// 8.查找不同类型
//		String[] str = dao.distinctType();
//		
//		for(int i=0;i<str.length;i++){
//			System.out.println(str[i]);
//		}
		
//		// 1.增加
//		books book = new books();
//		book.setName("新世纪日本语教程1");
//		book.setType("基础课程");
//		book.setAuthor("水谷信子");
//		book.setPrice("39.90");
//		book.setDate(null);
//		dao.add(book);
		
		// 2.更新
//		books book = new books();		
//		book.setName("新世纪日本语教程");
//		book.setType("基础课程");
//		book.setAuthor("水谷信子");
//		book.setPrice("39.90");
//		book.setDate(null);
//		book.setId(5);
//		dao.update(book);
		
		// 3.删除
//		dao.delete(7);	
		
		// 4.遍历
//		List<books> list = dao.query();
//		System.out.println(list);   //此处输出是在控制台上进行输出，是因为对books类中进行了tostring方法的重写
		
		
		// 5.按id进行查询
//		books book = dao.getBookById(2);	
//		System.out.println(book);
		
		// 6.按类型进行查询
//		List<books> list = dao.typeSearch("基础科学");
//		System.out.println(list);
		
		// 7.按文本来进行查找
//		List<books> list = dao.textSearch("大学");
//		System.out.println(list);
		
	}
	*/
	
	

}
