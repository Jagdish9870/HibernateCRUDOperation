package org.example;

import com.mysql.cj.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println("select options for further operation");
        System.out.println("option 1 to add details into database ");
        System.out.println("option 2 to fetch details from database ");
        System.out.println("option 3 to fetch details by id  ");
        System.out.println("option 4 to update details into database ");
        System.out.println("option 5 to delete details from database ");
        System.out.println("Press 6 to exit ");


        Scanner sc= new Scanner(System.in);
        int choice = sc.nextInt();
        switch(choice){
            case 1:
                SessionFactory factory= HibernateUtil.getSessionfactory();
                Session session= factory.openSession();
                Transaction txn= session.beginTransaction();
                System.out.println(factory);

                //first operation -creating table and adding data into student2 table

                Student2 st= new Student2(1,"Mohit"," delhi", " nit","mohit@gmail.com");

                System.out.println("data saved successfully!");
                session.save(st);
                txn.commit();
                break;
            case 2:
                SessionFactory factory2= HibernateUtil.getSessionfactory();
                Session session2= factory2.openSession();
                Transaction txn2= session2.beginTransaction();
                List<Student2> listStu= session2.createQuery("from Student2", Student2.class).list();
                listStu.forEach(e-> System.out.println(listStu));
                txn2.commit();
                session2.close();
                factory2.close();


                break;
            case 3:
                SessionFactory factory3= HibernateUtil.getSessionfactory();
                Session session3= factory3.openSession();
                Transaction txn3= session3.beginTransaction();
                Student2 stuSingle= session3.get(Student2.class,1);
                System.out.println(stuSingle);
                System.out.println("data fetched successfully!");
                txn3.commit();
                session3.close();
                factory3.close();
                break;
            case 4:

                SessionFactory factory4= HibernateUtil.getSessionfactory();
                Session session4= factory4.openSession();
                Transaction txn4= session4.beginTransaction();
                Student2 stUpdate= session4.get(Student2.class,1);
                stUpdate.setName("madhur");
                stUpdate.setEmail("madhur.ac.in");
                System.out.println("data updated successfully!");

                session4.saveOrUpdate(stUpdate);

                txn4.commit();
                session4.close();
                factory4.close();

                break;

            case 5:
                SessionFactory factory5= HibernateUtil.getSessionfactory();
                Session session5= factory5.openSession();
                Transaction txn5= session5.beginTransaction();
                Student2 stDelete= session5.get(Student2.class,2);
                System.out.println("data deleted successfully!");
                session5.delete(stDelete);
                txn5.commit();
                session5.close();
                factory5.close();
                break;
            default :

                break;




        }

    }
}