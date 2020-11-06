package com.ls.controller;

import com.ls.pojo.Employee;
import com.ls.service.impl.EmployeeSvImpl;
import com.ls.util.ImportToExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ImportController {

    @Autowired
    EmployeeSvImpl employeeSv;

    @GetMapping("/import")
    public void toExcel(HttpServletResponse response){
        List<Employee> employees = new ArrayList<Employee>();
        employees = employeeSv.query();
        ImportToExcel importToExcel = new ImportToExcel();
        importToExcel.importToExcel(employees,response);
    }

}
