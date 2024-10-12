
package com.codingshuttle.akshay.prod_ready_features.prod_ready_feature.dto;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

import java.time.LocalDate;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private Long id;

    private String name;

    private String email;


    private Integer age;



    private Double salary;


    private String role;//Admin,user


    private LocalDate dateOfJoining;


    private Boolean isActive;


}




