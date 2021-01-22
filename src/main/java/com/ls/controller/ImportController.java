package com.ls.controller;

import com.ls.pojo.Employee;
import com.ls.service.impl.EmployeeSvImpl;
import com.ls.util.ImportToExcel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@Api(tags = "导出excel")
public class ImportController {

    private static final Log log = LogFactory.getLog(ImportController.class);

    @Autowired
    EmployeeSvImpl employeeSv;

    @GetMapping("/import")
    @ApiOperation(value = "批量导出",notes ="导出全部数据到表格")
    public void toExcel(HttpServletResponse response){
        List<Employee> employees;
        employees = employeeSv.query();
        ImportToExcel importToExcel = new ImportToExcel();
        importToExcel.importToExcel(employees,response);
    }

}
