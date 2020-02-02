//package com.ahmadmongo.ahmadmongo.sevice;
//
//import com.ahmadmongo.ahmadmongo.importedClass.SysUserAssembler;
//import com.ahmadmongo.ahmadmongo.model.SysUserDto;
//import com.ahmadmongo.ahmadmongo.repo.SysUserRepository;
//import iconpln.common.model.http.HttpResponseModel;
//import iconpln.sinergi.successionplan.domain.entity.system.SysUser;
//import iconpln.sinergi.successionplan.model.request.LoginReq;
//import iconpln.sinergi.successionplan.service.util.TokenUtil;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.StringUtils;
//import org.mindrot.jbcrypt.BCrypt;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.annotation.Nonnull;
//import java.util.Optional;
//
//@Service
//@Slf4j
//public class AuthServiceImpl implements AuthService {
//    @Autowired
//    private SysUserRepository userRepository;
//    @Autowired
//    private SysUserAssembler userAssembler;
//
//    @Override
////    @Transactional
//    public HttpResponseModel login(LoginReq req) {
//        HttpResponseModel model = HttpResponseModel.error(400, "Gagal login, pastikan username & password sesuai!");
//        if ((StringUtils.isBlank(req.getUsername())) || StringUtils.isBlank(req.getPassword()))
//            return model;
//
//        log.info("user with id:{} try to login", req.getUsername());
//
//        Optional<SysUserDto> op = userRepository.findByUsername(req.getUsername().toUpperCase());
//        if (!op.isPresent())
//            return model;
//
//        SysUserDto entity = op.get();
//        String hashed = entity.getPassword();
//        if (!BCrypt.checkpw(req.getPassword(), hashed)) {
//            log.info("user with id:{} failed to login, invalid password!", req.getUsername());
//            return model;
//        }
//
//
//        // generate token
//        String jwtToken = TokenUtil.genJWTToken(userAssembler.toJwtDto(entity));
//
//        // response
//        SysUserDto userDTO = userAssembler.toDto(entity);
//        userDTO.setToken(jwtToken);
//
//        log.info("user with id:{} success login", req.getUsername());
//        return HttpResponseModel.ok(userDTO);
//    }
//
//    @Override
//    public HttpResponseModel validateToken(String token, SysUserDto dto) {
//        Optional<SysUserDto> opUserDTO = this.userRepository.findById(dto.getId()).map((user) -> {
//            return this.userAssembler.toDto(user);
//        });
//        if (!opUserDTO.isPresent()) {
//            return HttpResponseModel.error(404, "User Not Found");
//        } else {
//            SysUserDto userDTO = opUserDTO.get();
//            userDTO.setToken(token);
//            return HttpResponseModel.ok(userDTO, "Success");
//        }
//    }
//
//    @Override
//    public void logout(@Nonnull String username, @Nonnull String appSource) {
//        /* No logout process its state-less jwt */
//    }
//
//    public HttpResponseModel register(LoginReq req) {
//        Optional<SysUserDto> opUserDTO = userRepository.save(req);
//        return HttpResponseModel.ok(opUserDTO,"Success");
//    }
//
//}
