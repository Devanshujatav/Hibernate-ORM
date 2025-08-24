package org.devanshu;

import jakarta.persistence.*;
import org.devanshu.Student;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager em = emf.createEntityManager();

        // CREATE
        em.getTransaction().begin();
        Student s1 = new Student("Devanshu", "Java");
        em.persist(s1);
        em.getTransaction().commit();

//        // READ
//        Student s = em.find(Student.class, 1);
//        System.out.println("Student: " + s.getName());
//
//        // UPDATE
//        em.getTransaction().begin();
//        s.setCourse("Hibernate");
//        em.merge(s);
//        em.getTransaction().commit();
//
//        // DELETE
//        em.getTransaction().begin();
//        em.remove(s);
//        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}