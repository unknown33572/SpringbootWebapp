package com.project.springbootwebapp.service;

import com.project.springbootwebapp.dto.BoardDto;
import com.project.springbootwebapp.dto.UserDto;
import com.project.springbootwebapp.mapper.BoardMapper;
import com.project.springbootwebapp.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {
  private BoardMapper boardMapper;
  private UserMapper userMapper;
  @Override
  public List<BoardDto> list(UserDto loginUser) {
    if(loginUser!=null) {
      userMapper.setLoginUserId(loginUser.getUId());
    }
    List<BoardDto> list=boardMapper.findAll();
    if(loginUser!=null) {
      userMapper.setLoginUserIdNull();
    }
    return list;
  }

  @Override
  @Transactional
  public BoardDto detail(int bId) {
//    boardMapper.updateIncrementViewCountByBId(bId);
    BoardDto detail=boardMapper.findByBId(bId);
    return detail;
  }

  @Override
  public int register(BoardDto board, List<String> tags) {
    int register=boardMapper.insertOne(board);
    return register;
  }

  @Override
  public int modify(BoardDto board, List<String> tags) {
    int modify=boardMapper.updateOne(board);
    return modify;
  }

  @Override
  public int remove(int bId) {
    int remove=boardMapper.deleteOne(bId);
    return remove;
  }
}
