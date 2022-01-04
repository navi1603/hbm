package domain;

import bl.HibernateUtil;
import com.ibm.icu.util.Calendar;
import entity.Address;
import entity.Employee;
import entity.Project;
import org.hibernate.Session;
import org.hibernate.query.spi.SelectQueryPlan;
import service.AddressService;
import service.EmployeeService;
import service.ProjectService;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Domain {
    public static void main(String[] args) throws SQLException {
        AddressService addressService = new AddressService();
        EmployeeService employeeService = new EmployeeService();
        ProjectService projectService = new ProjectService();

        Address address = new Address();
        address.setCountry("DC");
        address.setCity("Gotham city");
        address.setStreet("Arkham street 1");
        address.setPostCode("12345");

        Project project = new Project();
        project.setTitle("Gotham PD");

        Employee employee = new Employee();
        employee.setFirstName("James");
        employee.setLastName("Gordon");

        Calendar calendar = Calendar.getInstance();
        calendar.set(1939, Calendar.MAY, 1);

        employee.setBirthDay(new Date(calendar.getTime().getTime()));
        employee.setAddress(address);

        Set<Employee> employees = new HashSet<Employee>();
        employees.add(employee);
        project.setEmployees(employees);

        Set<Project> projects = new HashSet<Project>();
        projects.add(project);
        employee.setProjects(projects);

        addressService.add(address);
        employeeService.add(employee);
        projectService.add(project);

        Address a = addressService.getById(1L);
        System.out.println(a);

        HibernateUtil.shutDown();
    }


}
