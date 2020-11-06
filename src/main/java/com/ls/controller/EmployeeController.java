package com.ls.controller;

import com.ls.service.impl.EmployeeSvImpl;
import com.ls.pojo.Employee;
import com.sun.deploy.nativesandbox.comm.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeSvImpl employeeSv;

    //查询所有员工返回列表页面
    @GetMapping("/emps")
    public String list(Model model){

        List<Employee> list = employeeSv.query();

        //放在请求域中
        model.addAttribute("emps",list);
        // thymeleaf默认就会拼串
        return "emp/list";
    }

    //先到员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //来到添加页面,查出所有的部门，在页面显示
        return "emp/add";
    }

    //员工添加
    //SpringMVC自动将请求参数和入参对象的属性进行一一绑定；要求请求参数的名字和javaBean入参的对象里面的属性名是一样的
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        //添加员工
        employeeSv.addEmp(employee);
        // redirect: 表示重定向到一个地址  /代表当前项目路径
        // forward: 表示转发到一个地址
        return "redirect:/emps";
    }

    //来到修改页面，查出当前员工，在页面回显
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeSv.getEmpByID(id);
        model.addAttribute("emp",employee);
        //回到修改页面(add是一个修改添加二合一的页面);
        return "emp/update";
    }

    //员工修改；需要提交员工id；
    @PutMapping("/emp/{id}")
    public String updateEmployee(@PathVariable("id") Integer id,Employee employee){
        employeeSv.updateEmp(employee,id);
        return "redirect:/emps";
    }

    //员工删除
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeSv.deleteEmp(id);
        return "redirect:/emps";
    }



}
