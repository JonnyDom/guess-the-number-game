package com.jpdomingues;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        //a log is created automatically with the @slf4j annotation
        log.info("Guess the number game");

        SpringApplication.run(Main.class, args);
    }


}
