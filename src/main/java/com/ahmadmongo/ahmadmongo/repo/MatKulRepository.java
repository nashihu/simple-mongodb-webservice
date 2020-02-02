package com.ahmadmongo.ahmadmongo.repo;

import com.ahmadmongo.ahmadmongo.model.MataKuliah;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MatKulRepository extends MongoRepository<MataKuliah,String> {

    MataKuliah findByName(String name);
}
