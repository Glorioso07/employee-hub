package com.employee.hub.controller;

import com.employee.hub.entity.Employee;
import com.employee.hub.service.EmployeeAddressService;
import com.employee.hub.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @MockBean
    private EmployeeAddressService employeeAddressService;

    @Test
    public void getEmployeesStatusOk() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/employee"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getEmployeeStatusNotFound() throws Exception {
        Mockito.when(this.employeeService.findById(Mockito.anyInt())).thenReturn(Optional.empty());
        mockMvc.perform(MockMvcRequestBuilders.get("/employee/1"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void getEmployeeStatusOk() throws Exception {
        Mockito.when(this.employeeService.findById(Mockito.anyInt())).thenReturn(Optional.of(new Employee()));
        mockMvc.perform(MockMvcRequestBuilders.get("/employee/2"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
