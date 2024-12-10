package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");


        SessionFactory factory= HibernateUtil.getSessionfactory();
        Session session= factory.openSession();
        Transaction txn= session.beginTransaction();
        System.out.println(factory);

        //first operation -creating table and adding data into student2 table

        Student2 st= new Student2(1,"Mohit"," delhi", " nit","mohit@gmail.com");


        session.save(st);
        txn.commit();



        session.close();
        factory.close();

    }
}