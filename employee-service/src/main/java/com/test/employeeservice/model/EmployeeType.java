package com.test.employeeservice.model;

public enum EmployeeType {
    HOURLY(10), SALARIED(15), MANAGERS(30);

    private int leave;

    EmployeeType(int leave) {
        this.leave = leave;
    }

    public int getLeave(){
       return this.leave;
    }
}
