package bork1;

/*
MovementCommand extends Command class, pertains to exits the user can and 
    cannot use
@author jmambert
 */
class MovementCommand extends Command {

    private String dir;


    /*
    MovementCommand has @param string called dir that is then set equal to a
    variable
    @author jmambert
     */
    MovementCommand(String dir) {
        this.dir = dir;
    }

    /*
    execute() changes the adventurers current room as they wish to whichever
        direction they choosed. However if the exit tries to go a way that is
        restricted or prohibited in any way, it will tell them they cannot go
        there
    @author jmambert
     */
    public String execute() {
        Room currentRoom = GameState.instance().getAdventurersCurrentRoom();
        Room nextRoom = currentRoom.leaveBy(dir);
        if (nextRoom != null) {
            if (currentRoom.getExit(dir).getLockState() == false) {  // could try/catch here.
                if (nextRoom.getIsDark() == true){
                    if (GameState.instance().getIsLit() == true){
                        GameState.instance().setAdventurersCurrentRoom(nextRoom);
                        return "\n" + nextRoom.describe() + "\n";
                    } else {
                        return "It's too dark to see anything";
                    }
                } else {
                    GameState.instance().setAdventurersCurrentRoom(nextRoom);
                        return "\n" + nextRoom.describe() + "\n";
                }
            } else {
                return "You can't go " + dir + " because it is locked.\n";
            }
        } else {
           return "You can't go " + dir + ".\n";
        }
    }
}
