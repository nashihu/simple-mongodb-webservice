//package com.ahmadmongo.ahmadmongo.sevice;
//
//import com.ahmadmongo.ahmadmongo.model.SysUserDto;
//import iconpln.common.model.http.HttpResponseModel;
//import iconpln.sinergi.successionplan.model.request.LoginReq;
//import org.springframework.lang.NonNull;
//
//import javax.annotation.Nonnull;
//
//public interface AuthService {
//    HttpResponseModel login(@Nonnull LoginReq req);
//
//    HttpResponseModel validateToken(String token, SysUserDto dto);
//
//    void logout(@Nonnull String username, @Nonnull String appSource);
//
//    HttpResponseModel register(@NonNull LoginReq req);
//}