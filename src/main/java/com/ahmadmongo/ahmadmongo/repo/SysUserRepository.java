//package com.ahmadmongo.ahmadmongo.repo;
//
//import com.ahmadmongo.ahmadmongo.model.SysUserDto;
//import iconpln.sinergi.successionplan.model.request.LoginReq;
//import org.springframework.data.mongodb.repository.MongoRepository;
//
//import java.util.Optional;
//
//public interface SysUserRepository extends MongoRepository<SysUserDto, String> {
//    Optional<SysUserDto> findByUsername(String username);
//
//    Optional<SysUserDto> findById(Long id);
//
//    Optional<SysUserDto> save(LoginReq req);
//}
