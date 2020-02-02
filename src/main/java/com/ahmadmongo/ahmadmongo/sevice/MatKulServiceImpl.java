package com.ahmadmongo.ahmadmongo.sevice;

import com.ahmadmongo.ahmadmongo.model.MataKuliah;
import com.ahmadmongo.ahmadmongo.repo.MatKulRepository;
import com.ahmadmongo.ahmadmongo.sevice.MatKulService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatKulServiceImpl implements MatKulService {

    @Autowired
    private MatKulRepository matKulRepository;

    @Override
    public Page<MataKuliah> findAll(PageRequest pageRequest) {
        return matKulRepository.findAll(pageRequest);
    }

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
