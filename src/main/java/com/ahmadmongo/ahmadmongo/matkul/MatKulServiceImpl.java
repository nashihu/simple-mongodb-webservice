package com.ahmadmongo.ahmadmongo.matkul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Queue;

@Service
public class MatKulServiceImpl implements MatKulService {

    @Autowired
    private MatKulRepository matKulRepository;

    @Override
    public List<MataKuliah> findAll() {
        return matKulRepository.findAll();
    }

    @Override
    public MataKuliah findMatkulByName(String name) {
        return matKulRepository.findByName(name);
    }

    @Override
    public void saveOrUpdateMatKul(MataKuliah mataKuliah) {
        matKulRepository.save(mataKuliah);
    }

    @Override
    public void deleteMatKul(String id) {
        matKulRepository.deleteById(id);
    }
}
