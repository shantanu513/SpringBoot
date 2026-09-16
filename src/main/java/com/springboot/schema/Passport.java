package com.springboot.schema;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.OneToOne;

@Entity
@Table(name = "passport")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Passport extends BaseEntity{

    @Column(name = "passport_no")
    private String passportNo;

    @OneToOne(mappedBy ="passport")
    private Person person;
    
}