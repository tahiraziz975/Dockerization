package com.example.demo.service;

import com.example.demo.dto.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Optional<Student> findStudentByNameAndEmail(String name,String email){
        return studentRepository.findStudentByNameAndEmail(name, email);
    }
    public Optional<SecurityProperties.User> findByUsername(String username){
        return studentRepository.findByUsername(username);
    }

    public List<Student> getStudents(){
       return studentRepository.findAll();

    }

    public Optional<Student> getStudentById(Long studentId) {
        return studentRepository.findById(studentId)

                .map(student -> {
                    student.setUniq( student.getEmail() + student.getId());
                    if (student.getDob() == null) {
                        student.setDob("Not Available");
                    }
                    return student;
                });
    }

    public boolean addNewStudent(Student student){
        studentRepository.save(student);
        return true;
    }

}
