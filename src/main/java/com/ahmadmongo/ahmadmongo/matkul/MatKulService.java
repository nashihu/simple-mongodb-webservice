package com.ahmadmongo.ahmadmongo.matkul;

import java.util.List;

public interface MatKulService {

    List<MataKuliah> findAll();

    MataKuliah findMatkulByName(String name);

    void saveOrUpdateMatKul(MataKuliah mataKuliah);

    void deleteMatKul(String id);
}
