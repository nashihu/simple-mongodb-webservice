package com.ahmadmongo.ahmadmongo.controllers;

import com.ahmadmongo.ahmadmongo.sevice.MatKulService;
import com.ahmadmongo.ahmadmongo.model.MataKuliah;
import com.ahmadmongo.ahmadmongo.model.Student;
import com.ahmadmongo.ahmadmongo.sevice.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/soal2F")
public class ExtensionController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private MatKulService matKulService;

    @GetMapping(value = "/getAllStudentWithMatkul")
    public List<Student> getAllStudents() {
        return studentService.findAll();
    }

    @GetMapping(value = "/getMatkulWithNumStudents")
    public List<MataKuliahLeftJoined> getAllMatkulWithNumStudents() {
        List<Student> students = studentService.findAll();
        List<MataKuliah> mataKuliahs = matKulService.findAll();
        List<MataKuliahLeftJoined> mataKuliahLeftJoineds = MataKuliahLeftJoined.fromMataKuliahs(mataKuliahs);

        List<MataKuliah> mataKuliahfromStudents = new ArrayList<>();
        for(int i = 0; i< students.size();i++) {
            mataKuliahfromStudents.addAll(students.get(i).getCourseList());
        }

        for(int i = 0 ; i< mataKuliahs.size();i++) {
            int numStudents = 0;
            for(int j = 0; j<mataKuliahfromStudents.size(); j++) {
                if(mataKuliahfromStudents.get(j).getName().equals(mataKuliahs.get(i).getName())) {
                    numStudents = numStudents + 1;
                }
            }
            mataKuliahLeftJoineds.get(i).setNumStudents(numStudents);
        }

        return mataKuliahLeftJoineds;
    }

    @GetMapping(value = "/getNumberStudentFromJurusanName/{jurusanName}")
    public int getNumberStudentFromJurusanName(@PathVariable("jurusanName") String jurusanName) {
        List<Student> students =  studentService.findAll();
        List<String> jurusan = new ArrayList<>();
        for(int i = 0; i< students.size();i++) {
            jurusan.add(students.get(i).getJurusan());
        }
        Set<String> uniqueJurusan = new HashSet<String>(jurusan);
        List<String> uniqueJurusanList = new ArrayList<>(uniqueJurusan);
        int numStudents = 0;
        for(int i =0; i<jurusan.size(); i++) {
            if(jurusan.get(i).equals(jurusanName)) {
                numStudents = numStudents + 1;
            }
        }
        return numStudents;
    }
}

class MataKuliahLeftJoined {
    private String id;
    private String name;
    private String teacherName;
    private int SKS;
    private int numStudents;

    public static List<MataKuliahLeftJoined> fromMataKuliahs(List<MataKuliah> mataKuliahs) {
        List<MataKuliahLeftJoined> mataKuliahLeftJoineds = new ArrayList<>();
        for(int i = 0; i< mataKuliahs.size(); i++) {
            MataKuliahLeftJoined mataKuliahLeftJoined = new MataKuliahLeftJoined();
            mataKuliahLeftJoined.setId(mataKuliahs.get(i).getId());
            mataKuliahLeftJoined.setName(mataKuliahs.get(i).getName());
            mataKuliahLeftJoined.setSKS(mataKuliahs.get(i).getSKS());
            mataKuliahLeftJoined.setTeacherName(mataKuliahs.get(i).getTeacherName());
            mataKuliahLeftJoineds.add(mataKuliahLeftJoined);
        }
        return mataKuliahLeftJoineds;
    }

    public MataKuliahLeftJoined() {}

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

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public int getSKS() {
        return SKS;
    }

    public void setSKS(int SKS) {
        this.SKS = SKS;
    }

    public int getNumStudents() {
        return numStudents;
    }

    public void setNumStudents(int numStudents) {
        this.numStudents = numStudents;
    }
}
