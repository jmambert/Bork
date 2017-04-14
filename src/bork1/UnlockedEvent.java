/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bork1;

/**
 *
 * @author Jordan
 */
class UnlockedEvent extends Event {
    String room;
    String exit;
    
    UnlockedEvent(String room, String exit) {
        this.room = room;
        this.exit = exit;
    }
    
    public String execute() {
        String exitName = this.exit.toString();
        GameState.instance().getDungeon().getRoom(room).getExit(exit)
                .setLockState(false);
        return "You unlocked " + exitName + "!";
    }
    
}
