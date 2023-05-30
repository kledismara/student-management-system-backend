package com.student.dto.request;


import lombok.Data;

import java.util.Date;

@Data
public class StudentRequest {
    private String firstName;
    private String lastName;
    private String gender;
    private Date birthday;
    private String email;
    private String mobilePhone;
    private Boolean isActive;
}
