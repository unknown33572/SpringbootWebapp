package com.project.springbootwebapp.service;

import com.project.springbootwebapp.dto.UserDto;
import org.springframework.stereotype.Service;

//@Component: spring container(Inversion of Controller 컨테이너) 관리하는 bean 객체
//IoC(제어의 역전): 객체를 내부에서 생성하는 것이 아니라 외부(컨테이너)에서 생성하고 주입하는 것 [AOP]
//DI(의존성 주입): private 필드인 @Autowired or (생성자 혹은 setter)를 통해 주입(POJO)
//DIP(의존성 역전 원칙): 주입받는 객체의 타입은 꼭 인터페이스로 정의
@Service //@Component 하위 어노테이션으로 service를 관리한다는 명시적 의미와 @Transactional 어노테이션을 정의 가능
public interface UserService {
  UserDto login(UserDto user);
  UserDto detail(String uId);
  int signup(UserDto user);
  int modify(UserDto user);
  int dropout(UserDto user);
}
