package com.project.springbootwebapp.controller;

import com.project.springbootwebapp.dto.UserDto;
import com.project.springbootwebapp.lib.AESEncryption;
import com.project.springbootwebapp.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@AllArgsConstructor
@Controller
@RequestMapping("/user")
@Log4j2
public class UserController {

  private UserService userService;

  @GetMapping("/signup.do")
  public void signupForm(){}
  @PostMapping("/signup.do")
  public String signupAction(
      @ModelAttribute UserDto user,
      RedirectAttributes redirectAttributes){
    int signup=0;
    String errorMsg=null;
    try {
      signup=userService.signup(user);
    }catch (Exception e){
      errorMsg=e.getMessage();
    }
    if(signup>0){
      redirectAttributes.addFlashAttribute("msg","회원가입을 축하합니다! 로그인 하세요.");
      return "redirect:/";
    }else{
      redirectAttributes.addFlashAttribute("msg","회원가입 실패 에러:"+errorMsg);
      return "redirect:/user/signup.do";
    }
  }

  @GetMapping("/login.do")
  public String loginForm(){
    return "/user/loginForm";
  }
  @PostMapping("/login.do")
  public String loginAction(
      UserDto user,
      Integer autoLogin,
      HttpSession session,
      RedirectAttributes redirectAttributes,
      @SessionAttribute(required = false) String redirectPage,
      HttpServletResponse resp) throws Exception {
    UserDto loginUser=null;
    log.info(user);
    try {
      loginUser=userService.login(user);
      log.info(loginUser);
    } catch(Exception e) {
      e.printStackTrace();
      log.error(e.getMessage());
    }
    if(loginUser!=null){
      if(autoLogin!=null && autoLogin==1){
        String encryptIdValue = AESEncryption.encryptValue(loginUser.getUId());
        String encryptPwValue = AESEncryption.encryptValue(loginUser.getPw());
        Cookie loginId=new Cookie("SPRING_LOGIN_ID",encryptIdValue);
        Cookie loginPw=new Cookie("SPRING_LOGIN_PW",encryptPwValue);
        loginId.setPath("/");
        loginPw.setPath("/");
        loginId.setMaxAge(7*24*60*60);
        loginPw.setMaxAge(7*24*60*60);
        resp.addCookie(loginId);
        resp.addCookie(loginPw);
      }
      redirectAttributes.addFlashAttribute("msg","로그인 성공");
      session.setAttribute("loginUser",loginUser);
      if(redirectPage!=null){
        session.removeAttribute("redirectPage");
        return "redirect:"+redirectPage;
      }
      return "redirect:/";
    }else{
      redirectAttributes.addFlashAttribute("msg","아이디나 패스워드를 확인하세요!");
      return "redirect:/user/login.do";
    }
  }
}
