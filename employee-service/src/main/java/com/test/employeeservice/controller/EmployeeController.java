package com.test.employeeservice.controller;

import com.test.employeeservice.model.Employee;
import com.test.employeeservice.model.EmployeeType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController()
public class EmployeeController {
    private static List<Employee> employeeList=new ArrayList<>();

    static {
        Employee employee1=new Employee(1,"Santosh",EmployeeType.MANAGERS);
        Employee employee2=new Employee(2,"Saurabh",EmployeeType.HOURLY);
        Employee employee3=new Employee(3,"Vaibhav",EmployeeType.HOURLY);
        Employee employee4=new Employee(4,"Santoshi",EmployeeType.HOURLY);
        Employee employee5=new Employee(5,"Rajat",EmployeeType.MANAGERS);
        Employee employee6=new Employee(6,"Vinay",EmployeeType.MANAGERS);
        Employee employee7=new Employee(7,"Gaurav",EmployeeType.SALARIED);
        Employee employee8=new Employee(8,"John",EmployeeType.SALARIED);
        Employee employee9=new Employee(9,"Pooja",EmployeeType.SALARIED);
        Employee employee10=new Employee(10,"Riya",EmployeeType.MANAGERS);
        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
        employeeList.add(employee4);
        employeeList.add(employee5);
        employeeList.add(employee6);
        employeeList.add(employee7);
        employeeList.add(employee8);
        employeeList.add(employee9);
        employeeList.add(employee10);
    }
    @GetMapping("/employee")
    public List<Employee> getEmployeeList(){
        return employeeList;
    }

    @GetMapping("work/{id}/{noOfWork}")
    public void work(@PathVariable(value = "id") Integer id,@PathVariable(value = "noOfWork") Integer noOfWork){
        employeeList.forEach(employee -> {
            if(employee.getEmpId()==id){
                employee.work(noOfWork);
            }

        });
    }

    @GetMapping("takeVacation/{id}/{noOfVacation}")
    public void takeVacation(@PathVariable(value = "id") Integer id,@PathVariable(value = "noOfVacation") Integer noOfVacation){
        employeeList.forEach(employee -> {
            if(employee.getEmpId()==id){
                employee.takeVacation(noOfVacation);
            }

        });
    }
}
