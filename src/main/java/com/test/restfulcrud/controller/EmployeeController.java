package com.test.restfulcrud.controller;

import com.test.restfulcrud.dao.DepartmentDao;
import com.test.restfulcrud.dao.EmployeeDao;
import com.test.restfulcrud.entities.Department;
import com.test.restfulcrud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps", employees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAdd(Model model) {
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("deps", departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String doAdd(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toEdit(@PathVariable("id") Integer id, Model model) {
        // 根据ID获取员工信息
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);
        // 获取所有部门信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("deps", departments);
        return "emp/add";
    }

    @PutMapping("/emp")
    public String doEdit(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String delete(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
