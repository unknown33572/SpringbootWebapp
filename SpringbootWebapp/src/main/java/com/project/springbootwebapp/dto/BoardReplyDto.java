package com.project.springbootwebapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@JsonIgnoreProperties({"handler"})
public class BoardReplyDto {
  private int brId; //pk (auto_increment)
  @JsonProperty("bId")
  private int bId; //fk boards.b_id
  @JsonProperty("uId")
  private String uId; //fk users.u_id
  private Integer parentBrId; //self join fk board_replies.br_id IS NULL
  private Date postTime; //default CURRENT_TIMESTAMP
  private Date updateTime; //default on update CURRENT_TIMESTAMP
  private String status; //enum [PUBLIC,PRIVATE,REPORT,BLOCK]
  private String imgPath;
  private String content;
  private LikeStatusCntDto likes; //1 : N = board_replies : board_reply_likes 이지만 집계한 결과만 조회
  private List<BoardReplyDto> replies; //1 : N = board_replies : board_replies
}
