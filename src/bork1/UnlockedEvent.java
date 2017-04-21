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
    private String room;
    private String exit;
    
    UnlockedEvent(String room, String exit) {
        this.room = room;
        this.exit = exit;
    }

    UnlockedEvent() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String execute() {
        
        GameState.instance().getDungeon().getRoom(room).getExit(exit)
                .setLockState(false);
        return "You unlocked " + exit + "!";
    }
    
}
