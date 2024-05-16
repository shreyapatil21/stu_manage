package com.example.studentmanagement.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.repository.StudentRepository;


@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student studentDetails) {
        Student student = studentRepository.findById(id).orElseThrow();
        student.setFirstName(studentDetails.getFirstName());
        student.setLastName(studentDetails.getLastName());
        student.setGrade(studentDetails.getGrade());
        student.setDateOfBirth(studentDetails.getDateOfBirth());
        student.setGender(studentDetails.getGender());
        student.setEmail(studentDetails.getEmail());
        student.setPhone(studentDetails.getPhone());
        student.setAddress(studentDetails.getAddress());
        student.setPhotograph(studentDetails.getPhotograph());
        student.setActive(studentDetails.isActive());
        return studentRepository.save(student);
    }

    public void deactivateStudent(Long id) {
        Student student = studentRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Student not found with id " + id));
student.setActive(false);
studentRepository.save(student);
    }
}

