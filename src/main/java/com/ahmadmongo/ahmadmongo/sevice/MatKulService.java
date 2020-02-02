package com.ahmadmongo.ahmadmongo.sevice;

import com.ahmadmongo.ahmadmongo.model.MataKuliah;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface MatKulService {

    Page<MataKuliah> findAll(PageRequest pageRequest);

    List<MataKuliah> findAll();

    MataKuliah findMatkulByName(String name);

    void saveOrUpdateMatKul(MataKuliah mataKuliah);

    void deleteMatKul(String id);
}
