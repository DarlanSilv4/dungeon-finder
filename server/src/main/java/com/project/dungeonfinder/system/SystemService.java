package com.project.dungeonfinder.system;

import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SystemService {

  final SystemRepository systemRepository;

  public SystemService(SystemRepository systemRepository) {
    this.systemRepository = systemRepository;
  }

  @Transactional
  public System save(System system) {
    return systemRepository.save(system);
  }

  public Boolean existsByName(String name) {
    return systemRepository.existsByName(name);
  }

  public Boolean existsByAbbreviation(String abbreviation) {
    return systemRepository.existsByAbbreviation(abbreviation);
  }

  public List<System> findAllByOrderByNameAsc() {
    return systemRepository.findAllByOrderByNameAsc();
  }
}
