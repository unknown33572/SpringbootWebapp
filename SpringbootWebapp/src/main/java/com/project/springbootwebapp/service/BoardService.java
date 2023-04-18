package com.project.springbootwebapp.service;

import com.project.springbootwebapp.dto.BoardDto;
import com.project.springbootwebapp.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BoardService {
  List<BoardDto> list(UserDto loginUser);
  BoardDto detail(int bId);
  int register(BoardDto board, List<String> tags);
  int modify(BoardDto board, List<String> tags);
  int remove(int bId);
}