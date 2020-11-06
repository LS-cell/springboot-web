package com.ls.service.impl;

import java.util.List;

import com.ls.pojo.Employee;
import com.ls.dao.interfaces.EmployeeDao;
import com.ls.service.interfaces.EmployeeSv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeSvImpl implements EmployeeSv {

    @Autowired
    EmployeeDao employeeDao;

    @Override
    public Employee getEmpByID(Integer id) {
        return employeeDao.getEmpByID(id);
    }

    public List<Employee> query(){
        return employeeDao.getEmp();
    }

    @Override
    public void addEmp(Employee employee) {
        employeeDao.insertEmp(employee);
    }

    @Override
    public void deleteEmp(Integer id) {
        employeeDao.deleteEmp(id);
    }

    @Override
    public void updateEmp(Employee employee, Integer id) {
        employeeDao.updateEmp(employee,id);
    }
}
