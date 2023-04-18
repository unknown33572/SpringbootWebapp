package com.project.springbootwebapp.service;

import com.project.springbootwebapp.dto.UserDto;
import com.project.springbootwebapp.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  private UserMapper userMapper;

  public UserServiceImpl(UserMapper userMapper) {
    this.userMapper = userMapper;
  }

  @Override
  public UserDto login(UserDto user) {
    return userMapper.findByUIdAndPw(user);
  }

  @Override
  public UserDto detail(String uId) {
    return null;
  }

  @Override
  public int signup(UserDto user) {
    return 0;
  }

  @Override
  public int modify(UserDto user) {
    return 0;
  }

  @Override
  public int dropout(UserDto user) {
    return 0;
  }
}
