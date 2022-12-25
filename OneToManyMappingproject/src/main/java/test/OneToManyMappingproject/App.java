package test.OneToManyMappingproject;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello
 * 
 *  world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
    	
    	Configuration cfg = new Configuration();
    	cfg=cfg.configure("hibernate.cfg.xml");
    	
    	SessionFactory factory=cfg.buildSessionFactory();
    	Session session=factory.openSession();
    	
    	Student student = new Student();
    	student.setName("Ajay");
    	student.setMarks(85);
    	
    	List<Laptop> laptoplist = new ArrayList<>();
    	
    	Laptop laptop1= new Laptop();
    	laptop1.setLap_name("Asus");
    	laptop1.setStudent(student);
    	
    	Laptop laptop2= new Laptop();
    	laptop2.setLap_name("Oneplus");
    	laptop2.setStudent(student);
    	
    	laptoplist.add(laptop1);
    	laptoplist.add(laptop2);
    	
   
    	student.setLaptop(laptoplist);
    	
    	Transaction transaction=session.beginTransaction();
    	
    	session.save(laptop1);
    	session.save(laptop2);
    	session.save(student);
    	
    	System.out.println("Record Inserted Successfully... ");
    	transaction.commit();
    	
    	session.close();
    	factory.close();   	
    }
}
