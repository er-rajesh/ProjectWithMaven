package com.org.first;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

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
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Project Started!" );
        Configuration config=new Configuration();
        // configure automatically picks xml file and we can specify it too, if don't find file in packages
        config.configure("hibernate.cfg.xml");
        SessionFactory factory=config.buildSessionFactory();
        
        //Creating Student
        Student student = new Student();
        student.setId(1);
        student.setName("Rajesh");
        student.setCity("Delhi");
        System.out.println(student);
        
        //Creating Object of Address Class
        Address address=new Address();
        address.setStreet("Street 1");
        address.setCity("Delhi");
        address.setOpen(true);
        address.setAddDate(new Date());
        address.setX(1234.45);
        
        // Reading Images
        FileInputStream fileRead=new FileInputStream("src/main/java/pic.png");
        byte[] image=new byte[fileRead.available()];
        address.setImage(image);
        
        // Assigning a session from factory Open session
        Session session = factory.openSession();
        
        //Assigning Transaction to variable and starting transaction
        Transaction tx=session.beginTransaction();

        //saving the student object data
        session.save(student);
        session.save(address);
        
        //Commit transaction in database
        tx.commit();
        
        // Closing the Session 
        session.close();
        factory.close();
    }
}
