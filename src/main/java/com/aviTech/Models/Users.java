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
@SequenceGenerator(name = "Users_seq",sequenceName = "Users_seq",initialValue = 1,allocationSize = 1)
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Users_seq")
    private long UserId;  //pk
    private String name;
    private String email;
    private String mobile;
    private String address;
    private String createdBy;
    private String createdOn;
    private String lastModifiedBy;
    private String lastModifiesOn;
    private long organizationId;  //fk


}
