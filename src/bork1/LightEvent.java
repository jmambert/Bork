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
class LightEvent extends Event {
    private String room;
    
    LightEvent(String room) {
        this.room = room;
    }
    
    public String execute() {
        String theRoom = GameState.instance().getDungeon().getRoom(room).getTitle();
        if (GameState.instance().getDungeon().getRoom(room).getIsDark() == true){
            GameState.instance().getDungeon().getRoom(room).setIsDark(false);
        } else{
            GameState.instance().getDungeon().getRoom(room).setIsDark(true);
        }
        return theRoom + " was lit up!";
    }
    
}
