package com.ahmadmongo.ahmadmongo.matkul;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MatKulRepository extends MongoRepository<MataKuliah,String> {

    MataKuliah findByName(String name);
}
