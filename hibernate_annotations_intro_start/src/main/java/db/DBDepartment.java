package db;

import models.Department;
import models.Employee;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBDepartment {

    private static Transaction transaction;
    private static Session session;

    public static List<Employee> getEmployeesForDept(Department dept){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Employee> results = null;
        try {
            Criteria cr = session.createCriteria(Employee.class);
            cr.add(Restrictions.eq("department", dept));
            results = cr.list();
        }catch (HibernateException e){
            e.printStackTrace();

        }finally {
            session.close();
        }
        return results;
    }

//    public static void save(Department department) {
//
//        session = HibernateUtil.getSessionFactory().openSession();
//        try {
//            transaction = session.beginTransaction();
//            session.save(department);
//            transaction.commit();
//        } catch (HibernateException e) {
//            transaction.rollback();
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//    }
}
