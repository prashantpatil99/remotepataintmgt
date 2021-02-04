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
@SequenceGenerator(name = "patientDeviceAssignments_seq",sequenceName = "patientDeviceAssignments_seq",initialValue = 1,allocationSize = 1)
public class PatientDeviceAssignments {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "patientDeviceAssignments_seq")
    private long deviceId; //fk
    private String assignedDate;
    private String unAssignedDate;
    private String createdBy;
    private String createdOn;
    private String lastModifiedBy;
    private String lastModifiesOn;
    private long patientId; //fk
    private double upperLimit;
    private double lowerLimit;
}
