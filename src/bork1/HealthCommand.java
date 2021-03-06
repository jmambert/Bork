/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bork1;

/**
 *
 * @author Jordan
 * returns a string depending on the amount of
 * health the user
 */
class HealthCommand extends Command {

    HealthCommand() {
    }

    /**
     *
     * @author Jordan
     * returns a string based on the player's current health
     * 
     */
    public String execute() {
        int tempHealth = GameState.instance().getHealth();
        int tempTotalHealth = GameState.instance().getTotalHealth();
        if (tempHealth == tempTotalHealth) {
            return "You're all healthed up!" + "\n";
        } else if ((tempHealth >= tempTotalHealth * .9) && (tempHealth < tempTotalHealth)) { //90-100
            return "You're feelin' pretty good." + "\n";
        } else if ((tempHealth >= tempTotalHealth * .5) && (tempHealth < tempTotalHealth * .9)) { //50-90
            return "You feel normal." + "\n";
        } else if ((tempHealth >= tempTotalHealth * .4) && (tempHealth < tempTotalHealth * .5)) { //40-50
            return "You feel a slight pang, but it's not enough to complain about." + "\n";
        } else if ((tempHealth >= tempTotalHealth * .3) && (tempHealth < tempTotalHealth * .4)) { //30-40
            return "You are in pain." + "\n";
        } else if ((tempHealth >= tempTotalHealth * .2) && (tempHealth < tempTotalHealth * .3)) { //20-30
            return "You really hurt." + "\n";
        } else if ((tempHealth >= tempTotalHealth * .1) && (tempHealth < tempTotalHealth * .2)) { //10-20
            return "You don't know how much longer you can go on" + "\n";
        } else if ((tempHealth > tempTotalHealth * 0) && (tempHealth < tempTotalHealth * .1)) { //1-10
            return "This is your last straw." + "\n";
        } else if (tempHealth <= 0) {
            return "You dead." + "\n";
        } 
        return "Something went wrong...Health unattainable" + "\n";
    }
}
