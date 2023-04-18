package com.project.springbootwebapp.dto;

import lombok.Data;

@Data
public class LikeStatusCntDto {
  //Status 의 집계(count) 결과
  private int like;
  private int bad;
  private int id;
  private String status;
}
