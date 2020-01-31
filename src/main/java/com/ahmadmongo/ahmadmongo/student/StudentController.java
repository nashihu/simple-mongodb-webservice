package com.ahmadmongo.ahmadmongo.student;

import com.ahmadmongo.ahmadmongo.BaseFunc;
import com.ahmadmongo.ahmadmongo.matkul.MatKulService;
import com.ahmadmongo.ahmadmongo.matkul.MataKuliah;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping(value = "/getAllStudent")
    public List<Student> getAllStudents() {
        return studentService.findAll();
    }

    @RequestMapping(value = "/getStudentByNumber/{studentNumber}",method = RequestMethod.GET)
    public Student getStudentByStudentNumber(@PathVariable("studentNumber") Long studentNumber) {
        return studentService.findByStudentNumber(studentNumber);
    }

    @RequestMapping(value = "/getStudentByEmail/{email}",method = RequestMethod.GET)
    public Student getStudentByEmail(@PathVariable("email") String email) {
        return studentService.findByEmail(email);
    }

    @RequestMapping(value = "/getStudentOrderByGpa",method = RequestMethod.GET)
    public List<Student> findAllByOrderByGpaDesc() {
        return studentService.findAllByOrderByGpa();
    }

    @PostMapping(value = "/addStudent")
    public ResponseEntity<?> saveOrUpdateStudent(@RequestBody Student student) {
        List<MataKuliah> mataKuliahs = new ArrayList<>();
        if(student.getCourseList()==null) {
            student.setCourseList(mataKuliahs);
        }
        studentService.saveOrUpdateStudent(student);
        return new ResponseEntity("Student added successfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteStudentByNumber/{studentNumber}")
    public void deleteStudent(@PathVariable Long studentNumber) {
        studentService.deleteStudent(studentService.findByStudentNumber(studentNumber).getId());
    }

    @PostMapping(value = "/addMatkul")
    public ResponseEntity<?> addMatKul(@RequestBody AddMatkul addMatkul) {
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
    public ResponseEntity<?> removeMatKul(@RequestBody AddMatkul addMatkul) {
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