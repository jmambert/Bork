/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bork1;

/**
 *
 * @author Jordan removes one item from the game completely only to 'transform'
 * and change it into another item to take its place
 */
class TransformEvent extends Event {

    private String itemName;
    private String newItemName;

    TransformEvent(String itemName, String newItemName) {
        this.itemName = itemName;
        this.newItemName = newItemName;
    }

    /**
     *
     * @author Jordan
     * removes the item from the game completely and returns a
     * string whether it was successful or not
     */
    public String execute() {
        try {
            try {
                Item theItem = GameState.instance().getItemFromInventoryNamed(itemName);
                GameState.instance().removeFromInventory(theItem);
                Item theNewItem = GameState.instance().getDungeon().getItem(newItemName);
                GameState.instance().addToInventory(theNewItem);
            } catch (Exception exc) {
                Item theItem = GameState.instance().getItemInVicinityNamed(itemName);
                GameState.instance().getAdventurersCurrentRoom().remove(theItem);
                Item theNewItem = GameState.instance().getDungeon().getItem(newItemName);
                GameState.instance().getAdventurersCurrentRoom().add(theNewItem);
            }
        } catch (Exception e) {
            return "Apologies, something went wrong with the transform.";
        }
        return itemName + " has disappeared! But, " + newItemName + " has appeared!";
    }

}
