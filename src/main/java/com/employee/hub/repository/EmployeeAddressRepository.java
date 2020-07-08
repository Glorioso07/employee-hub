package com.employee.hub.repository;

import com.employee.hub.entity.EmployeeAddress;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface EmployeeAddressRepository extends CrudRepository<EmployeeAddress, Integer> {

    EmployeeAddress findByEmployeeIdAndIsCurrent(Integer id, boolean isCurrent);

    @Modifying
    @Transactional
    @Query("UPDATE EmployeeAddress ea SET ea.isCurrent = :isCurrent WHERE ea.employee.id = :employeeId")
    void updateCurrentAddresses(@Param("employeeId") Integer employeeId, @Param("isCurrent") boolean isCurrent);

}
