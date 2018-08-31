package com.dds.mybatis;

import java.math.BigDecimal;

public class Employee {
    private BigDecimal empNo;
    private String eName;
    private String job;

    public Employee(){}

    public Employee(BigDecimal empNo, String name, String job) {
        this.empNo = empNo;
        this.eName = name;
        this.job = job;
    }

    public BigDecimal getEmpNo() {
        return empNo;
    }

    public void setEmpNo(BigDecimal empNo) {
        this.empNo = empNo;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empNo=" + empNo +
                ", eName='" + eName + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}
