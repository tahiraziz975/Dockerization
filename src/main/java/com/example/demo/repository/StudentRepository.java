package com.example.demo.repository;

import com.example.demo.dto.Student;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
   // @Query("SELECT s FROM Student s WHERE s.email=?1")
    Optional<Student> findStudentByNameAndEmail(String name,String email);
    Optional<SecurityProperties.User> findByUsername(String username);

}

