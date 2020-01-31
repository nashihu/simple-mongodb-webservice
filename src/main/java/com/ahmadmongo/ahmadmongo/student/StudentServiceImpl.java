package com.ahmadmongo.ahmadmongo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findByStudentNumber(long studentNumber) {
        return studentRepository.findByStudentNumber(studentNumber);
    }

    @Override
    public Student findByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

    @Override
    public List<Student> findAllByOrderByGpa() {
        List<Student> sip = studentRepository.findAllByOrderByGpa();
        Collections.sort(sip);
        return sip;
    }

    @Override
    public void saveOrUpdateStudent(Student student) {
        studentRepository.save(student);
    }



    @Override
    public void deleteStudent(String id) {
        studentRepository.deleteById(id);
    }
}
