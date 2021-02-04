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
@SequenceGenerator(name = "patientHealthReadings_seq",sequenceName = "patientHealthReadings_seq",initialValue = 1,allocationSize = 1)
public class PatientHealthReadings {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "patientHealthReadings_seq")
    private long patientHealthId; //pk
    private long patientId;  //fk
    private long deviceId;  //fk
    private String capturedOn;
    private String createdBy;
    private String createdOn;
}
