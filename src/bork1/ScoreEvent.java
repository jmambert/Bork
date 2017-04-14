/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bork1;

/**
 *
 * @author Jordan
 * when triggered, the event will add to the player's total score
 */
class ScoreEvent extends Event {
    private int addToScore;

    ScoreEvent() {
        addToScore = this.addToScore;
    }

    /**
     *
     * @author Jordan
     * returns a string saying the player's score has been updated
     */
    public String execute() {
        int tempScore = GameState.instance().getScore();
        int newScore = tempScore + addToScore;
        return "Your score has been updated!";
    }
}
