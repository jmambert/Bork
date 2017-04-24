/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bork1;

/**
 *
 * @author Jordan
 * when triggered, the event will print a message to the screen saying the 
 * player has taken damage
 */
class WoundEvent extends Event {

    private int damageTaken;
    WoundEvent(int damageTaken) {
        this.damageTaken = damageTaken;
    }

    /**
     *
     * @author Jordan
     * gets player's current health and subtracts it by the damage taken
     * returns a string saying the player has taken damaged
     */
    public String execute() {
        int playersCurrentHealth = GameState.instance().getHealth();
        int newCurrentHealth = playersCurrentHealth - damageTaken;
        GameState.instance().setHealth(newCurrentHealth);
        return "Ouch! That hurt. You have taken damage.";
    }

}
