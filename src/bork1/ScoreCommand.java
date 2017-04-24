/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bork1;

/**
 *
 * @author Jordan
 * returns a string containing the player's score
 */
class ScoreCommand extends Command {

    ScoreCommand() {

    }

    /**
     *
     * @author Jordan 
     * returns a string containing the player's current score
     */
    public String execute() {
        int score = GameState.instance().getScore();
        return "Your score is " + score + ". \n";
    }

}
