
package bork1;

/*
TakeCommand extends Command class and is called when user attempts to take items
@author jmambert
*/
class TakeCommand extends Command {

    private String itemName;

    /*
    TakeCommand has one @param that is a string
    Sets string it was passed to itemName
    @author jmambert
    */
    TakeCommand(String itemName) {
        this.itemName = itemName;
    }

    /*
    execute() checks to see if user is attempting to take a valid item or not
    can throw NoItemException if item is already in inventory or if item does
        not exist
    @author jmambert
    */
    public String execute() {
        if (itemName == null || itemName.trim().length() == 0) {
            return "Take what?\n";
        }
        try {
            Room currentRoom = 
                GameState.instance().getAdventurersCurrentRoom();
            Item theItem = currentRoom.getItemNamed(itemName);
            GameState.instance().addToInventory(theItem);
            currentRoom.remove(theItem);
            return itemName + " taken.\n";
        } catch (Item.NoItemException e) {
            // Check and see if we have this already. If no exception is
            // thrown from the line below, then we do.
            try {
                GameState.instance().getItemFromInventoryNamed(itemName);
                return "You already have the " + itemName + ".\n";
            } catch (Item.NoItemException e2) {
                return "There's no " + itemName + " here.\n";
            }
        }
    }
}
