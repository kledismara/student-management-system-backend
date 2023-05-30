package com.student.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentResponse {
    private String firstName;
    private String lastName;
    private String gender;
    private Date birthday;
    private String email;
    private String mobilePhone;
    private Boolean isActive;
    private Date createdAt;
}
