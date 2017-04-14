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
class SpecificTeleportEvent extends Event {
    private String roomname;
    
    SpecificTeleportEvent(String roomname) {
        this.roomname = roomname;
    }
    
    public String execute() {
        
        GameState.instance().setAdventurersCurrentRoom(GameState.instance()
                .getDungeon().getRoom(roomname));
        
        return "";
    }
    
}
