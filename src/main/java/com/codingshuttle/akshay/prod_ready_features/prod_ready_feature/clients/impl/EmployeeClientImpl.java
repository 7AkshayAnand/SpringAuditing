package com.codingshuttle.akshay.prod_ready_features.prod_ready_feature.clients.impl;

import com.codingshuttle.akshay.prod_ready_features.prod_ready_feature.advice.ApiResponse;
import com.codingshuttle.akshay.prod_ready_features.prod_ready_feature.clients.EmployeeClient;
import com.codingshuttle.akshay.prod_ready_features.prod_ready_feature.dto.EmployeeDTO;
import com.codingshuttle.akshay.prod_ready_features.prod_ready_feature.exeptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
@Service
@RequiredArgsConstructor
public class EmployeeClientImpl  implements EmployeeClient {
   private final RestClient restClient;

   Logger log= LoggerFactory.getLogger(EmployeeClient.class);
    @Override
    public List<EmployeeDTO> getAllEmployees() {
        log.trace("trying to recieve employee details");

        try{
          ApiResponse< List<EmployeeDTO>> employeeDtoList=  restClient.get()
                    .uri("employees")
                    .retrieve()
                    .body(new ParameterizedTypeReference<>() {
                    });
          log.info("Successfully retrieved the employees in getALlEMployees");
          log.trace("retrieved emploees list in getallemployees {} ",employeeDtoList.getData());
            return employeeDtoList.getData();

        }catch(Exception e){
//            here we are printing log if error comes
            log.error("Exception occoured in getAllEMployee "+e);
            throw new RuntimeException(e);
        }

    }

    @Override
    public EmployeeDTO getEmployeeById(Long employeeId) {
        log.trace("trying to getemployee by id {} ",employeeId);
        try{
            ApiResponse<EmployeeDTO> employeeResponse=  restClient.get()
                    .uri("employees/{employeeId}",employeeId)
                    .retrieve()
                    .body(new ParameterizedTypeReference<>() {
                    });
            return employeeResponse.getData();
        }catch(Exception e){
            log.error("Exception occoured in getEMployee by id "+e);
             throw new RuntimeException(e);
        }
    }

    @Override
    public EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO) {
        try{
            log.trace("trying to create new employee with informations {}",employeeDTO);
            ApiResponse<EmployeeDTO> employeeDTOApiResponse=restClient.post()
                    .uri("employees")
                    .body(employeeDTO)
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError,((request, response) -> {
                        log.debug("4xx client error occoured during creation of new employee");
                        log.error("error is "+new String(response.getBody().readAllBytes()));
                        throw  new ResourceNotFoundException("could not create employees");

                    }) )
                    .body(new ParameterizedTypeReference<>() {
                    });
            log.trace("successfully created the new employee : {}",employeeDTOApiResponse.getData());
            return employeeDTOApiResponse.getData();
        }catch(Exception e){
            log.error("exception occoured in creation of new employe {}",e);
            throw new RuntimeException(e);
        }
    }
}



