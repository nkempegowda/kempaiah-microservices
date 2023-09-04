package com.kempaiah.company;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileController {

  Logger LOGGER = LoggerFactory.getLogger(FileController.class);

  @PostMapping(value = "upload")
  public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
    LOGGER.info(String.format("%s %s uploaded successfully",file.getOriginalFilename(), file.getSize()));
    LOGGER.info(file.getInputStream().readAllBytes().toString());
    return ResponseEntity.ok("File uploaded successfully");
  }
}
