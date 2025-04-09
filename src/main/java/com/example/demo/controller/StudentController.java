package com.example.demo.controller;

import com.example.demo.dto.Student;
import com.example.demo.exceptions.ApiRequestException;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("abc")
public class StudentController {
    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService){
        this.studentService= studentService;
    }

    @GetMapping("/search")    public Optional<Student> getStudent(@RequestParam String name, @RequestParam String email) {

        return studentService.findStudentByNameAndEmail(name, email);
                }
    @GetMapping()
    public List<Student> getStudents(){
        return studentService.getStudents();
    }
    @GetMapping(path = "username/{username}")
    public Optional<SecurityProperties.User> findByUsername(@PathVariable("username") String username){
        return studentService.findByUsername(username);

    }

    @GetMapping(path = "id/{studentId}")
    public Optional<Student> getStudentById(@PathVariable("studentId") Long studentId){
//        throw new ApiRequestException("Server Error ! ");
        return studentService.getStudentById(studentId);

    }
    @PostMapping()
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }
//    @DeleteMapping(path ="{studentId}")
//    public void deleteStudent(@PathVariable("studentId")Long studentId){
//        studentService.deleteStudent(studentId);
//
//    }
//    @PutMapping(path = "{studentId}")
//    public void updateStudent(
//            @PathVariable("studentId") Long studentId,
//            @RequestParam (required = false) String name,
//            @RequestParam (required = false) String email){
//    studentService.updateStudent(studentId,name,email);
//    }
}
