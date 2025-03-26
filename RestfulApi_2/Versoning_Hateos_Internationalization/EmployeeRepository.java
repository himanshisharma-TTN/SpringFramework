package com.EmployeeManagment.RestfulApi_2.Versoning_Hateos_Internationalization;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
