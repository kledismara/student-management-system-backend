package com.student.mapper;

import com.student.dto.request.StudentRequest;
import com.student.dto.response.StudentResponse;
import com.student.entity.Student;

public class StudentMapper {

    public static Student convertFromStudentRequestToEntity(StudentRequest studentRequest){
        Student student = Student.builder()
                .firstName(studentRequest.getFirstName())
                .lastName(studentRequest.getLastName())
                .birthday(studentRequest.getBirthday())
                .email(studentRequest.getEmail())
                .isActive(studentRequest.getIsActive())
                .gender(studentRequest.getGender())
                .mobilePhone(studentRequest.getMobilePhone())
                .build();

        return student;
    }

    public static StudentResponse convertFromStudentEntityToResponse(StudentRequest studentRequest){
        StudentResponse studentResponse = StudentResponse.builder()
                .firstName(studentRequest.getFirstName())
                .lastName(studentRequest.getLastName())
                .birthday(studentRequest.getBirthday())
                .email(studentRequest.getEmail())
                .isActive(studentRequest.getIsActive())
                .gender(studentRequest.getGender())
                .mobilePhone(studentRequest.getMobilePhone())
                .build();

        return studentResponse;
    }

    public static void convertFromStudentRequestToEntity(StudentRequest studentRequest, Student student) {
        student.setFirstName(studentRequest.getFirstName());
        student.setLastName(studentRequest.getLastName());
        student.setBirthday(studentRequest.getBirthday());
        student.setEmail(studentRequest.getEmail());
        student.setIsActive(studentRequest.getIsActive());
        student.setGender(studentRequest.getGender());
        student.setMobilePhone(studentRequest.getMobilePhone());
    }
}
