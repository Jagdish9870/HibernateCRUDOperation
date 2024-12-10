package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");


//        SessionFactory factory= HibernateUtil.getSessionfactory();
//        Session session= factory.openSession();
//        Transaction txn= session.beginTransaction();
//        System.out.println(factory);
//
//        //first operation -creating table and adding data into student2 table
//
//        Student2 st= new Student2(1,"Mohit"," delhi", " nit","mohit@gmail.com");
//
//
//        session.save(st);
//        txn.commit();


        // second operation - reading data from database -> method 1
        SessionFactory factory= HibernateUtil.getSessionfactory();
        Session session= factory.openSession();
        List<Student2> listStu= session.createQuery("from Student2", Student2.class).list();
        listStu.forEach(e-> System.out.println(listStu));

//         reading data from database with particular id -> method 2
        Student2 stuSingle= session.get(Student2.class,1);
        System.out.println(stuSingle);


        session.close();
        factory.close();

    }
}