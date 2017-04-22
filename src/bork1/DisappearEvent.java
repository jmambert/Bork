/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bork1;

/**
 *
 * @author Jordan
 * when this event is triggered, an item will be erased from the game completely
 */
class DisappearEvent extends Event {
    private String itemName;

    DisappearEvent(String itemName) {
        this.itemName = itemName;
    }
/**
 * 
 * @author Jordan
 * removes the item from the game completely and returns a string whether it was
 * successful or not
 */
    public String execute() {
        try {
            Item theItem = GameState.instance().getItemFromInventoryNamed(itemName);
            GameState.instance().removeFromInventory(theItem);
            GameState.instance().getAdventurersCurrentRoom().remove(theItem);
        } catch (Item.NoItemException e) {
            try {
            Item theItem = GameState.instance().getItemInVicinityNamed(itemName);
            GameState.instance().getAdventurersCurrentRoom().remove(theItem);
            } catch (Exception i) {
                return itemName + " was not found.";
            }
        }
        return itemName + " has disappeared!";
    }

}
