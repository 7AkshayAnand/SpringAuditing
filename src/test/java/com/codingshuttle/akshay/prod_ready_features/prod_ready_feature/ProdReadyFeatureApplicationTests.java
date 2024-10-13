package com.codingshuttle.akshay.prod_ready_features.prod_ready_feature;

import com.codingshuttle.akshay.prod_ready_features.prod_ready_feature.clients.EmployeeClient;
import com.codingshuttle.akshay.prod_ready_features.prod_ready_feature.dto.EmployeeDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class ProdReadyFeatureApplicationTests {
@Autowired
private EmployeeClient employeeClient;
	@Test
	void contextLoads() {
	}
//     @Test
//	 void getAllEmployees(){
//		List<EmployeeDTO> employeeDTOList=employeeClient.getAllEmployees();
//		System.out.println("the list is "+employeeDTOList);
//	}
//
//	@Test
//	void getEmployeeById(){
//		EmployeeDTO employeeDTO=employeeClient.getEmployeeById(100000L);
//		System.out.println("id 1 emp is "+employeeDTO);
//	}
//
//
//	@Test
//	void createNewEmployeeTest(){
//		EmployeeDTO employeeDTO=new EmployeeDTO(null,"Ankit","ank@gmail.com",29,5000.160,"USER", LocalDate.of(2020,12,1),true);
//
//		EmployeeDTO savedEmployee=employeeClient.createNewEmployee(employeeDTO);
//		System.out.println("the returned object is "+savedEmployee);
//	}
}
