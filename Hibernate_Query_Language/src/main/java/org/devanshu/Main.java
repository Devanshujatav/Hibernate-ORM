package org.devanshu;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.query.sql.internal.SQLQueryParser;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.transform.Transformers;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;


public class Main {
    public static void main(String[] args) {
        Configuration config = new Configuration().configure().addAnnotatedClass(Student.class);
        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        SessionFactory sf = config.buildSessionFactory(registry);
        Session session = sf.openSession();
        session.beginTransaction();

        // Set up the data into the table
//        Random r = new Random();
//        for (int i=1 ; i<=50 ; i++){
//            Student s = new Student();
//            s.setRollno(i);
//            s.setName("Name :" + i);
//            s.setMarks(r.nextInt(100));
//            session.persist(s);
//        }

        // Fetching the data from the table
//        Query q = session.createQuery("from Student");
//        List<Student> students = q.list();
//
//        for (Student s : students){
//            System.out.println(s);
//        }


        // Fetching One data from the table
//        Query q = session.createQuery("FROM Student WHERE rollno=7");
//        Student student = (Student) q.uniqueResult();
//        System.out.println(student);

        // Fetching the data of only one student in the array
//        Query q = session.createQuery("SELECT rollno , name , marks FROM Student WHERE rollno=7");
//        Object[] student = (Object[]) q.uniqueResult();
//        System.out.println(student[0] + " : " + student[1] + " : " + student[2]);

        // Fetching the data of all the students in the list of arrays
//        Query q = session.createQuery("SELECT rollno , name , marks FROM Student");
//        List<Object[]> students = (List<Object[]>) q.list();
//        for (Object[] student : students){
//            System.out.println(student[0] + " : " + student[1] + " : " + student[2]);
//        }

        // Fetching the data of one student through SQL Query
//        Query query = session.createNativeQuery("SELECT * FROM student WHERE rollno = ?", Student.class);
//        query.setParameter(1, 1);
//        List<Student> students = query.getResultList();
//        for (Student s : students){
//            System.out.println(s);
//        }
//
        // Fetching the data of all the students through SQL Query
//        Query query = session.createNativeQuery("SELECT * FROM Student WHERE marks>60" , Student.class);
//        List<Student> students = query.list();
//        for (Student s : students){
//            System.out.println(s);
//        }





        // Fetching the two columns from the database

// This approch is depricated so its in not working with hibernate 6
//        Query query = session.createNativeQuery("SELECT name , marks FROM Student WHERE marks>60");
//        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);


        // We unwrap the hibernate from 6 to 5 to run the methods
        Query query = session.createNativeQuery("SELECT name, marks FROM Student WHERE marks>60")
                .unwrap(org.hibernate.query.NativeQuery.class)
                .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);

        List students = query.list();
        for (Object o : students){
            Map m = (Map) o;
            System.out.println(m.get("name") + " : " + m.get("marks"));
        }

        

        session.getTransaction().commit();

    }
}