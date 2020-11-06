package com.ls.service.interfaces;

import com.ls.pojo.Employee;

import java.util.List;

public interface EmployeeSv {
    public Employee getEmpByID(Integer id);
    public List<Employee> query();
    public void addEmp(Employee employee);
    public void deleteEmp(Integer id);
    public void updateEmp(Employee employee,Integer id);
}
