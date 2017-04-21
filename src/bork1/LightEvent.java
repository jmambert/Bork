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
        
    LightEvent() {
        
    }
    
    public String execute() {
        String itemName = "";
        if (GameState.instance().getIsLit() == true){
            GameState.instance().setIsLit(false);
        } else{
            GameState.instance().setIsLit(true);
        }
        return itemName + " was lit up!";
    }
    
}
