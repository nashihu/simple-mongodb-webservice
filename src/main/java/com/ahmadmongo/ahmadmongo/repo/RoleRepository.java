package com.ahmadmongo.ahmadmongo.repo;

import com.ahmadmongo.ahmadmongo.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role, String> {

    Role findByRole(String role);
}

