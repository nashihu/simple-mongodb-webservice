//package com.ahmadmongo.ahmadmongo.importedClass;
//
//import com.ahmadmongo.ahmadmongo.model.SysUserDto;
//import iconpln.sinergi.successionplan.assembler.Assembler;
//import iconpln.sinergi.successionplan.domain.entity.system.SysRole;
//import iconpln.sinergi.successionplan.domain.entity.system.SysUser;
//import iconpln.sinergi.successionplan.model.response.UserJwtDto;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Component
//public class SysUserAssembler implements Assembler<SysUserDto, SysUserDto> {
//    public SysUserAssembler() {
//    }
//
//    @Override
//    public SysUserDto toEntity(SysUserDto dto) {
//        return null;
//    }
//
//    @Override
//    public List<SysUserDto> toEntity(List<SysUserDto> dtos) {
//        return null;
//    }
//
//    @Override
//    public SysUserDto toDto(SysUserDto entity) {
//        return entity == null ? null : SysUserDto.builder().id(entity.getId()).username(entity.getUsername()).build();
//    }
//
//    @Override
//    public List<SysUserDto> toDto(List<SysUserDto> entities) {
//        return entities == null ? null : (List)entities.stream().map(this::toDto).collect(Collectors.toList());
//    }
//
//    public UserJwtDto toJwtDto(SysUserDto entity) {
//        return entity == null ? null : UserJwtDto.builder().id(entity.getId()).username(entity.getUsername()).build();
//    }
//}