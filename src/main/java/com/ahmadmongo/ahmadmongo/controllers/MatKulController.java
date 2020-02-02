package com.ahmadmongo.ahmadmongo.controllers;

import com.ahmadmongo.ahmadmongo.sevice.MatKulService;
import com.ahmadmongo.ahmadmongo.model.MataKuliah;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequestMapping("/matkul")
public class MatKulController {
    @Autowired
    MatKulService matKulService;

//    @GetMapping(value = "/findAllMatKul")
//    public List<MataKuliah> getAllMatKul() {
//        return matKulService.findAll();
//    }

    @GetMapping(value = "/findAllMatKulPageable")
    public Page<MataKuliah> getAllMatKulPageable(int page, int size) {
        PageRequest pageable = PageRequest.of(page,size);

        Page<MataKuliah> pages = matKulService.findAll(pageable);
        return pages;
    }

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
