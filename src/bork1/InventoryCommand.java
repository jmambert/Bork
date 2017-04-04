
package bork1;

/*
InventoryCommand extends Command class and prints to the screen what is in the
    user's inventory if any
*/
import java.util.ArrayList;

class InventoryCommand extends Command {

    InventoryCommand() {
    }

    public String execute() {
        ArrayList<String> names = GameState.instance().getInventoryNames();
        if (names.size() == 0) {
            return "You are empty-handed.\n";
        }
        String retval = "You are carrying:\n";
        for (String itemName : names) {
            retval += "   A " + itemName + "\n";
        }
        return retval;
    }
}
