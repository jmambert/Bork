
package bork1;

/*
Exit
*/
import java.io.PrintWriter;
import java.util.Scanner;

public class Exit {

    void storeState(PrintWriter w) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    class NoExitException extends Exception {}

    private String dir;
    private Room src, dest;
    private Boolean locked;

    /*
    Exit is passed a @param string, and @param 2 rooms
    @author jmambert
    */
    Exit(String dir, Room src, Room dest, Boolean locked) {
        init();
        this.dir = dir;
        this.src = src;
        this.dest = dest;
        this.locked = locked;
        src.addExit(this);
    }

    /** Given a Scanner object positioned at the beginning of an "exit" file
        entry, read and return an Exit object representing it. 
        @param d The dungeon that contains this exit (so that Room objects 
        may be obtained.)
        @throws NoExitException The reader object is not positioned at the
        start of an exit entry. A side effect of this is the reader's cursor
        is now positioned one line past where it was.
        @throws IllegalDungeonFormatException A structural problem with the
        dungeon file itself, detected when trying to read this room.
        * @author not jmambert
     */
    Exit(Scanner s, Dungeon d, Boolean initState) throws NoExitException,
        Dungeon.IllegalDungeonFormatException {

        init();
        String srcTitle = s.nextLine();
        if (srcTitle.equals(Dungeon.TOP_LEVEL_DELIM)) {
            throw new NoExitException();
        }
        src = d.getRoom(srcTitle);
        dir = s.nextLine();
        dest = d.getRoom(s.nextLine());
        String lock = s.nextLine();
        if(initState){
        locked = lock.equals("Locked: t");
        } else {
            locked = false;
        }
        
        // I'm an Exit object. Great. Add me as an exit to my source Room too,
        // though.
        src.addExit(this);

        // throw away delimiter
        if (!s.nextLine().equals(Dungeon.SECOND_LEVEL_DELIM)) {
            throw new Dungeon.IllegalDungeonFormatException("No '" +
                Dungeon.SECOND_LEVEL_DELIM + "' after exit.");
        }
    }
    
    

    // Common object initialization tasks.
    private void init() {
    }

    /*
    describe() lets the user know the possible exits they may leave by
    @author jmambert
    */
    String describe() {
        if(locked == true){
            return dir + " to " + dest.getTitle() + " is locked.";
        }
        
        return "You can go " + dir + " to " + dest.getTitle() + ".";
    }

    String getDir() { return dir; }
    Room getSrc() { return src; }
    Room getDest() { return dest; }
    
    public void setLockState(Boolean setLock){
        if(setLock == true) {
            locked = true;
        }else{
            locked = false;
        }
    }
    
    public Boolean getLockState(){
        return locked;
    }
}
