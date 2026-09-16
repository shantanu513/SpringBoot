package com.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonResponseDto {

    private Long id;
    private String name;
    private String passportNo;
    
}
