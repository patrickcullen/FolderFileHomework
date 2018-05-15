import db.DBDepartment;
import db.DBEmployee;
import db.DBHelper;
import models.Department;
import models.Employee;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Department dept1 = new Department("HR");
        DBHelper.save(dept1);
        Department dept2 = new Department("Sales");
        DBHelper.save(dept2);

        Employee employee1 = new Employee("Al", "Bundy", 35000, dept1);
        DBHelper.save(employee1);

        Employee employee2 = new Employee("Peggy", "Bundy", 50000, dept1);
        DBHelper.save(employee2);

        List<Employee> employees = DBHelper.getAll(Employee.class);

        List<Department> departments = DBHelper.getAll(Department.class);

        Employee foundEmployees = DBHelper.find(Employee.class, employee2.getId());

        Department foundDept = DBHelper.find(Department.class, dept1.getId());

        List<Employee> hrEmployees = DBDepartment.getEmployeesForDept(foundDept);
    }
}
