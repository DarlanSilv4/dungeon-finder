package com.project.dungeonfinder.system;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/system")
public class SystemController {

  final SystemService systemService;

  public SystemController(SystemService systemService) {
    this.systemService = systemService;
  }

  @PostMapping
  public ResponseEntity<Object> saveSystem(
    @RequestBody @Valid SystemDto systemDto
  ) {
    String nameFormatted = systemDto.getName().toLowerCase().trim();
    String abbreviationFormatted = "";

    if (
      systemDto.getAbbreviation() != null &&
      !systemDto.getAbbreviation().isEmpty()
    ) {
      abbreviationFormatted = systemDto.getAbbreviation().toLowerCase().trim();
    }

    if (systemService.existsByName(nameFormatted)) {
      return ResponseEntity
        .status(HttpStatus.CONFLICT)
        .body(
          Map.entry("message", "name is already used by an existing system!")
        );
    }

    if (
      !abbreviationFormatted.isBlank() &&
      systemService.existsByAbbreviation(abbreviationFormatted)
    ) {
      return ResponseEntity
        .status(HttpStatus.CONFLICT)
        .body(
          Map.entry(
            "message",
            "abbreviation is already used by an existing system!"
          )
        );
    }

    System system = new System();
    system.setName(nameFormatted);

    if (!abbreviationFormatted.isBlank()) system.setAbbreviation(
      abbreviationFormatted
    );

    return ResponseEntity
      .status(HttpStatus.CREATED)
      .body(systemService.save(system));
  }

  @GetMapping
  public ResponseEntity<List<System>> getListOfUsers() {
    return ResponseEntity
      .status(HttpStatus.OK)
      .body(systemService.findAllByOrderByNameAsc());
  }
}
