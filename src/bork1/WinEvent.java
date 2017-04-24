/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bork1;

/**
 *
 * @author Jordan 
 * when triggered, the event will print a message to the screen
 */
class WinEvent extends Event {

    WinEvent() {
        
    }

    /**
     * @author Jordan
     * returns a string saying the player won
     */
    public String execute() {
        GameState.instance().setIsWon();
        return "Congradulations! You won!";
    }

}
