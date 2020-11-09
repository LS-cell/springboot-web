package com.ls.dao.interfaces;

import com.ls.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeDao {
    public Employee getEmpByID(Integer id);
    List<Employee> getEmp();
    public void insertEmp(Employee employee);
    public void deleteEmp(Integer id);
    public void updateEmp(@Param("empl") Employee employee, @Param("id") Integer id);
}
