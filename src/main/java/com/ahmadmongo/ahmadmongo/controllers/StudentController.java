package com.ahmadmongo.ahmadmongo.controllers;

import com.ahmadmongo.ahmadmongo.sevice.MatKulService;
import com.ahmadmongo.ahmadmongo.model.MataKuliah;
import com.ahmadmongo.ahmadmongo.model.Student;
import com.ahmadmongo.ahmadmongo.sevice.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private MatKulService matKulService;

    @GetMapping(value = "/getAllStudentPageAble")
    public Page<Student> getAllStudents(int page, int size, @RequestHeader String Authorization) {
        PageRequest pageRequest = PageRequest.of(page,size);
        return studentService.findAll(pageRequest);
    }

    @RequestMapping(value = "/getStudentByNumber/{studentNumber}",method = RequestMethod.GET)
    public Student getStudentByStudentNumber(@PathVariable("studentNumber") Long studentNumber, @RequestHeader String Authorization) {
        return studentService.findByStudentNumber(studentNumber);
    }

    @RequestMapping(value = "/getStudentByEmail/{email}",method = RequestMethod.GET)
    public Student getStudentByEmail(@PathVariable("email") String email,@RequestHeader String Authorization) {
        return studentService.findByEmail(email);
    }

    @RequestMapping(value = "/getStudentOrderByGpa",method = RequestMethod.GET)
    public List<Student> findAllByOrderByGpaDesc(@RequestHeader String Authorization) {
        return studentService.findAllByOrderByGpa();
    }

    @PostMapping(value = "/addStudent")
    public ResponseEntity<?> saveOrUpdateStudent(@RequestBody Student student, @RequestHeader String Authorization) {
        List<MataKuliah> mataKuliahs = new ArrayList<>();
        if(student.getCourseList()==null) {
            student.setCourseList(mataKuliahs);
        }
        studentService.saveOrUpdateStudent(student);
        return new ResponseEntity("Student added successfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteStudentByNumber/{studentNumber}")
    public void deleteStudent(@PathVariable Long studentNumber,@RequestHeader String Authorization) {
        studentService.deleteStudent(studentService.findByStudentNumber(studentNumber).getId());
    }

    @PostMapping(value = "/addMatkul")
    public ResponseEntity<?> addMatKul(@RequestBody AddMatkul addMatkul,@RequestHeader String Authorization) {
        long  studentNumber = addMatkul.getStudentNumber();
        String matkul = addMatkul.getMatkul();
        Student student = studentService.findByStudentNumber(studentNumber);
        MataKuliah mataKuliah = matKulService.findMatkulByName(matkul);
        if(student==null) return new ResponseEntity("Student tidak ditemukan wkwk", HttpStatus.NOT_FOUND);
        if(mataKuliah==null) return new ResponseEntity("Matkul tidak ditemukan wkwk", HttpStatus.NOT_FOUND);
        List<MataKuliah> mataKuliahs = student.getCourseList();
        if(mataKuliahs.contains(mataKuliah)) return new ResponseEntity("Mata Kuliah sudah ditambah", HttpStatus.BAD_REQUEST);
        mataKuliahs.add(mataKuliah);
        student.setCourseList(mataKuliahs);
        studentService.saveOrUpdateStudent(student);
        return new ResponseEntity("Berhasil memperbarui mata kuliah", HttpStatus.OK);
    }

    @PostMapping(value = "/removeMatkul")
    public ResponseEntity<?> removeMatKul(@RequestBody AddMatkul addMatkul,@RequestHeader String Authorization) {
        long studentNumber = addMatkul.getStudentNumber();
        String matkul = addMatkul.getMatkul();
        Student student = studentService.findByStudentNumber(studentNumber);
        MataKuliah mataKuliah = matKulService.findMatkulByName(matkul);
        if(student==null) return new ResponseEntity("Student tidak ditemukan wkwk", HttpStatus.NOT_FOUND);
        if(mataKuliah==null) return new ResponseEntity("Matkul tidak ditemukan wkwk", HttpStatus.NOT_FOUND);
        List<MataKuliah> mataKuliahs = student.getCourseList();
        int getIndex = -1;
        for(int i = 0; i<mataKuliahs.size(); i++) {
            if(mataKuliahs.get(i).getName().equals(mataKuliah.getName())) {
                getIndex = i;
                break;
            }
        }
        if(getIndex==-1) return new ResponseEntity("Mata kuliah yang ingin dihapus tidak ada dari awal", HttpStatus.BAD_REQUEST);
        mataKuliahs.remove(getIndex);
        student.setCourseList(mataKuliahs);
        studentService.saveOrUpdateStudent(student);
        return new ResponseEntity("Berhasil menghapus matkul", HttpStatus.OK);
    }


}

class AddMatkul {
    private String matkul;
    private long studentNumber;

    public String getMatkul() {
        return matkul;
    }

    public void setMatkul(String matkul) {
        this.matkul = matkul;
    }

    public long getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(long studentNumber) {
        this.studentNumber = studentNumber;
    }
}