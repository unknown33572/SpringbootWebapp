package com.project.springbootwebapp.mapper;

import com.project.springbootwebapp.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BoardMapper {
  List<BoardDto> findAll();
  BoardDto findByBId(int bId);
  int insertOne(BoardDto board);
  int updateOne(BoardDto board);
  int deleteOne(int bId);
//  int updateStatusByBId(BoardDto board);
//  int updateIncrementViewCountByBId(int bId);
}
