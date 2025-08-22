package com.devanshu;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        Configuration config = new Configuration().configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(Alien.class);
        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();


        // LAZY FETCHING
//        Alien a1 = session.getReference(Alien.class , 1);
//        Collection<Laptop> laps = a1.getLaps();
//
//        for (Laptop l : laps){
//            System.out.println(l);
//        }

        // EAGER FETCHING
        Alien a1 = session.getReference(Alien.class , 1);
        Collection<Laptop> laps = a1.getLaps();
        System.out.println(a1.getAid());

        session.getTransaction().commit();

    }
}