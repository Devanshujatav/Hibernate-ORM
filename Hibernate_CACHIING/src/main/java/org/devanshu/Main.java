package org.devanshu;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import java.lang.String;
import java.lang.Object;

import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

public class Main {
    public static void main(String[] args) {
        Alien a = null;
        Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        SessionFactory sf = con.buildSessionFactory(reg);

        Session session1 = sf.openSession();
        session1.beginTransaction();
//        a = (Alien) session1.find(Alien.class, 101);
        Query q1 = session1.createQuery("FROM Alien WHERE aid=101");
        q1.setCacheable(true);
        a = (Alien) q1.uniqueResult();
        System.out.println(a);
        session1.getTransaction().commit();
        session1.close();

        Session session2 = sf.openSession();
        session1.beginTransaction();
        Query q2 = session2.createQuery("FROM Alien WHERE aid=101");
        q2.setCacheable(true);
        a = (Alien) q2.uniqueResult();
        System.out.println(a);
     }
}