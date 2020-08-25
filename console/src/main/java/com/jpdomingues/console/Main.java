package com.jpdomingues.console;

import com.jpdomingues.config.GameConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Main {

    public static void main(String[] args) {
        //a log is created automatically with the @slf4j annotation
        log.info("Guess the number game");

        //Create context
        ConfigurableApplicationContext context
                = new AnnotationConfigApplicationContext(GameConfig.class);

        //close context (container)
        context.close();
    }


}
