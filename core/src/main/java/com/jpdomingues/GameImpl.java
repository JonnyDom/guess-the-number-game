package com.jpdomingues;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
@Getter
@Component
public class GameImpl implements Game{

    //== Fields ==//
    @Getter(AccessLevel.NONE)  //numberGenerator is the only field that doesn't need a getter
    private final NumberGenerator numberGenerator;

    private final int guessCount;

    private int number;

    private int smallest;
    private int biggest;
    private int remainingGuesses;
    private boolean validNumberRange = true;

    @Setter //guess is the only field with a getter
    private int guess;

    //== Constructors ==//
    @Autowired
    public GameImpl(NumberGenerator numberGenerator,@GuessCount int guessCount) {
        this.numberGenerator = numberGenerator;
        this.guessCount = guessCount;
    }

    //== init ==//
    @PostConstruct
    @Override
    public void reset() {
        smallest = numberGenerator.getMinNumber();
        guess = 10;
        remainingGuesses = guessCount;
        biggest = numberGenerator.getMaxNumber();
        number = numberGenerator.next();
        //log.debug("The number is {}",number);
    }

    @PreDestroy
    public void preDestroy(){
        log.info("in Game preDestroy()");
    }

    //== public methods ==//

    @Override
    public void check() {
        checkValidNumberRange();

        if(validNumberRange){
            if(guess > number){
                biggest = guess -1;
            }

            if(guess < number){
                smallest = guess + 1;
            }
        }

        remainingGuesses--;
    }

    @Override
    public boolean isGameWon() {
        return guess == number;
    }

    @Override
    public boolean isGameLost() {
        return !isGameWon() && remainingGuesses <= 0;
    }


    //== private methods ==//
    private void checkValidNumberRange(){
        validNumberRange = (guess >= smallest) && (guess <= biggest);
    }
}
