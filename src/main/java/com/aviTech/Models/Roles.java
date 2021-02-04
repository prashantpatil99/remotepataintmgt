package com.aviTech.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
@SequenceGenerator(name = "Roles_seq",sequenceName = "Roles_seq",initialValue = 1,allocationSize = 1)
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Roles_seq")
    private long roleId;  //pk
    private String roleType;
    private String createdBy;
    private String CreatedOn;
    private String lastModifiedBy;
    private String lastModifiedOn;

    /*@OneToOne(targetEntity = Users.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "RoleId",referencedColumnName = "RoleId")
    private Users users;*/


}
