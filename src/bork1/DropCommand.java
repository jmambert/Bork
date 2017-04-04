
package bork1;
/*
DropCommand takes care of commands input by the user that pertain to dropping items
@author jmambert
DropCommand will verify user has a valid item to drop, then remove item as necessary
*/

class DropCommand extends Command {

    private String itemName;
    
    DropCommand(String itemName) {
        this.itemName = itemName;
    }

    /*
    execute checks to make sure user drop is valid
    catches possible errors
    @author jmambert
    */
    public String execute() {
        if (itemName == null || itemName.trim().length() == 0) {
            return "Drop what?\n";
        }
        try {
            Item theItem = GameState.instance().getItemFromInventoryNamed(
                itemName);
            GameState.instance().removeFromInventory(theItem);
            GameState.instance().getAdventurersCurrentRoom().add(theItem);
            return itemName + " dropped.\n";
        } catch (Item.NoItemException e) {
            return "You don't have a " + itemName + ".\n";
        }
    }
}
