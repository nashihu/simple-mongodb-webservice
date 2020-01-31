package com.ahmadmongo.ahmadmongo.student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    Student findByStudentNumber(long studentNumber);

    Student findByEmail(String email);

    List<Student> findAllByOrderByGpa();

    void saveOrUpdateStudent(Student student);

    void deleteStudent(String id);

}