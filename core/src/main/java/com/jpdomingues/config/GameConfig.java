package com.jpdomingues.config;

import com.jpdomingues.GuessCount;
import com.jpdomingues.MaxNumber;
import com.jpdomingues.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.jpdomingues")
@PropertySource("classpath:config/game.properties")
public class GameConfig {

    //== fields ==//
    @Value("${game.maxNumber:20}")
    private int maxNumber;

    @Value("${game.minNumber:2}")
    private int minNumber;

    @Value("${game.guessCount:5}")
    private int guessCount;

    //== bean methods ==//
    @Bean
    @MaxNumber
    public int maxNumber1() {
        return maxNumber;
    }

    @Bean
    @MinNumber
    public int minNumber1() {
        return minNumber;
    }

    @Bean
    @GuessCount
    public int guessCount1(){
        return guessCount;
    }
}
