package com.test.employeeservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.text.DecimalFormat;


public class Employee {
    private int empId;
    private String name;
    private float numberOfVacation = 0.0f;
    private Integer numberOfDaysWork;
    private static int WORK_YEARS_DAY = 260;

    private EmployeeType employeeType;

    public Employee(int empId, String name,  EmployeeType employeeType) {
        this.empId = empId;
        this.name = name;
        this.numberOfVacation = 0.0F;
        this.numberOfDaysWork = 0;
        this.employeeType = employeeType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfVacation(float numberOfVacation) {
        this.numberOfVacation = numberOfVacation;
    }

    public void setNumberOfDaysWork(Integer numberOfDaysWork) {
        this.numberOfDaysWork = numberOfDaysWork;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public int getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public float getNumberOfVacation() {
        return numberOfVacation;
    }

    public Integer getNumberOfDaysWork() {
        return numberOfDaysWork;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public Float work(int numberOfDaysWork) {
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setMaximumFractionDigits(2);
        int temp = this.numberOfDaysWork + numberOfDaysWork;
        if (temp >= 0 && temp <= WORK_YEARS_DAY) {
            this.numberOfDaysWork = temp;
            float noOfVacation = Float.valueOf(decimalFormat.format((employeeType.getLeave() * numberOfDaysWork) / WORK_YEARS_DAY));
            this.numberOfVacation += noOfVacation;
            return noOfVacation;
        } else {
            throw new RuntimeException("Number of work day can not be greater then 260 or less then 0");
        }


    }

    public Float takeVacation(int numberOfLeave) {
        if (numberOfLeave >= 0 && numberOfLeave <= numberOfVacation) {
            this.numberOfVacation -= numberOfLeave;
            return numberOfVacation;
        } else {
            throw new RuntimeException("Your leave request is greater then leave balance");
        }
    }


}
