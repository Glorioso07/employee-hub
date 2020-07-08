package com.employee.hub.service;

import com.employee.hub.entity.EmployeeAddress;

public interface EmployeeAddressService {

    EmployeeAddress findCurrentByEmployeeId(Integer id);

    void save(EmployeeAddress employeeAddress);
}
