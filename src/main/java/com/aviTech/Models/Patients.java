package com.aviTech.Models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
@SequenceGenerator(name = "patients_seq",sequenceName = "patients_seq",initialValue = 1,allocationSize = 1)
public class Patients {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "patients_seq")
    private long PatientId; //pk
    private String FirstName;
    private String MiddleName;
    private String LastName;
    private String Mobile;
    private String Email;
    private String Address;
    private String ZipCode;
    private int Age;
    private String Gender;
    private String MaritalStatus;
    private String DateOfBirth;
    private long ExternalId;
    private String PreferredLanguage;
    private long OrganizationId;   //fk
    private long UserId;   //fk
    private String IsDeleted;
    private String CreatedBy;
    private String CreatedOn;
    private String LastModifiedBy;
    private String LastModifiesOn;

}
