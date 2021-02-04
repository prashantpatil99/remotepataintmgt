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
@SequenceGenerator(name = "devices_seq",sequenceName = "devices_seq",initialValue = 1,allocationSize = 1)
public class Devices {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "devices_seq")
    private long deviceId; //pk
    private String deviceName;
    private String deviceType;
    private String isAssigned;
    private String isAuthenticated;
    private String createdBy;
    private String createdOn;
    private String lastModifiedBy;
    private String lastModifiesOn;
    private double upperLimit;
    private double lowerLimit;

}
