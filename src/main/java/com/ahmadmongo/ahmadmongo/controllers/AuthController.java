//package com.ahmadmongo.ahmadmongo.controllers;
//
//import com.ahmadmongo.ahmadmongo.importedClass.DecodeUtil;
//import com.ahmadmongo.ahmadmongo.importedClass.HeaderConstant;
//import com.ahmadmongo.ahmadmongo.model.SysUserDto;
//import com.ahmadmongo.ahmadmongo.sevice.AuthService;
//import iconpln.common.model.http.HttpResponseModel;
//import iconpln.sinergi.successionplan.model.request.LoginReq;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@RestController
//@CrossOrigin
//@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//@Api(value = "Auth User API", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"Auth"})
//public class AuthController {
//    @Autowired
//    private AuathService authService;
//
//    @PostMapping(value = "auth/login", consumes = MediaType.APPLICATION_JSON_VALUE)
//    @ApiOperation(value = "API Login", response = HttpResponseModel.class, notes = "LoginReq")
//    public ResponseEntity login(HttpServletRequest req, HttpServletResponse resp, @RequestBody LoginReq login) {
//        HttpResponseModel model = authService.login(login);
//        if (model.isSuccess()) {
//            SysUserDto dto = DecodeUtil.decode(model, SysUserDto.class);
//            String token = dto.getToken();
//            resp.setHeader(HeaderConstant.AUTHORIZATION, token);
//        }
//        return ResponseEntity.ok(model);
//    }
//
//    @PostMapping(value = "auth/register", consumes = MediaType.APPLICATION_JSON_VALUE)
//    @ApiOperation(value = "API Registerr", response = HttpResponseModel.class, notes = "User Register")
//    public ResponseEntity register(HttpServletRequest req, HttpServletResponse resp, @RequestBody LoginReq login) {
//
//        return ResponseEntity.ok(authService.register(login));
//    }
//}
