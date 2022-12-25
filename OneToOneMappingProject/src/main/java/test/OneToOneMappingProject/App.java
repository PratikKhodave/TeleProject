package test.OneToOneMappingProject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
    
    	Configuration cfg = new Configuration();
    	cfg=cfg.configure("hibernate.cfg.xml");
    	
    	SessionFactory factory=cfg.buildSessionFactory();
    	Session session=factory.openSession();
    	
    	Laptop laptop = new Laptop();
    	laptop.setLap_name("HP");
    	
    	Laptop laptop1 = new Laptop();
    	laptop1.setLap_name("Lenovo");
    	
    	Student student = new Student();
    	student.setName("Ram");
    	student.setMarks(80);
    	student.setLaptop(laptop);
    	student.setLaptop(laptop1);
    	
    	Transaction transaction=session.beginTransaction();
    	session.save(student);
    	
    	System.out.println("Student saved Successfully...");
    	transaction.commit();
    	
    	session.close();
    	factory.close();
    	
    	
    }
}
