package com.project.dungeonfinder.system;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemRepository extends JpaRepository<System, UUID> {
  boolean existsByName(String name);

  boolean existsByAbbreviation(String name);

  List<System> findAllByOrderByNameAsc();
}
