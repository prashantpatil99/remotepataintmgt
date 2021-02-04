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
@SequenceGenerator(name = "organizations_seq",sequenceName = "organizations_seq",initialValue = 1,allocationSize = 1)
public class Organizations {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "organizations_seq")
    private long organizationId;   //pk
    private String name;
    private String address;
    private String email;
    private String contact;
    private String ownerName;
    private String ownerContact;
    private String zipCode;
    private String createdBy;
    private String createdOn;
    private String lastModifiedBy;
    private String lastModifiedOn;
}
