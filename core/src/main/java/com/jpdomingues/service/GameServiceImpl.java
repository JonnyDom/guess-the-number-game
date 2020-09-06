package com.jpdomingues.service;

import com.jpdomingues.Game;
import com.jpdomingues.MessageGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Slf4j
@Service
public class GameServiceImpl implements GameService {

    // == fields == //
    final Game game;

    final MessageGenerator messageGenerator;


    //== Constructors ==//
    /**
     * Constructor injection of Game and MessageGenerator fields
     * (allows for these fields to be final)
     * @param game the Game type bean.
     * @param messageGenerator the MessageGenerator type bean.
     */
    @Autowired
    public GameServiceImpl(Game game, MessageGenerator messageGenerator) {
        this.game = game;
        this.messageGenerator = messageGenerator;
    }

    //== init ==//
    @PostConstruct
    private void init(){
        log.info("Number = {}", game.getNumber());
        log.info(messageGenerator.getMainMessage());
    }


    @Override
    public boolean isGameOver() {
        return game.isGameLost() || game.isGameWon();
    }

    @Override
    public String getMainMessage() {
        return messageGenerator.getMainMessage();
    }

    @Override
    public String getResultMessage() {
        return messageGenerator.getResultMessage();
    }

    @Override
    public void checkGuess(int guess) {
        game.setGuess(guess);
        game.check();
    }

    @Override
    public void reset() {
        game.reset();
    }
}
