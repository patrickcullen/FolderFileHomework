import db.DBDepartment;
import db.DBEmployee;
import models.Department;
import models.Employee;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Department dept1 = new Department("HR");
        DBDepartment.save(dept1);

        Department dept2 = new Department("Sales");
        DBDepartment.save(dept2);

        Employee employee1 = new Employee("Bruce", "Wayne", 150000);
        DBEmployee.save(employee1);

        Employee employee2 = new Employee("Clark", "Kent", 80000);
        DBEmployee.save(employee2);

        Employee employee3 = new Employee("Diana" ,"Prince", 95000);
        DBEmployee.save(employee3);

        Employee employee4 = new Employee("Arthur", "Curry", 60000);
        DBEmployee.save(employee4);

        Employee employee5 = new Employee("Barry", "Allen", 45000);
        DBEmployee.save(employee5);

        List<Employee> employees = DBEmployee.getAll();

        Employee foundEmployee = DBEmployee.find(employee1.getId());

        List<Employee> ordered = DBEmployee.orderBySalary();

        Double averageSalaray = DBEmployee.getAvaSalary();


    }
}