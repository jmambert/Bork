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
class LockedEvent extends Event {
    private String room;
    private String exit;
    
    LockedEvent(String room, String exit) {
        this.room = room;
        this.exit = exit;
    }
    
    public String execute() {
        
        GameState.instance().getDungeon().getRoom(room).getExit(exit)
                .setLockState(true);
        return exit + " was locked!";
    }
    
}
