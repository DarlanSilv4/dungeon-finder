package com.project.dungeonfinder.user;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Map;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

  final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping
  public ResponseEntity<Object> saveUser(@RequestBody @Valid UserDto userDto) {
    if (userService.existsByEmail(userDto.getEmail())) {
      return ResponseEntity
        .status(HttpStatus.CONFLICT)
        .body(Map.entry("message", "email has already been taken!"));
    }

    User user = new User();
    BeanUtils.copyProperties(userDto, user);
    user.setAvatarUrl(
      "https://api.dicebear.com/5.x/adventurer/svg?backgroundColor=f87171"
    );
    return ResponseEntity
      .status(HttpStatus.CREATED)
      .body(userService.save(user));
  }

  @GetMapping
  public ResponseEntity<List<User>> getListOfUsers() {
    return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
  }
}
