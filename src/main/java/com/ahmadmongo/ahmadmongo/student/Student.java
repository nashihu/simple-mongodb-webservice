package com.ahmadmongo.ahmadmongo.student;

import com.ahmadmongo.ahmadmongo.matkul.MataKuliah;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "students")
public class Student implements  Comparable {
    @Id
    private String id;
    private String name;
    private long studentNumber;
    private String email;
    private List<MataKuliah> courseList;
    private String jurusan;
    private String fakultas;
    private float gpa;

    public Student(String id, String name, String jurusan, String fakultas, long studentNumber, String email, List<MataKuliah> courseList, float gpa) {
        this.id = id;
        this.name = name;
        this.studentNumber = studentNumber;
        this.email = email;
        this.courseList = courseList;
        this.gpa = gpa;
        this.jurusan = jurusan;
        this.fakultas = fakultas;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getFakultas() {
        return fakultas;
    }

    public void setFakultas(String fakultas) {
        this.fakultas = fakultas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(long studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<MataKuliah> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<MataKuliah> courseList) {
        this.courseList = courseList;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    @Override
    public int compareTo(Object o) {
        Student sip = (Student) o;
        return Float.compare(this.getGpa(),sip.getGpa()) * -1;
    }
}