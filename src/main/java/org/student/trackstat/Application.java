package org.student.trackstat;

import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Log
@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    log.info("======> Start application...");
    SpringApplication.run(Application.class, args);
    log.info("======> Application started.");
  }
}
