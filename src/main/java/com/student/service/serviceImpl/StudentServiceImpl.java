package com.student.service.serviceImpl;

import com.student.dto.request.StudentRequest;
import com.student.entity.Student;
import com.student.exceptions.StudentNotFoundException;
import com.student.mapper.StudentMapper;
import com.student.repository.StudentRepository;
import com.student.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private static final String STUDENT_NOT_FOUND_MESSAGE = "Student with ID = %s does not exist";

    private final StudentRepository studentRepository;

    StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Integer studentId) throws StudentNotFoundException {
        return studentRepository.findById(studentId)
                .orElseThrow(() ->
                        new StudentNotFoundException(String.format(STUDENT_NOT_FOUND_MESSAGE, studentId))
                );
    }

    @Override
    public Student createStudent(StudentRequest studentRequest) {
        Student student = StudentMapper.convertFromStudentRequestToEntity(studentRequest);
        student.setCreatedAt(new Date());

        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Integer studentId, StudentRequest studentRequest) throws StudentNotFoundException {
        Optional<Student> student = getStudent(studentId);

        if (student.isPresent()) {
            Student updatedStudent = student.get();
            StudentMapper.convertFromStudentRequestToEntity(studentRequest, updatedStudent);
            return studentRepository.save(updatedStudent);
        } else {
            throw new StudentNotFoundException(String.format(STUDENT_NOT_FOUND_MESSAGE, studentId));
        }
    }

    @Override
    public Student deactivateStudent(Integer studentId) throws StudentNotFoundException {
        Optional<Student> student = getStudent(studentId);

        if (student.isPresent()) {
            ///TODO Its better to call a query so we will have only 1 request in DB
            Student deactivatedStudent = student.get();
            deactivatedStudent.setIsActive(false);
            return studentRepository.save(deactivatedStudent);
        } else {
            throw new StudentNotFoundException(String.format(STUDENT_NOT_FOUND_MESSAGE, studentId));
        }
    }

    private Optional<Student> getStudent(Integer studentId){
        return studentRepository.findById(studentId);
    }
}
