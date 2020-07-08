package com.employee.hub.controller;

import com.employee.hub.service.EmployeeAddressService;
import com.employee.hub.service.EmployeeService;
import com.employee.hub.entity.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Controller
@RequestMapping("employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    private final EmployeeAddressService employeeAddressService;

    public EmployeeController(EmployeeService employeeService, EmployeeAddressService employeeAddressService) {
        this.employeeService = employeeService;
        this.employeeAddressService = employeeAddressService;
    }

    @RequestMapping()
    public String getEmployees(Model model) {
        model.addAttribute("employees", this.employeeService.findAll());
        return "employee/listEmployees";
    }

    @RequestMapping("/{id}")
    public String getEmployee(Model model, @PathVariable int id) {
        final Optional<Employee> employeeOptional = this.employeeService.findById(id);
        if(!employeeOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        model.addAttribute("employee", employeeOptional.get());
        model.addAttribute("currentEmployeeAddress", this.employeeAddressService.findCurrentByEmployeeId(id));
        return "employee/viewEmployees";
    }

}
