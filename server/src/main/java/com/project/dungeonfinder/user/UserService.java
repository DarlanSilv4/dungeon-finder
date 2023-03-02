package com.project.dungeonfinder.user;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Transactional
  public User save(User user) {
    return userRepository.save(user);
  }

  public Boolean existsByEmail(String email) {
    return userRepository.existsByEmail(email);
  }
}
