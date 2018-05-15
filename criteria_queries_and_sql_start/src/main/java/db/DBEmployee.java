package db;

import models.Employee;
import org.hibernate.*;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBEmployee {
    private static Transaction transaction;
    private static Session session;

    public static void save(Employee employee) {

        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void delete(Employee employee){
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();
        } catch (HibernateException e){
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void update(Employee employee){
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static List<Employee> getAll(){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Employee> results = null;
        try {
            Criteria cr = session.createCriteria(Employee.class);
//            cr.add(Restrictions.ilike("firstName", "bru%"));
            results = cr.list();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    public static Employee find(int id){
        session = HibernateUtil.getSessionFactory().openSession();
        Employee result = null;
        try {
            Criteria cr = session.createCriteria(Employee.class);
            cr.add(Restrictions.eq("id", id));
            result = (Employee)cr.uniqueResult();
        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return result;
    }

    public static List<Employee> orderBySalary(){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Employee> employees = null;
        try {
            Criteria cr = session.createCriteria(Employee.class);
            cr.addOrder(Order.asc("salary"));
            employees = cr.list();
        }catch (HibernateException e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
        return employees;
    }

    public static Double getAvaSalary(){
        session = HibernateUtil.getSessionFactory().openSession();
        Double average = null;
        try{
            Criteria cr = session.createCriteria(Employee.class);
            cr.setProjection(Projections.avg("salary"));
            average = (Double)cr.uniqueResult();
        }catch (HibernateException e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
        return average;
    }

}
