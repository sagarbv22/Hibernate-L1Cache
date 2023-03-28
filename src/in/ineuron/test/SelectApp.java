package in.ineuron.test;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Employee;
import in.ineuron.util.HibernateUtil;

public class SelectApp {

	public static void main(String[] args) throws IOException {

		Session session = null;
		
		
		session=HibernateUtil.getSession();
		
		Employee e1 = session.get(Employee.class, 1);
		System.out.println(e1);//from DB
		
		Employee e2 = session.get(Employee.class, 1);
		System.out.println(e2);//from L1 cache
		
		session.evict(e1);//removed from L1 cache
		
		Employee e3 = session.get(Employee.class, 1);
		System.out.println(e3);//from DB
		
		Employee e4 = session.get(Employee.class, 2);
		System.out.println(e4);//from DB
		
		session.clear();//Removed all objects from L1 cache
		
			
	
	}

}
