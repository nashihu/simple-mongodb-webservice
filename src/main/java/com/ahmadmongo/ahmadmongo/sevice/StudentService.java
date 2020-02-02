package com.ahmadmongo.ahmadmongo.sevice;

import com.ahmadmongo.ahmadmongo.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    Page<Student> findAll(PageRequest pageRequest);

    Student findByStudentNumber(long studentNumber);

    Student findByEmail(String email);

    List<Student> findAllByOrderByGpa();

    void saveOrUpdateStudent(Student student);

    void deleteStudent(String id);

}