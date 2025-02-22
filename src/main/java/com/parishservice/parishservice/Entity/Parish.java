package com.parishservice.parishservice.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Parish {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String parishId;
    private String parishName;
    private String parishLeaderName;
    private String deputyParishLeaderName;
    private String parishSecretary;
    private String parishCommittee;
    private String description;
    private String parishEmail;
    private String phoneNumber;
    private String dateCreated;
    private String country;
    private String address;
    private String state;
    private String city;
    private String zipCode;







}
