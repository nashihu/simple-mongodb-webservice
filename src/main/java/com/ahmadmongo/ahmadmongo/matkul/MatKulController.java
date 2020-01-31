package com.ahmadmongo.ahmadmongo.matkul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matkul")
public class MatKulController {
    @Autowired
    MatKulService matKulService;

    @GetMapping(value = "/findAllMatKul")
    public List<MataKuliah> getAllMatKul() {return matKulService.findAll();}

    @GetMapping(value = "/getMatKulByName/{matKulName}")
    public MataKuliah getMatKulByName(@PathVariable("matKulName") String matKulName) {
        return matKulService.findMatkulByName(matKulName);
    }

    @PostMapping(value = "/addMatKul")
    public ResponseEntity<?> saveOrUpdateMatKul(@RequestBody MataKuliah mataKuliah) {
        matKulService.saveOrUpdateMatKul(mataKuliah);
        return new ResponseEntity("Matkul added successfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteMatKulByName/{mataKuliahName}")
    public  ResponseEntity<?> deleteMatKul(@PathVariable String mataKuliahName) {
        MataKuliah mataKuliah = matKulService.findMatkulByName(mataKuliahName);
        matKulService.deleteMatKul(matKulService.findMatkulByName(mataKuliahName).getId());
        return new ResponseEntity("sip",HttpStatus.OK);
    }

}
