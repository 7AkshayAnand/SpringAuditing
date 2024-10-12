package com.codingshuttle.akshay.prod_ready_features.prod_ready_feature.clients;

import com.codingshuttle.akshay.prod_ready_features.prod_ready_feature.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeClient {
    public List<EmployeeDTO> getAllEmployees();

    EmployeeDTO getEmployeeById(Long employeeId);

    EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO);
}
