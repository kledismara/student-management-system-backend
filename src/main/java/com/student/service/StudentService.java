package com.student.service;

import com.student.dto.request.StudentRequest;
import com.student.entity.Student;
import com.student.exceptions.StudentNotFoundException;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();
    Student getStudentById(Integer studentId) throws StudentNotFoundException;
    Student createStudent(StudentRequest studentRequest);
    Student updateStudent(Integer studentId, StudentRequest studentRequest) throws StudentNotFoundException;
    Student deactivateStudent(Integer studentId) throws StudentNotFoundException;
}
