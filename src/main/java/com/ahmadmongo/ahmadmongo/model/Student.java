package com.ahmadmongo.ahmadmongo.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "students")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
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

    @Override
    public int compareTo(Object o) {
        Student sip = (Student) o;
        return Float.compare(this.getGpa(),sip.getGpa()) * -1;
    }
}