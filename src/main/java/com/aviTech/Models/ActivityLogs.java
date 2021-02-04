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
@SequenceGenerator(name = "activityLogs_seq",sequenceName = "activityLogs_seq",initialValue = 1,allocationSize = 1)
public class ActivityLogs {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "activityLogs_seq")
    private long loginId;
    private long userId;
    private String webServerName;
    private String ipAddress;
    private String apiType;
    private String api;
    private String requestObject;
    private String response;
    private String createdBy;
    private String createdOn;
}
