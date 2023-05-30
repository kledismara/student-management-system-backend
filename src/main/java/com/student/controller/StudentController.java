package com.student.controller;

import com.student.dto.request.StudentRequest;
import com.student.entity.Student;
import com.student.exceptions.StudentNotFoundException;
import com.student.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/students")
public class StudentController {


    private final StudentService studentService;

    StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping(
            value = "/",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> studentList  = studentService.getAllStudents();

        return new ResponseEntity<>(
                studentList,
                HttpStatus.OK);
    }

    @GetMapping(
            value = "/{studentId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Student> getStudent(@PathVariable(name = "studentId") Integer studentId) throws StudentNotFoundException {
        Student student  = studentService.getStudentById(studentId);

        return new ResponseEntity<>(
                student,
                HttpStatus.OK);
    }

    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Student> createStudent(@RequestBody StudentRequest studentRequest){
        Student student  = studentService.createStudent(studentRequest);

        return new ResponseEntity<>(
                student,
                HttpStatus.OK);
    }

    @PutMapping(
            value = "/{studentId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Student> updateStudent(@PathVariable(name = "studentId") Integer studentId, @RequestBody StudentRequest studentRequest) throws StudentNotFoundException {
        Student student  = studentService.updateStudent(studentId, studentRequest);

        return new ResponseEntity<>(
                student,
                HttpStatus.OK);
    }

    @DeleteMapping(
            value = "/{studentId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Student> deactivateStudent(@PathVariable(name = "studentId") Integer studentId) throws StudentNotFoundException {
        Student student  = studentService.deactivateStudent(studentId);

        return new ResponseEntity<>(
                student,
                HttpStatus.OK);
    }
}
