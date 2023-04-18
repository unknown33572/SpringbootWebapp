package com.project.springbootwebapp.controller;

import com.project.springbootwebapp.dto.BoardDto;
import com.project.springbootwebapp.dto.UserDto;
import com.project.springbootwebapp.service.BoardService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller
@RequestMapping("/board")
@Log4j2
public class BoardController {
  private BoardService boardService;
  public BoardController(BoardService boardService) {
    this.boardService = boardService;
  }

  @GetMapping("/list.do")
  public String list(Model model,
                     @SessionAttribute(required = false) UserDto loginUser) {
    List<BoardDto> boards=boardService.list(loginUser);
    model.addAttribute("boards", boards);
    return "/board/list";
  }

  @GetMapping("{bId}/detail.do")
  public String detail(Model model,
                       @PathVariable int bId) {
    BoardDto board=boardService.detail(bId);
    model.addAttribute("b", board);
    return "/board/detail";
  }
}
