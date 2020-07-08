package com.employee.hub.service;

import com.employee.hub.entity.EmployeeAddress;
import com.employee.hub.repository.EmployeeAddressRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeAddressServiceImpl implements EmployeeAddressService {

    private final EmployeeAddressRepository employeeAddressRepository;

    public EmployeeAddressServiceImpl(EmployeeAddressRepository employeeAddressRepository) {
        this.employeeAddressRepository = employeeAddressRepository;
    }

    public EmployeeAddress findCurrentByEmployeeId(Integer id) {
        return this.employeeAddressRepository.findByEmployeeIdAndIsCurrent(id, true);
    }

    public void save(EmployeeAddress employeeAddress) {
        if (employeeAddress.isCurrent()) {
            this.employeeAddressRepository.updateCurrentAddresses(employeeAddress.getEmployee().getId(), false);
        }
        this.employeeAddressRepository.save(employeeAddress);
    }
}
