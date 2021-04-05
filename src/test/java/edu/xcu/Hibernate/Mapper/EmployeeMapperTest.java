package edu.xcu.Hibernate.Mapper;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;


/**
 * @project: JavaLearn
 * @description:
 * @author: dell
 * @date: 2020/10/12 - 16:43
 */
public class EmployeeMapperTest {
    private EmployeeMapper employeeMapper;
    private Integer empID1;
    private Integer empID2;
    private Integer empID3;
    @Before
    public void init(){
        try{
            SessionFactory factory = new Configuration().configure().buildSessionFactory();
            employeeMapper = new EmployeeMapper(factory);
        }catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    @Test
    public void addEmployee() {

        /* Add few employee records in database */
        empID1 = employeeMapper.addEmployee("Zara", "Ali", 1000);
        empID2 = employeeMapper.addEmployee("Daisy", "Das", 5000);
        empID3 = employeeMapper.addEmployee("John", "Paul", 10000);
    }

    @Test
    public void listEmployees() {
        /* List down all the employees */
        employeeMapper.listEmployees();
    }

    @Test
    public void updateEmployee() {
        /* Update employee's records */
        employeeMapper.updateEmployee(4, 5000);
    }

    @Test
    public void deleteEmployee() {
        /* Delete an employee from the database */
        employeeMapper.deleteEmployee(4);
    }
}