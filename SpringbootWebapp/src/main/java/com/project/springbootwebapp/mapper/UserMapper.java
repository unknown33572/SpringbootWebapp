package com.project.springbootwebapp.mapper;

import com.project.springbootwebapp.dto.BoardDto;
import com.project.springbootwebapp.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper //mybatis mapper 어노테이션
public interface UserMapper {
  UserDto findByUId(String uId);
  UserDto findByUIdAndPw(UserDto user);
  String findUIdByEmailAndPhoneAndName(UserDto user);
  int updateOne(UserDto user);
  int updatePw(UserDto user);
  int insertOne(UserDto user);
  int deleteByUIdAndPw(UserDto user);
  int setLoginUserId(String uId);
  int setLoginUserIdNull();
}
