package com.devanshu;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import org.hibernate.service.ServiceRegistry;

public class Main {
    public static void main(String[] args) {
        Laptop laptop = new Laptop();
        laptop.setLid(101);
        laptop.setLname("Dell");

        Student s = new Student();
        s.setName("Devanshu");
        s.setRollno(101);
        s.setMarks(100);

        s.getLaptop().add(laptop);

        laptop.getStudent().add(s);

        Configuration config = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);

        ServiceRegistry registry = new   StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();

        SessionFactory sf = config.buildSessionFactory(registry);

        Session session = sf.openSession();

        session.beginTransaction();

        session.persist(laptop);
        session.persist(s);
        
        session.getTransaction().commit();

    }
}