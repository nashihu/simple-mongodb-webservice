package com.ahmadmongo.ahmadmongo.repo;

import com.ahmadmongo.ahmadmongo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    User findByEmail(String email);
}
